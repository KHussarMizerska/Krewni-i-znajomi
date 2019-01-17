package pl.krewniiznajomi.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.krewniiznajomi.service.DorosliService;
import pl.krewniiznajomi.service.DzieciService;

import java.io.IOException;

public class DemografiaController {

    @FXML
    private TextArea taDemografia;

    @FXML
    void powrot(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/guestView.fxml"));
        adminStage.setTitle("Panel gościa");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    void plecDorosli() {


    }

    public void initialize() {

        DorosliService dorosliService = new DorosliService();
        DzieciService dzieciService = new DzieciService();

        double ileDorosli = dorosliService.ileDorosli();
        double ileDorosliK = dorosliService.ileDorosliK();
        double procentDorosliK = Math.round((ileDorosliK/ileDorosli)*100);
        double ileDorosliM = dorosliService.ileDorosliM();
        double procentDorosliM = Math.round((ileDorosliM/ileDorosli)*100);

        double ileBezDzieci = dorosliService.ileBezDzieci();
        double ileDzieciaci = ileDorosli - ileBezDzieci;
        double ile4dzieci = dorosliService.ile4dzieci();
        double ile3dzieci = dorosliService.ile3dzieci();
        double ile2dzieci = dorosliService.ile2dzieci();
        double ile1dziecko = dorosliService.ile1dziecko();


        double ileDzieci = dzieciService.ileDzieci();
        double ileDzieciK = dzieciService.ileDzieciK();
        double procentDzieciK = Math.round((ileDzieciK/ileDzieci)*100);
        double ileDzieciM = dzieciService.ileDzieciM();
        double procentDzieciM = Math.round((ileDzieciM/ileDzieci)*100);

        taDemografia.appendText("Liczba dorosłych w bazie: " + ileDorosli);
        taDemografia.appendText("\nLiczba dorosłych kobiet w bazie: " + ileDorosliK + ", czyli " + procentDorosliK + "%");
        taDemografia.appendText("\nLiczba dorosłych mężczyzn w bazie: " + ileDorosliM + ", czyli " + procentDorosliM + "%");
        taDemografia.appendText("\nLiczba bezdzietnych w bazie: " + ileBezDzieci);
        taDemografia.appendText("\nLiczba dzietnych w bazie: " + ileDzieciaci);
        taDemografia.appendText("\nLiczba osób z 4 dzieci: " + ile4dzieci);
        taDemografia.appendText("\nLiczba osób z 3 dzieci: " + ile3dzieci);
        taDemografia.appendText("\nLiczba osób z 2 dzieci: " + ile2dzieci);
        taDemografia.appendText("\nLiczba osób z 1 dzieci: " + ile1dziecko);
        taDemografia.appendText("\nLiczba dzieci w bazie: " + ileDzieci);
        taDemografia.appendText("\nLiczba dzieci - dziewczynek w bazie: " + ileDzieciK + ", czyli " + procentDzieciK + "%");
        taDemografia.appendText("\nLiczba dzieci - chłopców w bazie: " + ileDzieciM + ", czyli " + procentDzieciM + "%");

    }
}
