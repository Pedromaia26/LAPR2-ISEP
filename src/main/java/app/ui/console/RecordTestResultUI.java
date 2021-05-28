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
            System.out.println("Select the test whose result you want to register from the following list, using the sample barcode:");

            List<TestDTO> testList = rtrController.getTestListStore();
            for (TestDTO test : testList) {
                System.out.println(test);
            }
            System.out.println();
            barcode = ler.nextLine();

            Test t = rtrController.getTestByCode(barcode);

            System.out.println(t);

            List<TestParameter> tParamList = t.getTestParameter();
            System.out.println("---TEST PARAMETER LIST---");
            System.out.println();
            for (TestParameter tParam : tParamList) {
                System.out.println(tParam);
            }
            System.out.println();
            System.out.print("Choose a parameter, whose result you want to register, by selecting its code:");
            System.out.println();

            String parameterCode;
            String op;
            do {
                double resultValue;
                parameterCode = ler.nextLine();
                System.out.println(t.getTestParameterFor(parameterCode));
                System.out.println();

                System.out.println("Please insert the result value and metric of the parameter:");
                System.out.println();
                System.out.print("Result Value:");
                resultValue = ler.nextDouble();
                try {
                    t.addTestResult(parameterCode, resultValue);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                System.out.println("Do you want to compare another parameter value with the reference values? (Y/N)");

                ler.nextLine();
                op = ler.nextLine();


            } while (op.equalsIgnoreCase("Y"));

        }





        /*String category;

        List <Parameter> pList = new ArrayList<>();
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "klkll");

        List <ParameterCategory> pCatList = new ArrayList<>();

        pCatList.add(pc2);

        try {
            TestType tt = new TestType("Blood", "swab", "12345", pCatList);
           App.getInstance().getCompany().getTestTypeStore().addToList(tt);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }



        if(!App.getInstance().getCompany().getTestTypeStore().getTestTypes().isEmpty()) {

                System.out.println("Insert the code of the test, please.");
                String code = ler.nextLine();
                System.out.println("Insert the NHS code of the test, please.");
                String nhsCode = ler.nextLine();
                System.out.println("Insert code of the type of test, please");

                for(TestType tp : rtrController.getTestTypeStore().getTestTypes()){
                    System.out.println(tp.toString());
                }

                String codeOfTT = ler.nextLine();

                TestType tt = rtrController.getTestTypeStore().getTestTypeByCode(codeOfTT);
                System.out.println(tt);


                if(!rtrController.getParameterCategoryStore().getParameterCategories().isEmpty()) {
                    System.out.println("Choose the parameter category u want to add");
                    String pCategoryCode = ler.nextLine();
                    ParameterCategory pc = rtrController.getParameterCategoryStore().getParameterCategoryByCode(pCategoryCode);
                    Parameter p = new Parameter("aaaaa", "hemogl", "hemogl values", pc);
                    pList.add(p);
                }
                try {
                    LabOrder lO = new LabOrder(tt, pList);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        List<TestDTO> listTDto = new ArrayList<>();
        List<TestParameterDto> testParameterDto = new ArrayList<>();

        int testop;
        TestDTO testDto = null;
        boolean exists = false;

        listTDto = rtrController.getTestListStore();

        System.out.println("List of tests already registered in the system:");
        for (TestDTO testdto: listTDto){
            System.out.printf("%d - %s", listTDto.indexOf(testdto)+1, testdto);
            System.out.println("---------");
        }

    }*/

    }
}
