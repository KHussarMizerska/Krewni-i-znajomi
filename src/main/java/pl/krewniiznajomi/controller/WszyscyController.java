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
import javafx.util.Callback;
import pl.krewniiznajomi.model.FiltrWszyscyView;
import pl.krewniiznajomi.model.Wszyscy;
import pl.krewniiznajomi.service.WszyscyService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WszyscyController {

    @FXML
    private TableView<Wszyscy> tableWszyscy;

    @FXML
    private TableColumn<Wszyscy, String> colName;

    @FXML
    private TableColumn<Wszyscy, String> colLastName;

    @FXML
    private TableColumn<Wszyscy, Date> colBDate;

    @FXML
    private Button btnPowrot;

    @FXML
    private TextField tfFilterName;

    @FXML
    private TextField tfFilterLastName;

    @FXML
    private TextField tfFilterBDate;

    @FXML
    private Button btnSelect;

    @FXML
    void powrot(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    private WszyscyService wszyscyService;

    @FXML
    void pokaz(MouseEvent event) {

        String imieFiltr = tfFilterName.getText();
        String nazwiskoFiltr = tfFilterLastName.getText();

        FiltrWszyscyView filtr = new FiltrWszyscyView(imieFiltr, nazwiskoFiltr);
        List<Wszyscy> list = wszyscyService.filtruj(filtr);

        ObservableList<Wszyscy> data = FXCollections.observableArrayList(list);
        tableWszyscy.setItems(null);
        tableWszyscy.setItems(data);
    }

    public void initialize() { // jeśli chcemy wyświetlić dane od razu po otwarciu widoku

        // ---- pobranie danych Wszystkich z bazy danych ----
        wszyscyService = new WszyscyService();
        List<Wszyscy> wszyscy = wszyscyService.pokazWszyscy();

        ObservableList<Wszyscy> dane = FXCollections.observableArrayList(wszyscy);
        tableWszyscy.setItems(null);
        tableWszyscy.setItems(dane);

        // ustawienie kolumn które pola z Wszystkich mają być widoczne i w jakiej kolumnie z widoku

        colName.setCellValueFactory(new PropertyValueFactory<Wszyscy, String>("imie"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Wszyscy, String>("nazwisko"));
        colBDate.setCellValueFactory(new PropertyValueFactory<Wszyscy, Date>("dataUr")); // tu wklejam dane
        colBDate.setCellFactory(new Callback<TableColumn<Wszyscy, Date>, TableCell<Wszyscy, Date>>() { //tu ustawiam format daty
            public TableCell<Wszyscy, Date> call(TableColumn<Wszyscy, Date> column) {
                TableCell<Wszyscy, Date> cell = new TableCell<Wszyscy, Date>() {
                    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

                    @Override
                    protected void updateItem(Date item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            this.setText(format.format(item));
                        }
                    }
                };
                return cell;
            }
        });


       // WszyscyService wszyscyService = new WszyscyService(); // tu testujemy czy działa wyciąganie danych z widoku
        // System.out.println("Wszyscy view:"+wszyscyService.pokazWszyscy());

    }
}
