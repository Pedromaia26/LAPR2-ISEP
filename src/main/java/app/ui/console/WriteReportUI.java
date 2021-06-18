package app.ui.console;

import app.controller.WriteReportController;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestParameterDto;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class WriteReportUI implements Runnable {
    public WriteReportUI() {

    }

    @Override
    public void run() {
        Scanner ler = new Scanner(System.in);
        WriteReportController controller = null;
        try {
            controller = new WriteReportController();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException | IOException | OutputException | ParseException | BarcodeException e) {
            e.printStackTrace();
        }

        List<TestDTO> lTestsDto = null;
        List<TestParameterDto> lTestParametersDto;

        int testop;
        String op = "Y";
        TestDTO testDto = null;
        boolean exists = false;

        while (op.equalsIgnoreCase("y") || op.equalsIgnoreCase("yes")) {
            lTestsDto = controller.getTests();

            if (lTestsDto.isEmpty()) {
                throw new IllegalArgumentException("There are no tests to be reported.");
            }
            System.out.print("List of tests to be reported:\n");
            for (TestDTO testdto : lTestsDto) {
                System.out.printf("%d - Code: %s%nLabOrder:%n%s%nParameters:%s%n%s%n--------------------------------%n", lTestsDto.indexOf(testdto) + 1, testdto.getCode(), testdto.getLabOrder().getTestType(), testdto.getLabOrder().getParameters(), testdto.getSample());
            }
            System.out.print("Select one test of the list: \n");
            try {
                testop = ler.nextInt();


                testDto = lTestsDto.get(testop - 1);
                lTestParametersDto = controller.getResultParameters(testDto);
                for (TestParameterDto testParameter : lTestParametersDto) {
                    System.out.printf(" Test Parameter : %s \n Test Parameter Result : %s\n", testParameter.getParameterdto(), testParameter.getTprdto());
                    System.out.println("---------");
                }
                System.out.print("Introduce the diagnosis\n");
                String diagnosis = ler.next();
                controller.addReport(diagnosis);

                if (controller.removeTestToBeReported())
                    System.out.print("Report created with success.\n");
                else
                    System.out.println("Report not created.");

            } catch (Exception e) {
                System.out.print("The selected test does not exist.\n");
            }
            System.out.println("Do you want to write the report to another test? (Y/N)");
            op = ler.nextLine();
        }
        /*
        long time = createdAt.getTime();
        Timestamp ts = new Timestamp(time);
        System.out.println(ts); */
    }
}
