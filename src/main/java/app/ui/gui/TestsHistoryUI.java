package app.ui.gui;

import app.controller.ClinicalChemTechController;
import app.domain.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;


import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class TestsHistoryUI implements Initializable {

    private Company c;
    private Test test;
    @FXML
    private TableView<TestDTO> testsTable;
    @FXML
    private TableColumn<TestDTO, String> testColumn;
    @FXML
    private TableColumn<TestDTO, Date> dateColumn;
    @FXML
    private Label clientTest;
    @FXML
    private Button testDetails;
    private ClinicalChemTechController controller;

    public TestsHistoryUI() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    controller = new ClinicalChemTechController();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void initData(ClientDTO ccnClient) throws ClassNotFoundException, InstantiationException, IllegalAccessException, OutputException, BarcodeException, ParseException, IOException {
        /*Company c = new Company("Many Labs");

        ParameterCategory pc = new ParameterCategory("hemogram", "ioiia");
        Parameter p = new Parameter("67899", "hemog", "hemoglobin values", pc);
        List<ParameterCategory> pcList = new ArrayList<>();
        pcList.add(pc);
        List<Parameter> pList = new ArrayList<>();
        pList.add(p);
        TestType tt = new TestType("COVID-19", "swab", "12345", pcList);
        List<TestType> ttList = new ArrayList<>();
        ttList.add(tt);
        Laboratory l = new Laboratory("001LR", "ExeterLaboratory", "Manchester", 11111111111L, 9811111111L, ttList);

        LabOrder lO = new LabOrder(tt,pList);
        Test t = new Test(c, client, "123456789098", lO, l);
        this.test = t; */
        //for (TestDTO testessss: t){
          //  System.out.println(testessss);
        //}
        clientTest.setText(ccnClient.getNameDto() + "'s tests" );
        testColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("validationDate"));
        testsTable.setItems(getTestsByClient(ccnClient));



    }

    public ObservableList<TestDTO> getTestsByClient(ClientDTO client) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ObservableList<TestDTO> tests = FXCollections.observableArrayList();

        for (TestDTO testes: controller.getTestsByClient(client)){
            tests.add(testes);
        }

        for (TestDTO t: tests){
            System.out.println(t);
        }

        return tests;

    }

      public void testDetailsOnAction(ActionEvent actionEvent) throws IOException, OutputException, BarcodeException, ParseException, ClassNotFoundException, IllegalAccessException, InstantiationException {
            TestDTO test = testsTable.getSelectionModel().getSelectedItems().get(0);
            FXMLLoader fxmlLoader = new FXMLLoader (getClass().getClassLoader().getResource("TestResult.fxml"));
            Parent root = fxmlLoader.load();
            TestDetailsUI controller = fxmlLoader.getController();
            controller.initData(test);
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(root);
            stage2.setTitle("TEST RESULT");
            stage2.setScene(scene2);
            stage2.setResizable(true);
            stage2.show();
        }

    private Company getCompany() {
        return null;
    }


}
