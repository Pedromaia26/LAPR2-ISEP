package app.controller;

import app.domain.model.*;
import app.mappers.dto.ClientDTO;
import auth.AuthFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            parameters = new ArrayList<>();

            try
            {
            //parsing a CSV file into BufferedReader class constructor

                BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
                line=br.readLine();

                String[] header = line.split(splitBy);

                List<String> parameterstest=new ArrayList<>();
                List<Integer> parametersIndextest=new ArrayList<>();
                List<Integer> parameterCategorytest=new ArrayList<>();
                List<String> invalidParameters= new ArrayList<>();




                for (int i=1; i< header.length;i++){

                    if (header[i-1].equalsIgnoreCase("Category")){
                        parameterCategorytest.add(i-1);
                        while (!header[i].equalsIgnoreCase("Category") && !header[i].equalsIgnoreCase("Test_Reg_DateHour")){
                            parameterstest.add(header[i]);
                            parametersIndextest.add(i);
                            i++;

                        }

                    }

                }



                int j=0;
                while (j<parameterstest.size()){
                    try {
                        this.parameters.add(parameterStore.getParameterByCode(parameterstest.get(j)));


                    }catch (Exception e){
                        invalidParameters.add(parameterstest.get(j));

                    }
                    j++;
                }




                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    try {
                        cont++;
                        System.out.printf("Trying to create test number: %d\n", cont);
                        String[] tests = line.split(splitBy);    // use comma as separator
                        parameterCategory = new ArrayList<>();

                        //Nao utilizar code, Gerado automaticamente

                        DecimalFormat df = new DecimalFormat("0000000000000000");


                        //System.out.println("Tests :[Code=" + tests[0] + ", NhsCode=" + tests[1] + ", LabID=" + tests[2] + ", CCN=" + tests[3] + ", NHS=" + tests[4] +", TIN=" + tests[5] +", BirthDay=" + tests[6] +", PN=" + tests[7] +", Name=" + tests[8] +", Email=" + tests[9] +", Address=" + tests[10] +", TestType=" + tests[11] + ", Category=" + tests[12] + ", HB000=" + tests[13] +", WBC00=" + tests[14] + ", PLT00=" + tests[15] + ", RBC00=" + tests[16] +", Category=" + tests[17] + ", HDL00=" + tests[18] +", Category=" + tests[19] + ", IgGAN=" + tests[20] +", TestRegDat=" + tests[21] + ", TestChemDate=" + tests[22] + ", TestDocDate=" + tests[23] +", TestValDate=" + tests[24] +"]");

                        this.testType = testTypeStore.getTestTypeByDescription(tests[11]);
                        System.out.println("a");

                        j=0;
                        while (j<parameterCategorytest.size()){
                            try {


                                if (!tests[parameterCategorytest.get(j)].equalsIgnoreCase("NA")) {
                                    this.parameterCategory.add(parameterCategoryStore.getParameterCategoryByDescription(tests[parameterCategorytest.get(j)]));
                                }

                            }catch (Exception e){
                                System.out.println("Couldn't add this Parameter Category");
                            }
                            j++;
                        }


                        //Fazer com ligacao a store

                        LabOrder labOrder = labOrderStore.createLabOrder(this.testType, this.parameters);


                        Laboratory laboratory = laboratoryStore.getLabByLabId(tests[2]);


                        if (clientStore.getClientByCcn(df.format(Long.parseLong(tests[3])))) {
                            this.client = clientStore.getClientByEmail(tests[9]);
                        } else {
                            ClientDTO clientDTO = new ClientDTO((df.format(Long.parseLong(tests[3]))), Long.parseLong(tests[4]), tests[6], "Undifined", Long.parseLong(tests[5]), tests[9], tests[8], Long.parseLong(tests[7]), tests[10]);

                            this.client = clientStore.createNewClient(clientDTO);
                            if(clientStore.addNewClient(client)) {
                                clientStore.addUser(company);
                            }
                            else {
                                throw new IllegalArgumentException("Couldn't create this client");
                            }
                        }




                        Test newtest = testStore.createTest(this.company, this.client, tests[1], labOrder, laboratory, tests[parametersIndextest.get(parametersIndextest.size()-1)+1]);



                        Sample sample = newtest.RecordNewSample(this.company);

                        newtest.saveSample(sample, this.company, tests[parametersIndextest.get(parametersIndextest.size()-1)+1]);



                        j=0;

                        while (j<parameterstest.size()){
                            try {
                                if (!tests[parametersIndextest.get(j)].equalsIgnoreCase("NA")) {
                                    if (!invalidParameters.contains(parameterstest.get(j))) {
                                        String r1 = newtest.addTestParameterResult(sample.getBarcode().getBarcodeNumber(), parameters.get(j).getCode(), Double.parseDouble(tests[parametersIndextest.get(j)].replace(",", ".")), newtest.getExternalModule().getReferenceValue(newtest.getTestParameterFor(parameters.get(j).getCode()).getParameter()).getMetric(), tests[parametersIndextest.get(parametersIndextest.size() - 1) + 2]);
                                        newtest.saveTestParameterResult(r1);
                                    }
                                }


                            }catch (Exception e){
                                System.out.println("Couldn't analise this parameter");
                            }
                            j++;
                        }

                        if (!tests[parametersIndextest.get(parametersIndextest.size()-1)+3].equals("NA")) {
                            newtest.addReport("Default", tests[parametersIndextest.get(parametersIndextest.size()-1)+3]);
                        }




                        if (!tests[parametersIndextest.get(parametersIndextest.size()-1)+4].equals("NA")) {
                            newtest.validateTest(tests[parametersIndextest.get(parametersIndextest.size()-1)+4]);
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
            System.out.println(e);
            per.setText("No file selected");
        }
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
