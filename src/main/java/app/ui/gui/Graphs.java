package app.ui.gui;

import app.controller.App;
import app.controller.LCOverviewController;
import app.domain.model.*;
import com.isep.mdis.Sum;
import javafx.event.ActionEvent;
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
    private LineChart graph11;

    @FXML
    private CategoryAxis x11;

    @FXML
    private NumberAxis y11;

    @FXML
    private LineChart graph12;

    @FXML
    private CategoryAxis x12;

    @FXML
    private NumberAxis y12;

    @FXML
    private LineChart graph13;

    @FXML
    private CategoryAxis x13;

    @FXML
    private NumberAxis y13;

    @FXML
    private Label numOfClients;

    @FXML
    private Label testValidated;

    @FXML
    private LineChart graph14;

    @FXML
    private CategoryAxis x14;

    @FXML
    private NumberAxis y14;

    @FXML
    private LineChart graph21;

    @FXML
    private CategoryAxis x21;

    @FXML
    private NumberAxis y21;

    @FXML
    private LineChart graph31;

    @FXML
    private CategoryAxis x31;

    @FXML
    private NumberAxis y31;

    @FXML
    private LineChart graph22;

    @FXML
    private CategoryAxis x22;

    @FXML
    private NumberAxis y22;

    @FXML
    private LineChart graph23;

    @FXML
    private CategoryAxis x23;

    @FXML
    private NumberAxis y23;

    @FXML
    private LineChart graph24;

    @FXML
    private CategoryAxis x24;

    @FXML
    private NumberAxis y24;

    @FXML
    private LineChart graph32;

    @FXML
    private CategoryAxis x32;

    @FXML
    private NumberAxis y32;

    @FXML
    private LineChart graph33;

    @FXML
    private CategoryAxis x33;

    @FXML
    private NumberAxis y33;

    @FXML
    private LineChart graph34;

    @FXML
    private CategoryAxis x34;

    @FXML
    private NumberAxis y34;

    @FXML
    private Label testReg;

    @FXML
    private Label testVal;

    @FXML
    private Label nClient;

    private List<Sequence> dayList=new ArrayList<>();

    private List<Sequence> weekList=new ArrayList<>();

    private List<Sequence> monthList=new ArrayList<>();

    private List<Sequence> yearList=new ArrayList<>();

    private Company company;

    private ClientStore clientStore;

    private TestStore testStore;

    @FXML
    private Label endDateSub;

    @FXML
    private Label startDateSub;


    public Graphs() throws IllegalAccessException, ParseException, InstantiationException, OutputException, IOException, BarcodeException, ClassNotFoundException {
        this.company=App.getInstance().getCompany();
        this.clientStore=company.getClientStore();
        this.testStore=company.getTestStore();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {


            List<Sequence> sequenceList = LCOverviewController.getDiff();

            SimpleDateFormat days = new SimpleDateFormat("dd/MM/yyyy");

            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            int[] array = new int[sequenceList.size()];

            for (int i = 0; i < sequenceList.size(); i++) {
                array[i] = sequenceList.get(i).getNumber();
            }
            int[] result = getMaxSum().maxSum(array);



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




            boolean f=false;
            int cont2=0;
            int cont = 0;
            while (cont2 < result.length || !f) {


                while (cont < result.length && result[0] != sequenceList.get(cont).getNumber()) {

                    cont++;
                }

                cont2=cont;
                cont++;

                while (cont2 < result.length && result[cont2]==sequenceList.get(cont2).getNumber()){

                    cont2++;
                }


                if (cont2==result.length){

                    f=true;
                }


            }
            if (f){
                String startingDate = DateFor.format(sequenceList.get(cont).getDate());
                String endingDate = DateFor.format(sequenceList.get(cont2-1).getDate());


                endDateSub.setText(endingDate);
                startDateSub.setText(startingDate);

            }







            makeGraphic(DateFor,sequenceList,graph);


            List<Sequence> testRegbyDay = LCOverviewController.getTestRegbyDay();

            List<Sequence> testAnalbyDay = LCOverviewController.getTestAnalbyDay();

            List<Sequence> testValbyDay = LCOverviewController.getTestbyValDay();

            int numberOfTestReg = 0;
            for (Sequence sequence : testRegbyDay) {
                numberOfTestReg += sequence.getNumber();
            }

            int numberOfTestVal = 0;
            for (Sequence sequence : testAnalbyDay) {
                numberOfTestVal += sequence.getNumber();
            }

            testReg.setText(String.valueOf(numberOfTestReg));

            testVal.setText(String.valueOf(numberOfTestVal));






            showTestsByDay(copyDiff(testRegbyDay));

            makeGraphic(days,dayList,graph11);




            showTestsByWeek(copyDiff(testRegbyDay));

            makeGraphic(days,weekList,graph12);


            showTestsByMonth(copyDiff(testRegbyDay));

            makeGraphic(days,monthList,graph13);


            showTestsByYear(copyDiff(testRegbyDay));

            makeGraphic(days,yearList,graph14);


            showTestsByDay(copyDiff(testAnalbyDay));
            makeGraphic(days,dayList,graph21);


            showTestsByWeek(copyDiff(testAnalbyDay));
            makeGraphic(days,weekList,graph22);

            showTestsByMonth(copyDiff(testAnalbyDay));
            makeGraphic(days,monthList,graph23);

            showTestsByMonth(copyDiff(testAnalbyDay));
            makeGraphic(days,yearList,graph24);


            showTestsByDay(copyDiff(testValbyDay));
            makeGraphic(days,dayList,graph31);

            showTestsByWeek(copyDiff(testValbyDay));
            makeGraphic(days,weekList,graph32);

            showTestsByWeek(copyDiff(testValbyDay));
            makeGraphic(days,monthList,graph33);

            showTestsByWeek(copyDiff(testValbyDay));
            makeGraphic(days,yearList,graph34);


            nClient.setText(Arrays.toString(result));

            numOfClients.setText(String.valueOf(contClients()));

            testValidated.setText(String.valueOf(contTestValidated()));


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


    public void showTestsByDay(List<Sequence> sequences) throws ParseException {
        dayList=new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String date= formatter.format(LCOverviewController.getStartDate());


        Date startDate= formatter.parse(date);

        Date endDate= formatter.parse(date);

        endDate=new Date(endDate.getYear(),endDate.getMonth(),endDate.getDate()+1);



        while (!sequences.isEmpty()){
            int sum=0;
            boolean f= false;
            int c=0;

            while (!sequences.isEmpty() && (( sequences.get(0).getDate().equals(startDate) || sequences.get(0).getDate().equals(endDate)|| (sequences.get(0).getDate().after(startDate) && sequences.get(0).getDate().before(endDate))) )){

                System.out.println(sequences);
                sum+=sequences.get(0).getNumber();

                c++;
                f=true;
                sequences.remove(0);
            }
            if(f) {
                Sequence sequence = new Sequence(startDate, sum);
                f=false;
                dayList.add(sequence);
            }

            startDate=new Date(startDate.getYear(),startDate.getMonth(),startDate.getDate()+1);
            endDate=new Date(endDate.getYear(),endDate.getMonth(),endDate.getDate()+1);




        }

        System.out.println(dayList);
    }

    public void showTestsByWeek(List<Sequence> sequences) throws ParseException {

        weekList=new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String date= formatter.format(LCOverviewController.getStartDate());




        Date startDate= formatter.parse(date);

        Date endDate= formatter.parse(date);

        endDate=new Date(endDate.getYear(),endDate.getMonth(),endDate.getDate()+7);



        while (!sequences.isEmpty()){
            int sum=0;
            boolean f= false;
            int c=0;
            while (!sequences.isEmpty() && (( sequences.get(0).getDate().equals(startDate) || sequences.get(0).getDate().equals(endDate)|| (sequences.get(0).getDate().after(startDate) && sequences.get(0).getDate().before(endDate))) )){

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

        monthList=new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String date= formatter.format(LCOverviewController.getStartDate());



        Date startDate= formatter.parse(date);

        Date endDate= formatter.parse(date);

        endDate=new Date(endDate.getYear(),endDate.getMonth()+1,endDate.getDate());



        while (!sequences.isEmpty()){
            int sum=0;
            boolean f= false;
            int c=0;
            while (!sequences.isEmpty() &&(( sequences.get(0).getDate().equals(startDate) || sequences.get(0).getDate().equals(endDate)|| (sequences.get(0).getDate().after(startDate) && sequences.get(0).getDate().before(endDate))) )){

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

        yearList=new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String date= formatter.format(LCOverviewController.getStartDate());



        Date startDate= formatter.parse(date);

        Date endDate= formatter.parse(date);

        endDate=new Date(endDate.getYear()+1,endDate.getMonth(),endDate.getDate());



        while (!sequences.isEmpty()){
            int sum=0;
            boolean f= false;
            int c=0;
            while (!sequences.isEmpty() && (( sequences.get(0).getDate().equals(startDate) || sequences.get(0).getDate().equals(endDate)|| (sequences.get(0).getDate().after(startDate) && sequences.get(0).getDate().before(endDate))) )){

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

    public void makeGraphic(SimpleDateFormat formatter,List<Sequence> list, LineChart graph){



        XYChart.Series series1 = new XYChart.Series();




        for (int i = 0; i < list.size(); i++) {
            series1.getData().add(new XYChart.Data(formatter.format(list.get(i).getDate()), list.get(i).getNumber()));
        }

        graph.getData().addAll(series1);

        series1.getNode().setStyle("-fx-stroke:  #2D584F;");


    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
