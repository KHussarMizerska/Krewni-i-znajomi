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
    private Button btnShowAll;

    @FXML
    void showAll(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/allDView.fxml"));
        adminStage.setTitle("Lista wszystkich dorosłych w bazie");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

  }