package app.ui.console;

import app.ui.console.utils.Utils;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReceptionistUI implements Runnable {
    public ReceptionistUI()
    {
    }

    public void run() {
        /*com.sun.javafx.application.PlatformImpl.startup(()->{});
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                Parent aaaaa = null;
                try {
                    aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage2 = new Stage();
                Scene scene2 = new Scene(aaaaa);
                stage2.setTitle("LOGIN");
                stage2.setScene(scene2);
                stage2.setResizable(false);
                stage2.show();
            }
        });*/
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register a new Client", new RegistClientUI()));
        options.add(new MenuItem("Register a new Test", new TestUI()));
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
