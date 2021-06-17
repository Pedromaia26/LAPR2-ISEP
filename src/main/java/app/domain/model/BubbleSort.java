package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

public class BubbleSort implements SortingAlgorithms{


    public BubbleSort()  {
    }

    public List<ClientDTO> orderClientsByTin(List<ClientDTO> clientList){
        for (int i = 1; i < clientList.size()-1; i++) {
            for (int j = 1; j < clientList.size()-i; j++){
                if (clientList.get(j).getTifDto() > clientList.get(j+1).getTifDto()){
                    Collections.swap(clientList, j, j+1);
                }
            }
        }
        System.out.println(clientList);

        return clientList;

    }
    public List<ClientDTO>  orderClientsByName(List<ClientDTO> clientList){
        for (int i = 1; i < clientList.size()-1; i++) {
            for (int j = 1; j < clientList.size()-i; j++){
                if (clientList.get(j).getNameDto().compareTo(clientList.get(j+1).getNameDto())>0){
                    Collections.swap(clientList, j, j+1);
                }
            }
        }
        //System.out.println(clientList);
        return clientList;
    }



}
