package app.ui.gui;

import app.domain.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.Set;

public class TestDetailsUI implements Initializable {

    @FXML
    private TableView <TestResultClient> clientResults;
    @FXML
    private TableColumn<TestResultClient, String> parameterColumn;
    @FXML
    private TableColumn<TestResultClient, String> minRefValueColumn;
    @FXML
    private TableColumn<TestResultClient, String> maxRefValueColumn;
    @FXML
    private TableColumn<TestResultClient, Double> valueColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public ObservableList<TestResultClient> getParameters(TestDTO testDTO) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ObservableList<TestResultClient> testParameters = FXCollections.observableArrayList();

        for (TestParameterDto parameters: testDTO.getTestParameterList()){
            System.out.println("ola");
            testParameters.add(new TestResultClient(parameters, parameters.getTprdto()));
        }

        for (TestResultClient t: testParameters){
            System.out.println(t);
        }

        return testParameters;

    }

    /*public ObservableList<ReferenceValue> getReferenceValue(TestDTO testDTO) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ObservableList<ReferenceValue> testParameters = FXCollections.observableArrayList();


        for (TestParameterDto parameters: testDTO.getTestParameterList()){
            System.out.println(parameters);
            if (parameters.getTprdto()!=null) {
                testParameters.add(parameters.getTprdto().getRefValue());
            }

        }

        return testParameters;

    }

    public ObservableList<TestParameterResult> getResultValue(TestDTO testDTO) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ObservableList<TestParameterResult> testParameters = FXCollections.observableArrayList();


        for (TestParameterDto parameters: testDTO.getTestParameterList()){
            if (parameters.getTprdto()!=null) {
                testParameters.add(parameters.getTprdto());
            }

        }

        return testParameters;

    }

    private ScrollBar findScrollBar(TableView<?> table)
    {
        return (ScrollBar) table.lookup(".scroll-bar:vertical");
    }*/


    public void initData (TestDTO testDTO) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        parameterColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        minRefValueColumn.setCellValueFactory(new PropertyValueFactory<>("minimum"));
        maxRefValueColumn.setCellValueFactory(new PropertyValueFactory<>("maximum"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        clientResults.setItems(getParameters(testDTO));

    }



}
