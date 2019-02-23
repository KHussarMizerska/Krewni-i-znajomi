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
    private Button btnWykres1;

    @FXML
    private Button btnWykres2;

    @FXML
    private Button btnWykres3;

    @FXML
    private PieChart pChart1;

    @FXML
    private PieChart pChart2;

    @FXML
    private PieChart pChart3;


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
    void pokazWykres1(MouseEvent event) {

        taDemografia.setVisible(false);
        pChart1.setVisible(true);
        pChart2.setVisible(false);
        pChart3.setVisible(false);
        pChart1.getData().clear();


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

        pChart1.getData().add(slice);
        pChart1.getData().add(slice1);
        pChart1.getData().add(slice2);
        pChart1.getData().add(slice3);
        pChart1.getData().add(slice4);

        pChart1.setTitle("Liczba dzieci wśród wszystkich dorosłych");
        pChart1.setLegendVisible(false);

    }

    @FXML
    void pokazWykres2(MouseEvent event) {

        taDemografia.setVisible(false);
        pChart1.setVisible(false);
        pChart2.setVisible(true);
        pChart3.setVisible(false);
        pChart2.getData().clear();

        DorosliService dorosliService = new DorosliService();

        double ileDorosli = Math.round(dorosliService.ileDorosli());
        double ileBezDzieci = Math.round(dorosliService.ileBezDzieci());
        double ileDzieciaci = Math.round(ileDorosli - ileBezDzieci);
        double ile4dzieci = Math.round(dorosliService.ile4dzieci());
        double ile3dzieci = dorosliService.ile3dzieci();
        double ile2dzieci = dorosliService.ile2dzieci();
        double ile1dziecko = dorosliService.ile1dziecko();

        PieChart.Data slice1 = new PieChart.Data("1 dziecko", + ile1dziecko);
        PieChart.Data slice2 = new PieChart.Data("2 dzieci", ile2dzieci);
        PieChart.Data slice3 = new PieChart.Data("3 dzieci", ile3dzieci);
        PieChart.Data slice4 = new PieChart.Data("4 dzieci", ile4dzieci);

        pChart2.getData().add(slice1);
        pChart2.getData().add(slice2);
        pChart2.getData().add(slice3);
        pChart2.getData().add(slice4);

        pChart2.setTitle("Liczba dzieci wśród dorosłych posiadających dzieci");
        pChart2.setLegendVisible(false);
    }

    @FXML
    void pokazWykres3(MouseEvent event) {

        taDemografia.setVisible(false);
        pChart1.setVisible(false);
        pChart2.setVisible(false);
        pChart3.setVisible(true);
        pChart3.getData().clear();

        DzieciService dzieciService = new DzieciService();

        double ileDzieciM = dzieciService.ileDzieciM();
        double ileDzieciK = dzieciService.ileDzieciK();

        PieChart.Data slice1 = new PieChart.Data("Chłopcy", ileDzieciM);
        PieChart.Data slice2 = new PieChart.Data("Dziewczynki", ileDzieciK);

        pChart3.getData().add(slice1);
        pChart3.getData().add(slice2);

        pChart3.setTitle("Płeć dzieci");
        pChart3.setLegendVisible(false);

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

        double ileMwsrod1dziecko = dorosliService.ileMwsrod1dziecko();
        double ileKwsrod1dziecko = dorosliService.ileKwsrod1dziecko();
        double procentDzieciMwsrod1dziecko = Math.round((ileMwsrod1dziecko/ile1dziecko*2)*100);
        double procentDzieciKwsrod1dziecko = Math.round((ileKwsrod1dziecko/ile1dziecko*2)*100);

        double ileMatekPrzed30 = dorosliService.ileMatekPrzed30();
        double ileMatekPo30 = (ileDzieciaci/2)-ileMatekPrzed30;
        double procentMatekPrzed30 = Math.round(ileMatekPrzed30/(ileMatekPrzed30+ileMatekPo30)*100);
        double procentMatekPo30 = Math.round(ileMatekPo30/(ileMatekPrzed30+ileMatekPo30)*100);

        double ileOjcowPrzed30 = dorosliService.ileOjcowPrzed30();
        double ileOjcowPo30 = (ileDzieciaci/2)-ileOjcowPrzed30;
        double procentOjcowPrzed30 = Math.round(ileOjcowPrzed30/(ileOjcowPrzed30+ileOjcowPo30)*100);
        double procentOjcowPo30 = Math.round(ileOjcowPo30/(ileOjcowPrzed30+ileOjcowPo30)*100);

        double ileDzieciPrzed30Matki = dzieciService.ileDzieciPrzed30Matki();
        double ileDzieciPo30Matki = dzieciService.ileDzieciPo30Matki();
        double procentDzieciPrzed30Matki = Math.round(ileDzieciPrzed30Matki/(ileDzieciPo30Matki+ileDzieciPrzed30Matki)*100);
        double procentDzieciPo30Matki = Math.round(ileDzieciPo30Matki/(ileDzieciPo30Matki+ileDzieciPrzed30Matki)*100);
        double ileDzieciPrzed30Ojca = dzieciService.ileDzieciPrzed30Ojca();
        double ileDzieciPo30Ojca = dzieciService.ileDzieciPo30Ojca();
        double procentDzieciPrzed30Ojca = Math.round(ileDzieciPrzed30Ojca/(ileDzieciPo30Ojca+ileDzieciPrzed30Ojca)*100);
        double procentDzieciPo30Ojca = Math.round(ileDzieciPo30Ojca/(ileDzieciPo30Ojca+ileDzieciPrzed30Ojca)*100);

        double ileKslubPrzed30 = dorosliService.ileKslubPrzed30();
        double ileKslubPo30 = dorosliService.ileKslubPo30();
        double procentKslubPrzed30 = Math.round(ileKslubPrzed30/(ileKslubPrzed30+ileKslubPo30)*100);
        double procentKslubPo30 = Math.round(ileKslubPo30/(ileKslubPrzed30+ileKslubPo30)*100);
        double ileMslubPrzed30 = dorosliService.ileMslubPrzed30();
        double ileMslubPo30 = dorosliService.ileMslubPo30();
        double procentMslubPrzed30 = Math.round(ileMslubPrzed30/(ileMslubPrzed30+ileMslubPo30)*100);
        double procentMslubPo30 = Math.round(ileMslubPo30/(ileMslubPrzed30+ileMslubPo30)*100);


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
        taDemografia.appendText("\nLiczba dzieci - dziewczynek w bazie: " + (int) ileDzieciK + ", czyli " + procentDzieciK + "% wszystkich dzieci");
        taDemografia.appendText("\nLiczba dzieci - chłopców w bazie: " + (int) ileDzieciM + ", czyli " + procentDzieciM + "% wszystkich dzieci");
        taDemografia.appendText("\nLiczba dzieci - chłopców - wśród jedynaków: " + (int) ileMwsrod1dziecko + ", czyli " + procentDzieciMwsrod1dziecko + "% wszystkich jedynaków");
        taDemografia.appendText("\nLiczba dzieci - dziewczynek - wśród jedynaków: " + (int) ileKwsrod1dziecko + ", czyli " + procentDzieciKwsrod1dziecko + "% wszystkich jedynaków");
        taDemografia.appendText("\n\nLiczba matek, które pierwsze dziecko urodziły przed 30: " + (int) ileMatekPrzed30 + ", czyli " + procentMatekPrzed30 + "% wszystkich matek");
        taDemografia.appendText("\nLiczba matek, które pierwsze dziecko urodziły po 30: " + (int) ileMatekPo30 + ", czyli " + procentMatekPo30 + "% wszystkich matek");
        taDemografia.appendText("\nLiczba ojców, którzy pierwsze dziecko mieli przed 30: " + (int) ileOjcowPrzed30 + ", czyli " + procentOjcowPrzed30 + "% wszystkich ojców");
        taDemografia.appendText("\nLiczba ojców, którzy pierwsze dziecko mieli po 30: " + (int) ileOjcowPo30 + ", czyli " + procentOjcowPo30 + "% wszystkich ojców");
        taDemografia.appendText("\n\nLiczba dzieci, które urodziły się, gdy ich matki były przed 30: " + (int) ileDzieciPrzed30Matki + ", czyli " + procentDzieciPrzed30Matki + "% wszystkich dzieci");
        taDemografia.appendText("\nLiczba dzieci, które urodziły się, gdy ich matki były po 30: " + (int) ileDzieciPo30Matki + ", czyli " + procentDzieciPo30Matki + "% wszystkich dzieci");
        taDemografia.appendText("\nLiczba dzieci, które urodziły się, gdy ich ojcowie byli przed 30: " + (int) ileDzieciPrzed30Ojca + ", czyli " + procentDzieciPrzed30Ojca + "% wszystkich dzieci");
        taDemografia.appendText("\nLiczba dzieci, które urodziły się, gdy ich ojcowie byli po 30: " + (int) ileDzieciPo30Ojca + ", czyli " + procentDzieciPo30Ojca + "% wszystkich dzieci");
        taDemografia.appendText("\n\nLiczba kobiet, które wzięły ślub przed 30: " + (int) ileKslubPrzed30 + ", czyli " + procentKslubPrzed30 + "% wszystkich mężatek");
        taDemografia.appendText("\nLiczba kobiet, które wzięły ślub po 30: " + (int) ileKslubPo30 + ", czyli " + procentKslubPo30 + "% wszystkich mężatek");
        taDemografia.appendText("\nLiczba mężczyzn, którzy wzięli ślub przed 30: " + (int) ileMslubPrzed30 + ", czyli " + procentMslubPrzed30 + "% wszystkich żonatych");
        taDemografia.appendText("\nLiczba mężczyzn, którzy wzięli slub po 30: " + (int) ileMslubPo30 + ", czyli " + procentMslubPo30 + "% wszystkich żonatych");

    }
}
