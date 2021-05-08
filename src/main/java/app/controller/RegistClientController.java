package app.controller;

import app.domain.model.*;

import java.util.List;

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
        this.nc = clientStore.createNewClient(dto);
        return this.clientStore.validateClient(nc);
    }

    public boolean saveClient () {
        return this.company.getClientStore().saveClient(nc);
    }

    public List<Client> getClientList () {
        return this.company.getClientStore().getClientList();
    }

    public boolean validateClient() { return this.company.getClientStore().validateClient(nc); }


}