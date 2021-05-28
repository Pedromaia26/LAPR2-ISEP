package app.domain.model;

import auth.domain.model.UserRole;

import java.util.ArrayList;
import java.util.List;

public class RolesMapper {

    private List<OrgRoleDto> lRolesDto = new ArrayList<>();

    public List<OrgRoleDto> toDTO(List<OrgRole> lRoles){
        if (lRolesDto.isEmpty()){
            for (OrgRole role : lRoles){

                lRolesDto.add(new OrgRoleDto(role.getDesignation()));
            }
        }

        return lRolesDto;
    }
}
