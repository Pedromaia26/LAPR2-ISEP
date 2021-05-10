package app.domain.model;

import app.controller.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {

    static List<Employee> Employees = new ArrayList<>();
    static List<SpecialistDoctor> SpecialistDoctors = new ArrayList<>();


    public static Employee createEmployee(EmployeeDto empDto){
        return EmployeeMapper.toDto(empDto, Employees);
    }

    public static SpecialistDoctor createSpecialistDoctor(EmployeeDto specdocdto){
        return EmployeeMapper.toDto(SpecialistDoctors, specdocdto);
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

    public boolean validateEmployee(Employee emp){
        if(emp == null)
            return false;
        return !this.Employees.contains(emp);
    }

    public boolean addEmployee(Employee emp){
        if (!validateEmployee(emp))
            return false;
        return this.Employees.add(emp);
    }

    public List<Employee> getEmployeeList(){
        return Employees;
    }

    public void saveEmployee(Employee emp) throws FileNotFoundException {
        String pwd = System.getProperty("user.dir");


        File emailAndSMSMessages = new File(pwd + "\\src\\main\\emailAndSMSMessagesEmployees");
        if (!emailAndSMSMessages.exists()) {
            emailAndSMSMessages.mkdirs();
        }

        PrintWriter out = new PrintWriter(pwd + "\\src\\main\\emailAndSMSMessagesEmployees\\emailAndSMSMessages.txt");

        String password =  generatePassword();

        out.printf("Funcionario registado com sucesso a sua password de acesso é : %s",password);
        emp.setPassword(password);



        out.close();
        Employees.add(emp);
    }

    public void saveSpecialistDoctor(SpecialistDoctor emp) throws FileNotFoundException {
        String pwd = System.getProperty("user.dir");


        File emailAndSMSMessages = new File(pwd + "\\src\\main\\emailAndSMSMessagesEmployees");
        if (!emailAndSMSMessages.exists()) {
            emailAndSMSMessages.mkdirs();
        }

        PrintWriter out = new PrintWriter(pwd + "\\src\\main\\emailAndSMSMessagesEmployees\\emailAndSMSMessages.txt");

        String password =  generatePassword();

        out.printf("Funcionario registado com sucesso a sua password de acesso é : %s",password);

        out.close();

        emp.setPassword(password);

        SpecialistDoctors.add(emp);
    }

    public List<SpecialistDoctor> getSpecialistDoctors(){
        return SpecialistDoctors;
    }

    public boolean validateSpecialistDoctor(SpecialistDoctor emp){
        if(emp == null)
            return false;
        return !this.SpecialistDoctors.contains(emp);
    }

    public boolean createUser(Employee emp){
        return App.getInstance().getCompany().getAuthFacade().addUserWithRole(emp.getName(), String.valueOf(emp.getEmail()), emp.getPassword(), String.valueOf(emp.getUserRole().getId()));
    }

    public boolean createSpecialistDoctor(SpecialistDoctor emp){
        return App.getInstance().getCompany().getAuthFacade().addUserWithRole(emp.getName(), String.valueOf(emp.getEmail()), emp.getPassword(), String.valueOf(emp.getUserRole().getId()));
    }

}
