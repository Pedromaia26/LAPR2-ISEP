package app.domain.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import app.controller.App;
import auth.domain.model.Password;
import auth.domain.model.User;

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

        addNewClient(nc);
        return CreateUser(nc);
    }
    public String generatePassword(){
        int num= 10;
        String a="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuilder fim= new StringBuilder();
        for (int i=0;i<num;i++){
            fim.append(a.charAt((int) (Math.random() * (60))));
        }



        return String.valueOf(fim);
    }

    public void sendEmail(Client nc) throws IOException {
        String pwd = System.getProperty("user.dir");


        File emailAndSMSMessages = new File(pwd + "\\src\\main\\emailAndSMSMessages");
        if (!emailAndSMSMessages.exists()) {
            emailAndSMSMessages.mkdirs();
        }

        PrintWriter out = new PrintWriter(pwd + "\\src\\main\\emailAndSMSMessages\\emailAndSMSMessages.txt");

        String password =  generatePassword();

        out.printf("Cliente registado com sucesso a sua password de acesso é : %s",password);




        out.close();
        nc.setPassword(password);

    }

    public boolean CreateUser(Client nc){
        return App.getInstance().getCompany().getAuthFacade().addUserWithRole(nc.getName(),String.valueOf(nc.getEmail()),nc.getPassword(),"CLIENT");
    }


}
