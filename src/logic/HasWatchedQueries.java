package logic;

import data.Episode;
import data.Movie;
import data.Profile;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HasWatchedQueries {
    DBconnection database = new DBconnection();

    public boolean createHasWatchedMovie(String profileName, String email, int minutesWatched, int programId) {
        boolean result = false;
        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("INSERT INTO HasWatched(ProfileName,ProgramId,MinutesWatched, Email) VALUES(?,?,?,?)");
            statement.setString(1, profileName);
            statement.setInt(2, programId);
            statement.setInt(3, minutesWatched);
            statement.setString(4, email);
            statement.execute();
            result = true;
            new Alert(Alert.AlertType.CONFIRMATION,"Successfully added watched movie for profile: " + profileName).show();
            con.close();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Error while creating has watched movie.").show();
        }
        return result;
    }

    public boolean createHasWatchedEpisode(String profileName, String email, int minutesWatched, int programId) {
        boolean result = false;
        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("INSERT INTO HasWatched(ProfileName,ProgramId,MinutesWatched, Email) VALUES(?,?,?,?)");
            statement.setString(1, profileName);
            statement.setInt(2, programId);
            statement.setInt(3, minutesWatched);
            statement.setString(4, email);
            statement.execute();
            result = true;
            new Alert(Alert.AlertType.CONFIRMATION,"Successfully added watched episode for profile: " + profileName).show();
            con.close();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Error while creating has watched episode.").show();
        }
        return result;
    }

    public boolean updateHasWatchedMovie(String profileName, String email, int minutesWatched, int programId) {
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("UPDATE HasWatched SET MinutesWatched = ? WHERE Email = ? AND ProfileName = ? AND  ProgramId = ?;");
            statement.setInt(1, minutesWatched);
            statement.setString(2, email);
            statement.setString(3, profileName);
            statement.setInt(4, programId);
            statement.execute();
            result = true;
            new Alert(Alert.AlertType.CONFIRMATION,"Successfully updated watched movie for profile: " + profileName).show();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error while updating has watched.");
        }
        return result;
    }


    public boolean updateHasWatchedEpisode(String profileName, String email, int minutesWatched, int programId) {
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("UPDATE HasWatched SET MinutesWatched = ? WHERE Email = ? AND ProfileName = ? AND ProgramId = ?;");
            statement.setInt(1, minutesWatched);
            statement.setString(2, email);
            statement.setString(3, profileName);
            statement.setInt(4, programId);
            statement.execute();
            result = true;
            new Alert(Alert.AlertType.CONFIRMATION,"Successfully updated watched episodes for profile: " + profileName).show();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error while updating has watched.");
        }
        return result;
    }

    public boolean removeHasWatched(Profile profile) {
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("DELETE FROM HasWatched WHERE ProfileName = ? AND Email = ? ");
            statement.setString(1, profile.getProfileName());
            statement.setString(2, profile.getEmail());
            statement.execute();
            result = true;
            con.close();
        } catch (SQLException e) {
            System.out.println("Error while deleting has watched");
        }
        return result;
    }

    public List<Episode> episodesGetAll(){
        ArrayList<Episode> episodes = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Episode");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String episodeTitle = rs.getString("EpisodeName");
                int episodeNumber = rs.getInt("Episode");
                int seasonNumber = rs.getInt("Season");
                int length = rs.getInt("Length");
                int programId = rs.getInt("ProgramId");

                episodes.add(new Episode(episodeTitle,episodeNumber,seasonNumber,length, programId));
            }
            con.close();
        } catch (SQLException e){
            System.out.println("Error while getting all episodes.");
        }

        return episodes;
    }

    public List<Movie> moviesGetAll(){
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Movie");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String title = rs.getString("MovieName");
                String genre = rs.getString("Genre");
                String language = rs.getString("Language");
                int length = rs.getInt("Length");
                int ageRating = rs.getInt("AgeRating");
                int programId = rs.getInt("ProgramId");

                movies.add(new Movie(title,genre,language,length,ageRating, programId));
            }
            con.close();
        } catch (SQLException e){
            System.out.println("Error while getting all movies.");
        }
        return movies;
    }
}

