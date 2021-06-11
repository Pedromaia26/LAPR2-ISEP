package app.controller;

import app.domain.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LCOverviewController implements Initializable {
    private TestStore testStore;

    private Company company;

    private TestMapper tMapper= new TestMapper();

    @FXML
    private ListView listView;

    @FXML
    private Label label;

    List<Test> listTests;

    List<Test> testValidatedList;

    List<Integer> diff;

    public LCOverviewController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.company=App.getInstance().getCompany();
        this.testStore=App.getInstance().getCompany().getTestStore();


    }

    public List<TestDTO> getTests(){
        testValidatedList = new ArrayList<>();
        listTests = testStore.getTests();
        for (Test test : listTests){
            System.out.println(test.getValidationDate());
            if (test.getValidationDate() != null){
                testValidatedList.add(test);

            }
        }


        List<TestDTO> clientTests = tMapper.toDto(testValidatedList);
        return clientTests;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        for(TestDTO testDTO : getTests()){
            listView.getItems().add(testDTO.getCode());

        }


    }


    public void analyse(ActionEvent actionEvent) {

        diff = new ArrayList<>();

        int cVal=0;
        int cNVal=0;
        String aData="";
        String oData="";
        int i=0;
        System.out.println(getTests());
        while (i<listTests.size()-1) {
            do {
                i++;
                cNVal++;
                if (listTests.get(i-1).getValidationDate() != null) {
                    cVal++;
                }
                oData=String.valueOf(listTests.get(i-1).getDate());
                aData=String.valueOf(listTests.get(i).getDate());
            }while (aData.equals(oData) && i<listTests.size()-1);
            if (i==listTests.size()-1){
                i++;
                cNVal++;
                if (listTests.get(i-1).getValidationDate() != null) {
                    cVal++;
                }
            }
            diff.add((cVal-cNVal));
            cNVal=cNVal-cVal;
            cVal=0;

            oData=aData;

        }

        System.out.println(diff);

    }
}
