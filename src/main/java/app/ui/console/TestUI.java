package app.ui.console;

import app.controller.RegistEmployeeController;
import app.controller.RegistLaboratoryController;
import app.controller.TestTypeController;
import app.domain.model.*;
import app.controller.RegistTestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestUI implements Runnable{

    public TestUI(){

    }
    @Override
    public void run() {
        Scanner ler = new Scanner(System.in);
        RegistTestController createRegistTestController = new RegistTestController();
        TestTypeController createTestTypeController = new TestTypeController();
        String code;
        System.out.println("Insert the Tax Identification Number of the client related to the test:");
        long tinNumber = ler.nextLong();
        ler.nextLine();
        System.out.println("Insert its National Health Security code:");
        long nhsCode = ler.nextLong();
        List<TestTypeDTO> listTestTypeDto = createRegistTestController.getTestTypeDto();

        for(TestTypeDTO testTypeDTO : listTestTypeDto){
            System.out.println(testTypeDTO);
        }

        System.out.println("Type the Test Type Code:");

        String testType = ler.next();

        TestType tt = createRegistTestController.getTestTypeByCode(testType);

        List<ParameterDTO> listParameterDto = createRegistTestController.getParameterDto();

        for(ParameterDTO parameterDTO : listParameterDto){
            System.out.println(parameterDTO);
        }

        List<String> parameterCodes = new ArrayList<>();

        System.out.println("Type the Parameter Code:");

        int a;

        do {
            String parameterCode = ler.next();
            parameterCodes.add(parameterCode);
            System.out.println("Do you want to add another parameter to your Laboratory Order?:\n1 ---> Yes\n2 ---> No");
            a = ler.nextInt();
            System.out.println("Type the Parameter Code:");
        }while (a==1);

        List<Parameter> par = createRegistTestController.getParameterByCode(parameterCodes);

        LabOrder labOrder = null;
        try {
            labOrder = new LabOrder(tt,par);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (createRegistTestController.createTest(tinNumber, nhsCode, labOrder)){
            System.out.println("--------------------------");
            System.out.println("Please confirm the data:");
            System.out.printf("Tax Identification Number of the client: %d\nNational Health Security Code: %d\nLaboratory Order: %s\n", tinNumber, nhsCode, labOrder);
            System.out.println("--------------------------");
            System.out.println(" 1 --> Confirm");
            System.out.println(" 2 --> Cancel");
            int confirm = ler.nextInt();
            if(confirm == 1){
                if(createRegistTestController.saveTest()){
                    System.out.println("Test was created successfully.");
                }else{
                    System.out.println("Test creation error.");
                }
            }
        }
    }

}
