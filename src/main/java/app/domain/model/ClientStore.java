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

    /**
     * List that contains the Clients.
     */
    private List<Client> clientList;

    public ClientStore(){
        clientList = new ArrayList<>();
    }

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

        PrintWriter asd = new PrintWriter(pwd + "\\src\\main\\emailAndSMSMessages\\"+ nc.getName()+"_"+nc.getCcn()+".txt");

        String password =  generatePassword();
        asd.printf("Client registed succesfully and your password is: %s",password);




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
    /**
     * Returns the client list.
     * @return the client list.
     */
    public List<Client> getClientList() {
        return clientList;
    }

    /**
     * Searches for the client with a specific tin number.
     * @return the client with specific tin number.
     */
    public Client getClientByTinNumber(long tinNumber){

        for (Client client: clientList) {
            if (tinNumber==client.getTif())
                return client;
        }
        throw new IllegalArgumentException("There is no Sample with such barcode!");
    }



}
