package app.ui.gui;

import app.controller.AlterClientDataController;
import app.controller.AuthController;
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
            ctrl.doLogout();

            stage = (Stage) anchorPane.getScene().getWindow();

            System.out.println("closed");

            stage.close();


            Parent update = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(update, 600, 500);
            stage2.setTitle("MANY LABS");
            stage2.setScene(scene2);
            stage2.setResizable(true);


            stage2.show();
        }catch (Exception e){
            System.out.println("Fail during logout");
        }


    }

    public void overview(ActionEvent actionEvent) throws IOException {
       // try {
            stage = (Stage) anchorPane.getScene().getWindow();

            System.out.println("closed");

            stage.close();


            Parent update = FXMLLoader.load(getClass().getClassLoader().getResource("LBOverview.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(update);
            stage2.setTitle("OverView");
            stage2.setScene(scene2);
            stage2.setResizable(true);


            stage2.show();
       /* }catch (Exception e){
            System.out.println("Fail Opening the OverView window");
        }*/

    }
}
