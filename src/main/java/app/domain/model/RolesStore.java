package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class RolesStore {

    static List<OrgRole> lRoles = new ArrayList<>();
    public static void addDefaultRoles() {
        if (lRoles.isEmpty()){
            lRoles.add(new OrgRole("Administrator"));
            lRoles.add(new OrgRole("Receptionist"));
            lRoles.add(new OrgRole("MLT"));
            lRoles.add(new OrgRole("CCT"));
            lRoles.add(new OrgRole("LC"));
            lRoles.add(new OrgRole("SD"));
        }
    }

    public static List<OrgRole> getRoles(){
        return lRoles;
    }

}
