package pl.krewniiznajomi.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private TableView<StatDzieciDTO> tabWynik;

    @FXML
    private TableColumn<StatDzieciDTO, String> colWynik;

    @FXML
    private TableColumn<StatDzieciDTO, Long> colIle;

    @FXML
    private ComboBox<String> cbDzieciStat;

    ObservableList<String> dzieciStat = FXCollections.observableArrayList("Imiona", "Lata urodzenia", "Miesiące urodzenia", "Dni tygodnia urodzenia", "Dni miesiąca urodzenia", "Znaki zodiaku");

    @FXML
    private Button btnPokaz;

    @FXML
    void pokaz(MouseEvent event) {

        DzieciService dzieciService = new DzieciService();

        String dzieciStat = cbDzieciStat.getValue();

        if("Imiona".equals(dzieciStat)) {

            List<StatDzieciDTO> imionaDzieci = dzieciService.imionaDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(imionaDzieci);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Imię");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));

        } else if("Lata urodzenia".equals(dzieciStat)) {

            List<StatDzieciDTO> lataUrDzieci = dzieciService.lataUrDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(lataUrDzieci);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Rok urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));


        } else if("Dni tygodnia urodzenia".equals(dzieciStat)) {

            List<StatDzieciDTO> dniTygUrDzieci = dzieciService.dniTygUrDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(dniTygUrDzieci);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień tygodnia urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));

        } else if("Dni miesiąca urodzenia".equals(dzieciStat)) {

            List<StatDzieciDTO> dniMiesUrDzieci = dzieciService.dniMiesUrDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(dniMiesUrDzieci);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień miesiąca urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));

        } else if("Miesiące urodzenia".equals(dzieciStat)) {

            List<StatDzieciDTO> miesiaceUrDzieci = dzieciService.miesiaceUrDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(miesiaceUrDzieci);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Miesiąc urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));

        }
    }

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

    public void initialize() { cbDzieciStat.setItems(dzieciStat);    }

}
