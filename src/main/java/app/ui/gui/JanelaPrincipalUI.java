package app.ui.gui;

import app.domain.model.ClientStore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class JanelaPrincipalUI implements Initializable {


    ClientMenuUI c = new ClientMenuUI();
    ClientStore client;

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessage;

    @FXML
    private Button loginButton;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private ImageView userIcon;

    @FXML
    private ImageView passIcon;



    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {

        //try {
            if (username.getText().equals("") || password.getText().equals("")) {
                loginMessage.setText("Invalid e-mail or password. Please try again!");

            } else {
                    loginMessage.setText("Successful login!");
                    Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("clientMenu.fxml"));
                    Stage stage2 = new Stage();
                    Scene scene2 = new Scene(aaaaa);
                    stage2.setTitle("CLIENT MENU");
                    stage2.setScene(scene2);
                    stage2.setResizable(true);
                    stage2.show();
                }


            /*if (!client.getClientList().isEmpty()) {
                clientes.setText(client.getClientList().toString());
            }else{ */

            }
       // }

            //catch(Exception e) {
                // Printing the wrapper exception:
                // System.out.println("Wrapper exception: " + e);

                // Printing the 'actual' exception:
               // System.out.println("Underlying exception: " + e.getCause());




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

