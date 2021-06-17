package app.ui.console;

import app.controller.TestTypeController;
import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDto;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTypeUI implements Runnable{

         public TestTypeUI(){

        }
    @Override
    public void run() {
        Scanner ler = new Scanner(System.in);
        TestTypeController createTestTypeController = null;
        try {
            createTestTypeController = new TestTypeController();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException | IOException | OutputException | ParseException | BarcodeException e) {
            e.printStackTrace();
        }

        System.out.print("Insert the description of the new type of test you want to create:\n");
        String description = ler.nextLine();
        String api = "";
        if (description.equalsIgnoreCase("COVID-19")){
            api = "Domain.ExternalModuleAdapter1";
        }else if (description.equalsIgnoreCase("BLOOD")){
            System.out.print("1 - Domain.ExternalModuleAdapter2\n");
            System.out.print("2 - Domain.ExternalModuleAdapter3\n");
            int num = ler.nextInt();
            if (num == 1){
                api = "Domain.ExternalModuleAdapter2";
            }else
                api = "Domain.ExternalModuleAdapter3";
            ler.nextLine();
        }
        System.out.print("Insert its collecting method:\n");
        String collectingMethod = ler.nextLine();
        System.out.print("Insert its code:\n");
        String code = ler.next();
        System.out.print("Insert the code of the category that you want to add:\n");

        for(ParameterCategoryDto cat : createTestTypeController.getParameterCategoryDto()){
            System.out.println(cat);
        }

        List<ParameterCategory> pc = new ArrayList<>();

        List<String> categories = new ArrayList<>();

        int a;

        do {
            String categoryCode = ler.next();
            categories.add(categoryCode);
            System.out.print("Do you want to add another parameter category to your type of test?:\n1 ---> Yes\n2 ---> No\n");
            a = ler.nextInt();
        }while (a==1);


        //createTestTypeController.getParameterCategoryStore().getParameterCategoryByCode(categories);

        try {

            try {
                if (createTestTypeController.createTestType(description, collectingMethod, code, categories, api)){
                    System.out.print("--------------------------\n");
                    System.out.print("Please confirm the data:\n");
                    System.out.printf("Description: %s%nCollecting method: %s%nCode: %s%nCategories Code: %s%n", description, collectingMethod, code,categories);
                    System.out.print("--------------------------\n");
                    System.out.print(" 1 --> Confirm\n");
                    System.out.print(" 2 --> Cancel\n");
                    int confirm = ler.nextInt();
                    if(confirm == 1){
                        if(createTestTypeController.saveTestType()){
                            System.out.print("Test type created successfully.\n");
                        }else{
                            System.out.print("Test type creation error.\n");
                        }
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            System.out.println("Invalid data");
        }

    }
}
