package app.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("MANY LABS");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.setResizable(true);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        root.getStylesheets().add("styles/styles.css");




    }


    public static void main(String[] args) {
        launch(args);
    }


}
