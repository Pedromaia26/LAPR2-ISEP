package app.ui.gui;

import app.controller.App;
import app.controller.NHSReportController;
import app.controller.SendReportController;
import app.domain.model.TestStore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class AdminUI implements Initializable {

    @FXML
    private ComboBox dataComboBox;
    @FXML
    private ComboBox regressionModelComboBox;
    @FXML
    private ComboBox indVarComboBox;
    @FXML
    private Label indVarLabel;
    @FXML
    private Label invalidDate;
    @FXML
    private DatePicker begin;
    @FXML
    private DatePicker end;
    @FXML
    private TextField significanceLevel;
    @FXML
    private TextField confidenceLevel;
    @FXML
    private Label confidLevelLabel;
    @FXML
    private Label signifLevelLabel;
    @FXML
    private Label histPointsLabel;
    @FXML
    private TextField histPoints;
    @FXML
    private DatePicker currentDay;
    @FXML
    private ComboBox parameter;


    private SendReportController controller = new SendReportController();

    public TestStore testStore = App.getInstance().getCompany().getTestStore();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");





    private ObservableList<String> dataNHS = FXCollections.observableArrayList("Days", "Weeks");
    private ObservableList<String> regressionModel = FXCollections.observableArrayList("Simple", "Multiple");
    private ObservableList<String> independentVariable = FXCollections.observableArrayList("Number of tests", "Mean age");
    private ObservableList<String> pam = FXCollections.observableArrayList("a", "b");

    public AdminUI() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        indVarComboBox.setVisible(false);
        indVarLabel.setVisible(false);
        invalidDate.setVisible(false);
        signifLevelLabel.setVisible(false);
        confidLevelLabel.setVisible(false);
        histPointsLabel.setVisible(false);
        Locale.setDefault(Locale.ENGLISH);

        parameter.setItems(pam);
        parameter.setValue("Please select one");

        dataComboBox.setItems(dataNHS);
        dataComboBox.setValue("Please select one");

        regressionModelComboBox.setItems(regressionModel);
        regressionModelComboBox.setValue("Please select one");

        indVarComboBox.setItems(independentVariable);
        indVarComboBox.setValue("Please select one");

    }

    public void regressionModelComboBoxOnAction (ActionEvent actionEvent) {
        System.out.println(regressionModelComboBox.getSelectionModel().getSelectedItem());
        if (regressionModelComboBox.getSelectionModel().getSelectedItem().equals("Simple")) {
            indVarComboBox.setVisible(true);
            indVarLabel.setVisible(true);
        } else {
            indVarComboBox.setVisible(false);
            indVarLabel.setVisible(false);
        }

    }

    public void beginDateOnAction (ActionEvent actionEvent){
        if (end.getValue()!=null){
            if (begin.getValue().compareTo(end.getValue())>0){
                invalidDate.setText("Invalid Interval!");
                invalidDate.setVisible(true);

            }else {
                invalidDate.setVisible(false);
            }
        }

    }


    public void endDateOnAction (ActionEvent actionEvent) {
        if (begin.getValue()!=null){
            if (end.getValue().compareTo(begin.getValue())<0){
                invalidDate.setText("Invalid Interval!");
                invalidDate.setVisible(true);
            }else {
                invalidDate.setVisible(false);
            }
        }

    }

    public void sendDataOnAction (ActionEvent actionEvent) throws ParseException, OutputException, BarcodeException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        if (begin.getValue() == null && end.getValue() == null) {
            invalidDate.setText("Please, type the begin and end date");
            invalidDate.setVisible(true);
        } else if (end.getValue() == null) {
            invalidDate.setText("Please, type the end date");
            invalidDate.setVisible(true);
        } else if (begin.getValue() == null) {
            invalidDate.setText("Please, type the begin date");
            invalidDate.setVisible(true);
        } else if (!invalidDate.getText().equals("Invalid Interval!")) {
            invalidDate.setVisible(false);
        }


        double sL = 0;
        double cL = 0;


        try {
            String a = histPoints.getText();
            Integer hP = Integer.parseInt(a);
            histPointsLabel.setVisible(false);
            if (hP < 0) {
                histPointsLabel.setText("Must be a positive number!");
                histPointsLabel.setVisible(true);
            }
        } catch (Exception e) {
            histPointsLabel.setVisible(true);
        }

        try {
            String b = significanceLevel.getText();
            sL = Double.parseDouble(b);
            signifLevelLabel.setVisible(false);
            if (sL < 0 || sL > 100) {
                signifLevelLabel.setText("Must be a number between 0 and 100!");
                signifLevelLabel.setVisible(true);
            }

        } catch (Exception e) {
            signifLevelLabel.setVisible(true);
        }

        try {
            String c = confidenceLevel.getText();
            cL = Double.parseDouble(c);
            confidLevelLabel.setVisible(false);
            if (cL < 0 || cL > 100) {
                confidLevelLabel.setText("Must be a number between 0 and 100!");
                confidLevelLabel.setVisible(true);
            }

        } catch (Exception e) {
            confidLevelLabel.setVisible(true);
        }


        String histPts = histPoints.getText();
        Integer hP = Integer.parseInt(histPts);


        Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(currentDay.getValue().format(formatter));
        Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(begin.getValue().format(formatter));
        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(end.getValue().format(formatter));

        // controller.getTestsByInterval(startDate, endDate);
        //testStore.getPositiveTestsPerDay(startDate, endDate);


        if (regressionModelComboBox.getSelectionModel().getSelectedItem().equals("Simple")) {
            if (dataComboBox.getSelectionModel().getSelectedItem().equals("Days")) {
                if (indVarComboBox.getSelectionModel().getSelectedItem().equals("Number of tests")) {
                    controller.getReportForDays(startDate, endDate, currentDate, hP, sL, cL, parameter.getSelectionModel().getSelectedItem().toString());
                } else if (indVarComboBox.getSelectionModel().getSelectedItem().equals("Mean age")) {
                    controller.getReportForDaysWithMeanAge(startDate, endDate, currentDate, hP, sL, cL, parameter.getSelectionModel().getSelectedItem().toString());
                }
            } else if (dataComboBox.getSelectionModel().getSelectedItem().equals("Weeks")) {
                if (indVarComboBox.getSelectionModel().getSelectedItem().equals("Number of tests")) {
                    controller.getReportForWeeks(startDate, endDate, currentDate, hP, sL, cL, parameter.getSelectionModel().getSelectedItem().toString());
                } else if (indVarComboBox.getSelectionModel().getSelectedItem().equals("Mean age")) {
                    controller.getReportForWeeksWithMeanAge(startDate, endDate, currentDate, hP, sL, cL, parameter.getSelectionModel().getSelectedItem().toString());
                }
            }
        }else if(regressionModelComboBox.getSelectionModel().getSelectedItem().equals("Multiple")){
            System.out.println("ola");
        }
    }


}
