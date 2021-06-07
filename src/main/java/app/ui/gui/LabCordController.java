package app.ui.gui;

import app.controller.AlterClientDataController;
import com.sun.javafx.runtime.VersionInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LabCordController {

    public void toFilesCSV(ActionEvent actionEvent) throws IOException {

        Parent update = FXMLLoader.load(getClass().getClassLoader().getResource("ImportCSVFile.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(update);
        stage2.setTitle("Update");
        stage2.setScene(scene2);
        stage2.setResizable(true);


        stage2.show();

    }
}
