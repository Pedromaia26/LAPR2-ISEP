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
    private TableView <Parameter> table1;
    @FXML
    private TableView <ReferenceValue> table2;
    @FXML
    private TableView <TestParameterResult> table3;
    @FXML
    private TableColumn<Parameter, String> parameterColumn;
    @FXML
    private TableColumn<ReferenceValue, String> minRefValueColumn;
    @FXML
    private TableColumn<ReferenceValue, String> maxRefValueColumn;
    @FXML
    private TableColumn<TestParameterResult, Double> valueColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }


    public ObservableList<Parameter> getParameters(TestDTO testDTO) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ObservableList<Parameter> testParameters = FXCollections.observableArrayList();

        for (TestParameterDto parameters: testDTO.getTestParameterList()){
            testParameters.add(parameters.getParameterdto());
        }

        return testParameters;

    }

    public ObservableList<ReferenceValue> getReferenceValue(TestDTO testDTO) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
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
    }


    public void initData (TestDTO testDTO) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        parameterColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        minRefValueColumn.setCellValueFactory(new PropertyValueFactory<>("minimum"));
        maxRefValueColumn.setCellValueFactory(new PropertyValueFactory<>("maximum"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        table1.setItems(getParameters(testDTO));
        table2.setItems(getReferenceValue(testDTO));
        table3.setItems(getResultValue(testDTO));
        // synchronize scrollbars (must happen after table was made visible)
        scrollBar();
    }

    public void scrollBar(){
        ScrollBar tableParametersScrollBar = findScrollBar(table1);
        System.out.println(tableParametersScrollBar);
        ScrollBar referenceValuesScrollBar = findScrollBar(table2);
        ScrollBar parameterResultScrollBar = findScrollBar(table3);
        //tableParametersScrollBar.valueProperty().bindBidirectional(parameterResultScrollBar.valueProperty());
    }


}
