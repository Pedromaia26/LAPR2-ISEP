package app.ui.console;

import app.controller.CreateParameterCategoryController;
import app.controller.CreateParameterController;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
<<<<<<< HEAD
import java.text.ParseException;
=======
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
import java.util.Scanner;

public class CreateParameterCategoryUI implements Runnable {

    public CreateParameterCategoryUI(){
    }

    public void run(){
        Scanner ler = new Scanner(System.in);
        CreateParameterCategoryController createParameterCategoryController = null;
        try {
            createParameterCategoryController = new CreateParameterCategoryController();
<<<<<<< HEAD
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException | IOException | OutputException | ParseException | BarcodeException e) {
=======
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException | IOException e) {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
            e.printStackTrace();
        }

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
