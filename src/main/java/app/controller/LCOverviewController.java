package app.controller;

import app.domain.model.*;

import app.mappers.TestMapper;
import app.mappers.dto.TestDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LCOverviewController implements Initializable{


    private TestStore testStore;

    private Company company;

    private TestMapper tMapper= new TestMapper();

    @FXML
    private ListView listView;

    @FXML
    private Label label;

    @FXML
    private DatePicker startDateBox;

    @FXML
    private DatePicker endDateBox;

    @FXML
    private Button btnAnalise;


    private List<Test> listTests;

    private List<Test> listTestsinRegDateRange=new ArrayList<>();

    private List<Test> listTestsinValDateRange=new ArrayList<>();

    private List<Test> listTestsinValitaionDateRange=new ArrayList<>();

    private List<Test> testValidatedList;

    private static List<Sequence> diff = new ArrayList<>();

    private static List<Sequence> testByRegDay = new ArrayList<>();

    private static List<Sequence> testByAnalDay = new ArrayList<>();

    private static List<Sequence> testByValDay = new ArrayList<>();


    @FXML
    private ComboBox algorithms;

    @FXML
    private ComboBox startHour;

    @FXML
    private ComboBox startMinute;

    @FXML
    private ComboBox endMinute;

    @FXML
    private ComboBox endHour;

    private static String algorithm;

    private static Date startDate;

    private static Date endDate;

    private Stage stage;

    @FXML
    private AnchorPane anchorPane;


    public LCOverviewController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.company=App.getInstance().getCompany();
        this.testStore=App.getInstance().getCompany().getTestStore();


    }

    public List<TestDTO> getTests(){
        testValidatedList = new ArrayList<>();
        listTests = testStore.getTests();
        for (Test test : listTests){
            System.out.println(test.getResultRegist());
            if (test.getResultRegist() != null){
                testValidatedList.add(test);

            }
        }


        List<TestDTO> clientTests = tMapper.toDto(testValidatedList);
        return clientTests;
    }


    public void getTestsInInterval(){
        for(Test test : listTests){

            if ((test.getDate().toInstant().equals(startDate.toInstant()) || test.getDate().toInstant().equals(endDate.toInstant()) )|| (test.getDate().toInstant().isAfter(startDate.toInstant()) && test.getDate().toInstant().isBefore(endDate.toInstant()))){
                verify30Min(test,1);
                listTestsinRegDateRange.add(test);
            }

            if ((test.getResultRegist().toInstant().equals(startDate.toInstant()) || test.getResultRegist().toInstant().equals(endDate.toInstant()) )|| (test.getResultRegist().toInstant().isAfter(startDate.toInstant())&& test.getResultRegist().toInstant().isBefore(endDate.toInstant()))){

                verify30Min(test,2);
                listTestsinValDateRange.add(test);
            }
            if ((test.getDate().toInstant().equals(startDate.toInstant()) || test.getDate().toInstant().equals(endDate.toInstant()) )|| (test.getDate().toInstant().isAfter(startDate.toInstant()) && test.getDate().toInstant().isBefore(endDate.toInstant()))){
                verify30Min(test,3);
                listTestsinValitaionDateRange.add(test);
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Locale.setDefault(Locale.UK);


        for(TestDTO testDTO : getTests()){
            listView.getItems().add(testDTO.getCode() + "-" + testDTO.getDate());

        }

        algorithms.getItems().add("Brute Force");

        algorithms.getItems().add("Benchmark");

        startHour.getItems().addAll("08","09","10","11","12","13","14","15","16","17","18","19","20");

        endHour.getItems().addAll("08","09","10","11","12","13","14","15","16","17","18","19","20");

        startMinute.getItems().addAll("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59");

        endMinute.getItems().addAll("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59");

    }


    public void analyse(ActionEvent actionEvent) throws ParseException, IOException {
        try {
            List<Sequence> sequences = new ArrayList<>();
            List<Sequence> sequences2 = new ArrayList<>();
            List<Sequence> sequences3 = new ArrayList<>();

            listTestsinRegDateRange = new ArrayList<>();
            listTestsinValDateRange = new ArrayList<>();
            listTestsinValitaionDateRange=new ArrayList<>();

            diff = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(startDateBox.getValue().format(formatter) + " " + startHour.getValue().toString() + ":" + startMinute.getValue().toString());
            endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(endDateBox.getValue().format(formatter) + " " + endHour.getValue().toString() + ":" + endMinute.getValue().toString());

            getTestsInInterval();


            int cVal = 0;
            int cNVal = 0;
            Date aData = new Date();
            Date oData = new Date();
            Date lData = new Date();
            String oVData = "";
            String aVData = "";
            int i = 0;

            while (i < listTestsinRegDateRange.size() - 1) {

                do {
                    i++;



                /*f (listTests.get(i-1).getValidationDate() != null && listTests.get(i-1).getValidationDate().toString().equals(aData)) {
                    cVal++;
                }*/
                    cNVal++;
                    oData = (listTestsinRegDateRange.get(i - 1).getFakeDate());
                    aData = (listTestsinRegDateRange.get(i).getFakeDate());


                } while (aData.equals(oData) && i < listTestsinRegDateRange.size() - 1);
                if (i == listTestsinRegDateRange.size() - 1) {
                    i++;
                    cNVal++;
                    lData = listTestsinRegDateRange.get(i - 1).getFakeDate();
                /*if (listTests.get(i-1).getValidationDate() != null) {
                    cVal++;
                }*/
                    if (lData.equals(oData)) {
                        sequences.add(new Sequence(oData, cNVal));
                    } else {
                        sequences.add(new Sequence(oData, cNVal - 1));
                        sequences.add(new Sequence(lData, 1));
                    }
                } else {
                    sequences.add(new Sequence(oData, cNVal));
                }


                cNVal = 0;

                oData = aData;

                //diff.add((cVal-cNVal));
            }
            i = 0;
            cVal = 0;
            cNVal = 0;
            aData = new Date();
            oData = new Date();


            while (i < listTestsinValDateRange.size() - 1) {

                do {
                    i++;
                    if (listTestsinValDateRange.get(i - 1).getFakeResultRegist() != null) {

                        cNVal++;
                        oData = listTestsinValDateRange.get(i - 1).getFakeResultRegist();
                        aData = listTestsinValDateRange.get(i).getFakeResultRegist();


                    }

                /*f (listTests.get(i-1).getValidationDate() != null && listTests.get(i-1).getValidationDate().toString().equals(aData)) {
                    cVal++;
                }*/


                } while (aData != null && aData.equals(oData) && i < listTestsinValDateRange.size() - 1);
                if (i == listTestsinValDateRange.size() - 1) {
                    i++;

                    if (listTestsinValDateRange.get(i - 1).getFakeResultRegist() != null) {

                        cNVal++;
                        lData = listTestsinValDateRange.get(i - 1).getFakeResultRegist();
                    }
                    if (lData.equals(oData)) {
                        sequences2.add(new Sequence(oData, cNVal));
                    } else {
                        sequences2.add(new Sequence(oData, cNVal - 1));
                        sequences2.add(new Sequence(lData, 1));
                    }

                } else {
                    sequences2.add(new Sequence(oData, cNVal));
                }


                cNVal = 0;

                oData = aData;

                //diff.add((cVal-cNVal));
            }

            i = 0;
            cVal = 0;
            cNVal = 0;
            aData = new Date();
            oData = new Date();

            while (i < listTestsinValitaionDateRange.size() - 1) {

                do {
                    i++;
                    if (listTestsinValitaionDateRange.get(i - 1).getFakeValidationDate() != null) {

                        cNVal++;
                        oData = listTestsinValitaionDateRange.get(i - 1).getFakeValidationDate();
                        aData = listTestsinValitaionDateRange.get(i).getFakeValidationDate();


                    }

                /*f (listTests.get(i-1).getValidationDate() != null && listTests.get(i-1).getValidationDate().toString().equals(aData)) {
                    cVal++;
                }*/


                } while (aData != null && aData.equals(oData) && i < listTestsinValitaionDateRange.size() - 1);
                if (i == listTestsinValitaionDateRange.size() - 1) {
                    i++;

                    if (listTestsinValitaionDateRange.get(i - 1).getFakeValidationDate() != null) {

                        cNVal++;
                        lData = listTestsinValitaionDateRange.get(i - 1).getFakeValidationDate();
                    }
                    if (lData.equals(oData)) {
                        sequences3.add(new Sequence(oData, cNVal));
                    } else {
                        sequences3.add(new Sequence(oData, cNVal - 1));
                        sequences3.add(new Sequence(lData, 1));
                    }

                } else {
                    sequences3.add(new Sequence(oData, cNVal));
                }


                cNVal = 0;

                oData = aData;

                //diff.add((cVal-cNVal));
            }


            System.out.println(sequences);

            System.out.println(sequences2);

            System.out.println(sequences3);

            difference(sequences, sequences2, sequences3);
            sortDiff();


            System.out.println(diff);


            Parent graphs = FXMLLoader.load(getClass().getClassLoader().getResource("Graphs.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(graphs);
            stage2.setTitle("Graph");
            stage2.setScene(scene2);
            stage2.setResizable(true);
            stage2.show();

        }catch (Exception e){
            label.setText("There are no tests");
            System.out.println(e);
        }



    }

    public void difference(List<Sequence> sequences, List<Sequence> sequences2, List<Sequence> sequences3) throws ParseException {
        testByAnalDay=new ArrayList<>();
        testByRegDay=new ArrayList<>();
        testByValDay=new ArrayList<>();

        testByRegDay.addAll(sequences);
        testByAnalDay.addAll(sort(sequences2));
        testByValDay.addAll(sort(sequences3));




        int i=0;
        while (sequences.size()!=0 || sequences2.size()!=0){




            while ((sequences.size()!=0 && sequences2.size()!=0) && sequences.get(0).getDate()!=null && sequences2.get(i).getDate()!=null && sequences.get(0).getDate().toString().equals(sequences2.get(i).getDate().toString())) {
                System.out.println("c");
                System.out.println(sequences2);


                diff.add(new Sequence(sequences2.get(i).getDate(),sequences.get(0).getNumber()-sequences2.get(i).getNumber()));
                sequences.remove(0);
                sequences2.remove(i);

            }
            i=0;

            while ((sequences.size()!=0 && sequences2.size()!=0) && i<sequences2.size() && !sequences.get(0).getDate().toString().equals(sequences2.get(i).getDate().toString())){

                i++;
                if(i!=sequences2.size()){

                    System.out.println(sequences2.get(i).getDate());

                }

            }
            if(i==sequences2.size()){


                i=0;
            }


            if((sequences.size()!=0 && sequences2.size()!=0) && sequences.get(0).getDate()!=null && sequences2.get(i).getDate()!=null && !sequences.get(0).getDate().toString().equals(sequences2.get(i).getDate().toString())){
                diff.add(new Sequence(sequences.get(0).getDate(),sequences.get(0).getNumber()));
                sequences.remove(0);
            }


           /* while ((sequences.size()!=0 && sequences2.size()!=0) && sequences.get(0).getDate()!=null && sequences2.get(i).getDate()!=null && !sequences.get(0).getDate().toString().equals(sequences2.get(i).getDate().toString())){
                System.out.println("b");
                System.out.println(sequences);
                System.out.println(sequences2);


                    diff.add(new Sequence(sequences.get(0).getDate(),-sequences.get(0).getNumber()));
                    sequences.remove(i);

                    break;





            }*/

            int c=1;
            boolean f;
            while (sequences.size()==0 && sequences2.size()!=0){
                System.out.println("a");
                System.out.println(sequences2);
                while (c<sequences2.size() && !sequences2.get(0).getDate().equals(sequences2.get(c).getDate())){
                    System.out.println(sequences2.get(0).getDate());
                    System.out.println(sequences2.get(c).getDate());
                    System.out.println();
                        c++;

                }
                if(c==sequences2.size()){
                    f = false;
                }
                else  f = true;
                if(f){

                    diff.add(new Sequence(sequences2.get(0).getDate(),-(sequences2.get(0).getNumber()+sequences2.get(c).getNumber())));
                    sequences2.remove(0);
                    sequences2.remove(c-1);
                }
                else {
                    diff.add(new Sequence(sequences2.get(0).getDate(),-sequences2.get(0).getNumber()));
                    sequences2.remove(0);
                }
                c=1;
            }

            while (sequences.size()!=0 && sequences2.size()==0){
                System.out.println("j");
                System.out.println(sequences);
                while (c<sequences.size() && !sequences.get(0).getDate().equals(sequences.get(c).getDate())){
                    System.out.println(sequences.get(0).getDate());
                    System.out.println(sequences.get(c).getDate());
                    System.out.println();
                    c++;

                }
                if(c==sequences.size()){
                    f = false;
                }
                else  f = true;
                if(f){

                    diff.add(new Sequence(sequences.get(0).getDate(),(sequences.get(0).getNumber()+sequences.get(c).getNumber())));
                    sequences.remove(0);
                    sequences.remove(c-1);
                }
                else {
                    diff.add(new Sequence(sequences.get(0).getDate(),sequences.get(0).getNumber()));
                    sequences.remove(0);
                }
                c=1;
            }

        }







    }

    public void sortDiff(){

        for (int i=0; i<diff.size()-1;i++){

            for (int j=0;j<diff.size()-i-1;j++){

                if (diff.get(j+1).getDate().toInstant().isBefore(diff.get(j).getDate().toInstant())){
                    Sequence temp = diff.get(j+1);
                    diff.set(j+1, diff.get(j));
                    diff.set(j, temp);
                }

            }

        }
    }

    public List<Sequence> sort(List<Sequence> sequences){

        for (int i=0; i<sequences.size()-1;i++){

            for (int j=0;j<sequences.size()-i-1;j++){

                if (sequences.get(j+1).getDate().toInstant().isBefore(sequences.get(j).getDate().toInstant())){
                    Sequence temp = sequences.get(j+1);
                    sequences.set(j+1, sequences.get(j));
                    sequences.set(j, temp);
                }

            }

        }
        return sequences;
    }

    public void changeDate(ActionEvent actionEvent) {

        if (startDateBox.getValue()!=null && endDateBox.getValue()!=null && !algorithms.getSelectionModel().isEmpty() && !startMinute.getSelectionModel().isEmpty() && !startHour.getSelectionModel().isEmpty() && !endMinute.getSelectionModel().isEmpty() && !endHour.getSelectionModel().isEmpty()){
            btnAnalise.setDisable(false);
            btnAnalise.setText("Analise");
        }

        if (!algorithms.getSelectionModel().isEmpty()){
            algorithm=algorithms.getValue().toString();
        }

        if(startDateBox.getValue()!=null){
            startHour.setDisable(false);
        }
        if (!startHour.getSelectionModel().isEmpty()){
            startMinute.setDisable(false);
        }

        if(endDateBox.getValue()!=null){
            endHour.setDisable(false);
        }
        if (!endHour.getSelectionModel().isEmpty()){
            endMinute.setDisable(false);
        }


    }

    public static List<Sequence> getDiff() {
        return diff;
    }

    public TestStore getTestStore() {
        return testStore;
    }

    public static List<Sequence> getTestRegbyDay() {
        return testByRegDay;
    }

    public static List<Sequence> getTestAnalbyDay() {
        return testByAnalDay;
    }

    public static List<Sequence> getTestbyValDay() {
        return testByValDay;
    }


    public static String getAlgorithm(){
        if (algorithm.equals("Brute Force")){
            return "Domain.MaxSum2";
        }
        else {
            if (algorithm.equals("Benchmark")){
                return "Domain.MaxSum1";
            }
        }
       throw new IllegalArgumentException("Error in selecting the algorithm");
    }




    public void verify30Min(Test test, int num){

        int startMin= Integer.parseInt(startMinute.getValue().toString());

        int end30min= startMin+30;





            if(num==1){
                if (test.getDate().getMinutes()<end30min && test.getDate().getMinutes()>=startMin){
                    test.getFakeDate().setMinutes(startMin);
                }
                else {
                    if (end30min>59){
                        end30min=end30min-60;
                    }
                    if (startMin>0 && startMin < 30){

                        test.getFakeDate().setHours(test.getDate().getHours()-1);
                        test.getFakeDate().setMinutes(end30min);

                    }
                    else {
                        if (test.getDate().getMinutes()<end30min) {
                            test.getFakeDate().setHours(test.getDate().getHours() - 1);
                            test.getFakeDate().setMinutes(startMin);
                        }
                        else {
                            test.getFakeDate().setMinutes(end30min);
                        }
                    }
                }
            }
            else {
                if (num == 2) {
                    if (test.getResultRegist().getMinutes() < end30min && test.getResultRegist().getMinutes() >= startMin) {
                        test.getFakeResultRegist().setMinutes(startMin);
                    } else {
                        if (end30min > 59) {
                            end30min = end30min - 60;
                        }
                        if (startMin > 0 && startMin < 30) {

                            test.getFakeResultRegist().setHours(test.getResultRegist().getHours() - 1);
                            test.getFakeResultRegist().setMinutes(end30min);

                        } else {
                            if (test.getResultRegist().getMinutes() < end30min) {
                                test.getFakeResultRegist().setHours(test.getResultRegist().getHours() - 1);
                                test.getFakeResultRegist().setMinutes(startMin);
                            } else {
                                test.getFakeResultRegist().setMinutes(end30min);
                            }
                        }
                    }
                }
                else {
                    if (test.getValidationDate().getMinutes() < end30min && test.getValidationDate().getMinutes() >= startMin) {
                        test.getFakeValidationDate().setMinutes(startMin);
                    } else {
                        if (end30min > 59) {
                            end30min = end30min - 60;
                        }
                        if (startMin > 0 && startMin < 30) {

                            test.getFakeValidationDate().setHours(test.getValidationDate().getHours() - 1);
                            test.getFakeValidationDate().setMinutes(end30min);

                        } else {
                            if (test.getValidationDate().getMinutes() < end30min) {
                                test.getFakeValidationDate().setHours(test.getValidationDate().getHours() - 1);
                                test.getFakeValidationDate().setMinutes(startMin);
                            } else {
                                test.getFakeValidationDate().setMinutes(end30min);
                            }
                        }
                    }

                }
            }

    }

    public static Date getStartDate() {
         return startDate;
    }

    public static Date getEndDate() {
        return endDate;
    }

    public void logout(MouseEvent mouseEvent) {
        try {

            stage = (Stage) anchorPane.getScene().getWindow();

            System.out.println("closed");

            stage.close();

            Parent update = FXMLLoader.load(getClass().getClassLoader().getResource("LabCordinatorGUI.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(update);
            stage2.setTitle("MANY LABS");
            stage2.setScene(scene2);
            stage2.setResizable(false);


            stage2.show();
        }catch (Exception e){
            System.out.println("Fail Going back");
        }
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
