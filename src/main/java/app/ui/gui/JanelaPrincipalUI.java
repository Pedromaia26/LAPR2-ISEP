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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;


public class JanelaPrincipalUI {



    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessage;


    @FXML
    private TextField username;

    @FXML
    private TextField password;



    @FXML
    private BorderPane borderpane;

    Stage stage;

    private AuthController ctrl=new AuthController();


    public JanelaPrincipalUI() throws IllegalAccessException, InstantiationException, ClassNotFoundException, BarcodeException, ParseException, OutputException, IOException {}

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {

        boolean success;



            if (username.getText().equals("") || password.getText().equals("")) {
                loginMessage.setText("Invalid e-mail or password. Please try again!");

            } else {
                success = ctrl.doLogin(username.getText(), password.getText());

                if (success) {
                    List<UserRoleDTO> roles = this.ctrl.getUserRoles();
                    UserRoleDTO role = selectsRole(roles);


                    loginMessage.setText("Successful login!");

                    stage = (Stage) borderpane.getScene().getWindow();



                    stage.close();

                    if(role.getDescription().equalsIgnoreCase("CLIENT")) {
                        enter("clientMenu", "CLIENT");

                    } else if (role.getDescription().equalsIgnoreCase("LABORATORY COORDINATOR")){
                        enter("LabCordinatorGUI", "LABORATORY COORDINATOR");

                    } else if (role.getDescription().equalsIgnoreCase("CLINICAL CHEMISTRY TECHNOLOGIST")){
                        enter("CCTGUI", "CLINICAL CHEMISTRY TECHNOLOGIST");

                    } else if (role.getDescription().equalsIgnoreCase("ADMINISTRATOR")){
                        enter("AdminGUI", "ADMINISTRATOR");
                    } else if(role.getDescription().equalsIgnoreCase("SPECIALIST DOCTOR")){
                        enter("SDGui", "SPECIALIST DOCTOR");
                    }else if(role.getDescription().equalsIgnoreCase("RECEPTIONIST")){
                        enter("ReceptionistGUI","RECEPTIONIST");
                    }else if (role.getDescription().equalsIgnoreCase("MEDICAL LAB TECHNICIAN")){
                        enter("MLTGui", "MEDICAL LAB TECHNICIAN");
                    }

                } else {
                    loginMessage.setText("Invalid e-mail or password. Please try again!");
                }
            }
    }

    public static void logout(AuthController ctrl, Stage stage, AnchorPane anchorPane){
        ctrl.doLogout();

        stage = (Stage) anchorPane.getScene().getWindow();



        stage.close();
    }



    public void enter(String fxml, String title) throws IOException {
        Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource(fxml+".fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(aaaaa);
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setTitle(title);
        stage2.setScene(scene2);
        stage2.setResizable(true);
        stage2.show();
    }



    private UserRoleDTO selectsRole(List<UserRoleDTO> roles)
    {
        if (roles.size() == 1)
            return roles.get(0);
        else
            return (UserRoleDTO) Utils.showAndSelectOne(roles, "Select the role you want to adopt in this session:");
    }

}

