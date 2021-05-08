package app.controller;

import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class RegistEmployeeController {

    private List<OrgRole> lRoles = new ArrayList<>();

    public void getRoles(){
        lRoles = RolesStore.getRoles();
    }
}
