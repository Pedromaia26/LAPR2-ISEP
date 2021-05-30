package app.ui.console;

import app.controller.CreateParameterCategoryController;
import app.controller.CreateParameterController;

import java.util.Scanner;

public class CreateParameterCategoryUI implements Runnable {

    public CreateParameterCategoryUI(){
    }

    public void run(){
        Scanner ler = new Scanner(System.in);
        CreateParameterCategoryController createParameterCategoryController = new CreateParameterCategoryController();

        System.out.print("Insert the code of the parameter category, please.\n");
        String code = ler.nextLine();
        System.out.print("Insert the name of the parameter category, please.\n");
        String name = ler.nextLine();

        int confirm;

        if(createParameterCategoryController.createParameterCategory(name, code)) {
            System.out.print("--------------------------\n");
            System.out.print("Please confirm the data:\n");
            System.out.printf("Code: %s%nName: %s%n", code, name);
            System.out.print("--------------------------\n");
            System.out.print(" 1 --> Confirm\n");
            System.out.print(" 2 --> Cancel\n");
            confirm = ler.nextInt();
            if(confirm == 1){
                if(createParameterCategoryController.saveParameterCategory()){
                    System.out.print("Parameter category created successfully.\n");
                }else{
                    System.out.print("Parameter category creation error.\n");
                }
            }
        }

    }
}
