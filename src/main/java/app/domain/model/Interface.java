package app.domain.model;

import app.controller.CreateParameterCategoryController;
import app.controller.CreateParameterController;
import app.controller.RegistClientController;
import app.controller.RegistEmployeeController;
import auth.domain.model.Email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interface {

    public static void main(String[] args) throws IOException {
        int escolha;

        Company c = new Company("Many Labs");
        CreateParameterCategoryController createParameterCategoryController = new CreateParameterCategoryController(c);
        CreateParameterController createParameterController = new CreateParameterController(c);
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
                    ClientDTO teste1 = new ClientDTO(1234567891234567L,1234567891L,"12/12/2000","Male",1234567891L,"teste@gmail.com","teste",91345678912L);

                     RegistClientController cliente= new RegistClientController();
                    cliente.createNewClient(teste);
                    List<Client> clientList;
                    System.out.println("1"+cliente.saveClient());
                    cliente.createNewClient(teste1);
                    System.out.println("2"+cliente.saveClient());
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

                    //Company c = new Company("Many Labs");




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
                        int confirm;

                        if(createParameterController.createParameter(code, shortName, description, categoryCode)); {
                            System.out.println("--------------------------");
                            System.out.println("Please confirm the data:");
                            System.out.println(String.format("Code: %s\nShort Name: %s\nDescription: %s\nParameter Category Code: %S", code, shortName, description, categoryCode));
                            System.out.println("--------------------------");
                            System.out.println(" 1 --> Confirm");
                            System.out.println(" 2 --> Cancel");
                            confirm = ler.nextInt();
                            if(confirm == 1){
                                if(createParameterController.saveParameter()){
                                    System.out.println("Parameter category created successfully.");
                                }else{
                                    System.out.println("Parameter category creation error.");
                                }
                            }
                        }


                        System.out.println("Do you want to create a new parameter?");
                        System.out.println(" 1 --> Yes");
                        System.out.println(" 2 --> No");
                        optn = ler.nextInt();
                    }while(optn == 1);


                    break;
                case 6:



                    System.out.println("Insert the code of the parameter category, please.");
                    ler.nextLine();
                    String code = ler.nextLine();
                    System.out.println("Insert the name of the parameter category, please.");
                    String name = ler.nextLine();

                    int confirm;

                    if(createParameterCategoryController.createParameterCategory(name, code)) {
                        System.out.println("--------------------------");
                        System.out.println("Please confirm the data:");
                        System.out.println(String.format("Code: %s\nName: %s", code, name));
                        System.out.println("--------------------------");
                        System.out.println(" 1 --> Confirm");
                        System.out.println(" 2 --> Cancel");
                        confirm = ler.nextInt();
                        if(confirm == 1){
                            if(createParameterCategoryController.saveParameterCategory()){
                                System.out.println("Parameter category created successfully.");
                            }else{
                                System.out.println("Parameter category creation error.");
                            }
                        }
                    }




                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (escolha != 7);
    }

}


