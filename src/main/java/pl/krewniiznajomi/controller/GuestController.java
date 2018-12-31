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


    public class GuestController {

        @FXML
        private Button btnDzieci;

        @FXML
        private Button btnDorosli;

        @FXML
        private Button btnWszyscy;

        @FXML
        void pokazDorosli(MouseEvent event) throws IOException {

            Stage adminStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/dorosliStatView.fxml"));
            adminStage.setTitle("Statystki dorosłych");
            adminStage.setScene(new Scene(root));
            adminStage.show();

            ((Node) event.getSource()).getScene()
                    .getWindow()
                    .hide();

        }


        @FXML
        void pokazDzieci(MouseEvent event) {

        }

        @FXML
        void pokazWszyscy(MouseEvent event) {

        }


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
}
