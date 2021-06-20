package app.ui.gui;

import app.controller.CheckTestResultsController;
import app.domain.model.*;
import app.mappers.dto.ReportDTO;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestParameterDto;
import app.mappers.dto.TestParameterResultDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CheckTestResultsUI implements Initializable {

    @FXML
    private ListView<String> listTests = new ListView<>();

    @FXML
    private TableView<TestResultClient> tableResults = new TableView<>();

    @FXML
    private Label labelUserName = new Label();

    @FXML
    private Label labelReport = new Label();

    private Stage stage;

    @FXML
    private AnchorPane anchorpane;

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

        TableColumn<TestResultClient, String> parameter = new TableColumn<>("Parameter");
        parameter.setCellValueFactory(new PropertyValueFactory<>("shortName"));
        parameter.setPrefWidth(90);
        parameter.setResizable(false);

        TableColumn<TestResultClient, String> value = new TableColumn<>("Value");
        value.setCellValueFactory(new PropertyValueFactory<>("value"));
        value.setPrefWidth(90);
        value.setResizable(false);

        TableColumn<TestResultClient, String> referenceValue = new TableColumn<>("Reference Value");
        referenceValue.setCellValueFactory(new PropertyValueFactory<>("refValue"));
        referenceValue.setPrefWidth(220);
        referenceValue.setResizable(false);

        TableColumn<TestResultClient, String> metric = new TableColumn<>("Metric");
        metric.setCellValueFactory(new PropertyValueFactory<>("metric"));
        metric.setPrefWidth(90);
        metric.setResizable(false);


        tableResults.getColumns().addAll(parameter, value, referenceValue, metric);

        labelUserName.setText(checkTestResultsController.getUserName());
    }

    private ScrollBar findScrollBar(TableView<?> table)
    {
        return (ScrollBar) table.lookup(".scroll-bar:vertical");
    }

    public void SelectTest(ActionEvent event){
        ScrollBar scrollBarH1 = (ScrollBar) tableResults.lookup(".scroll-bar:horizontal");
        scrollBarH1.setVisible(false);
        int index = 0;
        String code = listTests.getSelectionModel().getSelectedItems().get(0);
        String[] array = code.split(" - ");
        report = checkTestResultsController.getTestReport(array[0]);
        ltestParameterDto = checkTestResultsController.getTestParameter(array[0]);
        TestResultClient trClient;
        for (TestParameterDto testParameterDto : ltestParameterDto){
            trClient = new TestResultClient(checkTestResultsController.getParameter(testParameterDto), checkTestResultsController.getResults(testParameterDto));
            tableResults.getItems().add(trClient);
            index++;
        }

        labelReport.setText(report.getDiagnosis());
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {

        stage = (Stage) anchorpane.getScene().getWindow();

        System.out.println("closed");

        stage.close();

        Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("clientMenu.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(aaaaa);
        stage2.setTitle("CLIENT MENU");
        stage2.setScene(scene2);
        stage2.setResizable(true);
        stage2.show();

    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
