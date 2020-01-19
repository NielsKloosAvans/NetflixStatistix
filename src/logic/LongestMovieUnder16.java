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
        int programId = 0;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT MAX(Movie.Length) as 'LongestMovie'," +
                    "MovieName, Genre, ProgramId, AgeRating, [Language] FROM MOVIE WHERE AgeRating < 16\n" +
                    "GROUP BY Genre, ProgramId, AgeRating, [Language], MovieName");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                length = rs.getInt("LongestMovie");
                movie = rs.getString("MovieName");
                genre = rs.getString("Genre");
                programId = rs.getInt("ProgramId");
                ageRating = rs.getInt("AgeRating");
                language = rs.getString("Language");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error while getting movie.");
        }
        return new Movie(movie, genre, language, length, ageRating, programId);
    }
}
