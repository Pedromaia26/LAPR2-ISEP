package app.ui.console;

import app.controller.ValidateWorkDoneController;
import app.mappers.dto.TestDtoDate;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidateWorkDoneUI implements Runnable {
    public ValidateWorkDoneUI(){
    }


    public void run() {
        Scanner ler = new Scanner(System.in);
        ValidateWorkDoneController validateWorkDoneController = null;
        try {
            validateWorkDoneController = new ValidateWorkDoneController();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException | IOException | OutputException | ParseException | BarcodeException e) {
            e.printStackTrace();
        }

        try {
            List<TestDtoDate> testsDto = validateWorkDoneController.getTests();
            for (TestDtoDate test : testsDto) {
                System.out.println(test);
            }

            int optn;
            List<String> testsToValidate = new ArrayList<>();
            do {
                System.out.print("Insert the code of the test to validate, please.\n");
                testsToValidate.add(ler.next());
                if (testsDto.size()>1){
                    System.out.print("Do you want to select another test to validate?\n1-> Yes\n2-> No\n");
                    optn = ler.nextInt();
                }else {
                    optn = 2;
                }

            } while (optn == 1);

            System.out.println("Confirm the code of the tests to be validated, please.");
            for (String code : testsToValidate){
                System.out.println(code);
            }

            System.out.println("\n1-> Confirm\n2-> Cancel");
            int confirm = ler.nextInt();

            if(confirm==1) {
                try {
                    validateWorkDoneController.validateTests(testsToValidate);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.print("Tests validated successfully!\n");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.print("\nThere are no tests to be validated.\n");
        }
    }
}
