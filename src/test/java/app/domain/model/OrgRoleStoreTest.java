package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrgRoleStoreTest {

    @Test
    public void addDefaultRolesNotEmpty() {
        OrgRole role = new OrgRole("adm");
        Company c = new Company("Many Labs");
        c.getOrgRoleStore().addOrgRole(role);
        c.getOrgRoleStore().addDefaultRoles();
        List<OrgRole> list = new ArrayList<>();
        list.add(role);

        Assert.assertEquals(list, c.getOrgRoleStore().getRoles());
    }

    @Test
    public void getRoles() {
        OrgRole role = new OrgRole("adm");
        Company c = new Company("Many Labs");
        List<OrgRole> roleList = new ArrayList<>();
        roleList.add(role);
        c.getOrgRoleStore().addOrgRole(role);

        Assert.assertEquals(roleList, c.getOrgRoleStore().getRoles());
    }
}