package app.ui.console;

import app.controller.App;
import app.controller.RegistEmployeeController;
import app.domain.model.*;
import app.domain.model.dto.EmployeeDto;
import auth.domain.model.Email;

import java.io.FileNotFoundException;
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
        String role = null;
        int num;
        boolean exists = false;

        System.out.printf("List of employee roles:\n");

        for(OrgRole orgRole : lRolesDto){
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
            for (OrgRole orgRole : lRolesDto){
                if (Orgop.equalsIgnoreCase(orgRole.getDesignation())){
                    role = orgRole.getDesignation();
                    exists = true;
                }
            }
        }
        /*if (Integer.parseInt(Orgop) <= lRolesDto.size() && Integer.parseInt(Orgop) >=1) {
            role = lRolesDto.get(Integer.parseInt(Orgop)-1).getDesignation();
            exists = true;
        }
        else{
            for (OrgRole orgRole : lRolesDto){
                if (Orgop.equalsIgnoreCase(orgRole.getDesignation())){
                    role = orgRole.getDesignation();
                    exists = true;
                }
            }
        }*/
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
                int docIndexNumber = ler.nextInt();
                if (employeeController.createSpecialistDoctor(new EmployeeDto(role, name, address, phoneNumber, email, socCode, docIndexNumber))) {
                    System.out.println("Data confirmation:");
                    System.out.printf("User Role: %s\nName: %s\nAddress: %s\nEmail: %s\nPhone number: %d\nSOC code: %d\nDoctorIndexNumber: %d\n", role, name, address, email, phoneNumber, socCode, docIndexNumber);
                    System.out.println("Do you want to create the employee?(Y/N)");
                    op = ler.next();
                    if (op.equalsIgnoreCase("Y") || op.equalsIgnoreCase("yes")) {
                        if (!App.getInstance().getCompany().getAuthFacade().existsUser(String.valueOf(email))) {
                            try {
                                employeeController.saveSpecialistDoctor();
                                System.out.println("Employee created with success.");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        } else {
                            throw new IllegalArgumentException("Employee already created.");
                        }
                    } else System.out.println("Employee regist canceled.");
                } else System.out.println("Employee created without success.");
            }
            else{
                if (employeeController.createEmployee(new EmployeeDto(role, name, address, phoneNumber, email, socCode))) {
                    System.out.println("Data confirmation:");
                    System.out.printf("User Role: %s\nName: %s\nAddress: %s\nEmail: %s\nPhone number: %d\nSOC code: %d\n", role, name, address, email, phoneNumber, socCode);
                    System.out.println("Do you want to create the employee?(Y/N)");
                    op = ler.next();
                    if (op.equalsIgnoreCase("Y") || op.equalsIgnoreCase("yes")) {
                        if (!App.getInstance().getCompany().getAuthFacade().existsUser(String.valueOf(email))) {
                            try {
                                employeeController.saveEmployee();
                                System.out.println("Employee created with success.");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        } else {
                            throw new IllegalArgumentException("Employee already created.");
                        }
                    } else System.out.println("Employee regist canceled.");
                } else System.out.println("Employee created without success.");
            }
        }
        else{
            throw new IllegalArgumentException("The selected role does not exist.");
        }
    }
}
