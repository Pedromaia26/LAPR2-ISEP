package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrgRoleTest {

    @Test
    public void OrgRole() {
        OrgRole role = new OrgRole("adm");

        Assert.assertEquals("adm", role.toString());
    }

    @Test
    public void createEmployee() {
    }

    @Test
    public void testCreateEmployee() {
    }

    @Test
    public void getDesignation() {
        OrgRole role = new OrgRole("orgRole");
        String expected = "orgRole";

        Assert.assertEquals(expected, role.getDesignation());
    }

    @Test
    public void testToString() {
        OrgRole role = new OrgRole("orgRole");
        String expected = "orgRole";

        Assert.assertEquals(expected, role.toString());
    }
}