package app.domain.model;

import java.util.List;

public interface SortingAlgorithms {
    List<ClientDTO> orderClientsByTin(List<ClientDTO> clients);
    List<ClientDTO> orderClientsByName(List<ClientDTO> clients);
}
