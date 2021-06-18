package app.ui.gui;

import app.controller.App;
import app.controller.LCOverviewController;
import app.domain.model.*;
import com.isep.mdis.Sum;
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
import java.util.*;

public class Graphs implements Initializable {


    @FXML
    private LineChart graph;

    @FXML
    private NumberAxis y;

    @FXML
    private CategoryAxis x;

    @FXML
    private LineChart graph1;

    @FXML
    private NumberAxis y1;

    @FXML
    private CategoryAxis x1;


    @FXML
    private LineChart graph2;

    @FXML
    private NumberAxis y2;

    @FXML
    private CategoryAxis x2;

    @FXML
    private LineChart graph3;

    @FXML
    private NumberAxis y3;

    @FXML
    private CategoryAxis x3;

    @FXML
    private Label testReg;

    @FXML
    private Label testVal;

    @FXML
    private Label nClient;

    @FXML
    private Label numOfClients;

    @FXML
    private Label testValidated;

    private List<Sequence> weekList=new ArrayList<>();

    private List<Sequence> monthList=new ArrayList<>();

    private List<Sequence> yearList=new ArrayList<>();

    private Company company;

    private ClientStore clientStore;

    private TestStore testStore;


    public Graphs() throws IllegalAccessException, ParseException, InstantiationException, OutputException, IOException, BarcodeException, ClassNotFoundException {
        this.company=App.getInstance().getCompany();
        this.clientStore=company.getClientStore();
        this.testStore=company.getTestStore();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            Locale.setDefault(Locale.UK);

            List<Sequence> sequenceList = LCOverviewController.getDiff();




            int[] array = new int[sequenceList.size()];

            for (int i = 0; i < sequenceList.size(); i++) {
                array[i] = sequenceList.get(i).getNumber();
            }


            int biggest = array[0];
            int lowest = array[0];

            for (int i = 0; i < array.length; i++) {
                if (array[i] > biggest) {
                    biggest = array[i];
                }
                if (array[i] < lowest) {
                    lowest = array[i];
                }
            }

            y.setUpperBound(biggest + 5);

            y.setLowerBound(lowest - 5);

            XYChart.Series series = new XYChart.Series();

            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            for (int i = 0; i < sequenceList.size(); i++) {
                series.getData().add(new XYChart.Data(DateFor.format(sequenceList.get(i).getDate()), sequenceList.get(i).getNumber()));
            }

            graph.getData().addAll(series);


            List<Sequence> testRegbyDay = LCOverviewController.getTestRegbyDay();

            List<Sequence> testValbyDay = LCOverviewController.getTestValbyDay();

            int numberOfTestReg = 0;
            for (Sequence sequence : testRegbyDay) {
                numberOfTestReg += sequence.getNumber();
            }

            int numberOfTestVal = 0;
            for (Sequence sequence : testValbyDay) {
                numberOfTestVal += sequence.getNumber();
            }

            testReg.setText(String.valueOf(numberOfTestReg));

            testVal.setText(String.valueOf(numberOfTestVal));



            y1.setUpperBound(biggest + 5);

            y1.setLowerBound(lowest - 5);

            XYChart.Series series1 = new XYChart.Series();



            showTestsByWeek(copyDiff(sequenceList));
            System.out.println("a");

            for (int i = 0; i < weekList.size(); i++) {
                series1.getData().add(new XYChart.Data(DateFor.format(weekList.get(i).getDate()), weekList.get(i).getNumber()));
            }

            graph1.getData().addAll(series1);



            System.out.println(copyDiff(sequenceList));

            showTestsByMonth(copyDiff(sequenceList));


            y2.setUpperBound(biggest + 5);

            y2.setLowerBound(lowest - 5);

            XYChart.Series series2= new XYChart.Series();



            for (int i = 0; i < monthList.size(); i++) {
                series2.getData().add(new XYChart.Data(DateFor.format(monthList.get(i).getDate()), monthList.get(i).getNumber()));
            }

            graph2.getData().addAll(series2);




            showTestsByYear(copyDiff(sequenceList));

            y3.setUpperBound(biggest + 5);

            y3.setLowerBound(lowest - 5);

            XYChart.Series series3= new XYChart.Series();






            for (int i = 0; i < yearList.size(); i++) {
                series3.getData().add(new XYChart.Data(DateFor.format(yearList.get(i).getDate()), yearList.get(i).getNumber()));
            }

            graph3.getData().addAll(series3);


            try {
                int[] result = getMaxSum().maxSum(array);

                nClient.setText(Arrays.toString(result));

                numOfClients.setText(String.valueOf(contClients()));

                testValidated.setText(String.valueOf(contTestValidated()));


            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IOException | OutputException | ParseException | BarcodeException e) {
                e.printStackTrace();
            }


        }catch (Exception e){
            throw new IllegalArgumentException("There are no tests");
        }
    }

    /**
     * Method to get the Api to use to create the barcodes
     * @return the ApiBarcode.
     */
    public MaxSum getMaxSum() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {

        Properties props = App.getInstance().getprops();
        String classAux = props.getProperty(LCOverviewController.getAlgorithm());
        Class<?> oClass = Class.forName(classAux);
        return (MaxSum) oClass.newInstance();

    }

    public void showTestsByWeek(List<Sequence> sequences) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String date= formatter.format(LCOverviewController.getStartDate());


        System.out.println(sequences);

        Date startDate= formatter.parse(date);

        Date endDate= formatter.parse(date);

        endDate=new Date(endDate.getYear(),endDate.getMonth(),endDate.getDate()+7);



        while (!sequences.isEmpty()){
            int sum=0;
            boolean f= false;
            int c=0;
            while (!sequences.isEmpty() && (( sequences.get(0).getDate().equals(startDate) || sequences.get(0).getDate().equals(endDate)|| sequences.get(0).getDate().after(startDate) && sequences.get(0).getDate().before(endDate)) )){

                sum+=sequences.get(0).getNumber();

                c++;
                f=true;
                sequences.remove(0);
            }
            if(f) {
                Sequence sequence = new Sequence(startDate, sum);
                f=false;
                weekList.add(sequence);
            }

            startDate=new Date(startDate.getYear(),startDate.getMonth(),startDate.getDate()+7);
            endDate=new Date(endDate.getYear(),endDate.getMonth(),endDate.getDate()+7);




        }

        System.out.println(weekList);
    }




    public void showTestsByMonth(List<Sequence> sequences) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String date= formatter.format(LCOverviewController.getStartDate());



        Date startDate= formatter.parse(date);

        Date endDate= formatter.parse(date);

        endDate=new Date(endDate.getYear(),endDate.getMonth()+1,endDate.getDate());



        while (!sequences.isEmpty()){
            int sum=0;
            boolean f= false;
            int c=0;
            while (!sequences.isEmpty() &&(( sequences.get(0).getDate().equals(startDate) || sequences.get(0).getDate().equals(endDate)|| sequences.get(0).getDate().after(startDate) && sequences.get(0).getDate().before(endDate)) )){

                sum+=sequences.get(0).getNumber();

                c++;
                f=true;
                sequences.remove(0);
            }
            if(f) {
                Sequence sequence = new Sequence(startDate, sum);
                f=false;
                monthList.add(sequence);
            }

            startDate=new Date(startDate.getYear(),startDate.getMonth()+1,startDate.getDate());
            endDate=new Date(endDate.getYear(),endDate.getMonth()+1,endDate.getDate());




        }

        System.out.println(monthList);
    }


    public void showTestsByYear(List<Sequence> sequences) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String date= formatter.format(LCOverviewController.getStartDate());



        Date startDate= formatter.parse(date);

        Date endDate= formatter.parse(date);

        endDate=new Date(endDate.getYear()+1,endDate.getMonth(),endDate.getDate());



        while (!sequences.isEmpty()){
            int sum=0;
            boolean f= false;
            int c=0;
            while (!sequences.isEmpty() && (( sequences.get(0).getDate().equals(startDate) || sequences.get(0).getDate().equals(endDate)|| sequences.get(0).getDate().after(startDate) && sequences.get(0).getDate().before(endDate)) )){

                sum+=sequences.get(0).getNumber();

                c++;
                f=true;
                sequences.remove(0);
            }
            if(f) {
                Sequence sequence = new Sequence(startDate, sum);
                f=false;
                yearList.add(sequence);
            }

            startDate=new Date(startDate.getYear()+1,startDate.getMonth(),startDate.getDate());
            endDate=new Date(endDate.getYear()+1,endDate.getMonth(),endDate.getDate());




        }

        System.out.println(yearList);
    }


    public List<Sequence> copyDiff(List<Sequence> diff){
        List<Sequence> copy= new ArrayList<>();

        for (Sequence sequence: diff){

            copy.add(sequence);

        }

        return copy;
    }



    public int contClients(){

        return testStore.contNumberofClients(testStore.getTestsInIntervalRegistDate(LCOverviewController.getStartDate(),LCOverviewController.getEndDate()));

    }

    public int contTestValidated(){

        return testStore.contNumberofTestValidated(testStore.getTestsInInterval(LCOverviewController.getStartDate(),LCOverviewController.getEndDate()));

    }

}
