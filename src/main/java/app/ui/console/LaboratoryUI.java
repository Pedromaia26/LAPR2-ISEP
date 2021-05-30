package app.ui.console;

import app.controller.RegistEmployeeController;
import app.controller.RegistLaboratoryController;
import app.controller.TestTypeController;
import app.domain.model.ParameterCategory;
import app.domain.model.ParameterCategoryDto;
import app.domain.model.TestType;
import app.domain.model.TestTypeStore;

import java.sql.SQLOutput;
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

        System.out.print("Insert the Laboratory ID you want to create:\n");
        String laboratoryID = ler.next();
        System.out.print("Insert its name:\n");
        String name = ler.next();
        ler.nextLine();
        System.out.print("Insert its address:\n");
        String address = ler.next();
        System.out.print("Insert the phone number of the Clinical Analysis Laboratory:\n");
        long phoneNumber = ler.nextLong();
        System.out.print("Insert the Tax Identification Number:\n");
        long tinNumber = ler.nextLong();
        System.out.print("Insert the code of the Test Type you want to use:\n");

        List<String> testtypes = new ArrayList<>();

        int a;
        String testTypeCode;

        do {
            testTypeCode = ler.next();
            testtypes.add(testTypeCode);
            System.out.print("Do you want to add another type test to your Laboratory?:\n1 ---> Yes\n2 ---> No\n");
            a = ler.nextInt();
        }while (a==1);

        List<TestType> tt = new ArrayList<>();

        for(String code : testtypes){
            tt.add(createRegistLaboratoryController.getTestTypeStore().getTestTypeByCode(code));
        }

        createRegistLaboratoryController.getTestTypeStore().getTestTypeByCode(testTypeCode);
        
        if (createRegistLaboratoryController.createLaboratory(laboratoryID, name, address, phoneNumber, tinNumber, tt)){
            System.out.print("--------------------------\n");
            System.out.print("Please confirm the data:\n");
            System.out.printf("Laboratory ID: %s\nName: %s\nAddress: %s\nPhone Number: %d\nTax Identification Number: %d\nTest Type code: %s\n%n", laboratoryID, name, address, phoneNumber, tinNumber, testtypes);
            System.out.print("--------------------------\n");
            System.out.print(" 1 --> Confirm\n");
            System.out.print(" 2 --> Cancel\n");
            int confirm = ler.nextInt();
            if(confirm == 1){
                if(createRegistLaboratoryController.saveLaboratory()){
                    System.out.print("Laboratory created successfully.\n");
                }else{
                    System.out.print("Laboratory creation error.\n");
                }
            }
        }
    }
}
