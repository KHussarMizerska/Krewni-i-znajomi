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
import pl.krewniiznajomi.model.Dorosli;
import pl.krewniiznajomi.model.dto.StatDorosliDTO;
import pl.krewniiznajomi.model.dto.StatRoczniceDTO;
import pl.krewniiznajomi.service.DorosliService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        DorosliService dorosliService = new DorosliService();

        String dorosliStat = cbDorosliStat.getValue();

        if ("Dni tygodnia urodzenia".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDorosliDTO> dniTygUrDorosli = dorosliService.dniTygUrDorosli();

            for (StatDorosliDTO s : dniTygUrDorosli) {

                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Miesiące urodzenia".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDorosliDTO> miesiaceUrDorosli = dorosliService.miesiaceUrDorosli();

            for (StatDorosliDTO s : miesiaceUrDorosli) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Lata urodzenia".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDorosliDTO> lataUrDorosli = dorosliService.lataUrDorosli();

            for (StatDorosliDTO s : lataUrDorosli) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Dni miesiąca urodzenia".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDorosliDTO> dniMiesUrDorosli = dorosliService.dniMiesUrDorosli();

            for (StatDorosliDTO s : dniMiesUrDorosli) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }
        } else if ("Imiona".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDorosliDTO> imionaDorosli = dorosliService.imionaDorosli();

            for (StatDorosliDTO s : imionaDorosli) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Znaki zodiaku".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDorosliDTO> znakiZodiakuDorosli = dorosliService.znakiZodiakuDorosli();

            for (StatDorosliDTO s : znakiZodiakuDorosli) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Lata ślubu".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDorosliDTO> lataSlubu = dorosliService.lataSlubu();

            for (StatDorosliDTO s : lataSlubu) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Miesiące ślubu".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDorosliDTO> miesiaceSlubu = dorosliService.miesiaceSlubu();

            for (StatDorosliDTO s : miesiaceSlubu) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Dni tygodnia ślubu".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDorosliDTO> dniTygSlubu = dorosliService.dniTygSlubu();

            for (StatDorosliDTO s : dniTygSlubu) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }

        } else if ("Dni miesiąca ślubu".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(false);
            pChart.setVisible(true);
            pChart.getData().clear();

            List<StatDorosliDTO> dniMiesSlubu = dorosliService.dniMiesSlubu();

            for (StatDorosliDTO s : dniMiesSlubu) {
                PieChart.Data slice = new PieChart.Data(s.getWynik(), s.getIle());
                pChart.getData().add(slice);
            }
        }
    }

    final CategoryAxis xAxis1 = new CategoryAxis();
    final NumberAxis yAxis1 = new NumberAxis();
    final BarChart<String,Number> bChart1 = new BarChart<String,Number>(xAxis1,yAxis1);
    XYChart.Series series1 = new XYChart.Series();


    @FXML
    void pokazWykresSlupkowy(MouseEvent event) {

        DorosliService dorosliService = new DorosliService();

        String dorosliStat = cbDorosliStat.getValue();

        if ("Dni tygodnia urodzenia".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(true);
            pChart.setVisible(false);
            bChart.getData().clear();

            List<StatDorosliDTO> dniTygUrDorosli = dorosliService.dniTygUrDorosli();

            //ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(dniTygUrDorosli);

            xAxis1.setLabel("Dzień tygodnia");
//            xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
//                    "Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota")));
            //xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList());
            yAxis1.setLabel("Liczba wystąpień");

            for (StatDorosliDTO s : dniTygUrDorosli) {
                //
                // xAxis.setCategories(FXCollections.observableArrayList(Arrays.asList(s.getWynik())));
                series1.getData().add(new XYChart.Data(s.getWynik(), s.getIle()));
            }
//                XYChart.Series<String, Long> series = new XYChart.Series();
//                series.setName(s.getWynik());
//                series.getData().add(new XYChart.Data(s.getWynik(), s.getIle()));
            bChart.getData().addAll(series1);

            } else if ("Miesiące urodzenia".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(true);
            pChart.setVisible(false);
            //bChart.getData().clear();

            List<StatDorosliDTO> miesiaceUrDorosli = dorosliService.miesiaceUrDorosli();

            List<String> osX = new ArrayList<>();
            //xAxis.setCategories(FXCollections.<String>observableArrayList(osX)); //chcę tu nadpisać pusą listą, żeby zniknęły wcześniejjsze kategorie

            //1 sposób java 8 Stream
//            osX = miesiaceUrDorosli.stream()
//                    .map(dane -> dane.getWynik())
//                    .limit(6)
//                    .collect(Collectors.toList());

            //2 sposób pętla forech
            int count = 0;
            for (StatDorosliDTO dane : miesiaceUrDorosli) {
                if (count >= 6) {
                    break;
                }
                osX.add(dane.getWynik());
                count++;
            }

            xAxis.setLabel("Miesiąc");
            xAxis.setCategories(FXCollections.<String>observableArrayList(osX));
            yAxis.setLabel("Liczba wystąpień");

            for (StatDorosliDTO s : miesiaceUrDorosli) {

                XYChart.Series<String, Long> series = new XYChart.Series();
                series.setName(s.getWynik());
                series.getData().add(new XYChart.Data(s.getWynik(), s.getIle()));
                bChart.getData().add(series);
            }

        } else if ("Lata urodzenia".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(true);
            pChart.setVisible(false);
            bChart.getData().clear();

            List<StatDorosliDTO> lataUrDorosli = dorosliService.lataUrDorosli(); //jak to posortować wg roku?

            //ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(dniTygUrDorosli);

            xAxis.setLabel("Rok");

            //xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList()); // jak tu dodać kategorie - lata?
            yAxis.setLabel("Liczba wystąpień");

            for (StatDorosliDTO s : lataUrDorosli) {

                XYChart.Series<String, Long> series = new XYChart.Series();
                series.setName(s.getWynik());
                series.getData().add(new XYChart.Data(s.getWynik(), s.getIle()));
                bChart.getData().addAll(series);

            }

        } else if ("Imiona".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(true);
            pChart.setVisible(false);
            bChart.getData().clear();

            List<StatDorosliDTO> imionaDorosli = dorosliService.imionaDorosli(); //jak to posortować?

            List<String> osX = new ArrayList<>();

            //1 sposób java 8 Stream
            osX = imionaDorosli.stream()
                    .map(dane -> dane.getWynik())
                    .limit(10)
                    .collect(Collectors.toList());

//            //2 sposób pętla forech
//            int count = 0;
//            for (StatDorosliDTO dane : imionaDorosli) {
//                if (count >= 10) {
//                    break;
//                }
//                osX.add(dane.getWynik());
//                count++;
//            }

            xAxis.setLabel("Imię");

            //xAxis.setCategories(FXCollections.<String>observableArrayList(osX));

            yAxis.setLabel("Liczba wystąpień");

            XYChart.Series<String, Long> series = new XYChart.Series();

            for (StatDorosliDTO s : imionaDorosli) {
                series.setName(s.getWynik());
                series.getData().add(new XYChart.Data(s.getWynik(), s.getIle()));
            }

            bChart.getData().addAll(series);

        } else if ("Dni miesiąca urodzenia".equals(dorosliStat)) {

            tabWynik.setVisible(false);
            bChart.setVisible(true);
            pChart.setVisible(false);
            bChart.getData().clear();

            List<StatDorosliDTO> dniMiesUrDorosli = dorosliService.dniMiesUrDorosli();

            xAxis.setLabel("Dzień miesiąca");

            //xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList()); // jak tu dodać kategorie - lata?
            yAxis.setLabel("Liczba wystąpień");

            for (StatDorosliDTO s : dniMiesUrDorosli) {

                XYChart.Series<String, Long> series = new XYChart.Series(); //tutaj nie działa?
                series.setName(s.getWynik());
                series.getData().add(new XYChart.Data(s.getWynik(), s.getIle()));
                bChart.getData().addAll(series);
            }
        }
    }

    @FXML
    void pokaz(MouseEvent event) {

        DorosliService dorosliService = new DorosliService();

        String dorosliStat = cbDorosliStat.getValue();

        if ("Imiona".equals(dorosliStat)) {

            List<StatDorosliDTO> imionaDorosli = dorosliService.imionaDorosli();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(imionaDorosli);
            pChart.setVisible(false);
            bChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Imię");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));

        } else if ("Lata urodzenia".equals(dorosliStat)) {

            List<StatDorosliDTO> lataUrDorosli = dorosliService.lataUrDorosli();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(lataUrDorosli);
            pChart.setVisible(false);
            bChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Rok urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));


        } else if ("Dni tygodnia urodzenia".equals(dorosliStat)) {

            List<StatDorosliDTO> dniTygUrDorosli = dorosliService.dniTygUrDorosli();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(dniTygUrDorosli);
            pChart.setVisible(false);
            bChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień tygodnia urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));

        } else if ("Dni miesiąca urodzenia".equals(dorosliStat)) {

            List<StatDorosliDTO> dniMiesUrDorosli = dorosliService.dniMiesUrDorosli();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(dniMiesUrDorosli);
            pChart.setVisible(false);
            bChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień miesiąca urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));

        } else if ("Miesiące urodzenia".equals(dorosliStat)) {

            List<StatDorosliDTO> miesiaceUrDorosli = dorosliService.miesiaceUrDorosli();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(miesiaceUrDorosli);
            pChart.setVisible(false);
            bChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Miesiąc urodzenia");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));

        } else if ("Znaki zodiaku".equals(dorosliStat)) {

            List<StatDorosliDTO> znakiZodiakuDorosli = dorosliService.znakiZodiakuDorosli();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(znakiZodiakuDorosli);
            bChart.setVisible(false);
            pChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Znak zodiaku");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));

        } else if ("Lata ślubu".equals(dorosliStat)) {

            List<StatDorosliDTO> lataSlubu = dorosliService.lataSlubu();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(lataSlubu);
            bChart.setVisible(false);
            pChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Rok ślubu");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));

        } else if ("Miesiące ślubu".equals(dorosliStat)) {

            List<StatDorosliDTO> miesiaceSlubu = dorosliService.miesiaceSlubu();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(miesiaceSlubu);
            bChart.setVisible(false);
            pChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Miesiąc ślubu");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));

        } else if ("Dni tygodnia ślubu".equals(dorosliStat)) {

            List<StatDorosliDTO> dniTygSlubu = dorosliService.dniTygSlubu();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(dniTygSlubu);
            bChart.setVisible(false);
            pChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień tygodnia ślubu");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
            colIle.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, Long>("ile"));

        } else if ("Dni miesiąca ślubu".equals(dorosliStat)) {

            List<StatDorosliDTO> dniMiesSlubu = dorosliService.dniMiesSlubu();

            ObservableList<StatDorosliDTO> lista = FXCollections.observableArrayList(dniMiesSlubu);
            bChart.setVisible(false);
            pChart.setVisible(false);
            tabWynik.setVisible(true);
            tabWynik.setItems(null);
            tabWynik.setItems(lista);

            colWynik.setText("Dzień miesiąca ślubu");

            colWynik.setCellValueFactory(new PropertyValueFactory<StatDorosliDTO, String>("wynik"));
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

    public void initialize() {
        cbDorosliStat.setItems(dorosliStat);
        tabWynik.setVisible(false);
        bChart.setVisible(false);
        pChart.setVisible(false);

        DorosliService dorosliService = new DorosliService();
        int ileDorosli = dorosliService.ileDorosli();
        lblSuma.setText("Liczba dorosłych w bazie: " + ileDorosli);
    }


}
