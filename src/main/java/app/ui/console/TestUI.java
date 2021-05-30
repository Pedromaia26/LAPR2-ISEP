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
        String code;

        List<ClientDTO> clientDto = createRegistTestController.getClientDto();
        for(ClientDTO clientDTO : clientDto){
            System.out.println(clientDTO);
        }

        System.out.print("Insert the Tax Identification Number(TIN) of the client related to the test:%n");
        long tinNumber = ler.nextLong();
        ler.nextLine();
        System.out.print("Insert its National Health Security code:%n");
        long nhsCode = ler.nextLong();
        List<TestTypeDTO> listTestTypeDto = createRegistTestController.getTestTypeDto();

        for(TestTypeDTO testTypeDTO : listTestTypeDto){
            System.out.println(testTypeDTO);
        }

        System.out.print("Type the Test Type Code:%n");

        String testType = ler.next();

        TestType tt = createRegistTestController.getTestTypeByCode(testType);

        List<ParameterDTO> listParameterDto = createRegistTestController.getParameterDto();

        for(ParameterDTO parameterDTO : listParameterDto){
            System.out.println(parameterDTO);
        }

        List<String> parameterCodes = new ArrayList<>();

        System.out.print("Type the Parameter Code:%n");

        int a;

        do {
            String parameterCode = ler.next();
            parameterCodes.add(parameterCode);
            System.out.print("Do you want to add another parameter to your Laboratory Order?:%n1 ---> Yes%n2 ---> No%n");
            a = ler.nextInt();
            if(a==1) System.out.print("Type the Parameter Code:%n");
        }while (a==1);

        List<Parameter> par = createRegistTestController.getParameterByCode(parameterCodes);

        LabOrder labOrder = null;
        labOrder = new LabOrder(tt,par);

        if (createRegistTestController.createTest(tinNumber, nhsCode, labOrder)){
            System.out.print("--------------------------%n");
            System.out.print("Please confirm the data:%n");
            System.out.printf("Tax Identification Number of the client: %d%nNational Health Security Code: %d%nLaboratory Order: %s%n", tinNumber, nhsCode, labOrder);
            System.out.print("--------------------------%n");
            System.out.print(" 1 --> Confirm%n");
            System.out.print(" 2 --> Cancel%n");
            int confirm = ler.nextInt();
            if(confirm == 1){
                if(createRegistTestController.saveTest()){
                    System.out.print("Test was created successfully.%n");
                }else{
                    System.out.print("Test creation error.%n");
                }
            }
        }
    }

}
