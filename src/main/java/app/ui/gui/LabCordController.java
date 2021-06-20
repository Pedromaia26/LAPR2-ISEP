package app.ui.gui;

import app.controller.AlterClientDataController;
import app.controller.AuthController;
import app.controller.ValidateWorkDoneController;
import app.ui.console.ValidateWorkDoneUI;
import com.sun.javafx.runtime.VersionInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;

public class LabCordController {

    @FXML
    private Label logoutLabel;

    @FXML
    private AnchorPane anchorPane;

    private AuthController ctrl=new AuthController();

    Stage stage;

    public LabCordController() throws IllegalAccessException, ParseException, InstantiationException, IOException, OutputException, BarcodeException, ClassNotFoundException {
    }

    public void toFilesCSV(ActionEvent actionEvent) throws IOException {
        try {
            Parent update = FXMLLoader.load(getClass().getClassLoader().getResource("ImportCSVFile.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(update);
            stage2.setTitle("Import Csv Files");
            stage2.setScene(scene2);
            stage2.setResizable(true);


            stage2.show();
        }catch (Exception e){
            System.out.println("Fail opening the Import Csv File window");
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

    public void overview(ActionEvent actionEvent) throws IOException {
        try {
            closeGui();


            Parent update = FXMLLoader.load(getClass().getClassLoader().getResource("LBOverview.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(update);
            stage2.setTitle("OverView");
            stage2.setScene(scene2);
            stage2.setResizable(true);


            stage2.show();
        }catch (Exception e){
            System.out.println("Fail Opening the OverView window");
        }

    }

    public void validateTest(ActionEvent actionEvent) throws IOException {

        closeGui();
        ValidateWorkDoneUI validateWorkDoneUI = new ValidateWorkDoneUI();
        validateWorkDoneUI.run();

        returnToGui();

    }

    public void returnToGui() throws IOException {
        Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("LabCordinatorGUI.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(aaaaa);
        stage2.setTitle("Receptionist");
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
