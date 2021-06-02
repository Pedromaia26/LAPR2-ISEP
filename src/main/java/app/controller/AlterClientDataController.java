package app.controller;

import app.domain.model.*;
import auth.AuthFacade;
import auth.domain.model.Email;

public class AlterClientDataController {
    private ClientStore clientStore;

    private Company company;

    private Client client;

    private AuthFacade authFacade;




    public AlterClientDataController(){
        this.company=App.getInstance().getCompany();
        this.clientStore=App.getInstance().getCompany().getClientStore();
        this.authFacade= company.getAuthFacade();

    }

    public AlterClientDataController(Company company) {
        this.clientStore=App.getInstance().getCompany().getClientStore();
        this.company= company;
        this.authFacade= company.getAuthFacade();

    }

    public void checkClient(){
        Email empemail= authFacade.getCurrentUserSession().getUserId();

        this.client=company.getClientStore().getClientByEmail(String.valueOf(empemail));


    }



}
