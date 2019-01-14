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
        private Button btnDemografia;



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
        void pokazDzieci(MouseEvent event) throws IOException {

            Stage adminStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/dzieciStatView.fxml"));
            adminStage.setTitle("Statystki dzieci");
            adminStage.setScene(new Scene(root));
            adminStage.show();

            ((Node) event.getSource()).getScene()
                    .getWindow()
                    .hide();

        }

        @FXML
        void pokazWszyscy(MouseEvent event) throws IOException {
        }

        @FXML
        void pokazDemografia(MouseEvent event) throws IOException {

                Stage adminStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/demografiaView.fxml"));
                adminStage.setTitle("Dane demograficzne");
                adminStage.setScene(new Scene(root));
                adminStage.show();

                ((Node) event.getSource()).getScene()
                        .getWindow()
                        .hide();

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
