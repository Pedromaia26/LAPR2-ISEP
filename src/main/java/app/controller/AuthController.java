package app.controller;

import auth.domain.model.UserRole;
import auth.mappers.dto.UserRoleDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class AuthController {

    private App app;

    public AuthController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.app = App.getInstance();
    }

    public boolean doLogin(String email, String pwd)
    {
        try {
            return this.app.doLogin(email, pwd);
        } catch(IllegalArgumentException ex)
        {
            return false;
        }
    }

    public List<UserRoleDTO> getUserRoles()
    {
        if (this.app.getCurrentUserSession().isLoggedIn())
        {
            return this.app.getCurrentUserSession().getUserRoles();
        }
        return null;
    }

    public void doLogout()
    {
        this.app.doLogout();
    }
}
