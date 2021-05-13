package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class OrgRoleStore {

    private List<OrgRole> store = new ArrayList<>();

    public OrgRoleStore() { }

    public void addDefaultRoles(){
        if (store.isEmpty()){
            this.addOrgRole(new OrgRole("Administrator"));
            this.addOrgRole(new OrgRole("Receptionist"));
            this.addOrgRole(new OrgRole("Medical Lab Technician"));
            this.addOrgRole(new OrgRole("Clinical Chemestry Technologist"));
            this.addOrgRole(new OrgRole("Laboratory Coordinator"));
            this.addOrgRole(new OrgRole("Specialist Doctor"));
        }
    }

    public void addOrgRole(OrgRole orgRole){
        store.add(orgRole);
    }


    public List<OrgRole> getOrgRoleStore(){
        return store;
    }

}
