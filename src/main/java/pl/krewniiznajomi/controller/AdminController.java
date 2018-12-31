package pl.krewniiznajomi.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private Button btnWszyscy;

    @FXML
    private Button btnKartka;

    @FXML
    private Button btnJubileusze;

    @FXML
    private Button btnWyloguj;

    @FXML
    void wyloguj(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/loginView.fxml"));
        adminStage.setTitle("Panel logowania");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void pokazWszyscy(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/wszyscyView.fxml"));
        adminStage.setTitle("Lista wszystkich w bazie");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }


    @FXML
    void pokazKartka(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/kartkaView.fxml"));
        adminStage.setTitle("Kartka z kalendarza");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();

    }

    @FXML
    void pokazJubileusze(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/jubileuszeView.fxml"));
        adminStage.setTitle("Jubileusze w tym miesiącu");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();

    }
  }