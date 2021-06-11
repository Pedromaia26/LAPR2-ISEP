package app.domain.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import app.controller.App;
import app.serialization.Serialization;
import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

public class ClientStore {

    /**
     * Object used to save the information.
     */
    private Serialization ser = new Serialization();

    private String orderingAlgorithm;

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
    public boolean addNewClient(Client nc) throws IOException {
        if (!validateClient(nc))
            return false;
        this.clientList.add(nc);
        sendEmail(nc);
        save();
        return true;
    }

    /**
     * Calls all the methods to save and create the client.
     * @param nc the client to be saved.
     * @return True if the client is successfully created, false if it is not.
     */
    public boolean saveClient(Client nc) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, ParseException, OutputException, BarcodeException {
        validateClient(nc);

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
        asd.printf("Client registed succesfully.Your email is : %s \n and your password is: %s",nc.getEmail().getEmail(),password);




        asd.close();
        nc.setPassword(password);

    }

    /**
     * Creates a new client(becomes a system user).
     * @param nc the client to be created.
     * @return True if the client is successfully saved, false if it is not.
     */
    public boolean CreateUser(Client nc) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
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

    public Client getClientByEmail(String email) {
        for (Client client : clientList) {
            if (email.equals(String.valueOf(client.getEmail())))
                return client;
        }
        throw new IllegalArgumentException("There is no Client with such Email!");
    }

    public Boolean getClientByCcn(String ccn){
        for (Client client : clientList) {
            if (ccn.equals(client.getCcn()))
                return true;
        }
        return false;

    }

    public void ChangeName(Client client, String name){

        client.setName(name);

    }

    public void ChangeCCN(Client client, String ccn){

        client.setCcn(ccn);

    }

    public void ChangeNHS(Client client, long nhs){

        client.setNhs(nhs);

    }

    public void ChangeTIN(Client client, long tin){

        client.setTif(tin);

    }

    public void ChangeSex(Client client, String tin){

        client.setSex(tin);

    }
    public void ChangePN(Client client, long pn){

        client.setPhoneNumber(pn);

    }
    public void ChangePassword(Client client, String pw){

        client.setPassword(pw);

    }
    public void ChangeEmail(Client client, String email){

        client.setEmail(new Email(email));

    }
    public void ChangeBD(Client client, String birth){

        client.setBirth(birth);

    }

    public void save(){
        ser.escrever((List<Object>) (List<?>) clientList, "client.ser");
    }

    public void read(Company c){
        clientList = (List<Client>) (List<?>) ser.ler("client.ser");
        addUser(c);
    }

    public void addUser(Company c){
        for( Client nc : clientList){
            c.getAuthFacade().addUserWithRole(nc.getName(),String.valueOf(nc.getEmail()),nc.getPassword(),"CLIENT");
        }
    }

    public OrderClientsTIN OrderingAlgorithm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {
        Properties prop = App.getInstance().getprops();
        String classaux = prop.getProperty(getOrderingAlgorithm());
        Class<?> oClass = Class.forName(classaux);
        return (OrderClientsTIN) oClass.newInstance();
    }

    public void setOrderingAlgorithm(String orderingAlgorithm) {
        this.orderingAlgorithm = orderingAlgorithm;
    }

    public String getOrderingAlgorithm(){
        return orderingAlgorithm;
    }


}
