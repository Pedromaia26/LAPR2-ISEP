package app.ui.console;

import app.controller.App;
import app.controller.RegistEmployeeController;
import app.domain.model.*;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;
import auth.domain.model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
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

        List<OrgRoleDto> lRolesDto = employeeController.getRoles();

        String op;
        String role = null;
        int num;
        int docIndexNumber = 0;
        boolean exists = false;

        System.out.printf("List of employee roles:\n");

        for(OrgRoleDto orgRole : lRolesDto){
            System.out.printf("%d - %s\n",lRolesDto.indexOf(orgRole)+1, orgRole.getDesignation());
        }
        System.out.printf("Select a role:\n");
        String Orgop = ler.nextLine();
        try {
            num = Integer.parseInt(Orgop);
            if (Integer.parseInt(Orgop) <= lRolesDto.size() && Integer.parseInt(Orgop) >=1) {
                role = lRolesDto.get(Integer.parseInt(Orgop)-1).getDesignation();
                exists = true;
            }

        } catch (NumberFormatException e) {
            for (OrgRoleDto orgRole : lRolesDto){
                if (Orgop.equalsIgnoreCase(orgRole.getDesignation())){
                    role = orgRole.getDesignation();
                    exists = true;
                }
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
            if (role.equalsIgnoreCase("specialist doctor")){
                System.out.printf("Doctor Index Number: ");
                docIndexNumber = ler.nextInt();
                if (employeeController.createSpecialistDoctor(new EmployeeDto(role, name, address, phoneNumber, email, socCode, docIndexNumber))) {
                    ConfirmDataSave(role, name, address, phoneNumber, email, socCode, docIndexNumber, employeeController);
                } else System.out.println("Employee created without success.");
            }
            else{
                if (employeeController.createEmployee(new EmployeeDto(role, name, address, phoneNumber, email, socCode))) {
                    ConfirmDataSave(role, name, address, phoneNumber, email, socCode, docIndexNumber, employeeController);
                } else System.out.println("Employee created without success.");
            }
        }
        else{
            throw new IllegalArgumentException("The selected role does not exist.");
        }
    }

    public void ConfirmDataSave(String role, String name, String address, long phoneNumber, Email email, int socCode, int docIndexNumber, RegistEmployeeController employeeController){
        String op;
        Scanner ler = new Scanner(System.in);

        if (docIndexNumber == 0){
            System.out.println("Data confirmation:");
            System.out.printf("User Role: %s\nName: %s\nAddress: %s\nEmail: %s\nPhone number: %d\nSOC code: %d\n", role, name, address, email, phoneNumber, socCode);
        }
        else{
            System.out.println("Data confirmation:");
            System.out.printf("User Role: %s\nName: %s\nAddress: %s\nEmail: %s\nPhone number: %d\nSOC code: %d\nDoctorIndexNumber: %d\n", role, name, address, email, phoneNumber, socCode, docIndexNumber);
        }
        System.out.println("Do you want to create the employee?(Y/N)");
        op = ler.next();
        if (op.equalsIgnoreCase("Y") || op.equalsIgnoreCase("yes")) {
            if (!App.getInstance().getCompany().getAuthFacade().existsUser(String.valueOf(email))) {
                try {
                    if (docIndexNumber == 0) employeeController.saveEmployee();
                    else employeeController.saveSpecialistDoctor();
                    System.out.println("Employee created with success.");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                throw new IllegalArgumentException("Employee already created.");
            }
        } else System.out.println("Employee regist canceled.");
    }
}
