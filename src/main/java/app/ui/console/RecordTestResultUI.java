package app.ui.console;

import app.controller.App;
import app.controller.RecordTestResultController;
import app.domain.model.*;
import app.mappers.dto.TestDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordTestResultUI implements Runnable {
    public RecordTestResultUI() {

    }

    @Override
    public void run() {

        Scanner ler = new Scanner(System.in);
        RecordTestResultController rtrController = null;
        try {
            rtrController = new RecordTestResultController();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException | IOException | OutputException | ParseException | BarcodeException e) {
            e.printStackTrace();
        }

        try {
            if (!App.getInstance().getCompany().getTestStore().getTests().isEmpty()) {
                String barcode;

                Test t;
                String op;
                String result = "";
                List<TestParameter> tParamList = new ArrayList<>();
                //try {
                    do {

                        List<TestDTO> testList = rtrController.getTestListStore();
                        for (TestDTO test : testList) {
                            if (!test.getSample().isEmpty() && rtrController.checkLab(test)) {
                                System.out.printf("------------Test------------%nCode: %s%nTestType: %s%nParameters: %s%nBarcode:%s%n", test.getCode(), test.getLabOrder().getTestType(), test.getLabOrder().getParameters(), test.getSample());
                            }
                        }

                        System.out.print("Select the test whose result you want to register from the following list, using one of the samples barcode:\n");
                        System.out.println();
                        barcode = ler.nextLine();

                        //try {
                            t = rtrController.getTestByBarcode(barcode);


                            for (TestParameter tp : t.getTestParameter()) {
                                tParamList.add(tp);
                            }

                            System.out.print("---TEST PARAMETER LIST---\n");
                            System.out.println();
                            for (TestParameter tParam : tParamList) {
                                System.out.printf("Test Parameter: %s, %s \n", tParam.getParameter().getCode(), tParam.getParameter().getShortName());
                            }
                            System.out.println();
                            System.out.print("Choose a parameter, whose result you want to register, by selecting its code:");
                            System.out.println();

                            String parameterCode;

                            rtrController.getTest().getSample().remove(t.getSampleByBarcode(barcode));

                            do {
                                String metric;
                                double resultValue;
                                parameterCode = ler.nextLine();

                                System.out.println();

                                System.out.print("Please insert the result value and metric of the parameter:\n");
                                System.out.println();
                                System.out.print("Result Value: ");
                                resultValue = ler.nextDouble();
                                System.out.print("Metric: ");
                                ler.nextLine();
                                metric = ler.nextLine();

                                System.out.print("Please confirm the data:\n");
                                System.out.printf("---------------\nResult Value: %s\nMetric: %s%n---------------\n", resultValue, metric);
                                System.out.print(" 1 --> Confirm\n");
                                System.out.print(" 2 --> Cancel\n");
                                int confirm = ler.nextInt();

                                try {
                                    result = rtrController.getTest().addTestParameterResult(barcode, parameterCode, resultValue, metric);
                                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                                    e.printStackTrace();
                                }

                                if (confirm == 1) {
                                    if (rtrController.saveTestParameterResult(result))
                                        System.out.print("Parameter result was added successfully.\n");
                                    tParamList.remove(t.getTestParameterFor(parameterCode));
                                } else {
                                    System.out.print("Unfortunately, the parameter result could not be added.\n");
                                }
                                if (!tParamList.isEmpty()) {
                                    System.out.print("For which parameter do you want to compare your result with the reference values next?\n");
                                    for (TestParameter tParam : tParamList) {
                                        System.out.printf("Test Parameter: %s, %s \n", tParam.getParameter().getCode(), tParam.getParameter().getShortName());
                                    }
                                    System.out.print("Enter the code: ");
                                    ler.nextLine();
                                }


                            } while (!tParamList.isEmpty());
                            System.out.print("Do you want to analyse more samples?(Y/N)\n");
                            ler.nextLine();
                            op = ler.nextLine();
                        /*} catch (Exception e) {
                            System.out.println("Invalid data");
                            op = "N";
                        }*/
                    } while (op.equalsIgnoreCase("Y"));

                //}catch (Exception e){
                   // System.out.println("No tests to be validated");
               // }
            }
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | ParseException | BarcodeException | OutputException | IOException e) {
            e.printStackTrace();

        }
    }

}
