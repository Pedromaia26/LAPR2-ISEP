package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class OrgRoleStore {

    private List<OrgRole> store = new ArrayList<>();

    public void addOrgRole(OrgRole orgRole){
        store.add(orgRole);
    }

    public List<OrgRole> getOrgRoleStore(){
        return store;
    }

}
