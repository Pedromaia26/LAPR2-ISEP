package app.ui.gui;

import app.controller.CheckTestResultsController;
import app.domain.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CheckTestResultsUI implements Initializable {

    @FXML
    ListView<String> listTests = new ListView<>();

    @FXML
    TableView<TestParameterResultDTO> tableResults = new TableView<>();

    @FXML
    TableView<ParameterDTO> tableParameter = new TableView<>();

    @FXML
    Label labelUserName = new Label();

    @FXML
    Label labelReport = new Label();

    private List<TestDTO> clientTests = new ArrayList<>();

    private CheckTestResultsController checkTestResultsController = new CheckTestResultsController();

    private ReportDTO report;

    private List<TestParameterDto> ltestParameterDto = new ArrayList<>();

    private TestParameterResultDTO testParameterResultDTO;

    public CheckTestResultsUI() throws IllegalAccessException, ParseException, InstantiationException, OutputException, ClassNotFoundException, BarcodeException, IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        clientTests = checkTestResultsController.getTests();

        for (TestDTO test : clientTests){
            listTests.getItems().add(test.getCode() + " - " + test.getDate());
        }

        TableColumn<ParameterDTO, String> parameter = new TableColumn<>("Parameter");
        parameter.setCellValueFactory(new PropertyValueFactory<>("shortName"));

        TableColumn<TestParameterResultDTO, String> value = new TableColumn<>("Value");
        value.setCellValueFactory(new PropertyValueFactory<>("value"));
        value.setPrefWidth(75);
        value.setResizable(false);

        TableColumn<TestParameterResultDTO, String> referenceValue = new TableColumn<>("Reference Value");
        referenceValue.setCellValueFactory(new PropertyValueFactory<>("refValue"));
        referenceValue.setPrefWidth(120);
        referenceValue.setResizable(false);

        TableColumn<TestParameterResultDTO, String> metric = new TableColumn<>("Metric");
        metric.setCellValueFactory(new PropertyValueFactory<>("metric"));
        metric.setPrefWidth(75);
        metric.setResizable(false);

        tableParameter.getColumns().add(parameter);

        tableResults.getColumns().addAll(value, referenceValue, metric);

        labelUserName.setText(checkTestResultsController.getUserName());
    }

    public void SelectTest(ActionEvent event){
        int index = 0;
        String code = listTests.getSelectionModel().getSelectedItems().get(0);
        report = checkTestResultsController.getTestReport(code);
        ltestParameterDto = checkTestResultsController.getTestParameter(code);
        for (TestParameterDto testParameterDto : ltestParameterDto){
            tableParameter.getItems().add(checkTestResultsController.getParameter(testParameterDto));
            tableResults.getItems().add(checkTestResultsController.getResults(testParameterDto));
            index++;
        }

        labelReport.setText(report.getDiagnosis());
    }
}
