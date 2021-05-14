package app.ui.console;

import app.controller.App;
import app.controller.RecordSampleController;
import app.controller.RegistClientController;
import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordSampleUI implements Runnable {
    public RecordSampleUI() {
    }

    @Override
    public void run() {
        Scanner ler = new Scanner(System.in);
        RecordSampleController controller= new RecordSampleController();

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pc);
        TestType testesss = new TestType("asd","asd","12345",listPC);

        App.getInstance().getCompany().getTestTypeStore().addToList(testesss);
         List<Parameter> parameters = new ArrayList<>();

        LabOrder labOrder= new LabOrder(testesss,parameters);

        App.getInstance().getCompany().getLabOrderStore().addToList(labOrder);

        for(LabOrderDTO loDTO : controller.getLabOrderDto()){
            System.out.println(loDTO);
        }

        String testTypeLO = ler.nextLine();

        System.out.println("Insert the date of collection of the sample.");
        String dataColl = ler.nextLine();
        System.out.println("Insert the time of collection of the sample.");
        String timeColl = ler.nextLine();
        int confirm;

        if(controller.createNewSample(new SampleDTO(dataColl,timeColl,testTypeLO))){

            System.out.println("--------------------------");
            System.out.println("Please confirm the data:");
            System.out.printf("Data of Collecting the sample: %s\nTime of Collecting the sample: %s\nLabOrderCode: %s\n%n", dataColl, timeColl, testTypeLO);
            System.out.println("--------------------------");
            System.out.println(" 1 --> Confirm");
            System.out.println(" 2 --> Cancel");
            confirm = ler.nextInt();
            if(confirm == 1){
                if(controller.saveSample()){
                    System.out.println("Sample recorded successfully.");
                }else{
                    System.out.println("Sample recording error.");
                }
            }

        }


    }
}
