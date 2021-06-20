package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class OrgRoleStore {
    /**
     * List that contains the OrgRoles
     */
    private List<OrgRole> store = new ArrayList<>();

    /**
     * Method that adds the default OrgRoles if there are no OrgRoles registered
     */
    public void addDefaultRoles(){
        if (store.isEmpty()){
            this.addOrgRole(new OrgRole("Administrator"));
            this.addOrgRole(new OrgRole("Receptionist"));
            this.addOrgRole(new OrgRole("Medical Lab Technician"));
            this.addOrgRole(new OrgRole("Clinical Chemistry Technologist"));
            this.addOrgRole(new OrgRole("Laboratory Coordinator"));
            this.addOrgRole(new OrgRole("Specialist Doctor"));
        }
    }

    /**
     * Add a OrgRole to the list of OrgRoles
     * @param orgRole the OrgRole to add to the list
     */
    public void addOrgRole(OrgRole orgRole){
        store.add(orgRole);
    }

    /**
     * Returns the list that contains the OrgRoles
     * @return the OrgRoles list
     */
    public List<OrgRole> getRoles(){
        return store;
    }
    /**
     * Searches for the org role with a specific designation.
     * @return the org role with specific designation.
     */
    public OrgRole getRoleByDesignation(String designation) {
        for (OrgRole role : store){
            if (role.getDesignation().equals(designation)){
                return role;
            }
        }
        return null;
    }

}
