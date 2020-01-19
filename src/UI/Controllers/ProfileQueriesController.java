package UI.Controllers;

import data.Account;
import data.Serie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import logic.AccountQueries;

import java.io.IOException;
import java.util.List;

public class ProfileQueriesController {

    @FXML
    private List<Account> accounts;

    @FXML
    private ComboBox<Serie> cbSeries;

    @FXML
    private ComboBox<Account> cbAccount;

    @FXML
    private ComboBox<Account> cbAccountWatched;

    @FXML
    public void refreshAccount() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbAccount.setItems(cbList);
    }

    @FXML
    public void refreshCbAccountWatched() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbAccountWatched.setItems(cbList);
    }



//    @FXML
//    public void refreshCbSeries() {
//        Serie series = new Serie();
//        series = account.getAll();
//        ObservableList cbList = FXCollections.observableList(accounts);
//        cbUpdate.setItems(cbList);
//        ChangeName.setText("");
//        ChangePassword.setText("");
//        ChangeAddress.setText("");
//        ChangeCity.setText("");
//    }
//




    @FXML
    private void showAccountOverview(ActionEvent event) throws IOException {
        Parent newView = FXMLLoader.load(getClass().getResource("AccountView.fxml"));

        Scene newScene = new Scene(newView);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}
