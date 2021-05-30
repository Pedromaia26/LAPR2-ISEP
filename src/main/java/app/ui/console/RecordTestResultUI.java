package app.ui.console;

import app.controller.App;
import app.controller.RecordSampleController;
import app.controller.RecordTestResultController;
import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordTestResultUI implements Runnable {
    public RecordTestResultUI() {

    }

    @Override
    public void run() {

        Scanner ler = new Scanner(System.in);
        RecordTestResultController rtrController = new RecordTestResultController();

        if (!App.getInstance().getCompany().getTestStore().getTests().isEmpty()) {
            String barcode;

            Test t;
            String op;
            String result = "";
            List<TestParameter> tParamList = new ArrayList<>();
            do {

                List<TestDTO> testList = rtrController.getTestListStore();
                for (TestDTO test : testList) {
                    System.out.println(test);
                }
                System.out.println("Select the test whose result you want to register from the following list, using one of the samples barcode:");
                System.out.println();
                barcode = ler.nextLine();

                t = rtrController.getTestByBarcode(barcode);

                for (TestParameter tp: t.getTestParameter()){
                    tParamList.add(tp);
                }

                System.out.println("---TEST PARAMETER LIST---");
                System.out.println();
                for (TestParameter tParam : tParamList) {
                    System.out.println(tParam);
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

                    System.out.println("Please insert the result value and metric of the parameter:");
                    System.out.println();
                    System.out.print("Result Value: ");
                    resultValue = ler.nextDouble();
                    System.out.print("Metric: ");
                    ler.nextLine();
                    metric = ler.nextLine();

                    System.out.println("Please confirm the data:");
                    System.out.println(String.format("---------------\nResult Value: %s\nMetric: %s\n---------------", resultValue, metric));
                    System.out.println(" 1 --> Confirm");
                    System.out.println(" 2 --> Cancel");
                    int confirm = ler.nextInt();

                    try {
                        result = rtrController.getTest().addTestResult(barcode, parameterCode, resultValue, metric);
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    if (confirm == 1){
                        if (rtrController.saveTestResult(result))
                            System.out.println("Parameter result was added successfully.");
                            tParamList.remove(t.getTestParameterFor(parameterCode));
                    }else{
                        System.out.println("Unfortunately, the parameter result could not be added.");
                    }

                    if (!tParamList.isEmpty()) {
                        System.out.println("For which parameter do you want to compare your result with the reference values next?");
                        for (TestParameter tParam : tParamList) {
                            System.out.println(tParam);
                        }
                        System.out.print("Enter the code: ");
                        ler.nextLine();
                    }


                } while (!tParamList.isEmpty());
                System.out.print("Do you want to analyse more samples?(Y/N)\n");
                ler.nextLine();
                op = ler.nextLine();

            }while (op.equalsIgnoreCase("Y"));
        }

        }

    }

