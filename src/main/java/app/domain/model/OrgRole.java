package app.domain.model;

public class OrgRole {

    private String orgRole;

    public OrgRole(String orgRole){
        if (orgRole.length() > 15)
            throw new IllegalArgumentException("Organization Role cannot have more than 15 characters");
        this.orgRole = orgRole;
    }

}
