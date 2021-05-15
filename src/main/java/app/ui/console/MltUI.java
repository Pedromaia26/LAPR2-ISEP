package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MltUI implements Runnable{
    public MltUI() {

    }

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Record a new Sample", new RecordSampleUI()));
        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMedical Lab technician Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
