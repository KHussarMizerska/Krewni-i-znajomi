package pl.krewniiznajomi.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.krewniiznajomi.model.User;
import pl.krewniiznajomi.service.UserService;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfPassword;

    @FXML
    private PasswordField psPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnShow;


    public void initialize() {
    }

    @FXML
    void login(InputEvent event) throws SQLException, IOException {

        String login = tfLogin.getText();
        String pass = psPassword.isVisible() ? psPassword.getText() : tfPassword.getText();

        UserService userService = new UserService();
        User user = userService.login(login, pass);

        // najpierw sprawdzić, czy user w ogóle istnieje; jeśli nie - alert


        if (user != null) {

            if ("a".equals(user.getLogin()) && ("a".equals(user.getPassword()))) {

                Stage adminStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
                adminStage.setTitle("Panel administratora");
                adminStage.setScene(new Scene(root));
                adminStage.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
            }
            else if ("g".equals(user.getLogin()) && ("g".equals(user.getPassword()))) {

                Stage adminStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/guestView.fxml"));
                adminStage.setTitle("Panel gościa");
                adminStage.setScene(new Scene(root));
                adminStage.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
            }

        }
        else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Error");
            error.setContentText("Błędny login lub hasło lub konto jest nieaktywne!!!");
            error.setTitle("Podaj poprawne dane logowania");
            error.showAndWait();
        }
    }

    @FXML
    void showPass(MouseEvent event) {

        if ("Pokaż hasło".equals(btnShow.getText())) {
            tfPassword.setText(psPassword.getText());
            btnShow.setText("Ukryj hasło");
            tfPassword.setVisible(true);
            psPassword.setVisible(false);
        }
        else if ("Ukryj hasło".equals(btnShow.getText())) {
            psPassword.setText(tfPassword.getText());
            btnShow.setText("Pokaż hasło");
            tfPassword.setVisible(false);
            psPassword.setVisible(true);
        }
    }

    @FXML
    void loginKeyAction(KeyEvent event) throws IOException, SQLException {
        if (event.getCode() == KeyCode.ENTER) {
            login(event);
        }
    }

    @FXML
    private Button btnSignIn;

    @FXML
    void signIn(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/signInView.fxml"));
        adminStage.setTitle("Sign in");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void guest(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/guestView.fxml"));
        adminStage.setTitle("Ankieta guest view");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
