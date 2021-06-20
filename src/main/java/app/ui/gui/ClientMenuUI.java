package app.ui.gui;

import app.controller.AlterClientDataController;
import app.controller.App;
import app.controller.AuthController;
import app.domain.model.Company;
import auth.AuthFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;


public class ClientMenuUI implements Initializable {

    @FXML
    private Button check;
    @FXML
    private Button update;
    @FXML
    private TextField welcome;

    @FXML
    private Label name;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label logout;
    Stage stage;

    private AuthController ctrl=new AuthController();

    private AuthFacade authFacade;

    private Company company;

    public ClientMenuUI() throws IllegalAccessException, ParseException, InstantiationException, IOException, OutputException, BarcodeException, ClassNotFoundException {
        this.company=App.getInstance().getCompany();
        this.authFacade= company.getAuthFacade();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name.setText("Welcome "+authFacade.getCurrentUserSession().getUserId().toString());

    }


    public void updateOnAction(ActionEvent actionEvent) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, ParseException, OutputException, BarcodeException {

        stage = (Stage) anchorPane.getScene().getWindow();

        stage.close();




        Parent update = FXMLLoader.load(getClass().getClassLoader().getResource("ClientInterfaceGUI.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(update);
        stage2.setTitle("Update");
        stage2.setScene(scene2);
        stage2.setResizable(false);
        
        stage2.show();

    }

    public void checkOnAction(javafx.event.ActionEvent actionEvent) throws IOException, IllegalAccessException, ParseException, InstantiationException, OutputException, BarcodeException, ClassNotFoundException {

        stage = (Stage) anchorPane.getScene().getWindow();



        stage.close();


        Parent seeResults = FXMLLoader.load(getClass().getClassLoader().getResource("CheckTestResults.fxml"));
        Stage stage3 = new Stage();
        Scene scene3 = new Scene(seeResults);
        stage3.setTitle("View the results");
        stage3.setScene(scene3);
        stage3.setResizable(false);

        CheckTestResultsUI checkTestResultsUI = new CheckTestResultsUI();

        stage3.show();
    }

    public void logout(MouseEvent mouseEvent) {
        try {
            JanelaPrincipalUI janelaPrincipalUI = new JanelaPrincipalUI();

            JanelaPrincipalUI.logout(ctrl,stage,anchorPane);

            janelaPrincipalUI.enter("login", "Many Labs");
        }catch (Exception e){
            System.out.println("Fail during logout");
        }
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
