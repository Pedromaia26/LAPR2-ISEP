package app.ui.console;

import app.controller.App;
import app.controller.RecordSampleController;
import app.controller.RegistClientController;
import app.domain.model.*;
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
        RecordSampleController controller= null;
        try {
            controller = new RecordSampleController();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
        try {

            for (TestDTO loDTO : controller.getTestDto()) {

                if (loDTO.getSample().isEmpty() && controller.checkLab(loDTO)) {
                    System.out.printf("------------Test------------%nCode: %s%nTestType: %s%nParameters: %s%n", loDTO.getCode(), loDTO.getLabOrder().getTestType(), loDTO.getLabOrder().getParameters());
                }
            }

        String codeTest = ler.nextLine();

        System.out.print("Insert how many samples want to collect.\n");
        try {
        int number = ler.nextInt();


        int confirm;

            for (int i = 1; i <= number; i++) {
                try {
                    if (controller.createNewSample(new SampleDTO(codeTest))) {

                        System.out.print("--------------------------\n");
                        System.out.print("Please confirm the data:\n");
                        System.out.printf("TestCode: %s%nBarcode of sample %d: %s%n", codeTest, i, controller.getSamp().toString());
                        System.out.print("--------------------------\n");
                        System.out.print(" 1 --> Confirm\n");
                        System.out.print(" 2 --> Cancel\n");
                        confirm = ler.nextInt();
                        if (confirm == 1) {
                            if (controller.saveSample()) {
                                System.out.print("Sample recorded successfully.\n");
                                System.out.print("--------------------------\n");
                            } else {
                                System.out.print("Sample recording error.\n");
                                System.out.print("--------------------------\n");
                            }
                        }
                    }
                } catch (OutputException | BarcodeException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println();
            }
        }catch (Exception e){
            System.out.println("Invalid test code");
        }
    }catch (Exception e){
        System.out.println("No tests to be analised");
    }

    }
}
