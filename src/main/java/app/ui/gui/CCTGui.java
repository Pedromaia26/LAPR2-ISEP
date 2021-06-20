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


            Parent update = FXMLLoader.load(getClass().getClassLoader().getResource("ClinicalChemistryTechnologist.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(update);
            stage2.setTitle("Consult the tests");
            stage2.setScene(scene2);
            stage2.setResizable(true);


            stage2.show();
        }catch (Exception e){
            System.out.println("Fail Opening the OverView window");
        }


    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        try {
            JanelaPrincipalUI janelaPrincipalUI = new JanelaPrincipalUI();

            janelaPrincipalUI.logout(ctrl,stage,anchorPane);

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
        Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("CCTGui.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(aaaaa);
        stage2.setTitle("Consult the tests");
        stage2.setScene(scene2);
        stage2.setResizable(true);
        stage2.show();
    }

    public void closeGui(){
        stage = (Stage) anchorPane.getScene().getWindow();

        System.out.println("closed");

        stage.close();
    }
}
