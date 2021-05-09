package app.ui.console;

import app.controller.RegistEmployeeController;
import app.domain.model.OrgRole;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;

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
        RegistEmployeeController employee = new RegistEmployeeController();

        List<OrgRole> lRolesDto;
        lRolesDto = employee.getRoles();

        for(OrgRole orgRole : lRolesDto){
            System.out.printf("%d - %s\n",lRolesDto.indexOf(orgRole)+1, orgRole);
        }
        System.out.printf("Select a role (number): ");
        int num = ler.nextInt();
        if (num <= 6){
            System.out.printf("Name: ");
            String name = ler.next();
            System.out.printf("Address: ");
            String address = ler.next();
            System.out.printf("Phone number: ");
            long phoneNumber = ler.nextLong();
            System.out.printf("Email: ");
            String m = ler.next();
            Email email = new Email(m);
            System.out.printf("SOC code: ");
            int socCode = ler.nextInt();
            System.out.printf("User Role: ");
            if (num == 6){

            }
        }
    }
}
