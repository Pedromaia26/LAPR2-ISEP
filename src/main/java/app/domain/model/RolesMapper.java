package app.domain.model;

import auth.domain.model.UserRole;

import java.util.ArrayList;
import java.util.List;

public class RolesMapper {

    private static List<UserRole> lRolesDto = new ArrayList<>();

    public static List<UserRole> toDTO(List<UserRole> lRoles){
        if (lRolesDto.isEmpty()){
            for (UserRole role : lRoles){
                lRolesDto.add(role);
            }
        }

        return lRolesDto;
    }
}
