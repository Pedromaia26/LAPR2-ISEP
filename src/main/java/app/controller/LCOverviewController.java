package app.controller;

import app.domain.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class LCOverviewController implements Initializable{
   // private static List<Sequence> diff;

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

    private List<Test> testValidatedList;

    private static List<Sequence> diff = new ArrayList<>();

    private static List<Sequence> testByRegDay = new ArrayList<>();

    private static List<Sequence> testByValDay = new ArrayList<>();


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


    public void getTestsInInterval(Date startDate, Date endDate){
        for(Test test : listTests){

            if ((test.getDate().toInstant().equals(startDate.toInstant()) || test.getDate().toInstant().equals(endDate.toInstant()) )|| (test.getDate().toInstant().isAfter(startDate.toInstant()) && test.getDate().toInstant().isBefore(endDate.toInstant()))){

                listTestsinRegDateRange.add(test);
            }

            if ((test.getResultRegist().toInstant().equals(startDate.toInstant()) || test.getResultRegist().toInstant().equals(endDate.toInstant()) )|| (test.getResultRegist().toInstant().isAfter(startDate.toInstant())&& test.getResultRegist().toInstant().isBefore(endDate.toInstant()))){

                listTestsinValDateRange.add(test);
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        for(TestDTO testDTO : getTests()){
            listView.getItems().add(testDTO.getCode());

        }


    }


    public void analyse(ActionEvent actionEvent) throws ParseException, IOException {
        List<Sequence> sequences = new ArrayList<>();
        List<Sequence> sequences2 = new ArrayList<>();

        listTestsinRegDateRange=new ArrayList<>();
        listTestsinValDateRange= new ArrayList<>();

        diff = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Date startDate=new SimpleDateFormat("dd/MM/yyyy").parse(startDateBox.getValue().format(formatter));
        Date endDate=new SimpleDateFormat("dd/MM/yyyy").parse(endDateBox.getValue().format(formatter));

        getTestsInInterval(startDate, endDate);

        int cVal=0;
        int cNVal=0;
        Date aData= new Date();
        Date oData = new Date();
        Date lData= new Date();
        String oVData="";
        String aVData="";
        int i=0;

        while (i<listTestsinRegDateRange.size()-1) {

             do{
                i++;



                /*f (listTests.get(i-1).getValidationDate() != null && listTests.get(i-1).getValidationDate().toString().equals(aData)) {
                    cVal++;
                }*/
                 cNVal++;
                oData=(listTestsinRegDateRange.get(i-1).getDate());
                aData=(listTestsinRegDateRange.get(i).getDate());



            }while (aData.equals(oData)&& i<listTestsinRegDateRange.size()-1);
            if (i==listTestsinRegDateRange.size()-1){
                i++;
                cNVal++;
                lData=listTestsinRegDateRange.get(i-1).getDate();
                /*if (listTests.get(i-1).getValidationDate() != null) {
                    cVal++;
                }*/
                if (lData.equals(oData)){
                    sequences.add(new Sequence(oData, cNVal));
                }
                else{
                    sequences.add(new Sequence(oData, cNVal-1));
                    sequences.add(new Sequence(lData, 1));
                }
            }else {
                sequences.add(new Sequence(oData, cNVal));
            }


            cNVal=0;

            oData=aData;

            //diff.add((cVal-cNVal));
        }
        i=0;
        cVal=0;
        cNVal=0;
        aData=new Date();
        oData=new Date();





        while (i<listTestsinValDateRange.size()-1) {

            do{
                i++;
                if (listTestsinValDateRange.get(i-1).getResultRegist()!=null) {

                    cNVal++;
                    oData=listTestsinValDateRange.get(i-1).getResultRegist();
                    aData=listTestsinValDateRange.get(i).getResultRegist();


                }

                /*f (listTests.get(i-1).getValidationDate() != null && listTests.get(i-1).getValidationDate().toString().equals(aData)) {
                    cVal++;
                }*/




            }while (aData!=null && aData.equals(oData)&& i<listTestsinValDateRange.size()-1 );
            if (i==listTestsinValDateRange.size()-1){
                i++;

                if (listTestsinValDateRange.get(i-1).getResultRegist() != null) {

                    cNVal++;
                    lData=listTestsinValDateRange.get(i-1).getResultRegist();
                }
                if (lData.equals(oData)){
                    sequences2.add(new Sequence(oData, cNVal));
                }
                else{
                    sequences2.add(new Sequence(oData, cNVal-1));
                    sequences2.add(new Sequence(lData, 1));
                }

            }
            else {
                sequences2.add(new Sequence(oData, cNVal));
            }


            cNVal=0;

            oData=aData;

            //diff.add((cVal-cNVal));
        }


        System.out.println(sequences);

        System.out.println(sequences2);



        difference(sequences,sequences2);
        sortDiff();



        System.out.println(diff);






        Parent graphs = FXMLLoader.load(getClass().getClassLoader().getResource("Graphs.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(graphs);
        stage2.setTitle("Graph");
        stage2.setScene(scene2);
        stage2.setResizable(true);
        stage2.show();



    }

    public void difference(List<Sequence> sequences, List<Sequence> sequences2) throws ParseException {
        testByValDay=new ArrayList<>();
        testByRegDay=new ArrayList<>();

        testByRegDay.addAll(sequences);
        testByValDay.addAll(sequences2);




        int i=0;
        while (sequences.size()!=0 || sequences2.size()!=0){




            while ((sequences.size()!=0 && sequences2.size()!=0) && sequences.get(0).getDate()!=null && sequences2.get(i).getDate()!=null && sequences.get(0).getDate().toString().equals(sequences2.get(i).getDate().toString())) {



                diff.add(new Sequence(sequences2.get(i).getDate(),sequences2.get(i).getNumber() - sequences.get(0).getNumber()));
                sequences.remove(0);
                sequences2.remove(i);

            }
            i=0;

            while ((sequences.size()!=0 && sequences2.size()!=0) && i<sequences2.size() &&!sequences.get(0).getDate().toString().equals(sequences2.get(i).getDate().toString())){

                i++;
            }
            if(i==sequences2.size()){


                i=0;
            }




            while ((sequences.size()!=0 && sequences2.size()!=0) && sequences.get(0).getDate()!=null && sequences2.get(i).getDate()!=null && !sequences.get(0).getDate().toString().equals(sequences2.get(i).getDate().toString())){


                if(sequences.get(0).getDate().toInstant().isBefore(sequences2.get(i).getDate().toInstant())){

                    diff.add(new Sequence(sequences.get(0).getDate(),-sequences.get(0).getNumber()));
                    sequences.remove(i);
                }
                else {
                    diff.add(new Sequence(sequences2.get(i).getDate(),sequences2.get(i).getNumber()));
                    sequences2.remove(i);
                }



            }
            int c=1;
            boolean f;
            while (sequences.size()==0 && sequences2.size()!=0){
                while (c<sequences2.size() && !sequences2.get(0).getDate().equals(sequences2.get(c).getDate())){
                        c++;

                }
                if(c==sequences2.size()){
                    f = false;
                }
                else  f = true;
                if(f){
                    diff.add(new Sequence(sequences2.get(0).getDate(),sequences2.get(0).getNumber()+sequences2.get(c).getNumber()));
                    sequences2.remove(0);
                    sequences2.remove(c-1);
                }
                else {
                    diff.add(new Sequence(sequences2.get(0).getDate(),sequences2.get(0).getNumber()));
                    sequences2.remove(0);
                }
                c=1;
            }

            while (sequences.size()!=0 && sequences2.size()==0){

                diff.add(new Sequence(sequences.get(0).getDate(),sequences.get(0).getNumber()));
                sequences.remove(0);

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

    public void changeDate(ActionEvent actionEvent) {

        if (startDateBox.getValue()!=null && endDateBox.getValue()!=null){
            btnAnalise.setDisable(false);
            btnAnalise.setText("Analise");
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

    public static List<Sequence> getTestValbyDay() {
        return testByValDay;
    }
}
