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

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String today = formatter.format(date);

        lblData.setText("Dziś jest: " + today);

        KartkaService kartkaService = new KartkaService();

        List<Wszyscy> urodzinyDzis = kartkaService.urodzinyDzis();

        taKartka.setText("Dziś urodziny obchodzi: \n");

        for (Wszyscy w: urodzinyDzis) {
            taKartka.appendText(w.getImie()+ " " + w.getNazwisko()+"\n");
        }

        List<Wszyscy> okragleDniDzis = kartkaService.okragleDniDzis();

        taKartka.appendText("\nDziś powód do świętowania ma: \n");

        for (Wszyscy w: okragleDniDzis) {
            taKartka.appendText(w.getImie()+ " " + w.getNazwisko() + "\n");
        }

    }

}
