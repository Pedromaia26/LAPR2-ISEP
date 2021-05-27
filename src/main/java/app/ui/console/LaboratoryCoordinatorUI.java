package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryCoordinatorUI implements Runnable{
    public LaboratoryCoordinatorUI()
    {
    }

    public void run(){
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Validate the work done", new ValidateWorkDoneUI()));
        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
