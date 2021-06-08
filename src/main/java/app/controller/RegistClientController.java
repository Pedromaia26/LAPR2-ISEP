package app.controller;

import app.domain.model.*;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class RegistClientController {
    private ClientStore clientStore;

    private Company company;

    private Client nc;

<<<<<<< HEAD
    public RegistClientController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
=======
    public RegistClientController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
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
