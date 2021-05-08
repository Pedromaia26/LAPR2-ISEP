package app.domain.model;

import app.controller.CreateParameterController;
import app.controller.RegistClientController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interface {

    public static void main(String[] args) throws IOException {
        int escolha;
        do {
            Scanner ler = new Scanner(System.in);

            //Chamar os metodos para ter os dados necessarios
            System.out.println("------------------------------------------------------------------");
            System.out.println("|                            MENU                                |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("| 1 | Register Client                                            |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("| 2 | Register Employee                                          |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("| 3 | Register Clinical analysis Laboratory                      |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("| 4 | Create a new type of test                                  |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("| 5 | Create a new parameter                                     |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("| 6 | Create a new parameter category                            |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("| 7 | Sair                                                       |");
            System.out.println("------------------------------------------------------------------");


            escolha = ler.nextInt();
            System.out.println();

            switch (escolha) {
                case 1:
                     ClientDTO teste = new ClientDTO(1234567891234567L,1234567891L,"12/12/2000","Male",1234567891L,"teste@gmail.com","teste",91345678912L);

                     RegistClientController cliente= new RegistClientController();
                     cliente.createNewClient(teste);

                    List<Client> clientList = new ArrayList<Client>();
                    cliente.validateClient();
                    cliente.saveClient();
                    clientList=cliente.getClientList();

                    for (Client cat : clientList) {
                        System.out.println(cat);
                    }

                    break;
                case 2:


                    break;
                case 3:

                case 4:

                    break;
                case 5:

                    Company c = new Company("Many Labs");
                    CreateParameterController createParameterController = new CreateParameterController(c);



                    int optn;
                    do {
                        System.out.println("Insert the code of the parameter, please.");
                        ler.nextLine();
                        String code = ler.nextLine();
                        System.out.println("Insert the short name of the parameter, please.");
                        String shortName = ler.nextLine();
                        System.out.println("Insert the description of the parameter, please.");
                        String description = ler.nextLine();
                        System.out.println("Insert code of the category that categorize the parameter");

                        for( ParameterCategoryDto cat : createParameterController.getParameterCategoryDto()){
                            System.out.println(cat);
                        }

                        String categoryCode = ler.nextLine();



                        if (createParameterController.createParameter(code, shortName, description, categoryCode)) {
                            System.out.println("Parameter created successfully.");
                        } else {
                            System.out.println("Parameter creation error.");
                        }

                        System.out.println("Do you want to create a new parameter?");
                        System.out.println(" 1 --> Yes");
                        System.out.println(" 2 --> No");
                        optn = ler.nextInt();
                    }while(optn == 1);


                    break;
                case 6:

                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha enexistente.");
                    break;
            }
        } while (escolha != 7);
    }

}


