package app.controller;

import app.domain.model.*;

import java.io.IOException;
import java.util.List;

public class RegistClientController {
    private ClientStore clientStore;

    private Company company;

    private Client nc;

    public RegistClientController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
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

    public boolean saveClient () throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        return this.company.getClientStore().saveClient(nc);
    }


}
