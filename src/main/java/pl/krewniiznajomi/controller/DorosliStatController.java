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
import pl.krewniiznajomi.service.DorosliService;

import java.io.IOException;
import java.util.List;

public class DorosliStatController {

    @FXML
    private Button btnPowrot;

    @FXML
    private TableView<StatDorosliDTO> tabWynik;

    @FXML
    private TableColumn<StatDorosliDTO, String> colWynik;

    @FXML
    private TableColumn<StatDorosliDTO, Long> colIle;

    @FXML
    private ComboBox<String> cbDorosliStat;

    ObservableList<String> dorosliStat = FXCollections.observableArrayList("Imiona", "Lata urodzenia", "Miesiące urodzenia", "Dni tygodnia urodzenia", "Dni miesiąca urodzenia", "Znaki zodiaku", "Lata ślubu", "Miesiące ślubu", "Dni tygodnia ślubu", "Dni miesiąca ślubu");

    @FXML
    private Button btnPokaz;

    @FXML
    void pokaz(MouseEvent event) {

        DorosliService dorosliService = new DorosliService();

        String dorosliStat = cbDorosliStat.getValue();

        if("Imiona".equals(dorosliStat)) {

            List<StatDorosliDTO> imionaDorosli = dorosliService.imionaDorosli();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(imionaDorosli);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Imię");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));

        } else if("Lata urodzenia".equals(dorosliStat)) {

            List<StatDorosliDTO> lataUrDorosli = dorosliService.lataUrDorosli();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(lataUrDorosli);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Rok urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("rok"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));


        } else if("Dni tygodnia urodzenia".equals(dorosliStat)) {

            List<StatDorosliDTO> dniTygUrDorosli = dorosliService.dniTygUrDorosli();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(dniTygUrDorosli);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień tygodnia urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("imie"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));

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

    public void initialize() { cbDorosliStat.setItems(dorosliStat);    }





}
