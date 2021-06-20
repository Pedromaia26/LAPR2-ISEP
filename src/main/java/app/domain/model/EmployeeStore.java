package app.domain.model;

import app.controller.App;
import app.mappers.EmployeeMapper;
import app.mappers.dto.EmployeeDto;
import app.serialization.Serialization;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {

    /**
     * Object used to save the information.
     */
    private Serialization ser = new Serialization();

    /**
     * List that contains Employees
     */
    private List<Employee> Employees = new ArrayList<>();

    /**
     * List that contains Specialist Doctors
     */
    private List<SpecialistDoctor> SpecialistDoctors = new ArrayList<>();

    /**
     * Send the received data and the list of Employees to the EmployeeMapper.toDto() method.
     * @param empDto A EmployeeDto instance
     * @return the EmployeeMapper.toDto() method
     */
    public Employee createEmployee(EmployeeDto empDto, Company company) throws IllegalAccessException, InstantiationException, ClassNotFoundException, BarcodeException, ParseException, OutputException, IOException {
        return EmployeeMapper.toDtoE(empDto, company);
    }

    /**
     * Send the received data and the list of Specialist Doctors to the EmployeeMapper.toDto() method.
     * @param specdocdto A EmployeeDto instance
     * @return the EmployeeMapper.toDto() method
     */
    public SpecialistDoctor createSpecialistDoctor(EmployeeDto specdocdto, Company company) throws IllegalAccessException, InstantiationException, ClassNotFoundException, BarcodeException, ParseException, OutputException, IOException {
        return EmployeeMapper.toDtoSD(specdocdto, company);
    }

    /**
     * Returns a alphanumeric generated password, with 10 characters.
     * @return a alphanumeric generated password, with 10 characters
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
     * Verify if a Employee is already presented in the Employees List.
     * @param emp A Employee instance
     * @return the method contains() to verify if the received Employee is presented in the Employee List
     */
    public boolean validateEmployee(Employee emp){
        if(emp == null)
            return false;
        return !this.Employees.contains(emp);
    }

    /**
     * Add to the Employees List the validated Employee instance received by parameter
     * @param emp A Employee Instance
     * @return the addition to Employees List of the Employee instance received by parameter
     */
    public boolean addEmployee(Employee emp){
        if (!validateEmployee(emp))
            return false;
        return this.Employees.add(emp);
    }

    /**
     * Add to the Employees List the validated Employee instance received by parameter
     * @param emp A SpecialistDoctor Instance
     * @return the addition to Specialist Doctors List of the Specialist Doctor instance received by parameter
     */
    public boolean addSpecialistDoctor(SpecialistDoctor emp){
        if (!validateSpecialistDoctor(emp))
            return false;
        return this.SpecialistDoctors.add(emp);
    }

    /**
     * Returns the Employees List
     * @return the Employees List
     */
    public List<Employee> getEmployeeList(){
        return Employees;
    }

    /**
     * Receives a Employee instance by parameter, create  a file and, if exists, present the Employee password.
     * @param emp A Employee instance
     * @throws FileNotFoundException
     */
    public void saveEmployee(Employee emp) throws FileNotFoundException {
        String pwd = System.getProperty("user.dir");


        File emailAndSMSMessages = new File(pwd + "\\src\\main\\emailAndSMSMessagesEmployees");
        if (!emailAndSMSMessages.exists()) {
            emailAndSMSMessages.mkdirs();
        }

        PrintWriter out = new PrintWriter(pwd + "\\src\\main\\emailAndSMSMessagesEmployees\\"+emp.getEmployeeId()+".txt");

        String password =  generatePassword();


        out.printf("Employee registered with success. The password is: %s",password);
        emp.setPassword(password);



        out.close();
        Employees.add(emp);
        save();
    }

    /**
     * Receives a Specialist Doctor instance by parameter, create  a file and, if exists, present the Specilist Doctor password.
     * @param emp A Specialist Doctor instance
     * @throws FileNotFoundException
     */
    public void saveSpecialistDoctor(SpecialistDoctor emp) throws FileNotFoundException {
        String pwd = System.getProperty("user.dir");


        File emailAndSMSMessages = new File(pwd + "\\src\\main\\emailAndSMSMessagesEmployees");
        if (!emailAndSMSMessages.exists()) {
            emailAndSMSMessages.mkdirs();
        }

        PrintWriter out = new PrintWriter(pwd + "\\src\\main\\emailAndSMSMessagesEmployees\\"+emp.getEmployeeId()+".txt");

        String password =  generatePassword();

        out.printf("Employee registered with success. The password is: %s",password);

        out.close();

        emp.setPassword(password);


        SpecialistDoctors.add(emp);

        saveSpecialistDoctor();
    }

    /**
     * Returns the Specialist Doctors List
     * @return the Specialist Doctors List
     */
    public List<SpecialistDoctor> getSpecialistDoctors(){
        return SpecialistDoctors;
    }

    /**
     * Verify if a Specialist Doctor is already presented in the Specialist Doctors List.
     * @param emp A Specialist Doctor instance
     * @return the method contains() to verify if the received Specialist Doctor is presented in the Specialist Doctor List
     */
    public boolean validateSpecialistDoctor(SpecialistDoctor emp){
        if(emp == null)
            return false;
        return !this.SpecialistDoctors.contains(emp);
    }

    /**
     * Create a system user to the received Employee instance
     * @param emp A Employee instance
     * @return the addUserWithRole, associated with the Employee instance
     */

    public boolean createUser(Employee emp) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        return App.getInstance().getCompany().getAuthFacade().addUserWithRole(emp.getName(), String.valueOf(emp.getEmail()), emp.getPassword(), String.valueOf(emp.getUserRole()));
    }

    /**
     * Create a system user to the received Specialist Doctor instance
     * @param emp A Specialist Doctor instance
     * @return the addUserWithRole, associated with the Specialist Doctor instance
     */

    public boolean createUser(SpecialistDoctor emp) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        return App.getInstance().getCompany().getAuthFacade().addUserWithRole(emp.getName(), String.valueOf(emp.getEmail()), emp.getPassword(), String.valueOf(emp.getUserRole()));
    }

    /**
     * Verify if a Employee email is registered in the Employees list
     * @param email The Email of a Employee
     * @return a boolean that is true if the email is registered and false if doesn't.
     */
    public boolean exists(String email)
    {
        for(Employee emp: this.Employees)
        {

            if(String.valueOf(emp.getEmail()).equals(email)) {

                return true;
            }
        }
        return false;
    }
    /**
     * Searches for the employee with a specific labid.
     * @return the laboratory with specific labid.
     */
    public Laboratory getEmpByEmail(String labid) {
        for (Employee lab : Employees) {
            if (labid.equals(String.valueOf(lab.getEmail())))
                return lab.getLaboratory();
            }
            throw new IllegalArgumentException("There is no Employee with such Email!");
        }



    public void save(){
        ser.escrever((List<Object>) (List<?>) Employees, "employees.ser");
    }

    public void read(Company c){
        Employees = (List<Employee>) (List<?>) ser.ler("employees.ser");
        addUser(c);
    }

    /**
     * create a user
     */
    public void addUser(Company c){
        for( Employee emp : Employees){
            c.getAuthFacade().addUserWithRole(emp.getName(), String.valueOf(emp.getEmail()), emp.getPassword(), emp.getUserRole());
        }
    }

    public void saveSpecialistDoctor(){
        ser.escrever((List<Object>) (List<?>) SpecialistDoctors, "SpecialistDoctor.ser");
    }

    public void readSpecialistDoctor(Company c){
        File f = new File("SpecialistDoctor.ser");
        if (f.exists()) {
            SpecialistDoctors = (List<SpecialistDoctor>) (List<?>) ser.ler("SpecialistDoctor.ser");
        }
        addUserSpecialistDoctor(c);
    }

    /**
     * create user
     */
    public void addUserSpecialistDoctor(Company c){
        for( SpecialistDoctor emp : SpecialistDoctors){
            c.getAuthFacade().addUserWithRole(emp.getName(), String.valueOf(emp.getEmail()), emp.getPassword(), String.valueOf(emp.getUserRole()));
        }
    }

}
