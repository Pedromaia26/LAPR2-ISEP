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


            closeGui();


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

        closeGui();

        CreateEmployeeUI createEmployeeUI = new CreateEmployeeUI();

        createEmployeeUI.run();

        returnToGui();
    }


    public void registLab(ActionEvent actionEvent) throws IOException {
        closeGui();

        LaboratoryUI laboratoryUI=new LaboratoryUI();
        laboratoryUI.run();

        returnToGui();
    }

    public void registTestType(ActionEvent actionEvent) throws IOException {
        closeGui();

        TestTypeUI testTypeUI =new TestTypeUI();
        testTypeUI.run();

        returnToGui();
    }

    public void registParameter(ActionEvent actionEvent) throws IOException {
        closeGui();

        CreateParameterUI createParameterUI=new CreateParameterUI();
        createParameterUI.run();

        returnToGui();
    }


    public void registParameterCategory(ActionEvent actionEvent) throws IOException {
        closeGui();

        CreateParameterCategoryUI createParameterCategoryUI= new CreateParameterCategoryUI();
        createParameterCategoryUI.run();

        returnToGui();
    }

    public void returnToGui() throws IOException {
        Parent aaaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("AdminGUI.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(aaaaaa);
        stage.setTitle("ADMINISTRATOR");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void closeGui(){
        stage = (Stage) anchorPane.getScene().getWindow();

        System.out.println("closed");

        stage.close();
    }
}
