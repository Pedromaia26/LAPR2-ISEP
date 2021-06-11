package app.controller;

import app.domain.model.*;
import auth.AuthFacade;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ImportCSVFileController{

    private ClientStore clientStore;

    private TestTypeStore testTypeStore;

    private Company company;

    private Client client;

    private AuthFacade authFacade;

    private TestType testType;

    private List<ParameterCategory> parameterCategory ;

    private List<Parameter> parameters;

    private  ParameterCategoryStore parameterCategoryStore;

    private ParameterStore parameterStore;

    private LaboratoryStore laboratoryStore;

    private TestStore testStore;

    private LabOrderStore labOrderStore;

    @FXML
    private Button test;

    @FXML
    private ProgressBar pb;

    @FXML
    private Label per;

    public ImportCSVFileController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.company=App.getInstance().getCompany();
        this.clientStore=App.getInstance().getCompany().getClientStore();
        this.authFacade= company.getAuthFacade();
        this.testTypeStore= App.getInstance().getCompany().getTestTypeStore();
        this.parameterCategoryStore= App.getInstance().getCompany().getParameterCategoryStore();
        this.parameterStore= App.getInstance().getCompany().getParameterStore();
        this.laboratoryStore= App.getInstance().getCompany().getLaboratoryStore();
        this.testStore= App.getInstance().getCompany().getTestStore();
        this.labOrderStore= App.getInstance().getCompany().getLabOrderStore();

    }

    @FXML
    public void test(ActionEvent actionEvent) {


        per.setText("Wait...");
        int c=0;
        int d=0;
        int cont=0;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        List<File> f = fileChooser.showOpenMultipleDialog(null);
        try {


        for (File file : f){
            System.out.println(file.getAbsolutePath());
            String line = "";
            String splitBy = ";";

            try
            {
            //parsing a CSV file into BufferedReader class constructor

                BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
                br.readLine();
                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    try {
                        cont++;
                        String[] tests = line.split(splitBy);    // use comma as separator
                        parameterCategory = new ArrayList<>();
                        parameters = new ArrayList<>();
                        //Nao utilizar code, Gerado automaticamente

                        DecimalFormat df = new DecimalFormat("0000000000000000");

                        double valor = Double.parseDouble(tests[13].replace("," , "."));
                        System.out.println(valor);

                        //System.out.println("Tests :[Code=" + tests[0] + ", NhsCode=" + tests[1] + ", LabID=" + tests[2] + ", CCN=" + tests[3] + ", NHS=" + tests[4] +", TIN=" + tests[5] +", BirthDay=" + tests[6] +", PN=" + tests[7] +", Name=" + tests[8] +", Email=" + tests[9] +", Address=" + tests[10] +", TestType=" + tests[11] + ", Category=" + tests[12] + ", HB000=" + tests[13] +", WBC00=" + tests[14] + ", PLT00=" + tests[15] + ", RBC00=" + tests[16] +", Category=" + tests[17] + ", HDL00=" + tests[18] +", Category=" + tests[19] + ", IgGAN=" + tests[20] +", TestRegDat=" + tests[21] + ", TestChemDate=" + tests[22] + ", TestDocDate=" + tests[23] +", TestValDate=" + tests[24] +"]");

                        this.testType = testTypeStore.getTestTypeByDescription(tests[11]);



                        if (testType.getDescription().equalsIgnoreCase("covid")) {
                            this.parameterCategory.add(parameterCategoryStore.getParameterCategoryByDescription(tests[19]));
                            this.parameters.add(parameterStore.getParameterByCode("IgGAN"));

                        } else {
                            this.parameterCategory.add(parameterCategoryStore.getParameterCategoryByDescription(tests[12]));

                            this.parameters.add(parameterStore.getParameterByCode("HB000"));
                            this.parameters.add(parameterStore.getParameterByCode("WBC00"));
                            this.parameters.add(parameterStore.getParameterByCode("PLT00"));
                            this.parameters.add(parameterStore.getParameterByCode("RBC00"));

                            this.parameterCategory.add(parameterCategoryStore.getParameterCategoryByDescription(tests[17]));

                            this.parameters.add(parameterStore.getParameterByCode("HDL00"));

                        }



                        //Fazer com ligacao a store

                        LabOrder labOrder = labOrderStore.createLabOrder(this.testType, this.parameters);


                        Laboratory laboratory = laboratoryStore.getLabByLabId(tests[2]);


                        if (clientStore.getClientByCcn(df.format(Long.parseLong(tests[3])))) {
                            this.client = clientStore.getClientByEmail(tests[9]);
                        } else {
                            ClientDTO clientDTO = new ClientDTO((df.format(Long.parseLong(tests[3]))), Long.parseLong(tests[4]), tests[6], "Undifined", Long.parseLong(tests[5]), tests[9], tests[8], Long.parseLong(tests[7]));
                            this.client = clientStore.createNewClient(clientDTO);
                            clientStore.addNewClient(client);
                        }



                        Test newtest = testStore.createTest(this.company, this.client, tests[1], labOrder, laboratory, tests[21]);



                        Sample sample = newtest.RecordNewSample(this.company);

                        newtest.saveSample(sample, this.company, tests[21]);




                        //Alterar para analisar todas as samples de uma vez para cada parametro(Info do stor)

                        if (testType.getDescription().equalsIgnoreCase("covid")) {
                            String r1 = newtest.addTestParameterResult(sample.getBarcode().getBarcodeNumber(), parameters.get(0).getCode(), Double.parseDouble(tests[20].replace("," , ".")), "Index (S/C) Value", tests[22]);

                            newtest.saveTestParameterResult(r1);

                        } else {




                            String r1 = newtest.addTestParameterResult(sample.getBarcode().getBarcodeNumber(), parameters.get(0).getCode(), Double.parseDouble(tests[13].replace("," , ".")), "g/L", tests[22]);
                            String r2 = newtest.addTestParameterResult(sample.getBarcode().getBarcodeNumber(), parameters.get(1).getCode(), Double.parseDouble(tests[14].replace("," , ".")), "10e9L", tests[22]);
                            String r3 = newtest.addTestParameterResult(sample.getBarcode().getBarcodeNumber(), parameters.get(2).getCode(), Double.parseDouble(tests[15].replace("," , ".")), "10e9L", tests[22]);
                            String r4 = newtest.addTestParameterResult(sample.getBarcode().getBarcodeNumber(), parameters.get(3).getCode(), Double.parseDouble(tests[16].replace("," , ".")), "10e12L", tests[22]);
                            newtest.saveTestParameterResult(r1);
                            newtest.saveTestParameterResult(r2);
                            newtest.saveTestParameterResult(r3);
                            newtest.saveTestParameterResult(r4);


                        }

                        if (!tests[23].equals("NA")) {
                            newtest.addReport("Default", tests[23]);
                        }


                        if (!tests[24].equals("NA")) {
                            newtest.validateTest(tests[24]);
                        }

                        testStore.saveTest(newtest);

                        c++;
                    }catch (Exception e){
                        System.out.println("Couldnt create");
                        System.out.println(e);
                    }
                }
                pb.setProgress((double)c/cont);
                per.setText(Math.floor((double)c/cont*100) + "% of tests created" );
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        System.out.println(c);

        }catch (Exception e){
            per.setText("No file selected");
        }
    }

}
