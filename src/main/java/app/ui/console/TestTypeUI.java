package app.ui.console;

import app.controller.RegistEmployeeController;
import app.controller.TestTypeController;
import app.domain.model.ParameterCategoryDto;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TestTypeUI implements Runnable{

         public TestTypeUI(){

        }
    @Override
    public void run() {
        Scanner ler = new Scanner(System.in);
        TestTypeController tt = new TestTypeController();

        System.out.println("Insert the description of the new test of test you want to create:");
        ler.next();
        System.out.println("Insert its collecting method:");
        ler.next();
        System.out.println("Insert its code:");
        ler.next();
        System.out.println("Insert code of the category that you want to add:");



    }
}
