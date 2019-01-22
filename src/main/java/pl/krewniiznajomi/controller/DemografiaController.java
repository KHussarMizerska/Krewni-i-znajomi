package pl.krewniiznajomi.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.krewniiznajomi.service.DorosliService;
import pl.krewniiznajomi.service.DzieciService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemografiaController {

    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @FXML
    private TextArea taDemografia;

    @FXML
    private Label lblData;

    @FXML
    private Button btnWykres;

    @FXML
    private PieChart pChart;

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

    @FXML
    void pokazWykres(MouseEvent event) {

        taDemografia.setVisible(false);
        pChart.setVisible(true);

        DorosliService dorosliService = new DorosliService();

        double ileDorosli = Math.round(dorosliService.ileDorosli());
        double ileBezDzieci = Math.round(dorosliService.ileBezDzieci());
        double ileDzieciaci = Math.round(ileDorosli - ileBezDzieci);
        double ile4dzieci = Math.round(dorosliService.ile4dzieci());
        double ile3dzieci = dorosliService.ile3dzieci();
        double ile2dzieci = dorosliService.ile2dzieci();
        double ile1dziecko = dorosliService.ile1dziecko();

       PieChart.Data slice = new PieChart.Data("bezdzietni", ileBezDzieci);
       PieChart.Data slice1 = new PieChart.Data("1 dziecko", ile1dziecko);
       PieChart.Data slice2 = new PieChart.Data("2 dzieci", ile2dzieci);
       PieChart.Data slice3 = new PieChart.Data("3 dzieci", ile3dzieci);
       PieChart.Data slice4 = new PieChart.Data("4 dzieci", ile4dzieci);

        pChart.getData().add(slice);
        pChart.getData().add(slice1);
        pChart.getData().add(slice2);
        pChart.getData().add(slice3);
        pChart.getData().add(slice4);

    }

    public void initialize() {

        DorosliService dorosliService = new DorosliService();
        DzieciService dzieciService = new DzieciService();

        Date date = new Date();
        String today = format.format(date);

        lblData.setText("Dziś jest: " + today);

        double ileDorosli =  dorosliService.ileDorosli();
        double ileDorosliK =  dorosliService.ileDorosliK();
        double procentDorosliK = Math.round((ileDorosliK/ileDorosli)*100);
        double ileDorosliM = dorosliService.ileDorosliM();
        double procentDorosliM = Math.round((ileDorosliM/ileDorosli)*100);

        double ileBezDzieci = dorosliService.ileBezDzieci();
        double procentBezDzieci = Math.round((ileBezDzieci/ileDorosli)*100);
        double ileDzieciaci = (ileDorosli - ileBezDzieci);
        double procentDzieciaci = Math.round((ileDzieciaci/ileDorosli)*100);

        double ile4dzieci = dorosliService.ile4dzieci();
        double procent4dzieci = Math.round((ile4dzieci/ileDorosli)*100);
        double ile3dzieci = dorosliService.ile3dzieci();
        double procent3dzieci = Math.round((ile3dzieci/ileDorosli)*100);
        double ile2dzieci = dorosliService.ile2dzieci();
        double procent2dzieci = Math.round((ile2dzieci/ileDorosli)*100);
        double ile1dziecko = dorosliService.ile1dziecko();
        double procent1dziecko = Math.round((ile1dziecko/ileDorosli)*100);

        double ileDzieci = dzieciService.ileDzieci();
        double ileDzieciK = dzieciService.ileDzieciK();
        double procentDzieciK = Math.round((ileDzieciK/ileDzieci)*100);
        double ileDzieciM = dzieciService.ileDzieciM();
        double procentDzieciM = Math.round((ileDzieciM/ileDzieci)*100);

        taDemografia.appendText("Liczba dorosłych w bazie: " + (int) ileDorosli);
        taDemografia.appendText("\nLiczba dorosłych kobiet w bazie: " + (int) ileDorosliK + ", czyli " + procentDorosliK + "% wszystkich dorosłych");
        taDemografia.appendText("\nLiczba dorosłych mężczyzn w bazie: " + (int) ileDorosliM + ", czyli " + procentDorosliM + "% wszystkich dorosłych");
        taDemografia.appendText("\n\nLiczba bezdzietnych w bazie: " + (int) ileBezDzieci + ", czyli " + procentBezDzieci + "% wszystkich dorosłych");
        taDemografia.appendText("\n\nLiczba dzietnych w bazie: " + (int) ileDzieciaci + ", czyli " + procentDzieciaci + "% wszystkich dorosłych");
        taDemografia.appendText("\nLiczba osób z 4 dzieci: " + (int) ile4dzieci + ", czyli " + procent4dzieci + "% wszystkich dorosłych");
        taDemografia.appendText("\nLiczba osób z 3 dzieci: " + (int) ile3dzieci + ", czyli " + procent3dzieci + "% wszystkich dorosłych");
        taDemografia.appendText("\nLiczba osób z 2 dzieci: " + (int) ile2dzieci + ", czyli " + procent2dzieci + "% wszystkich dorosłych");
        taDemografia.appendText("\nLiczba osób z 1 dzieckiem: " + (int) ile1dziecko + ", czyli " + procent1dziecko + "% wszystkich dorosłych");
        taDemografia.appendText("\n\nLiczba dzieci w bazie: " + (int) ileDzieci);
        taDemografia.appendText("\nLiczba dzieci - dziewczynek w bazie: " + (int) ileDzieciK + ", czyli " + procentDzieciK + "% wszsytkich dzieci");
        taDemografia.appendText("\nLiczba dzieci - chłopców w bazie: " + (int) ileDzieciM + ", czyli " + procentDzieciM + "% wszystkich dzieci");

    }
}
