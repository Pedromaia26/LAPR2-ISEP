package app.controller;

import auth.domain.model.UserRole;
import auth.mappers.dto.UserRoleDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
<<<<<<< HEAD
import java.text.ParseException;
=======
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
import java.util.List;
/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class AuthController {

    private App app;

<<<<<<< HEAD
    public AuthController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
=======
    public AuthController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
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
