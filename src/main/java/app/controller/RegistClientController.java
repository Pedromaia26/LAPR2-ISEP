package app.controller;

import app.domain.model.*;

public class RegistClientController {
    private ClientStore clientStore;

    private Company company;

    private Client nc;


    public RegistClientController(){
        this(App.getInstance().getCompany());
        this.clientStore=App.getInstance().getCompany().getClientStore();
    }

    public RegistClientController(Company company) {
        this.clientStore=company.getClientStore();
        this.company= company;
    }


    public boolean createNewClient(ClientDTO dto) {
        this.nc = this.clientStore.createNewClient(dto);
        return this.clientStore.validateClient(nc);
    }
}
