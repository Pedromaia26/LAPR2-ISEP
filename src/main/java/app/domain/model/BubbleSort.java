package app.domain.model;

import app.mappers.dto.ClientDTO;

import java.util.Collections;
import java.util.List;

public class BubbleSort implements SortingAlgorithms{


    public BubbleSort()  {
    }

    public List<ClientDTO> orderClientsByTin(List<ClientDTO> clientList){
        for (int i = 0; i < clientList.size()-1; i++) {
            for (int j = 1; j < clientList.size()-i; j++){
                if (clientList.get(j-1).getTifDto() > clientList.get(j).getTifDto()){
                    Collections.swap(clientList, j-1, j);
                }
            }
        }
        

        return clientList;

    }
    public List<ClientDTO>  orderClientsByName(List<ClientDTO> clientList){
        for (int i = 0; i < clientList.size()-1; i++) {
            for (int j = 1; j < clientList.size()-i; j++){
                if (clientList.get(j-1).getNameDto().compareTo(clientList.get(j).getNameDto())>0){
                    Collections.swap(clientList, j-1, j);
                }
            }
        }
        //System.out.println(clientList);
        return clientList;
    }



}
