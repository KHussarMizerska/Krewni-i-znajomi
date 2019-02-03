package pl.krewniiznajomi.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.krewniiznajomi.model.dto.StatDorosliDTO;
import pl.krewniiznajomi.model.dto.StatWszyscyDTO;
import pl.krewniiznajomi.service.DorosliService;
import pl.krewniiznajomi.service.WszyscyStatService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WszyscyStatController {

    @FXML
    private Button btnPowrot;

    @FXML
    private TableView<StatWszyscyDTO> tabWynik;

    @FXML
    private TableColumn<StatWszyscyDTO, String> colWynik;

    @FXML
    private TableColumn<StatWszyscyDTO, Long> colIle;

    @FXML
    private ComboBox<String> cbWszyscyStat;

    ObservableList<String> wszyscyStat = FXCollections.observableArrayList("Imiona", "Miesiące urodzenia", "Dni tygodnia urodzenia", "Dni miesiąca urodzenia", "Znaki zodiaku");

    @FXML
    private Button btnPokaz;

    @FXML
    private Button btnWykresKolowy;

    @FXML
    private Button btnWykresSlupkowy;

    @FXML
    private PieChart pChart;

    @FXML
    private BarChart<String, Long> bChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Label lblSuma;

    @FXML
    void pokazWykresKolowy(MouseEvent event) {

    }

    @FXML
    void pokazWykresSlupkowy(MouseEvent event) {

    }

    @FXML
    void pokaz(MouseEvent event) {

        WszyscyStatService wszyscyStatService = new WszyscyStatService();

        String wszyscyStat = cbWszyscyStat.getValue();

        if ("Imiona".equals(wszyscyStat)) {

            List<StatWszyscyDTO> imionaWszyscy = wszyscyStatService.imionaWszyscy();

            ObservableList<StatWszyscyDTO> lista = FXCollections.observableArrayList(imionaWszyscy);
            pChart.setVisible(false);
            bChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Imię");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatWszyscyDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatWszyscyDTO, Long>("ile"));

        } else if ("Miesiące urodzenia".equals(wszyscyStat)) {

            List<StatWszyscyDTO> miesiaceUrWszyscy = wszyscyStatService.miesiaceUrWszyscy();

            ObservableList<StatWszyscyDTO> lista = FXCollections.observableArrayList(miesiaceUrWszyscy);
            pChart.setVisible(false);
            bChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Miesiąc urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatWszyscyDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatWszyscyDTO, Long>("ile"));

        } else if ("Dni tygodnia urodzenia".equals(wszyscyStat)) {

            List<StatWszyscyDTO> dniTygUrWszyscy = wszyscyStatService.dniTygUrWszyscy();

            ObservableList<StatWszyscyDTO> lista = FXCollections.observableArrayList(dniTygUrWszyscy);
            pChart.setVisible(false);
            bChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień tygodnia urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatWszyscyDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatWszyscyDTO, Long>("ile"));

        } else if ("Dni miesiąca urodzenia".equals(wszyscyStat)) {

            List<StatWszyscyDTO> dniMiesUrWszyscy = wszyscyStatService.dniMiesUrWszyscy();

            ObservableList<StatWszyscyDTO> lista = FXCollections.observableArrayList(dniMiesUrWszyscy);
            pChart.setVisible(false);
            bChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień miesiąca urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatWszyscyDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatWszyscyDTO, Long>("ile"));

        } else if ("Znaki zodiaku".equals(wszyscyStat)) {

            List<StatWszyscyDTO> znakiZodiakuWszyscy = wszyscyStatService.znakiZodiakuWszyscy();

            ObservableList<StatWszyscyDTO> lista = FXCollections.observableArrayList(znakiZodiakuWszyscy);
            pChart.setVisible(false);
            bChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Znak zodiaku");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatWszyscyDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatWszyscyDTO, Long>("ile"));

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

    public void initialize() {
        cbWszyscyStat.setItems(wszyscyStat);
        tabWynik.setVisible(false);
        bChart.setVisible(false);
        pChart.setVisible(false);

        WszyscyStatService wszyscyStatService = new WszyscyStatService();
        int ileWszyscy = wszyscyStatService.ileWszyscy();
        lblSuma.setText("Liczba wszystkich dorosłych i dzieci w bazie: " + ileWszyscy);
    }


}
