package app.domain.model.mappers;

import app.domain.model.OrgRole;
import auth.domain.model.UserRole;

import java.util.ArrayList;
import java.util.List;

public class RolesMapper {

    private static List<OrgRole> lRolesDto = new ArrayList<>();

    public static List<OrgRole> toDTO(List<OrgRole> lRoles){
        if (lRolesDto.isEmpty()){
            for (OrgRole role : lRoles){
                lRolesDto.add(role);
            }
        }

        return lRolesDto;
    }
}
