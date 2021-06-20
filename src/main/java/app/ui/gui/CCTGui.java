package app.ui.gui;

import app.controller.AuthController;
import app.ui.console.RecordTestResultUI;
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

public class CCTGui {

    @FXML
    private AnchorPane anchorPane;

    private AuthController ctrl=new AuthController();

    Stage stage;

    public CCTGui() throws IllegalAccessException, ParseException, InstantiationException, IOException, OutputException, BarcodeException, ClassNotFoundException {
    }

    public void consultTests(ActionEvent actionEvent) {
        try {
            closeGui();

            JanelaPrincipalUI janelaPrincipalUI= new JanelaPrincipalUI();
            janelaPrincipalUI.enter("ClinicalChemistryTechnologist","Consult the tests");


        }catch (Exception e){
            System.out.println("Fail Opening the OverView window");
        }


    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        try {


            JanelaPrincipalUI.logout(ctrl,stage,anchorPane);


            JanelaPrincipalUI janelaPrincipalUI = new JanelaPrincipalUI();
            janelaPrincipalUI.enter("login", "Many Labs");


        }catch (Exception e){
            System.out.println("Fail during logout");
        }


    }

    public void analyse(ActionEvent actionEvent) throws IOException {
        closeGui();

        RecordTestResultUI recordTestResultUI = new RecordTestResultUI();
        recordTestResultUI.run();

        returnToGui();
    }

    public void returnToGui() throws IOException {
        Parent aa = FXMLLoader.load(getClass().getClassLoader().getResource("CCTGui.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(aa);
        stage.setTitle("Consult the tests");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void closeGui(){
        stage = (Stage) anchorPane.getScene().getWindow();

        stage.close();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
