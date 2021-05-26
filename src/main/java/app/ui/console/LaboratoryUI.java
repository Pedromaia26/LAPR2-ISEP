package app.ui.console;

import app.controller.RegistLaboratoryController;
import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LaboratoryUI implements Runnable{

    public LaboratoryUI(){

    }
    @Override
    public void run() {
        Scanner ler = new Scanner(System.in);
        RegistLaboratoryController createRegistLaboratoryController = new RegistLaboratoryController();

        System.out.println("Insert the Laboratory ID you want to create:");
        String laboratoryID = ler.next();
        System.out.println("Insert its name:");
        String name = ler.next();
        ler.nextLine();
        System.out.println("Insert its address:");
        String address = ler.next();
        System.out.println("Insert the phone number of the Clinical Analysis Laboratory:");
        long phoneNumber = ler.nextLong();
        System.out.println("Insert the Tax Identification Number:");
        long tinNumber = ler.nextLong();
        System.out.println("Insert the code of the Test Type you want to use:");

        List<String> testtypes = new ArrayList<>();

        int a;
        String testTypeCode;

        do {
            testTypeCode = ler.next();
            testtypes.add(testTypeCode);
            System.out.println("Do you want to add another type test to your Laboratory?:\n1 ---> Yes\n2 ---> No");
            a = ler.nextInt();
        }while (a==1);

        List<TestType> tt = new ArrayList<>();

        for(String code : testtypes){
            tt.add(createRegistLaboratoryController.getTestTypeStore().getTestTypeByCode(code));
        }

        createRegistLaboratoryController.getTestTypeStore().getTestTypeByCode(testTypeCode);
        
        if (createRegistLaboratoryController.createLaboratory(laboratoryID, name, address, phoneNumber, tinNumber, tt)){
            System.out.println("--------------------------");
            System.out.println("Please confirm the data:");
            System.out.printf("Laboratory ID: %s\nName: %s\nAddress: %s\nPhone Number: %d\nTax Identification Number: %d\nTest Type code: %s\n%n", laboratoryID, name, address, phoneNumber, tinNumber, testtypes);
            System.out.println("--------------------------");
            System.out.println(" 1 --> Confirm");
            System.out.println(" 2 --> Cancel");
            int confirm = ler.nextInt();
            if(confirm == 1){
                if(createRegistLaboratoryController.saveLaboratory()){
                    System.out.println("Laboratory created successfully.");
                }else{
                    System.out.println("Laboratory creation error.");
                }
            }
        }
    }
}
