package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class RolesMapper {

    private static List<OrgRole> lRolesDto = new ArrayList<>();

    public static List<OrgRole> toDTO(List<OrgRole> lRoles){
        for (OrgRole role : lRoles){
            lRolesDto.add(role);
        }
        return lRolesDto;
    }
}
