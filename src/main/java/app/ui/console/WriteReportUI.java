package app.ui.console;

import app.controller.App;
import app.controller.WriteReportController;
import app.domain.model.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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

        if(lTestsDto.isEmpty()){
            throw new IllegalArgumentException("There are no tests to be reported.");
        }
        System.out.print("List of tests to be reported:\n");
        for (TestDTO testdto: lTestsDto){
            System.out.printf("%d - Code: %s%nLabOrder:%n%s%nParameters:%s%n%s%n--------------------------------%n", lTestsDto.indexOf(testdto)+1, testdto.getCode(),testdto.getLabOrder().getTestType(),testdto.getLabOrder().getParameters(), testdto.getSample() );
        }
        System.out.print("Select one test of the list: \n");
        testop = ler.nextInt();
        if (testop <= lTestsDto.size() && testop >= 1){
            testDto = lTestsDto.get(testop-1);
            exists = true;
        }
        if (exists){
            lTestParametersDto = controller.getResultParameters(testDto);
            for (TestParameterDto testParameter : lTestParametersDto){
                System.out.printf(" Test Parameter : %s \n Test Parameter Result : %s\n",testParameter.getParameterdto(),testParameter.getTprdto());
                System.out.println("---------");
            }
            System.out.print("Introduce the diagnosis\n");
            String diagnosis = ler.next();
            controller.addReport(diagnosis);

            if (controller.removeTestToBeReported())
                System.out.print("Report created with success.\n");
            else
                throw new IllegalArgumentException("Report not created.");
        }
        else{
            throw new IllegalArgumentException("The selected test does not exist.");
        }
        /*
        long time = createdAt.getTime();
        Timestamp ts = new Timestamp(time);
        System.out.println(ts); */
    }
}
