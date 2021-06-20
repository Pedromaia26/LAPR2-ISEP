package app.ui.gui;

import app.controller.AuthController;
import app.ui.console.RegistClientUI;
import app.ui.console.TestUI;
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

public class ReceptionistGUI {

    @FXML
    private AnchorPane anchorPane;

    private AuthController ctrl=new AuthController();

    Stage stage;

    public ReceptionistGUI() throws IllegalAccessException, ParseException, InstantiationException, IOException, OutputException, BarcodeException, ClassNotFoundException {
    }

    public void RegistClient(ActionEvent actionEvent) throws IOException {
        closeGui4();

        RegistClientUI registClientUI = new RegistClientUI();
        registClientUI.run();

        returnToGui4();
    }

    public void registTest(ActionEvent actionEvent) throws IOException {

        closeGui4();

        TestUI testUI = new TestUI();
        testUI.run();

        returnToGui4();
    }

    public void logout(MouseEvent mouseEvent) {
        try {

            JanelaPrincipalUI.logout(ctrl,stage,anchorPane);
            JanelaPrincipalUI janelaPrincipalUI = new JanelaPrincipalUI();



            janelaPrincipalUI.enter("login", "Many Labs");
        }catch (Exception e){
            System.out.println("Fail during logout");
        }
    }

    public void returnToGui4() throws IOException {
        Parent aaaaa = FXMLLoader.load(getClass().getClassLoader().getResource("ReceptionistGUI.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(aaaaa);
        stage2.setTitle("Receptionist");
        stage2.setScene(scene2);
        stage2.setResizable(true);
        stage2.show();
    }

    public void closeGui4(){
        stage = (Stage) anchorPane.getScene().getWindow();

        System.out.println("closed");

        stage.close();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
