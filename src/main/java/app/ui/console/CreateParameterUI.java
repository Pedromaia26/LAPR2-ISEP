package app.ui.console;

import app.controller.CreateParameterController;
import app.mappers.dto.ParameterCategoryDto;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class CreateParameterUI implements Runnable{

    public CreateParameterUI(){
    }

    public void run(){
        Scanner ler = new Scanner(System.in);
        CreateParameterController createParameterController = null;
        try {
            createParameterController = new CreateParameterController();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException | IOException | OutputException | ParseException | BarcodeException e) {
            e.printStackTrace();
        }

        int optn;
        do {
            if(!createParameterController.getParameterCategoryDto().isEmpty()) {

            System.out.print("Insert the code of the parameter, please.\n");
            String code = ler.nextLine();
            System.out.print("Insert the short name of the parameter, please.\n");
            String shortName = ler.nextLine();
            System.out.print("Insert the description of the parameter, please.\n");
            String description = ler.nextLine();


            System.out.print("Insert code of the category that categorize the parameter\n");


            for(ParameterCategoryDto cat : createParameterController.getParameterCategoryDto()){
                System.out.println(cat);
            }


                String categoryCode = ler.nextLine();
                int confirm;

                if (createParameterController.createParameter(code, shortName, description, categoryCode)) {
                    System.out.print("--------------------------\n");
                    System.out.print("Please confirm the data:\n");
                    System.out.printf("Code: %s%nShort Name: %s%nDescription: %s%nParameter Category Code: %S%n", code, shortName, description, categoryCode);
                    System.out.print("--------------------------\n");
                    System.out.print(" 1 --> Confirm\n");
                    System.out.print(" 2 --> Cancel\n");
                    confirm = ler.nextInt();
                    if (confirm == 1) {
                        if (createParameterController.saveParameter()) {
                            System.out.print("Parameter created successfully.\n");
                        } else {
                            System.out.print("Parameter creation error.\n");
                        }
                    }
                }


                System.out.print("Do you want to create a new parameter?\n");
                System.out.print(" 1 --> Yes\n");
                System.out.print(" 2 --> No\n");
                optn = ler.nextInt();
                ler.nextLine();
            }else{
                optn = 0;
            }

        }while(optn == 1);
    }
}
