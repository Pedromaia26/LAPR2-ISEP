package app.domain.shared;

import app.domain.model.OrgRole;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Constants {
    public static final String ROLE_ADMIN = "ADMINISTRATOR";
    public static final String ROLE_REC = "RECEPTIONIST";
    public static final String ROLE_MLT = "MEDICAL LAB TECHNICIAN";
    public static final String ROLE_CCT = "CLINICAL CHEMESTRY TECHNOLOGIST";
    public static final String ROLE_LC = "LABORATORY COORDINATOR";
    public static final String ROLE_SD = "SPECIALIST DOCTOR";

    public static final OrgRole ORGROLE_ADMIN = new OrgRole("Administrator");
    public static final OrgRole ORGROLE_REC = new OrgRole("Receptionist");
    public static final OrgRole ORGROLE_MLT = new OrgRole("Med Lab Tec");
    public static final OrgRole ORGROLE_CCT = new OrgRole("Clin Chem Tec");
    public static final OrgRole ORGROLE_LC = new OrgRole("Lab Coordinator");
    public static final OrgRole ORGROLE_SD = new OrgRole("Spec Doctor");



    public static final String PARAMS_FILENAME = "config.properties";
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";
}
