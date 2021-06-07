package app.ui.gui;

import app.controller.AlterClientDataController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ClientMenuUI implements Initializable {

    @FXML
    private Button check;
    @FXML
    private Button update;
    @FXML
    private TextField welcome;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcome.setText("Welcome");
    }


    public void updateOnAction(ActionEvent actionEvent) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Parent update = FXMLLoader.load(getClass().getClassLoader().getResource("ClientInterfaceGUI.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(update);
        stage2.setTitle("Update");
        stage2.setScene(scene2);
        stage2.setResizable(true);

        AlterClientDataController alterClientDataController = new AlterClientDataController();
        stage2.show();

    }


    public void checkOnAction(javafx.event.ActionEvent actionEvent) {
    }
}
