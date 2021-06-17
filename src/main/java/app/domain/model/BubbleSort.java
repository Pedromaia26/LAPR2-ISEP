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
        for (int i = 0; i < clientList.size()-1; i++) {
            for (int j = 0; j < clientList.size()-1; j++){
                if (clientList.get(i).getTifDto() > clientList.get(j+1).getTifDto()){
                    Collections.swap(clientList, i, j+1);
                }
            }
        }
        return clientList;

    }
    public List<ClientDTO>  orderClientsByName(List<ClientDTO> clientList){
        for (int i = 0; i < clientList.size()-1; i++) {
            for (int j = 0; j < clientList.size()-1; j++){
                if (clientList.get(i).getNameDto().compareTo(clientList.get(j+1).getNameDto())>0){
                    Collections.swap(clientList, i, j+1);
                }
            }
        }
    return clientList;
    }



}
