package app.domain.model;

import java.util.Objects;

public class ClientMapper{

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
