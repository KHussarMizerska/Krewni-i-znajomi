package pl.krewniiznajomi.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
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
    private Label lblSuma;

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
    void pokaz(MouseEvent event) {

        DzieciService dzieciService = new DzieciService();

        String dzieciStat = cbDzieciStat.getValue();

        if ("Imiona".equals(dzieciStat)) {

            List<StatDzieciDTO> imionaDzieci = dzieciService.imionaDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(imionaDzieci);
            tabWynik.setVisible(true);
            pChart.setVisible(false);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Imię");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));

        } else if ("Lata urodzenia".equals(dzieciStat)) {

            List<StatDzieciDTO> lataUrDzieci = dzieciService.lataUrDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(lataUrDzieci);
            tabWynik.setVisible(true);
            pChart.setVisible(false);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Rok urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));


        } else if ("Dni tygodnia urodzenia".equals(dzieciStat)) {

            List<StatDzieciDTO> dniTygUrDzieci = dzieciService.dniTygUrDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(dniTygUrDzieci);
            tabWynik.setVisible(true);
            pChart.setVisible(false);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień tygodnia urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));

        } else if ("Dni miesiąca urodzenia".equals(dzieciStat)) {

            List<StatDzieciDTO> dniMiesUrDzieci = dzieciService.dniMiesUrDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(dniMiesUrDzieci);
            tabWynik.setVisible(true);
            pChart.setVisible(false);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień miesiąca urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));

        } else if ("Miesiące urodzenia".equals(dzieciStat)) {

            List<StatDzieciDTO> miesiaceUrDzieci = dzieciService.miesiaceUrDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(miesiaceUrDzieci);
            tabWynik.setVisible(true);
            pChart.setVisible(false);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Miesiąc urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));

        } else if ("Znaki zodiaku".equals(dzieciStat)) {

            List<StatDzieciDTO> znakiZodiakuDzieci = dzieciService.znakiZodiakuDzieci();

            ObservableList<StatDzieciDTO> lista = FXCollections.observableArrayList(znakiZodiakuDzieci);
            tabWynik.setVisible(true);
            pChart.setVisible(false);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Znak zodiaku");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDzieciDTO, Long>("ile"));

        }
    }

    @FXML
    void pokazWykresKolowy(MouseEvent event) {

        DzieciService dzieciService = new DzieciService();

        String dzieciStat = cbDzieciStat.getValue();

        if ("Dni tygodnia urodzenia".equals(dzieciStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDzieciDTO> dniTygUrDzieci = dzieciService.dniTygUrDzieci();

            for (StatDzieciDTO s : dniTygUrDzieci) {

                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Miesiące urodzenia".equals(dzieciStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDzieciDTO> miesiaceUrDzieci = dzieciService.miesiaceUrDzieci();

            for (StatDzieciDTO s : miesiaceUrDzieci) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Lata urodzenia".equals(dzieciStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDzieciDTO> lataUrDzieci = dzieciService.lataUrDzieci();

            for (StatDzieciDTO s : lataUrDzieci) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Dni miesiąca urodzenia".equals(dzieciStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDzieciDTO> dniMiesUrDzieci = dzieciService.dniMiesUrDzieci();

            for (StatDzieciDTO s : dniMiesUrDzieci) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }
        } else if ("Imiona".equals(dzieciStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDzieciDTO> imionaDzieci = dzieciService.imionaDzieci();

            for (StatDzieciDTO s : imionaDzieci) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Znaki zodiaku".equals(dzieciStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDzieciDTO> znakiZodiakuDzieci = dzieciService.znakiZodiakuDzieci();

            for (StatDzieciDTO s : znakiZodiakuDzieci) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }
        }

    }

    @FXML
    void pokazWykresSlupkowy(MouseEvent event) {

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

        cbDzieciStat.setItems(dzieciStat);

        tabWynik.setVisible(false);
        bChart.setVisible(false);
        pChart.setVisible(false);

        DzieciService dzieciService = new DzieciService();

        int ileDzieci = dzieciService.ileDzieci();

        lblSuma.setText("Liczba dzieci w bazie: " + ileDzieci);}

}
