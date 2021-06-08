package app.controller;

import app.domain.model.*;
import auth.AuthFacade;
import auth.domain.model.Email;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;

import java.io.IOException;

public class AlterClientDataController {
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



<<<<<<< HEAD
    public AlterClientDataController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
=======
    public AlterClientDataController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
        this.company=App.getInstance().getCompany();
        this.clientStore=App.getInstance().getCompany().getClientStore();
        this.authFacade= company.getAuthFacade();
        checkClient();


    }

<<<<<<< HEAD
    public AlterClientDataController(Company company) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
=======
    public AlterClientDataController(Company company) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
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

        this.txtChangePW.setPromptText(this.client.getName());
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

        System.out.println(client.getName());

    }

    public void UpdateCCN(ActionEvent actionEvent) {

        String newCcn= this.txtChangeCCN.getCharacters().toString();

        this.clientStore.ChangeCCN(this.client,newCcn);

    }

    public void UpdateNHS(ActionEvent actionEvent) {

        String newNhs= this.txtChangeNHS.getCharacters().toString();

        this.clientStore.ChangeNHS(this.client,Long.parseLong(newNhs));

    }

    public void UpdateTIN(ActionEvent actionEvent) {

        String newTIN= this.txtChangeTIN.getCharacters().toString();

        this.clientStore.ChangeTIN(this.client,Long.parseLong(newTIN));

    }

    public void UpdateEmail(ActionEvent actionEvent) {

        String newEmail= this.txtChangeEmail.getCharacters().toString();

        this.clientStore.ChangeEmail(this.client,newEmail);

    }

    public void UpdateSex(ActionEvent actionEvent) {

        String newSex= this.txtChangeSex.getCharacters().toString();

        this.clientStore.ChangeSex(this.client,newSex);

    }

    public void UpdateBirthDate(ActionEvent actionEvent) {

        String newBirthDate= this.txtChangeBD.getCharacters().toString();

        this.clientStore.ChangeBD(this.client,newBirthDate);

    }
    public void UpdatePhoneNumer(ActionEvent actionEvent) {

        String newPhoneNumer= this.txtChangePN.getCharacters().toString();

        this.clientStore.ChangePN(this.client,Long.parseLong(newPhoneNumer));

    }
    public void UpdatePassword(ActionEvent actionEvent) {

        String newPassword= this.txtChangePW.getCharacters().toString();

        this.clientStore.ChangePassword(this.client,newPassword);

    }

    public void showdata(ActionEvent actionEvent) {

        setprompttext();

    }
}
