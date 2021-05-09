package app.domain.model;

import auth.domain.model.UserRole;

import java.util.ArrayList;
import java.util.List;

public class OrgRoleStore {

    List<OrgRole> listOrgRoles = new ArrayList<OrgRole>();

    public OrgRole create(String description)
    {
        return new OrgRole(description);
    }

    /*public boolean add(OrgRole role)
    {
        if (role != null) {
            if (!exists(role))
                return this.store.add(role);
        }
        return false;
    }*/

}
