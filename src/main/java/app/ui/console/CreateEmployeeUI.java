package app.ui.console;

import app.controller.App;
import app.controller.RegistEmployeeController;
import app.domain.model.*;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;
import auth.domain.model.User;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateEmployeeUI  implements Runnable{
    public CreateEmployeeUI()
    {
    }

    public void run() {
        Scanner ler = new Scanner(System.in);
        RegistEmployeeController employeeController = new RegistEmployeeController();

        List<OrgRole> lRolesDto = employeeController.getRoles();

        String op;
        boolean exists = false;

        System.out.printf("List of employee roles:\n");

        for(OrgRole orgRole : lRolesDto){
            System.out.printf("%d - %s\n",lRolesDto.indexOf(orgRole)+1, orgRole.getDesignation());
        }
        System.out.printf("Type a role:\n");
        String role = ler.nextLine();
        for(OrgRole orgRole : lRolesDto){
            if (orgRole.getDesignation().equals(role)) {
                exists = true;
            }
        }
        if (exists){
            System.out.printf("Name: ");
            String name = ler.nextLine();
            System.out.printf("Address: ");
            String address = ler.nextLine();
            System.out.printf("Phone number: ");
            long phoneNumber = ler.nextLong();
            ler.nextLine();
            System.out.printf("Email: ");
            String m = ler.nextLine();
            Email email = new Email(m);
            System.out.printf("SOC code: ");
            int socCode = ler.nextInt();
            ler.nextLine();
            OrgRole UserRole = new OrgRole(role);
            String employeeIddefault = "default";
            if (role.equalsIgnoreCase("specialist doctor")){
                System.out.printf("Doctor Index Number: ");
                int docIndexNumber = ler.nextInt();
                SpecialistDoctor sp = employeeController.createSpecialistDoctor(new EmployeeDto(UserRole, employeeIddefault, name, address, phoneNumber, email, socCode, docIndexNumber));
                System.out.println("Data confirmation:");
                System.out.printf("Employee ID: %s\nUser Role: %s\nName: %s\nAddress: %s\nEmail: %s\nPhone number: %d\nSOC code: %d\nDoctorIndexNumber: %d\n", sp.getEmployeeId(), sp.getUserRole(), sp.getName(), sp.getAdress(), sp.getEmail(), sp.getPhoneNumber(), sp.getSocCode(), sp.getDocIndexNumber());
                System.out.println("Do you want to create the employee?(Y/N)");
                op = ler.next();
                if (op.equalsIgnoreCase("Y") || op.equalsIgnoreCase("yes")){
                    if (!App.getInstance().getCompany().getAuthFacade().existsUser(String.valueOf(sp.getEmail()))) {
                        try {
                            employeeController.saveSpecialistDoctor();
                            System.out.println("Employee created with success.");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        throw new IllegalArgumentException("Employee already created.");
                    }
                }
                else System.out.println("Employee regist canceled.");
            }
            else{
                Employee emp = employeeController.createEmployee(new EmployeeDto(UserRole, employeeIddefault, name, address, phoneNumber, email, socCode));
                System.out.println("Data confirmation:");
                System.out.printf("Employee ID: %s\nUser Role: %s\nName: %s\nAddress: %s\nEmail: %s\nPhone number: %d\nSOC code: %d\n", emp.getEmployeeId(), emp.getUserRole(), emp.getName(), emp.getAdress(), emp.getEmail(), emp.getPhoneNumber(), emp.getSocCode());
                System.out.println("Do you want to create the employee?(Y/N)");
                op = ler.next();
                if (op.equalsIgnoreCase("Y") || op.equalsIgnoreCase("yes")) {
                    if (!App.getInstance().getCompany().getAuthFacade().existsUser(String.valueOf(emp.getEmail()))) {
                        try {
                            employeeController.saveEmployee();
                            System.out.println("Employee created with success.");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        throw new IllegalArgumentException("Employee already created.");
                    }
                }
                else System.out.println("Employee regist canceled.");
            }
        }
        else{
            throw new IllegalArgumentException("The selected role does not exist.");
        }
    }
}
