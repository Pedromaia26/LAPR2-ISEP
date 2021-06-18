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

    @Test
    public void addRoles(){

        Company c= new Company("ManyLabs");

        List<OrgRole> roles= new ArrayList<>();

        c.getOrgRoleStore().addDefaultRoles();

        List<OrgRole> roles1= c.getOrgRoleStore().getRoles();

        roles.add(new OrgRole("Administrator"));
        roles.add(new OrgRole("Receptionist"));
        roles.add(new OrgRole("Medical Lab Technician"));
        roles.add(new OrgRole("Clinical Chemistry Technologist"));
        roles.add(new OrgRole("Laboratory Coordinator"));
        roles.add(new OrgRole("Specialist Doctor"));

        assertEquals(roles1,roles);
    }

    @Test
    public void getRoleByDesignation() {
        Company c= new Company("ManyLabs");

        c.getOrgRoleStore().addDefaultRoles();

        OrgRole orgRole1= new OrgRole("Administrator");

        OrgRole orgRole= c.getOrgRoleStore().getRoleByDesignation("Administrator");

        assertEquals(orgRole1,orgRole);

    }
}