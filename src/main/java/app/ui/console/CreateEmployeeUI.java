package app.ui.console;

import app.controller.App;
import app.controller.RegistEmployeeController;
import app.domain.model.Employee;
import app.domain.model.EmployeeDto;
import app.domain.model.OrgRole;
import app.domain.model.SpecialistDoctor;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;
import auth.domain.model.User;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

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
        RegistEmployeeController employeeControler = new RegistEmployeeController();

        List<UserRole> lRolesDto = new ArrayList<>();
        lRolesDto = employeeControler.getRoles();

        System.out.printf("List of employee roles:\n");

        for(UserRole orgRole : lRolesDto){
            System.out.printf("%d - %s\n",lRolesDto.indexOf(orgRole)+1, orgRole.getDescription());
        }
        System.out.printf("Select a role:\n");
        String role = ler.next();
        if (lRolesDto.contains(new UserRole(role, role))){
            ler.nextLine();
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
                employeeControler.createSpecialistDoctor(new EmployeeDto(UserRole, employeeIddefault, name, address, phoneNumber, email, socCode, docIndexNumber));
                try {
                    employeeControler.saveSpecialistDoctor();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{
                employeeControler.createEmployee(new EmployeeDto(UserRole, employeeIddefault, name, address, phoneNumber, email, socCode));
                try {
                    employeeControler.saveEmployee();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            /*List<SpecialistDoctor> list;
            list = employeeControler.getSpecialistDoctorList();
            for(SpecialistDoctor emp : list){
                System.out.println(emp);
            }*/
        }
    }
}
