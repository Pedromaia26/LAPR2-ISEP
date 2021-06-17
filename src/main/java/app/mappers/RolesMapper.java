package app.mappers;

import app.domain.model.OrgRole;
import app.mappers.dto.OrgRoleDto;

import java.util.ArrayList;
import java.util.List;

public class RolesMapper {

    /**
     * List that contains intances of OrgRoleDto
     */
    private List<OrgRoleDto> lRolesDto = new ArrayList<>();

    /**
     * Method responsible to convert a list of OrgRoles into a list of OrgRolesDto
     * @param lRoles the list that contains the existing OrgRoles
     * @return a list of OrgRolesDto
     */
    public List<OrgRoleDto> toDTO(List<OrgRole> lRoles){
        if (lRolesDto.isEmpty()){
            for (OrgRole role : lRoles){

                lRolesDto.add(new OrgRoleDto(role.getDesignation()));
            }
        }

        return lRolesDto;
    }
}
