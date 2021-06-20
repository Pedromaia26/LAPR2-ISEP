package app.ui.gui;

import app.domain.model.*;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestParameterDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

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
            if (parameters.getTprdto()!=null) {
                testParameters.add(new TestResultClient(parameters, parameters.getTprdto()));
            }

        }

        for (TestResultClient t: testParameters){
            System.out.println(t);
        }

        return testParameters;

    }
    

    public void initData (TestDTO testDTO) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        parameterColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        minRefValueColumn.setCellValueFactory(new PropertyValueFactory<>("minimum"));
        maxRefValueColumn.setCellValueFactory(new PropertyValueFactory<>("maximum"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        clientResults.setItems(getParameters(testDTO));

    }


    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
