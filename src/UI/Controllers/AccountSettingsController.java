package UI.Controllers;

import data.Account;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.AccountQueries;

import java.io.IOException;
import java.util.List;

public class AccountSettingsController {

    @FXML
    private List<Account> accounts;

    @FXML
    private ComboBox<Account> cb;

    @FXML
    private TextField ChangeEmail;

    @FXML
    private TextField ChangeName;

    @FXML
    private TextField ChangePassword;

    @FXML
    private TextField ChangeAddress;

    @FXML
    private TextField ChangeCity;

    @FXML
    private void showAccountOverview(ActionEvent event) throws IOException {
        Parent newView = FXMLLoader.load(getClass().getResource("AccountView.fxml"));

        Scene newScene = new Scene(newView);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void updateAccount() {
        AccountQueries accountQueries = new AccountQueries();
        Account account = cb.getSelectionModel().getSelectedItem();
        if (account != null) {
            account.setEmail(ChangeEmail.getText());
            account.setName(ChangeName.getText());
            account.setPassword(ChangePassword.getText());
            account.setAddress(ChangeAddress.getText());
            account.setCity(ChangeCity.getText());
            boolean succeeded = accountQueries.updateAccount(account);
            if (succeeded) {
                refreshAccounts();
                new Alert(Alert.AlertType.INFORMATION, "Update Successful.").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Update Unsuccessful.").show();
            }
        }
    }

    private void refreshAccounts() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cb.setItems(cbList);
        ChangeName.setText("");
        ChangeEmail.setText("");
        ChangePassword.setText("");
        ChangeAddress.setText("");
        ChangeCity.setText("");
    }


}
