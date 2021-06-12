package app.ui.gui;

import app.controller.App;
import app.controller.ClinicalChemTechController;
import app.domain.model.Client;
import app.domain.model.ClientDTO;
import app.domain.model.ClientStore;
import app.domain.model.Company;
import auth.AuthFacade;
import auth.UserSession;
//import com.sun.rowset.internal.Row;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import javax.imageio.IIOParam;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class ClinicalChemTechUI implements Initializable {

    /*private Company c;
    Client client0 = new Client("1234567890123456",1234567890L,"12/12/2002","male",1234567890L,"client@lei.sem2.pt","Client",12312312312L);
    Client client = new Client("1234567890123456",1234567890L,"12/12/2002","male",1234567890L,"client@lei.sem2.pt","Tiago",12312312312L);
    Client client1 = new Client("5654161110898400",1234567890L,"01/12/2002","female",9898798910L,"client@lei.sem2.pt","Joana",12312312312L);
    private List<Client> clientList = new ArrayList<>();*/
    @FXML
    private TableView<ClientDTO> tableView = new TableView<>();
    @FXML
    private TableColumn<ClientDTO, String> nameColumn = new TableColumn<>();
    @FXML
    private TableColumn<ClientDTO, String> tinColumn = new TableColumn<>();
    @FXML
    private TableColumn<ClientDTO, String> ccnColumn = new TableColumn<>();
    @FXML
    private Label client2;
    private ClientStore cStore;

    private ClinicalChemTechController controller;

    public ClinicalChemTechUI() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        controller = new ClinicalChemTechController();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // client.setText("Welcome");

        // client2.setText("Welcome, " + auth.getCurrentUserSession().getUserId());



        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nameDto"));
        tinColumn.setCellValueFactory(new PropertyValueFactory<>("tifDto"));
        ccnColumn.setCellValueFactory(new PropertyValueFactory<>("ccnDto"));

        try {
            tableView.setItems(getClients());
        } catch (OutputException e) {
            e.printStackTrace();
        } catch (BarcodeException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }



    public ObservableList<ClientDTO> getClients() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ObservableList<ClientDTO> clients = FXCollections.observableArrayList();


        for (ClientDTO c:controller.getClients()){
            System.out.println(c);
            clients.add(c);
        }

        return clients;

    }



    public void historyOnAction (ActionEvent actionEvent) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, OutputException, BarcodeException, ParseException {

        ClientDTO a = tableView.getSelectionModel().getSelectedItems().get(0);
        FXMLLoader fxmlLoader = new FXMLLoader (getClass().getClassLoader().getResource("TestsHistory.fxml"));
        Parent root = fxmlLoader.load();
        TestsHistoryUI controller = fxmlLoader.getController();
        controller.initData(a);
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(root);
        stage2.setTitle("TESTS HISTORY");
        stage2.setScene(scene2);
        stage2.setResizable(true);
        stage2.show();
    }

    public void sortByTinOnAction (ActionEvent actionEvent) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        App.getInstance().getCompany().getClientStore().setOrderingAlgorithm("Domain.OrderByTin");
        List<ClientDTO> clientList = App.getInstance().getCompany().getClientStore().OrderingAlgorithm().orderClientsByTin(controller.getClients());
        tableView.setItems(orderByTin(clientList));
    }

    public void sortByNameOnAction (ActionEvent actionEvent) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        App.getInstance().getCompany().getClientStore().setOrderingAlgorithm("Domain.OrderByName");
        List<ClientDTO> clientList = App.getInstance().getCompany().getClientStore().OrderingAlgorithm().orderClientsByName(controller.getClients());
        tableView.setItems(orderByName(clientList));
    }

    public ObservableList<ClientDTO> orderByTin(List<ClientDTO> clientList){
        ObservableList<ClientDTO> orderedClientList = FXCollections.observableArrayList();
        for (ClientDTO clients:clientList){
            orderedClientList.add(clients);
        }
        return orderedClientList;
    }

    public ObservableList<ClientDTO> orderByName(List<ClientDTO> clientList){
        ObservableList<ClientDTO> orderedClientList = FXCollections.observableArrayList();
        for (ClientDTO clients:clientList){
            orderedClientList.add(clients);
        }
        return orderedClientList;
    }

}
