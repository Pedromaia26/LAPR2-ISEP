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

        System.out.println("Insert the code of the parameter category, please.");
        String code = ler.nextLine();
        System.out.println("Insert the name of the parameter category, please.");
        String name = ler.nextLine();

        int confirm;

        if(createParameterCategoryController.createParameterCategory(name, code)) {
            System.out.println("--------------------------");
            System.out.println("Please confirm the data:");
            System.out.println(String.format("Code: %s\nName: %s", code, name));
            System.out.println("--------------------------");
            System.out.println(" 1 --> Confirm");
            System.out.println(" 2 --> Cancel");
            confirm = ler.nextInt();
            if(confirm == 1){
                if(createParameterCategoryController.saveParameterCategory()){
                    System.out.println("Parameter category created successfully.");
                }else{
                    System.out.println("Parameter category creation error.");
                }
            }
        }

    }
}
