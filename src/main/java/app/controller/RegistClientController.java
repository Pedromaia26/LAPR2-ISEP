package app.controller;

import app.domain.model.*;
import app.mappers.dto.ClientDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;

public class RegistClientController {
    private ClientStore clientStore;

    private Company company;

    private Client nc;

    public RegistClientController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
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

    public boolean saveClient () throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException, ParseException, OutputException, BarcodeException {

        return this.company.getClientStore().saveClient(nc);
    }


}
