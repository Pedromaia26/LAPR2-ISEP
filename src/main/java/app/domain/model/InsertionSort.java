package app.domain.model;

import app.mappers.dto.ClientDTO;

import java.util.Collections;
import java.util.List;

public class InsertionSort implements SortingAlgorithms{
    /**
     * Returns the list of clients ordered by tin using insertion sort.
     * @return  list of clients.
     */
    public List<ClientDTO> orderClientsByTin(List<ClientDTO> clients){
        for (int i = 1; i < clients.size(); i++) {
            long current = clients.get(i).getTifDto();
            int j = i - 1;
            while(j >= 0 && current < clients.get(j).getTifDto()) {
                Collections.swap(clients, j+1, j);
                j--;
            }
            //Collections.swap(clients, j+1, i);
        }
        //System.out.println(clients);

        return clients;
    }
    /**
     * Returns the list of clients ordered by name using insertion sort.
     * @return  list of clients.
     */
    public List<ClientDTO> orderClientsByName(List<ClientDTO> clients){
        for (int i = 1; i < clients.size(); i++) {
            String current = clients.get(i).getNameDto();
            int j = i - 1;
            while(j >= 0 && current.compareTo(clients.get(j).getNameDto())<0) {
                Collections.swap(clients, j+1, j);
                j--;
            }
           // Collections.swap(clients, j+1, i);
        }
        //System.out.println(clients);
        return clients;
    }

}
