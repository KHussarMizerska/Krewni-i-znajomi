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
import pl.krewniiznajomi.model.Dorosli;
import pl.krewniiznajomi.service.DorosliService;

import java.io.IOException;
import java.util.List;

public class DorosliStatController {

    @FXML
    private Button btnPowrot;

    @FXML
    private TableView<Dorosli> tabWynik;

    @FXML
    private TableColumn<Dorosli, String> colWynik;

    @FXML
    private TableColumn<Dorosli, Long> colIle;

    @FXML
    private ComboBox<String> cbDorosliStat;

    ObservableList<String> dorosliStat = FXCollections.observableArrayList("Imiona", "Lata urodzenia", "Miesiące urodzenia", "Dni tygodnia urodzenia", "Dni miesiąca urodzenia", "Znaki zodiaku", "Lata ślubu", "Miesiące ślubu", "Dni tygodnia ślubu", "Dni miesiąca ślubu");

    @FXML
    private TextArea taDorosliStat;

    @FXML
    private Button btnPokaz;

    @FXML
    void pokaz(MouseEvent event) {

        DorosliService dorosliService = new DorosliService();

        String dorosliStat = cbDorosliStat.getValue();
        List<Dorosli> imionaDorosli = dorosliService.imionaDorosli();

//        if("Imiona".equals(dorosliStat)) {
//
//            taDorosliStat.setText("Imiona dorosłych i liczba wystąpień:");
//            for (Dorosli d : imionaDorosli) {
//                taDorosliStat.appendText(d.getImie() + " " + d.getIle() + "\n");
//            }
//        }

        ObservableList<Dorosli> wynik = FXCollections.observableArrayList(imionaDorosli);
        tabWynik.setItems(null);
        tabWynik.setItems(wynik);

        // ustawienie kolumn które pola z Wszystkich mają być widoczne i w jakiej kolumnie z widoku

        colWynik.setCellValueFactory(new PropertyValueFactory<Dorosli, String>("imie"));
        colIle.setCellValueFactory(new PropertyValueFactory<Dorosli, Long>("ile"));
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
