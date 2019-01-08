package pl.krewniiznajomi.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.krewniiznajomi.model.dto.StatDorosliDTO;
import pl.krewniiznajomi.model.dto.StatDzieciDTO;
import pl.krewniiznajomi.service.DorosliService;
import pl.krewniiznajomi.service.DzieciService;

import java.io.IOException;
import java.util.List;

public class DzieciStatController {

    @FXML
    private Button btnPowrot;

    @FXML
    private ComboBox<String> cbDzieciStat;

    ObservableList<String> dzieciStat = FXCollections.observableArrayList("Imiona", "Lata urodzenia", "Miesiące urodzenia", "Dni tygodnia urodzenia", "Dni miesiąca urodzenia", "Znaki zodiaku");

    @FXML
    private Button btnPokaz;

    @FXML
    private TableView<StatDzieciDTO> tabWynik;

    @FXML
    private TableColumn<StatDzieciDTO, String> colWynik;

    @FXML
    private TableColumn<StatDzieciDTO, Long> colIle;

    @FXML
    void pokaz(MouseEvent event) throws IOException {

        DzieciService dzieciService = new DzieciService();

        String dzieciStat = cbDzieciStat.getValue();

        if ("Imiona".equals(dzieciStat)) {

            List<StatDzieciDTO> imionaDzieci = dzieciService.imionaDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(imionaDzieci);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Imię");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("imie"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));

        }
    }

        @FXML
        void powrot (MouseEvent event) throws IOException {

            Stage adminStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/guestView.fxml"));
            adminStage.setTitle("Panel gościa");
            adminStage.setScene(new Scene(root));
            adminStage.show();

            ((Node) event.getSource()).getScene()
                    .getWindow()
                    .hide();

        }

        public void initialize () {
            cbDzieciStat.setItems(dzieciStat);
        }
    }

