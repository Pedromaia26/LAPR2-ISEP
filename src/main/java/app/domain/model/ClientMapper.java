package app.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientMapper{

    private List<ClientDTO> listClientDto;

    public ClientMapper(){
        this.listClientDto= new ArrayList<>();
    }


    /**
     * Recieves the ClientDTO and returns the new Client.
     * @param dto The ClientDTO
     * @return new client.
     */
    public static Client toModel(ClientDTO dto) {

        long ccn = dto.getCcnDto();
        long nhs = dto.getNhsDto();
        String birth = dto.getBirthDto();
        String sex = dto.getSexDto();
        long tif = dto.getTifDto();
        String email = dto.getEmailDto();
        String name = dto.getNameDto();
        long phoneNumber = dto.getPhoneNumberDto();

        return new Client(ccn, nhs, birth, sex, tif, email, name, phoneNumber);


    }

    public List<ClientDTO> toDto(List<Client> listClient) {
        if(listClient.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("There are no test types.");
        }
        listClientDto = new ArrayList<>();
        for (Client client : listClient) {
            listClientDto.add(new ClientDTO(client));
        }
        return listClientDto;
    }

}
