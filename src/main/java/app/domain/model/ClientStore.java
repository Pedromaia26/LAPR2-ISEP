package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ClientStore {

    private List<Client> clientList = new ArrayList<Client>();

    public Client createNewClient(ClientDTO dto) {
        return ClientMapper.toModel(dto);

    }

    public boolean validateClient(Client nc){
        if (nc == null)
            return false;
        return ! this.clientList.contains(nc);
    }

    public boolean saveClient(Client nc){
        if (!validateClient(nc))
            return false;
        return this.clientList.add(nc);
    }

    public List<Client> getClientList() {
        return clientList;
    }

    @Override
    public String toString() {
        return "ClientStore{" +
                "clientList=" + clientList +
                '}';
    }
}
