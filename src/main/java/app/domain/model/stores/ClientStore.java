package app.domain.model.stores;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import app.controller.App;
import app.domain.model.Client;
import app.domain.model.dto.ClientDTO;
import app.domain.model.mappers.ClientMapper;

public class ClientStore {
    /**
     * List that contains the Clients.
     */
    private List<Client> clientList = new ArrayList<>();
    /**
     * Create a new client with the dto received.
     * @param dto The clientDTO
     * @return The client created.
     */
    public Client createNewClient(ClientDTO dto) {
        return ClientMapper.toModel(dto);

    }
    /**
     * Validates the client received.
     * @param nc the client to be validated.
     * @return True if the client is successfully validated, false if it is not.
     */
    public boolean validateClient(Client nc){
        if (nc == null)
            return false;
        return ! this.clientList.contains(nc);
    }
    /**
     * Saves the client received.
     * @param nc the client to be saved.
     * @return True if the client is successfully saved, false if it is not.
     */
    public boolean addNewClient(Client nc){
        if (!validateClient(nc))
            return false;
        return this.clientList.add(nc);
    }
    /**
     * Returns the list of clients.
     * @return list of clients.
     */
    public List<Client> getClientList() {
        return clientList;
    }

    /**
     * Calls all the methods to save and create the client.
     * @param nc the client to be saved.
     * @return True if the client is successfully created, false if it is not.
     */
    public boolean saveClient(Client nc) throws IOException {
        validateClient(nc);

        sendEmail(nc);

        addNewClient(nc);

        return CreateUser(nc);
    }
    /**
     * Generates a random password.
     * @return the password.
     */
    public String generatePassword(){
        int num= 10;
        String a="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuilder fim= new StringBuilder();
        for (int i=0;i<num;i++){
            fim.append(a.charAt((int) (Math.random() * (60))));
        }



        return String.valueOf(fim);
    }
    /**
     * Create directories to save the txt file that saves the password. Create the file that saves the password and writes on it.
     * @param nc the client to be send the email.
     */
    public void sendEmail(Client nc) throws IOException {
        String pwd = System.getProperty("user.dir");


        File emailAndSMSMessages = new File(pwd + "\\src\\main\\emailAndSMSMessages");
        if (!emailAndSMSMessages.exists()) {
            emailAndSMSMessages.mkdirs();
        }

        PrintWriter asd = new PrintWriter(pwd + "\\src\\main\\emailAndSMSMessages\\emailAndSMSMessages.txt");

        String password =  generatePassword();
        asd.printf("Cliente registado com sucesso a sua password de acesso é : %s",password);




        asd.close();
        nc.setPassword(password);

    }

    /**
     * Creates a new client(becomes a system user).
     * @param nc the client to be created.
     * @return True if the client is successfully saved, false if it is not.
     */
    public boolean CreateUser(Client nc){
        return App.getInstance().getCompany().getAuthFacade().addUserWithRole(nc.getName(),String.valueOf(nc.getEmail()),nc.getPassword(),"CLIENT");
    }


}
