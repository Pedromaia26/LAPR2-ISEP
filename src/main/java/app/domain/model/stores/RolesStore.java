package app.domain.model.stores;

import app.domain.model.OrgRole;

import java.util.ArrayList;
import java.util.List;

public class RolesStore {

    static List<OrgRole> lRoles = new ArrayList<>();

    public static void addRole(OrgRole role){
        lRoles.add(role);
    }

    public static List<OrgRole> getRoles(){
        return lRoles;
    }

}
