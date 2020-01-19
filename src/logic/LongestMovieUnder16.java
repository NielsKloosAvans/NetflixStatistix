package logic;

import data.Movie;

import java.sql.*;

public class LongestMovieUnder16 {
    private DBconnection database = new DBconnection();

    public Movie get() {
        String movie = "";
        String genre = "";
        String language = "";
        int length = 0;
        int ageRating = 0;
        int durationInMinutes = 0;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT MAX(Movie.Length) as 'Longest movie' FROM MOVIE WHERE AgeRating < 16");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                movie = rs.getString("Movie");
                genre = rs.getString("Genre");
                language = rs.getString("Language");
                length = rs.getInt("Length");
                ageRating = rs.getInt("AgeRating");
                durationInMinutes = rs.getInt("DurationInMinutes");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error while getting movie.");
        }
        return new Movie(movie, genre, language, length, ageRating);
    }
}
