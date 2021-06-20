package app.ui.gui;

import app.controller.AuthController;
import app.ui.console.RecordSampleUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;

public class MLTGui {

    @FXML
    private AnchorPane anchorPane;

    private AuthController ctrl=new AuthController();

    Stage stage;

    public MLTGui() throws IllegalAccessException, ParseException, InstantiationException, IOException, OutputException, BarcodeException, ClassNotFoundException {
    }

    public void recordSample(ActionEvent actionEvent) throws IOException {

        closeGui();

        RecordSampleUI recordSampleUI = new RecordSampleUI();
        recordSampleUI.run();

        returnToGui();
    }

    public void returnToGui() throws IOException {
        Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("MLTGui.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(aaaaa);
        stage2.setTitle("MLT");
        stage2.setScene(scene2);
        stage2.setResizable(true);
        stage2.show();
    }

    public void closeGui(){
        stage = (Stage) anchorPane.getScene().getWindow();

        System.out.println("closed");

        stage.close();
    }

    public void logout(MouseEvent mouseEvent) throws IllegalAccessException, ParseException, InstantiationException, OutputException, IOException, BarcodeException, ClassNotFoundException {
        try {
            JanelaPrincipalUI janelaPrincipalUI = new JanelaPrincipalUI();

            janelaPrincipalUI.logout(ctrl,stage,anchorPane);

            janelaPrincipalUI.enter("login", "Many Labs");
        }catch (Exception e){
            System.out.println("Fail during logout");
        }

    }
}
