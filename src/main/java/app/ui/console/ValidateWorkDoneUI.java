package app.ui.console;

import app.controller.ValidateWorkDoneController;
import app.domain.model.TestDtoDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidateWorkDoneUI implements Runnable {
    public ValidateWorkDoneUI(){
    }


    public void run() {
        Scanner ler = new Scanner(System.in);
        ValidateWorkDoneController validateWorkDoneController = new ValidateWorkDoneController();

        try {
            for (TestDtoDate test : validateWorkDoneController.getTests()) {
                System.out.println(test);
            }

            int optn;
            List<String> testsToValidate = new ArrayList<>();
            do {
                System.out.print("Insert the code of the test to validate, please.\n");
                testsToValidate.add(ler.next());
                System.out.print("Do you want to select another test to validate?\n1-> Yes\n2-> No\n");
                optn = ler.nextInt();
            } while (optn == 1);

            try {
                validateWorkDoneController.validateTests(testsToValidate);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.print("Tests validated successfully!\n");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.print("\nThere are no tests to be validated.\n");
        }
    }
}
