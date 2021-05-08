package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class RolesStore {

    static List<OrgRole> lRoles = new ArrayList<>();
    public void addjoiasjoifdasj() {
        lRoles.add(new OrgRole("Administrator"));
        lRoles.add(new OrgRole("Receptionist"));
        lRoles.add(new OrgRole("Medical Lab Technician"));
        lRoles.add(new OrgRole("Clinical Chemestry Technologist"));
        lRoles.add(new OrgRole("Laboratory Coordinator"));
        lRoles.add(new OrgRole("SpecialistDoctor"));
    }

    public static List<OrgRole> getRoles(){
        return lRoles;
    }

}
