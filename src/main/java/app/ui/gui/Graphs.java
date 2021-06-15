package app.ui.gui;

import app.controller.LCOverviewController;
import app.domain.model.Sequence;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

public class Graphs implements Initializable {


    @FXML
    private LineChart graph;

    @FXML
    private NumberAxis y;

    @FXML
    private CategoryAxis x;

    @FXML
    private Label testReg;

    @FXML
    private Label testVal;

    @FXML
    private Label nClient;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Sequence> sequenceList = LCOverviewController.getDiff();

        System.out.println(sequenceList);

        int[] array = new int[sequenceList.size()];

        for (int i=0; i<sequenceList.size(); i++){
            array[i]=sequenceList.get(i).getNumber();
        }



        int biggest=array[0];
        int lowest=array[0];

        for (int i=0; i<array.length;i++){
            if (array[i]>biggest){
                biggest= array[i];
            }
            if (array[i]<lowest){
                lowest=array[i];
            }
        }

        y.setUpperBound(biggest+5);

        y.setLowerBound(lowest-5);

        XYChart.Series series = new XYChart.Series();

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");

        for (int i=0; i<sequenceList.size();i++){
            series.getData().add(new XYChart.Data(DateFor.format(sequenceList.get(i).getDate()),sequenceList.get(i).getNumber()));
        }

        graph.getData().addAll(series);



        List<Sequence> testRegbyDay = LCOverviewController.getTestRegbyDay();

        List<Sequence> testValbyDay = LCOverviewController.getTestValbyDay();

        int numberOfTestReg=0;
        for (Sequence sequence : testRegbyDay){
            numberOfTestReg+=sequence.getNumber();
        }

        int numberOfTestVal=0;
        for (Sequence sequence : testValbyDay){
            numberOfTestVal+=sequence.getNumber();
        }

        testReg.setText(String.valueOf(numberOfTestReg));

        testVal.setText(String.valueOf(numberOfTestVal));








    }

}