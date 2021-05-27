package app.ui.console;

import app.controller.CreateParameterController;
import app.domain.model.ParameterCategoryDto;

import java.util.Scanner;

public class CreateParameterUI implements Runnable{

    public CreateParameterUI(){
    }

    public void run(){
        Scanner ler = new Scanner(System.in);
        CreateParameterController createParameterController = new CreateParameterController();

        int optn;
        do {
            if(!createParameterController.getParameterCategoryDto().isEmpty()) {

            System.out.println("Insert the code of the parameter, please.");
            String code = ler.nextLine();
            System.out.println("Insert the short name of the parameter, please.");
            String shortName = ler.nextLine();
            System.out.println("Insert the description of the parameter, please.");
            String description = ler.nextLine();


            System.out.println("Insert code of the category that categorize the parameter");


            for(ParameterCategoryDto cat : createParameterController.getParameterCategoryDto()){
                System.out.println(cat);
            }


                String categoryCode = ler.nextLine();
                int confirm;

                if (createParameterController.createParameter(code, shortName, description, categoryCode)) {
                    System.out.println("--------------------------");
                    System.out.println("Please confirm the data:");
                    System.out.println(String.format("Code: %s\nShort Name: %s\nDescription: %s\nParameter Category Code: %S", code, shortName, description, categoryCode));
                    System.out.println("--------------------------");
                    System.out.println(" 1 --> Confirm");
                    System.out.println(" 2 --> Cancel");
                    confirm = ler.nextInt();
                    if (confirm == 1) {
                        if (createParameterController.saveParameter()) {
                            System.out.println("Parameter created successfully.");
                        } else {
                            System.out.println("Parameter creation error.");
                        }
                    }
                }


                System.out.println("Do you want to create a new parameter?");
                System.out.println(" 1 --> Yes");
                System.out.println(" 2 --> No");
                optn = ler.nextInt();
                ler.nextLine();
            }else{
                optn = 0;
            }

        }while(optn == 1);
    }
}
