package app.controller;

import app.domain.model.*;
import app.domain.model.dto.ClientDTO;
import app.domain.model.stores.ClientStore;

import java.io.IOException;
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

    public boolean saveClient () throws IOException {

        return this.company.getClientStore().saveClient(nc);
    }

    public List<Client> getClientList () {
        return this.company.getClientStore().getClientList();
    }


}
