package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register a new Employee", new CreateEmployeeUI()));
        options.add(new MenuItem("Register a new clinical analysis laboratory", new ShowTextUI("You have chosen Option A.")));
        options.add(new MenuItem("Specify a new type of test", new TestTypeUI()));
        options.add(new MenuItem("Specify a new parameter and categorize it", new ShowTextUI("You have chosen Option C.")));
        options.add(new MenuItem("Specify a new parameter category", new ShowTextUI("You have chosen Option C.")));

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
