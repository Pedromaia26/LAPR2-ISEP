package app.ui.console;

import app.controller.App;
import app.controller.RegistClientController;
import app.controller.RegistEmployeeController;
import app.domain.model.Client;
import app.domain.model.ClientDTO;
import app.domain.model.OrgRole;
import auth.domain.model.Email;
import auth.domain.model.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RegistClientUI implements Runnable {
    public RegistClientUI()
    {

    }
    @Override
    public void run() {
        Scanner ler = new Scanner(System.in);
        RegistClientController cliente= new RegistClientController();


        System.out.print("Name: ");
        String name = ler.nextLine();
        System.out.print("Email: ");
        String email = ler.nextLine();
        System.out.print("Phone number: ");
        long phoneNumber = ler.nextLong();
        System.out.print("Citizen Card Number: ");
        long ccn = ler.nextLong();
        System.out.print("National Health Service number: ");
        long nhs = ler.nextLong();
        System.out.print("Tax Identification Number: ");
        long tif = ler.nextLong();
        System.out.print("Birth date: ");
        ler.nextLine();
        String birth = ler.nextLine();

        System.out.print("Sex(if you dont want to write it, leave it blank): ");
        String sex = ler.nextLine();


        cliente.createNewClient(new ClientDTO(ccn,nhs,birth,sex,tif,email,name,phoneNumber));





    }
}
