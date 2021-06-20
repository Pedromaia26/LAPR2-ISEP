package app.controller;

import app.domain.model.*;
import auth.AuthFacade;
import auth.domain.model.Email;
import javafx.event.ActionEvent;
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
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import java.util.ResourceBundle;

public class AlterClientDataController implements Initializable {
    private ClientStore clientStore;

    private Company company;

    private Client client;

    private AuthFacade authFacade;


    @FXML
    private Button changeName;
    @FXML
    private Button changeAddress;


    @FXML
    private Button changeSex;

    @FXML
    private Button changePn;






    @FXML
    private TextField txtChangeName;

    @FXML
    private TextField txtChangeAddress;


    @FXML
    private TextField txtChangeSex;


    @FXML
    private TextField txtChangePN;


    Stage stage;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Label showName;

    @FXML
    private Label showAddress;

    @FXML
    private Label showSex;

    @FXML
    private Label showPN;

    @FXML
    private Label showCCN;

    @FXML
    private Label showTIN;

    @FXML
    private Label showBirth;

    @FXML
    private Label showNHS;

    @FXML
    private Label showEmail;

    @FXML
    private Label confirmSex;

    @FXML
    private Label confirmAddress;

    @FXML
    private Label confirmName;

    @FXML
    private Label confirmPN;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setprompttext();
    }


    public AlterClientDataController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.company=App.getInstance().getCompany();
        this.clientStore=App.getInstance().getCompany().getClientStore();
        this.authFacade= company.getAuthFacade();
        checkClient();


    }

    public AlterClientDataController(Company company) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.clientStore=App.getInstance().getCompany().getClientStore();
        this.company= company;
        this.authFacade= company.getAuthFacade();
        checkClient();


    }

    public void checkClient(){
        Email empemail= authFacade.getCurrentUserSession().getUserId();


        this.client=company.getClientStore().getClientByEmail(String.valueOf(empemail));


    }



    public void setprompttext(){

       this.txtChangeName.setPromptText(this.client.getName());
        this.txtChangeName.setDisable(false);
        //this.txtChangeName.setPromptText("this.client.getName()");



        this.txtChangePN.setPromptText(String.valueOf(this.client.getPhoneNumber()));
        this.txtChangePN.setDisable(false);



        this.txtChangeSex.setPromptText(this.client.getSex());
        this.txtChangeSex.setDisable(false);

        this.txtChangeAddress.setPromptText(this.client.getAddress());
        this.txtChangeAddress.setDisable(false);









        this.changePn.setDisable(false);

        this.changeAddress.setDisable(false);

        this.changeSex.setDisable(false);


        this.changeName.setDisable(false);



        //success = ctrl.doLogin(id, pwd);
// para fazer login usamos isto acho eu
    }


    public void UpdateName(ActionEvent actionEvent) {
    try {

        resetConfirms();
        String newName = this.txtChangeName.getCharacters().toString();

        this.clientStore.ChangeName(this.client, newName);

        txtChangeName.clear();
        setprompttext();
        clientStore.save();
        confirmName.setText("Updated Successfully");
        confirmName.setTextFill(Paint.valueOf("Green"));

    }catch (Exception e){
        confirmName.setText("Invalid Name ");
        confirmName.setTextFill(Paint.valueOf("Red"));

    }


    }

    public void UpdateAdress(ActionEvent actionEvent) {
        try {
            resetConfirms();

            String newAdress = this.txtChangeAddress.getCharacters().toString();

            this.clientStore.ChangeAddress(this.client, newAdress);

            txtChangeName.clear();
            clientStore.save();
            setprompttext();
            confirmAddress.setText("Updated Successfully");
            confirmAddress.setTextFill(Paint.valueOf("Green"));

        }catch (Exception e){
            confirmAddress.setText("Invalid Address");
            confirmAddress.setTextFill(Paint.valueOf("Red"));
        }

    }



    public void UpdateSex(ActionEvent actionEvent) {
        try {

            resetConfirms();
            String newSex = this.txtChangeSex.getCharacters().toString();

            this.clientStore.ChangeSex(this.client, newSex);

            txtChangeSex.clear();
            clientStore.save();
            setprompttext();
            confirmSex.setText("Updated Successfully");
            confirmSex.setTextFill(Paint.valueOf("Green"));
        }catch (Exception e){
            confirmSex.setText("Invalid Gender");
            confirmSex.setTextFill(Paint.valueOf("Red"));
        }


    }


    public void UpdatePhoneNumer(ActionEvent actionEvent) {
        try {
            resetConfirms();

            String newPhoneNumer = this.txtChangePN.getCharacters().toString();

            this.clientStore.ChangePN(this.client, Long.parseLong(newPhoneNumer));

            txtChangePN.clear();
            clientStore.save();

            setprompttext();
            confirmPN.setText("Updated Successfully");
            confirmPN.setTextFill(Paint.valueOf("green"));
        }catch (Exception e){
            confirmPN.setText("Invalid Phone Number");
            confirmPN.setTextFill(Paint.valueOf("Red"));
        }

    }



    public void goback(MouseEvent mouseEvent) throws IOException {

        stage = (Stage) anchorpane.getScene().getWindow();

        System.out.println("closed");

        stage.close();

        Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("clientMenu.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(aaaaa);
        stage2.setTitle("CLIENT MENU");
        stage2.setScene(scene2);
        stage2.setResizable(true);
        stage2.show();

    }


    public void mouseEnterName(MouseEvent dragEvent) {

        showName.setText(client.getName());
        resetConfirms();
    }

    public void mouseExitName(MouseEvent dragEvent) {

        showName.setText("Name");

    }



    public void mouseEnterAddress(MouseEvent dragEvent) {

        showAddress.setText(client.getAddress());
        resetConfirms();
    }

    public void mouseExitAddress(MouseEvent dragEvent) {

        showAddress.setText("Address");

    }



    public void mouseEnterSex(MouseEvent dragEvent) {

        showSex.setText(client.getSex());
        resetConfirms();
    }


    public void mouseExitSex(MouseEvent dragEvent) {

        showSex.setText("Sex");

    }


    public void mouseEnterPN(MouseEvent dragEvent) {

        showPN.setText(String.valueOf(client.getPhoneNumber()));
        resetConfirms();
    }

    public void mouseExitPN(MouseEvent dragEvent) {

        showPN.setText("Phone Number");

    }


    public void mouseEnterCCN(MouseEvent dragEvent) {

        showCCN.setText(String.valueOf(client.getCcn()));
        resetConfirms();
    }

    public void mouseExitCCN(MouseEvent dragEvent) {

        showCCN.setText("CCN");

    }


    public void mouseEnterTIN(MouseEvent dragEvent) {

        showTIN.setText(String.valueOf(client.getTif()));
        resetConfirms();
    }

    public void mouseExitTIN(MouseEvent dragEvent) {

        showTIN.setText("TIN");

    }


    public void mouseEnterNHS(MouseEvent dragEvent) {

        showNHS.setText(String.valueOf(client.getNhs()));
        resetConfirms();
    }

    public void mouseExitNHS(MouseEvent dragEvent) {

        showNHS.setText("NHS Code");

    }

    public void mouseEnterBirth(MouseEvent dragEvent) {

        showBirth.setText(client.getBirth());
        resetConfirms();
    }

    public void mouseExitBirth(MouseEvent dragEvent) {

        showBirth.setText("Birth Date");

    }

    public void mouseEnterEmail(MouseEvent dragEvent) {

        showEmail.setText(client.getEmail().getEmail());
        resetConfirms();
    }

    public void mouseExitEmail(MouseEvent dragEvent) {

        showEmail.setText("Email");

    }

    public void resetConfirms(){
        confirmAddress.setText("");
        confirmName.setText("");
        confirmPN.setText("");
        confirmSex.setText("");
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
