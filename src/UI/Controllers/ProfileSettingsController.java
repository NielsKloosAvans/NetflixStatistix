package UI.Controllers;

import data.*;
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
import logic.HasWatchedQueries;
import logic.ProfileQueries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileSettingsController {
    @FXML
    public ComboBox<Profile> cbUpdateProfile;

    @FXML
    public List<Episode> episodes;

    @FXML
    public List <Movie> movies;

    @FXML
    public ComboBox<Account> cbCreateProfile;

    @FXML
    public ComboBox<Account> cbUpdateProfileAccount;

    @FXML
    public ComboBox<Account> cbRemoveProfileAccount;

    @FXML
    public ComboBox<Profile> cbRemoveProfile;

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
    private void addProfile(){
        ProfileQueries profileQueries = new ProfileQueries();
        Account account = cbCreateProfile.getSelectionModel().getSelectedItem();
        if (account != null){
            Profile profile = new Profile(createProfileName.getText(),Integer.parseInt(createProfileAge.getText()), account.getEmail());
            account.addProfile(profile);
            boolean succeeded = profileQueries.createProfile(profile);
            if (succeeded){
                new Alert(Alert.AlertType.INFORMATION,"Profile Created.").show();
            } else {
                new Alert(Alert.AlertType.ERROR,"An error occurred while creating a profile.").show();
            }
        }
    }

    @FXML
    public void refreshAccount() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbAccountList = FXCollections.observableList(accounts);
        cbRemoveProfileAccount.setItems(cbAccountList);
        createProfileName.setText("");
        createProfileAge.setText("");
    }

    @FXML
    private void updateProfile(){
        ProfileQueries profileQueries = new ProfileQueries();
        Profile profile = cbUpdateProfile.getSelectionModel().getSelectedItem();
        profile.setAge(Integer.parseInt(updateProfileAge.getText()));
        boolean succeeded = profileQueries.updateProfile(profile);
        if (succeeded){
            refreshUpdateProfile();
            new Alert(Alert.AlertType.INFORMATION,"Profile Updated.").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"An error occurred while updating the profile.").show();
        }
    }

    @FXML
    private void removeProfile(){
        ProfileQueries profileQueries = new ProfileQueries();
        Profile profile = cbRemoveProfile.getSelectionModel().getSelectedItem();
        boolean succeeded = profileQueries.removeProfile(profile);
        if (succeeded){
            refreshAccount();
            new Alert(Alert.AlertType.INFORMATION,"Profile removed.").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"An error occurred while removing the profile.").show();
        }
    }

    @FXML
    public void refreshAccountsCreate() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbCreateProfile.setItems(cbList);
        createProfileName.setText("");
        createProfileAge.setText("");
    }

    @FXML
    public void refreshAccountsUpdate() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbUpdateProfileAccount.setItems(cbList);
        createProfileName.setText("");
        createProfileAge.setText("");
    }

    @FXML
    public void refreshAccountsRemove() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbRemoveProfileAccount.setItems(cbList);
        createProfileName.setText("");
        createProfileAge.setText("");
    }

    @FXML
    public void refreshUpdateProfile() {
        ProfileQueries profileQueries = new ProfileQueries();
        profiles = profileQueries.getProfilesFromAccount(cbUpdateProfileAccount.getSelectionModel().getSelectedItem());
        ObservableList cbList = FXCollections.observableList(profiles);
        cbUpdateProfile.setItems(cbList);
        updateProfileName.setText("");
        updateProfileAge.setText("");
    }

    @FXML
    public void refreshRemoveProfile() {
        ProfileQueries profileQueries = new ProfileQueries();
        profiles = profileQueries.getProfilesFromAccount(cbRemoveProfileAccount.getSelectionModel().getSelectedItem());
        ObservableList cbList = FXCollections.observableList(profiles);
        cbRemoveProfile.setItems(cbList);
        updateProfileName.setText("");
        updateProfileAge.setText("");
    }

    //ADD WATCHED MOVIE
    @FXML
    public ComboBox<Profile> cbWatchedProfile;

    @FXML
    public ComboBox<Account> cbWatchedAccount;

    @FXML
    public ComboBox<Movie> cbListMovies;

    @FXML
    private TextField minutesWatched;



    //ADD WATCHED MOVIE METHODS
    @FXML
    public void refreshAccountsWatched() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbWatchedAccount.setItems(cbList);
    }

    @FXML
    public void refreshProfileWatched() {
        ProfileQueries profileQueries = new ProfileQueries();
        profiles = profileQueries.getProfilesFromAccount(cbWatchedAccount.getSelectionModel().getSelectedItem());
        ObservableList cbList = FXCollections.observableList(profiles);
        cbWatchedProfile.setItems(cbList);
        minutesWatched.setText("");
    }

    @FXML
    public void refreshMovies(){
        HasWatchedQueries hasWatchedQueries = new HasWatchedQueries();
        movies = hasWatchedQueries.moviesGetAll();
        ObservableList cbList = FXCollections.observableList(movies);
        cbListMovies.setItems(cbList);
    }

    @FXML
    public void createHasWatchedMovie(){
        HasWatchedQueries hasWatchedQueries = new HasWatchedQueries();
        Profile profile = cbWatchedProfile.getSelectionModel().getSelectedItem();
        Account account = cbWatchedAccount.getSelectionModel().getSelectedItem();
        Movie movie = cbListMovies.getSelectionModel().getSelectedItem();
        int minutes = Integer.parseInt(minutesWatched.getText());
        int programId = movie.getProgramId();

        hasWatchedQueries.createHasWatchedMovie(profile.getProfileName(),account.getEmail(),minutes, programId);
    }

    //ADD WATCHED EPISODE
    @FXML
    public ComboBox<Profile> cbWatchedProfile1;

    @FXML
    public ComboBox<Account> cbWatchedAccount1;

    @FXML
    private TextField minutesWatched1;

    @FXML
    public ComboBox<Episode> cbListEpisodes;

    //ADD WATCH EPISODE METHODS

    @FXML
    public void refreshAccountsWatched1() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbWatchedAccount1.setItems(cbList);
    }

    @FXML
    public void refreshProfileWatched1() {
        ProfileQueries profileQueries = new ProfileQueries();
        profiles = profileQueries.getProfilesFromAccount(cbWatchedAccount1.getSelectionModel().getSelectedItem());
        ObservableList cbList = FXCollections.observableList(profiles);
        cbWatchedProfile1.setItems(cbList);
        minutesWatched.setText("");
    }

    @FXML
    public void refreshEpisodes(){
        HasWatchedQueries hasWatchedQueries = new HasWatchedQueries();
        episodes = hasWatchedQueries.episodesGetAll();
        ObservableList cbList = FXCollections.observableList(episodes);
        cbListEpisodes.setItems(cbList);
    }

    @FXML
    public void createHasWatchedEpisode(){
        HasWatchedQueries hasWatchedQueries = new HasWatchedQueries();
        Profile profile = cbWatchedProfile1.getSelectionModel().getSelectedItem();
        Account account = cbWatchedAccount1.getSelectionModel().getSelectedItem();
        Episode episode = cbListEpisodes.getSelectionModel().getSelectedItem();
        int minutes = Integer.parseInt(minutesWatched1.getText());
        int programId = episode.getProgramId();
        if (minutes <= episode.getDurationInMinutes()) {
            hasWatchedQueries.createHasWatchedEpisode(profile.getProfileName(), account.getEmail(), minutes, programId);
        } else if (minutes > episode.getDurationInMinutes()){
            new Alert(Alert.AlertType.ERROR,"Watched minutes can't be higher than the duration!");

        }
    }


    //UPDATE WATCHED MOVIE
    @FXML
    public ComboBox<Profile> cbWatchedProfile2;

    @FXML
    public ComboBox<Account> cbWatchedAccount2;

    @FXML
    public ComboBox<Movie> cbListMovies1;

    @FXML
    private TextField minutesWatched2;

    //UPDATE WATCHED MOVIE METHODS
    @FXML
    public void refreshAccountsWatched2() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbWatchedAccount2.setItems(cbList);
    }

    @FXML
    public void refreshProfileWatched2() {
        ProfileQueries profileQueries = new ProfileQueries();
        profiles = profileQueries.getProfilesFromAccount(cbWatchedAccount2.getSelectionModel().getSelectedItem());
        ObservableList cbList = FXCollections.observableList(profiles);
        cbWatchedProfile2.setItems(cbList);
        minutesWatched.setText("");
    }

    @FXML
    public void refreshMovies1(){
        HasWatchedQueries hasWatchedQueries = new HasWatchedQueries();
        movies = hasWatchedQueries.moviesGetAll();
        ObservableList cbList = FXCollections.observableList(movies);
        cbListMovies1.setItems(cbList);
    }

    @FXML
    public void updateHasWatchedMovie(){
        HasWatchedQueries hasWatchedQueries = new HasWatchedQueries();
        Profile profile = cbWatchedProfile2.getSelectionModel().getSelectedItem();
        Account account = cbWatchedAccount2.getSelectionModel().getSelectedItem();
        Movie movie = cbListMovies1.getSelectionModel().getSelectedItem();
        int minutes = Integer.parseInt(minutesWatched2.getText());
        int programId = movie.getProgramId();
        hasWatchedQueries.updateHasWatchedMovie(profile.getProfileName(),account.getEmail(),minutes, programId);
    }





    //UPDATE WATCHED EPISODE
    @FXML
    public ComboBox<Profile> cbWatchedProfile3;

    @FXML
    public ComboBox<Account> cbWatchedAccount3;

    @FXML
    public ComboBox<Episode> cbListEpisodes1;

    @FXML
    private TextField minutesWatched3;

    //UPDATE WATCHED EPISODE METHODS
    @FXML
    public void refreshAccountsWatched3() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbWatchedAccount3.setItems(cbList);
    }

    @FXML
    public void refreshProfileWatched3() {
        ProfileQueries profileQueries = new ProfileQueries();
        profiles = profileQueries.getProfilesFromAccount(cbWatchedAccount3.getSelectionModel().getSelectedItem());
        ObservableList cbList = FXCollections.observableList(profiles);
        cbWatchedProfile3.setItems(cbList);
        minutesWatched.setText("");
    }

    @FXML
    public void refreshEpisodes1(){
        HasWatchedQueries hasWatchedQueries = new HasWatchedQueries();
        episodes = hasWatchedQueries.episodesGetAll();
        ObservableList cbList = FXCollections.observableList(episodes);
        cbListEpisodes1.setItems(cbList);
    }

    @FXML
    public void updateHasWatchedEpisode(){
        HasWatchedQueries hasWatchedQueries = new HasWatchedQueries();
        Profile profile = cbWatchedProfile3.getSelectionModel().getSelectedItem();
        Account account = cbWatchedAccount3.getSelectionModel().getSelectedItem();
        Episode episode = cbListEpisodes1.getSelectionModel().getSelectedItem();
        int minutes = Integer.parseInt(minutesWatched3.getText());
        int programId = episode.getProgramId();

        if (minutes <= episode.getDurationInMinutes()) {
            hasWatchedQueries.updateHasWatchedEpisode(profile.getProfileName(), account.getEmail(), minutes, programId);
        } else if (minutes > episode.getDurationInMinutes()){
            new Alert(Alert.AlertType.ERROR,"Watched minutes can't be higher than the duration!");
        }
    }






}
