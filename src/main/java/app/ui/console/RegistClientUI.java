package app.ui.console;

import app.controller.App;
import app.controller.RegistClientController;
import app.domain.model.ClientDTO;

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


        if(cliente.createNewClient(new ClientDTO(ccn,nhs,birth,sex,tif,email,name,phoneNumber))){
            System.out.print("--------------------------%n");
            System.out.print("Please confirm the data:%n");
            System.out.printf("CCN: %d%nNHS: %d%nBirth date: %s%nSex: %s%nTIN: %d%nEmail: %s%nName: %s%nPhone Number: %s%n", ccn, nhs, birth,sex,tif,email,name,phoneNumber);
            System.out.print("--------------------------%n");
            System.out.print(" 1 --> Confirm%n");
            System.out.print(" 2 --> Cancel%n");
            int confirm = ler.nextInt();
            if(confirm == 1){
                try {
                    if(cliente.saveClient()){
                        System.out.print("Client registered successfully.%n");
                    }else{
                        System.out.print("Client register error.%n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
