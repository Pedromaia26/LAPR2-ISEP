package app.domain.model;

import java.util.Scanner;

public class Interface {

    public static void main(String[] args) {
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

                    break;
                case 2:


                    break;
                case 3:

                case 4:

                    break;
                case 5:

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


