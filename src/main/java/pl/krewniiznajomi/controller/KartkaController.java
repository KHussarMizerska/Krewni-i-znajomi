package pl.krewniiznajomi.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.krewniiznajomi.model.Rocznice;
import pl.krewniiznajomi.model.Wszyscy;
import pl.krewniiznajomi.service.KartkaService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class KartkaController {

    @FXML
    private Label lblData;

    @FXML
    private TextArea taKartka;

    @FXML
    private Button btnPowrot;

    @FXML
    void powrot(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();

    }

    public void initialize() {

        // Bieżąca data
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String today = formatter.format(date);
        lblData.setText("Dziś jest: " + today);

        KartkaService kartkaService = new KartkaService();

        // Kto dziś obchodzi urodziny
        List<Wszyscy> urodzinyDzis = kartkaService.urodzinyDzis();

        if(urodzinyDzis.isEmpty()) {
            taKartka.appendText("Dziś nikt nie obchodzi urodzin. \n");
        }
        else {
            taKartka.appendText("Dziś urodziny obchodzi: \n");
            for (Wszyscy w: urodzinyDzis) {
                SimpleDateFormat f = new SimpleDateFormat("yyyy");
                Date data = new Date();
                String rok = f.format(data);
                Long rokLiczba = Long.parseLong(rok);
                String rokUr = w.getDataUr().toString().substring(0,4);
                Long rokUrLiczba = Long.parseLong(rokUr);
                taKartka.appendText(w.getImie()+ " " + w.getNazwisko()+ " kończy dziś lat: " + (rokLiczba-rokUrLiczba) + "\n");
            }
        }

        // Kto dziś obchodzi okrągły jubileusz urodzin w dniach
        List<Wszyscy> okragleDniDzis = kartkaService.okragleDniDzis();

        if(okragleDniDzis.isEmpty()) {
            taKartka.appendText("\nDziś nikt nie obchodzi okrągłego jubileuszu urodzin w dniach. \n");
        }
        else {
            taKartka.appendText("\nDziś powód do świętowania ma: \n");
            for (Wszyscy w : okragleDniDzis) {
                taKartka.appendText(w.getImie() + " " + w.getNazwisko() + " kończy dziś okrągłe " + w.getWiekWdniach() + " dni\n");
            }
        }

        // Kto dziś obchodzi rocznicę ślubu
        List<Rocznice> roczniceSlubuDzis = kartkaService.roczniceSlubuDzis();

        if(roczniceSlubuDzis.isEmpty()) {
            taKartka.appendText("\nDziś nikt nie obchodzi rocznicy ślubu. \n");
        }
        else {
            taKartka.appendText("\nDziś rocznicę ślubu obchodzą: \n");
            for (Rocznice r : roczniceSlubuDzis) {
                taKartka.appendText(r.getImieZony() +" "+ r.getNazwiskoZony() + " i " + r.getImieMeza() +" "+ r.getNazwiskoMeza() + "\n" + "Ślub wzięli " + r.getDataSlubu() +". To jest ich rocznica nr " + r.getNrRocznicy() +" - " + r.getNazwaRocznicy());
            }
        }

    }

}
