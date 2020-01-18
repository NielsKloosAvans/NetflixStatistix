package UI.Controllers;

import data.Account;
import data.Profile;
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
import logic.DatabaseQueries;
import logic.ProfileQueries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileSettingsController {
    @FXML
    public ComboBox<Profile> cbProfile;

    @FXML
    public ComboBox<Account> cbAccount;

    @FXML
    List<Account> accounts;

    @FXML
    List<Profile> profiles;

    @FXML
    private TextField createProfileName;

    @FXML
    private TextField createProfileAge;

    @FXML
    private TextField updateProfileName;

    @FXML
    private TextField updateProfileAge;


    @FXML
    private void showAccountOverview(ActionEvent event) throws IOException {   //Link terug naar Account view
        Parent newView = FXMLLoader.load(getClass().getResource("AccountView.fxml"));

        Scene newScene = new Scene(newView);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void createProfile(){
        ProfileQueries profileQueries = new ProfileQueries();
        Account account = cbAccount.getSelectionModel().getSelectedItem();

        if (account != null){
            boolean succeeded = profileQueries.createProfile(account, createProfileName.getText(), Integer.parseInt(createProfileAge.getText()));

            if (succeeded){
                new Alert(Alert.AlertType.INFORMATION,"Profile Created.").show();
            } else {
                new Alert(Alert.AlertType.ERROR,"An error occurred while creating a profile.").show();

            }
        }
    }

    @FXML
    public void printProfiles(){
        ProfileQueries profileQueries = new ProfileQueries();
        System.out.println(profileQueries.getAll());
    }

    @FXML
    public void refreshAccount() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbAccountList = FXCollections.observableList(accounts);
        cbAccount.setItems(cbAccountList);
        createProfileName.setText("");
        createProfileAge.setText("");
    }

    @FXML
    private void updateProfile(){
        ProfileQueries profileQueries = new ProfileQueries();
        Profile profile = cbProfile.getSelectionModel().getSelectedItem();
        profile.setProfileName(updateProfileName.getText());
        profile.setAge(Integer.parseInt(updateProfileAge.getText()));

        boolean succeeded = profileQueries.updateProfile(profile);
        if (succeeded){
            refreshAccount();
            new Alert(Alert.AlertType.INFORMATION,"Profile Updated.").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"An error occurred while updating the profile.").show();
        }
    }

    @FXML
    private void removeProfile(){
        ProfileQueries profileQueries = new ProfileQueries();
        Profile profile = cbProfile.getSelectionModel().getSelectedItem();

        boolean succeeded = profileQueries.removeProfile(profile);
        if (succeeded){
            refreshAccount();
            new Alert(Alert.AlertType.INFORMATION,"Profile removed.").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"An error occurred while removing the profile.").show();
        }
    }


}
