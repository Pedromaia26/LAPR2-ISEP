package app.mappers.dto;

import app.domain.shared.Constants;
import auth.domain.model.Email;
import auth.domain.model.UserRole;

public class OrgRoleDto {

    /**
     * String that contains the Designation of a OrgRole
     */
    private String designationDto;

    /**
     * Create a new instance of a OrgRoleDto, receiving by parameter the designation
     * @param designation Designation of a OrgRoleDto
     */
    public OrgRoleDto(String designation){
        designationDto = designation;
    }

    /**
     * Returns the Description of a OrgRoleDto
     * @return the Description of a OrgRoleDto
     */
    public String getDesignation() {
        return designationDto;
    }

    /**
     * Returns a String with the information of a OrgRoleDto
     * @return attributes of a OrgRoleDto
     */
    @Override
    public String toString() {
        return designationDto;

    }


}

