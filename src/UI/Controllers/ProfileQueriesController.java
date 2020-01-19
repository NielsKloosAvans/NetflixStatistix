package UI.Controllers;

import data.Account;
import data.Episode;
import data.Series;
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
import logic.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileQueriesController {

    @FXML
    private List<Account> accounts;

    @FXML
    private ComboBox<Series> cbSeries;

    @FXML
    private ComboBox<Account> cbAccount;

    @FXML
    private ComboBox<Account> cbAccountWatched;

    @FXML
    private ComboBox<Series> cbSeriesAccount;

    @FXML
    public List<Series> series;

    @FXML
    public List<Episode> episodes;

    @FXML
    public void refreshAccount() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbAccount.setItems(cbList);
    }

    @FXML
    public void refreshAccountWatched() {
        AccountQueries account = new AccountQueries();
        accounts = account.getAll();
        ObservableList cbList = FXCollections.observableList(accounts);
        cbAccountWatched.setItems(cbList);
    }


    @FXML
    public void refreshCbSeries() {
        SeriesQueries seriesQueries = new SeriesQueries();
        series = seriesQueries.getAll();
        ObservableList<Series> cbList = FXCollections.observableList(series);
        cbSeries.setItems(cbList);
    }

    @FXML
    public void refreshCbSeriesAccount() {
        SeriesQueries seriesQueries = new SeriesQueries();
        series = seriesQueries.getAll();
        ObservableList<Series> cbList = FXCollections.observableList(series);
        cbSeriesAccount.setItems(cbList);
    }

    @FXML
    public void showWatchedSeries(){
        EpisodeAverageWatchedSeries episodeAverageWatchedSeries = new EpisodeAverageWatchedSeries();
        Series series = cbSeries.getSelectionModel().getSelectedItem();
        episodes = episodeAverageWatchedSeries.episodeGetPercentage(series);
        for(Episode episode : episodes) {
            System.out.println(episode + "Percentage Watched: " + episode.getPercentageWatched() + "% \n");
        }

    }

    @FXML
    public void showWatchedSeriesAccount(){
        EpisodeAverageWatched episodeAverageWatched = new EpisodeAverageWatched();
        Series series = cbSeriesAccount.getSelectionModel().getSelectedItem();
        Account account = cbAccountWatched.getSelectionModel().getSelectedItem();
        episodes = episodeAverageWatched.episodeGetPercentage(series, account);
        for(Episode episode :episodes) {
            System.out.println(episode + "Percentage Watched: " + episode.getPercentageWatched() + "% \n");
        }
    }


    @FXML
    private void showAccountOverview(ActionEvent event) throws IOException {
        Parent newView = FXMLLoader.load(getClass().getResource("AccountView.fxml"));

        Scene newScene = new Scene(newView);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void showLongestMovieUnder16 (){
        LongestMovieUnder16 longestMovieUnder16 = new LongestMovieUnder16();
        System.out.println(longestMovieUnder16.get());
    }

}
