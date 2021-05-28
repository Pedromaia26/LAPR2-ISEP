package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrgRoleDtoTest {

    @Test
    public void getDesignation() {
        OrgRoleDto role = new OrgRoleDto("adm");
        String r = "adm";

        Assert.assertEquals(r, role.getDesignation());
    }

    @Test
    public void testToString() {
        OrgRoleDto role = new OrgRoleDto("adm");
        String r = "adm";

        Assert.assertEquals(r, role.toString());
    }
}