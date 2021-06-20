package app.ui.gui;

import app.controller.AuthController;
import app.ui.console.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;

public class AdminGUI {
    @FXML
    private AnchorPane anchorPane;

    private AuthController ctrl=new AuthController();

    Stage stage;

    public AdminGUI() throws IllegalAccessException, ParseException, InstantiationException, IOException, OutputException, BarcodeException, ClassNotFoundException {
    }


    public void sendReport(ActionEvent actionEvent) throws IOException {

        try {


            closeGui1();


            Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("Admin.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(aaaaa);
            stage2.setTitle("ADMINISTRATOR");
            stage2.setScene(scene2);
            stage2.setResizable(true);
            stage2.show();
        }catch (Exception e){
            System.out.println("Fail Opening the Send Report window");
        }
    }

    public void logout(MouseEvent mouseEvent) {
        try {
            JanelaPrincipalUI.logout(ctrl,stage,anchorPane);

            JanelaPrincipalUI janelaPrincipalUI = new JanelaPrincipalUI();



            janelaPrincipalUI.enter("login", "Many Labs");



        }catch (Exception e){
            System.out.println("Fail during logout");
        }
    }

    public void registEmployee(ActionEvent actionEvent) throws IOException {

        closeGui1();

        CreateEmployeeUI createEmployeeUI = new CreateEmployeeUI();

        createEmployeeUI.run();

        returnToGui1();
    }


    public void registLab(ActionEvent actionEvent) throws IOException {
        closeGui1();

        LaboratoryUI laboratoryUI=new LaboratoryUI();
        laboratoryUI.run();

        returnToGui1();
    }

    public void registTestType(ActionEvent actionEvent) throws IOException {
        closeGui1();

        TestTypeUI testTypeUI =new TestTypeUI();
        testTypeUI.run();

        returnToGui1();
    }

    public void registParameter(ActionEvent actionEvent) throws IOException {
        closeGui1();

        CreateParameterUI createParameterUI=new CreateParameterUI();
        createParameterUI.run();

        returnToGui1();
    }


    public void registParameterCategory(ActionEvent actionEvent) throws IOException {
        closeGui1();

        CreateParameterCategoryUI createParameterCategoryUI= new CreateParameterCategoryUI();
        createParameterCategoryUI.run();

        returnToGui1();
    }

    public void returnToGui1() throws IOException {
        Parent aaaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("AdminGUI.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(aaaaaa);
        stage.setTitle("ADMINISTRATOR");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void closeGui1(){
        stage = (Stage) anchorPane.getScene().getWindow();

        System.out.println("closed");

        stage.close();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
