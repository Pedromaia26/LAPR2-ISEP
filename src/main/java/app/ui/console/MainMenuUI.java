package app.ui.console;

import app.ui.console.utils.Utils;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class MainMenuUI {

    public MainMenuUI()
    {
    }

    public void run() throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException, ParseException, BarcodeException, OutputException {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Do Login", new AuthUI()));
        options.add(new MenuItem("Know the Development Team",new DevTeamUI()));
        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }


}
