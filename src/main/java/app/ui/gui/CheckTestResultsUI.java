package app.ui.gui;

import app.controller.CheckTestResultsController;
import app.domain.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
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
import java.util.Set;

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

    Stage stage;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private ScrollBar scroll;

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

    private ScrollBar findScrollBar(TableView<?> table)
    {
        return (ScrollBar) table.lookup(".scroll-bar:vertical");
    }

    public void SelectTest(ActionEvent event){
        ScrollBar TableResultsScrollBar = findScrollBar(tableResults);
        ScrollBar TableParameterScrollBar = findScrollBar(tableParameter);
        TableResultsScrollBar.valueProperty().bindBidirectional(TableParameterScrollBar.valueProperty());
        ScrollBar scrollBarH = (ScrollBar) tableParameter.lookup(".scroll-bar:vertical");
        ScrollBar scrollBarH1 = (ScrollBar) tableResults.lookup(".scroll-bar:horizontal");
        ScrollBar scrollBarV = (ScrollBar) tableParameter.lookup(".scroll-bar:horizontal");
        scrollBarH.setVisible(false);
        scrollBarH1.setVisible(false);
        scrollBarV.setVisible(false);
        int index = 0;
        String code = listTests.getSelectionModel().getSelectedItems().get(0);
        String[] array = code.split(" - ");
        report = checkTestResultsController.getTestReport(array[0]);
        ltestParameterDto = checkTestResultsController.getTestParameter(array[0]);
        for (TestParameterDto testParameterDto : ltestParameterDto){
            tableParameter.getItems().add(checkTestResultsController.getParameter(testParameterDto));
            tableResults.getItems().add(checkTestResultsController.getResults(testParameterDto));
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
}
