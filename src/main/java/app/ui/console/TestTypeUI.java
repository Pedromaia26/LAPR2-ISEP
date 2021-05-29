package app.ui.console;

import app.controller.RegistEmployeeController;
import app.controller.TestTypeController;
import app.domain.model.ParameterCategory;
import app.domain.model.ParameterCategoryDto;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTypeUI implements Runnable{

         public TestTypeUI(){

        }
    @Override
    public void run() {
        Scanner ler = new Scanner(System.in);
        TestTypeController createTestTypeController = new TestTypeController();

        System.out.println("Insert the description of the new type of test you want to create:");
        String description = ler.nextLine();
        String api = "";
        if (description.equalsIgnoreCase("COVID-19")){
            api = "Domain.ExternalModuleAdapter1";
        }else if (description.equalsIgnoreCase("BLOOD")){
            System.out.println("1 - Domain.ExternalModuleAdapter2");
            System.out.println("2 - Domain.ExternalModuleAdapter3");
            int num = ler.nextInt();
            if (num == 1){
                api = "Domain.ExternalModuleAdapter2";
            }else
                api = "Domain.ExternalModuleAdapter3";
            ler.nextLine();
        }
        System.out.println("Insert its collecting method:");
        String collectingMethod = ler.nextLine();
        System.out.println("Insert its code:");
        String code = ler.next();
        System.out.println("Insert the code of the category that you want to add:");

        for(ParameterCategoryDto cat : createTestTypeController.getParameterCategoryDto()){
            System.out.println(cat);
        }

        List<ParameterCategory> pc = new ArrayList<>();

        List<String> categories = new ArrayList<>();

        int a;

        do {
            String categoryCode = ler.next();
            categories.add(categoryCode);
            System.out.println("Do you want to add another parameter category to your type of test?:\n1 ---> Yes\n2 ---> No");
            a = ler.nextInt();
        }while (a==1);


        //createTestTypeController.getParameterCategoryStore().getParameterCategoryByCode(categories);


        try {
            if (createTestTypeController.createTestType(description, collectingMethod, code, categories, api)){
                System.out.println("--------------------------");
                System.out.println("Please confirm the data:");
                System.out.println(String.format("Description: %s\nCollecting method: %s\nCode: %s\nCategories Code: %s", description, collectingMethod, code,categories));
                System.out.println("--------------------------");
                System.out.println(" 1 --> Confirm");
                System.out.println(" 2 --> Cancel");
                int confirm = ler.nextInt();
                if(confirm == 1){
                    if(createTestTypeController.saveTestType()){
                        System.out.println("Test type created successfully.");
                    }else{
                        System.out.println("Test type creation error.");
                    }
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
