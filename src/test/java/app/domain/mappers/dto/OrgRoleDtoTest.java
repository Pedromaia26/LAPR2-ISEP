package app.domain.mappers.dto;

import app.mappers.dto.OrgRoleDto;
import org.junit.Assert;
import org.junit.Test;

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