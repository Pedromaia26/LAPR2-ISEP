package app.ui.console;

import app.controller.WriteReportController;
import app.domain.model.TestParameter;
import app.domain.model.dto.TestDTO;
import app.domain.model.dto.TestParameterDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteReportUI implements Runnable {
    public WriteReportUI()
    {

    }
    @Override
    public void run() {
        Scanner ler = new Scanner(System.in);
        WriteReportController controller = new WriteReportController();

        List<TestDTO> lTestsDto;
        List<TestParameterDto> lTestParametersDto;

        int testop;
        TestDTO testDto = null;
        boolean exists = false;

        lTestsDto = controller.getTests();

        System.out.println("List of tests to be reported:");
        for (TestDTO testdto: lTestsDto){
            System.out.printf("%d - %s", lTestsDto.indexOf(testdto)+1, testdto);
            System.out.println("---------");
        }
        System.out.println("Select one test of the list:");
        testop = ler.nextInt();
        if (testop <= lTestsDto.size() && testop >= 1){
            testDto = lTestsDto.get(testop-1);
            exists = true;
        }
        if (exists){
            lTestParametersDto = controller.getResultParameters(testDto);
            for (TestParameterDto testParameter : lTestParametersDto){
                System.out.println(testParameter);
                System.out.println("---------");
            }
            System.out.println("Introduce the diagnosis");
            String diagnosis = ler.next();
            controller.addReport(diagnosis, testDto);
        }
        /*System.out.print("Name: ");
        String name = ler.nextLine();
        System.out.print("Email: ");
        String email = ler.nextLine();
        System.out.print("Phone number: ");
        long phoneNumber = ler.nextLong();
        System.out.print("Citizen Card Number: ");
        long ccn = ler.nextLong();
        System.out.print("National Health Service number: ");
        long nhs = ler.nextLong();
        System.out.print("Tax Identification Number: ");
        long tif = ler.nextLong();
        System.out.print("Birth date: ");
        ler.nextLine();
        String birth = ler.nextLine();

        System.out.print("Sex(if you dont want to write it, leave it blank): ");
        String sex = ler.nextLine();


        if(controller.createNewClient(new ClientDTO(ccn,nhs,birth,sex,tif,email,name,phoneNumber))){
            System.out.println("--------------------------");
            System.out.println("Please confirm the data:");
            System.out.println(String.format("CCN: %d\nNHS: %d\nBirth date: %s\nSex: %s\nTIN: %d\nEmail: %s\nName: %s\nPhone Number: %s", ccn, nhs, birth,sex,tif,email,name,phoneNumber));
            System.out.println("--------------------------");
            System.out.println(" 1 --> Confirm");
            System.out.println(" 2 --> Cancel");
            int confirm = ler.nextInt();
            if(confirm == 1){
                try {
                    if(controller.saveClient()){
                        System.out.println("Client registered successfully.");
                    }else{
                        System.out.println("Client register error.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

    }
}
