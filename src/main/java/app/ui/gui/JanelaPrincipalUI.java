package app.ui.gui;

import app.controller.AuthController;
import app.domain.model.ClientStore;
import app.domain.shared.Constants;
import app.ui.console.*;
import app.ui.console.utils.Utils;
import auth.mappers.dto.UserRoleDTO;
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
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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


    private AuthController ctrl=new AuthController();

<<<<<<< HEAD
    public JanelaPrincipalUI() throws IllegalAccessException, InstantiationException, ClassNotFoundException, BarcodeException, ParseException, OutputException, IOException {
=======
    public JanelaPrincipalUI() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {

        //try {
        boolean success;



            if (username.getText().equals("") || password.getText().equals("")) {
                loginMessage.setText("Invalid e-mail or password. Please try again!");

            } else {
                success = ctrl.doLogin(username.getText(), password.getText());

                if (success) {
                    List<UserRoleDTO> roles = this.ctrl.getUserRoles();
                    UserRoleDTO role = selectsRole(roles);


                    loginMessage.setText("Successful login!");
                    if(role.getDescription().equalsIgnoreCase("CLIENT")) {
                        Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("clientMenu.fxml"));
                        Stage stage2 = new Stage();
                        Scene scene2 = new Scene(aaaaa);
                        stage2.setTitle("CLIENT MENU");
                        stage2.setScene(scene2);
                        stage2.setResizable(true);
                        stage2.show();
                    }
                    else{
                        if(role.getDescription().equalsIgnoreCase("LABORATORY COORDINATOR")){
                            Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("LabCordinatorGUI.fxml"));
                            Stage stage2 = new Stage();
                            Scene scene2 = new Scene(aaaaa);
                            stage2.setTitle("LABORATORY COORDINATOR");
                            stage2.setScene(scene2);
                            stage2.setResizable(true);
                            stage2.show();
                        }
                    }
                }
                else {
                    loginMessage.setText("Invalid e-mail or password. Please try again!");
                }
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

    public void verificateLogin(){

    }


    private UserRoleDTO selectsRole(List<UserRoleDTO> roles)
    {
        if (roles.size() == 1)
            return roles.get(0);
        else
            return (UserRoleDTO) Utils.showAndSelectOne(roles, "Select the role you want to adopt in this session:");
    }

}

