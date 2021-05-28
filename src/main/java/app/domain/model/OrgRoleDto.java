package app.domain.model;

import app.domain.shared.Constants;
import auth.domain.model.Email;
import auth.domain.model.UserRole;

public class OrgRoleDto {

    private String designationDto;

    public OrgRoleDto(String designation){
        designationDto = designation;
    }

    public String getDesignation() {
        return designationDto;
    }

    @Override
    public String toString() {
        return designationDto;

    }


}

