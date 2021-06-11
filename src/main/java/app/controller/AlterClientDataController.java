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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import java.io.IOException;
import java.util.ResourceBundle;

public class AlterClientDataController implements Initializable {
    private ClientStore clientStore;

    private Company company;

    private Client client;

    private AuthFacade authFacade;


    @FXML
    private Button changeName;
    @FXML
    private Button changeEmail;

    @FXML
    private Button changeCcn;

    @FXML
    private Button changeNhs;

    @FXML
    private Button changeSex;

    @FXML
    private Button changePn;

    @FXML
    private Button changeBd;

    @FXML
    private Button changeTin;

    @FXML
    private Button changePw;
    @FXML
    private TextField txtChangeName;

    @FXML
    private TextField txtChangeCCN;

    @FXML
    private TextField txtChangeTIN;

    @FXML
    private TextField txtChangeNHS;

    @FXML
    private TextField txtChangeSex;

    @FXML
    private TextField txtChangeEmail;

    @FXML
    private TextField txtChangePN;

    @FXML
    private TextField txtChangeBD;

    @FXML
    private TextField txtChangePW;

    Stage stage;

    @FXML
    private AnchorPane anchorpane;


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

        this.txtChangePW.setPromptText(this.client.getPassword());
        this.txtChangePW.setDisable(false);

        this.txtChangePN.setPromptText(String.valueOf(this.client.getPhoneNumber()));
        this.txtChangePN.setDisable(false);

        this.txtChangeBD.setPromptText(this.client.getBirth());
        this.txtChangeBD.setDisable(false);

        this.txtChangeSex.setPromptText(this.client.getSex());
        this.txtChangeSex.setDisable(false);

        this.txtChangeEmail.setPromptText(this.client.getEmail().getEmail());
        this.txtChangeEmail.setDisable(false);

        this.txtChangeTIN.setPromptText(String.valueOf(this.client.getTif()));
        this.txtChangeTIN.setDisable(false);

        this.txtChangeNHS.setPromptText(String.valueOf(this.client.getNhs()));
        this.txtChangeNHS.setDisable(false);

        this.txtChangeCCN.setPromptText(String.valueOf(this.client.getCcn()));
        this.txtChangeCCN.setDisable(false);






        this.changePw.setDisable(false);

        this.changePn.setDisable(false);

        this.changeBd.setDisable(false);

        this.changeSex.setDisable(false);

        this.changeEmail.setDisable(false);

        this.changeTin.setDisable(false);

        this.changeNhs.setDisable(false);

        this.changeCcn.setDisable(false);

        this.changeName.setDisable(false);



        //success = ctrl.doLogin(id, pwd);
// para fazer login usamos isto acho eu
    }


    public void UpdateName(ActionEvent actionEvent) {

        String newName= this.txtChangeName.getCharacters().toString();

        this.clientStore.ChangeName(this.client,newName);

        txtChangeName.clear();
        setprompttext();


    }

    public void UpdateCCN(ActionEvent actionEvent) {

        String newCcn= this.txtChangeCCN.getCharacters().toString();

        this.clientStore.ChangeCCN(this.client,newCcn);

        txtChangeCCN.clear();
        setprompttext();


    }

    public void UpdateNHS(ActionEvent actionEvent) {

        String newNhs= this.txtChangeNHS.getCharacters().toString();

        this.clientStore.ChangeNHS(this.client,Long.parseLong(newNhs));

        txtChangeNHS.clear();
        setprompttext();


    }

    public void UpdateTIN(ActionEvent actionEvent) {

        String newTIN= this.txtChangeTIN.getCharacters().toString();

        this.clientStore.ChangeTIN(this.client,Long.parseLong(newTIN));

        txtChangeTIN.clear();
        setprompttext();


    }

    public void UpdateEmail(ActionEvent actionEvent) {

        String newEmail= this.txtChangeEmail.getCharacters().toString();

        this.clientStore.ChangeEmail(this.client,newEmail);

        txtChangeEmail.clear();
        setprompttext();


    }

    public void UpdateSex(ActionEvent actionEvent) {

        String newSex= this.txtChangeSex.getCharacters().toString();

        this.clientStore.ChangeSex(this.client,newSex);

        txtChangeSex.clear();
        setprompttext();


    }

    public void UpdateBirthDate(ActionEvent actionEvent) {

        String newBirthDate= this.txtChangeBD.getCharacters().toString();

        this.clientStore.ChangeBD(this.client,newBirthDate);

        txtChangeBD.clear();
        setprompttext();


    }
    public void UpdatePhoneNumer(ActionEvent actionEvent) {

        String newPhoneNumer= this.txtChangePN.getCharacters().toString();

        this.clientStore.ChangePN(this.client,Long.parseLong(newPhoneNumer));

        txtChangePN.clear();
        setprompttext();

    }
    public void UpdatePassword(ActionEvent actionEvent) {

        String newPassword= this.txtChangePW.getCharacters().toString();

        this.clientStore.ChangePassword(this.client,newPassword);

        txtChangePW.clear();
        setprompttext();

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
}
