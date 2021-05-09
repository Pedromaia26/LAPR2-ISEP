package app.domain.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import auth.domain.model.Password;

public class ClientStore {

    private List<Client> clientList = new ArrayList<>();

    public Client createNewClient(ClientDTO dto) {
        return ClientMapper.toModel(dto);

    }

    public boolean validateClient(Client nc){
        if (nc == null)
            return false;
        return ! this.clientList.contains(nc);
    }

    public boolean addNewClient(Client nc){
        if (!validateClient(nc))
            return false;
        return this.clientList.add(nc);
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public boolean saveClient(Client nc) throws IOException {
        validateClient(nc);

        sendEmail(nc);

        return addNewClient(nc);
    }

    public void sendEmail(Client nc) throws IOException {
        String pwd = System.getProperty("user.dir");


        File emailAndSMSMessages = new File(pwd + "\\src\\main\\emailAndSMSMessages");
        if (!emailAndSMSMessages.exists()) {
            emailAndSMSMessages.mkdirs();
        }

        PrintWriter out = new PrintWriter(pwd + "\\src\\main\\emailAndSMSMessages\\emailAndSMSMessages.txt");

        long password = (long) ((Math.random() * (9999999999L - 1000000000L)) + 1000000000L);

        out.printf("Cliente registado com sucesso a sua password de acesso é : %d",password);




        out.close();

        Password pass = new Password(String.valueOf(password));

        nc.setPassword(pass);


    }


}
