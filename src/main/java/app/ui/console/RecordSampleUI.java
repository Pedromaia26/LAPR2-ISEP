package app.ui.console;

import app.controller.App;
import app.controller.RecordSampleController;
import app.domain.model.*;
import app.domain.model.dto.SampleDTO;
import app.domain.model.dto.TestDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

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

        Test nteste=new Test("1234567890",1234123412L,labOrder);

        App.getInstance().getCompany().getTestStore().addToList(nteste);

        for(TestDTO loDTO : controller.getTestDto()){
            if (loDTO.getSample().isEmpty())
                System.out.println(loDTO);
        }
        String codeTest = ler.nextLine();

        System.out.println("Insert how many samples want to collect.");

        int number = ler.nextInt();


        int confirm;
        for (int i=1;i<=number;i++) {
            try {
                if (controller.createNewSample(new SampleDTO(codeTest))) {

                    System.out.println("--------------------------");
                    System.out.println("Please confirm the data:");
                    System.out.printf("TestCode: %s\nBarcode of sample %d: %s\n", codeTest, i,controller.getSamp().toString());
                    System.out.println("--------------------------");
                    System.out.println(" 1 --> Confirm");
                    System.out.println(" 2 --> Cancel");
                    confirm = ler.nextInt();
                    if (confirm == 1) {
                        if (controller.saveSample()) {
                            System.out.println("Sample recorded successfully.");
                            System.out.println("--------------------------");
                        } else {
                            System.out.println("Sample recording error.");
                            System.out.println("--------------------------");
                        }
                    }
                }
                else{
                    System.out.printf("Sample number:%d Creation error\n",i);
                }
            } catch (OutputException | BarcodeException e) {
                e.printStackTrace();
            }

        }

        for(TestDTO loDTO : controller.getTestDto()){
            System.out.println(loDTO);

        }

    }
}
