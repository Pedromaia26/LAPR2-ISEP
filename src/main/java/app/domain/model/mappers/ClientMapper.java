package app.domain.model.mappers;

import app.domain.model.Client;
import app.domain.model.dto.ClientDTO;

public class ClientMapper{
    /**
     * Recieves the ClientDTO and returns the new Client.
     * @param dto The ClientDTO
     * @return new client.
     */
    public static Client toModel(ClientDTO dto) {

        long ccn = dto.getCcn();
        long nhs = dto.getNhs();
        String birth = dto.getBirth();
        String sex = dto.getSex();
        long tif = dto.getTif();
        String email = dto.getEmail();
        String name = dto.getName();
        long phoneNumber = dto.getPhoneNumber();

        return new Client(ccn, nhs, birth, sex, tif, email, name, phoneNumber);


    }

}
