package logic;

import data.Movie;
import data.Program;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountWhichMovie {
    DBconnection database = new DBconnection();

    public List<Movie> getAll(String email) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT Account.Email,  Movie.MovieName\n" +
                    "FROM Account\n" +
                    "INNER JOIN HasWatched on HasWatched.Email = Account.Email\n" +
                    "INNER JOIN Movie on Movie.ProgramId = HasWatched.ProgramId WHERE Account.Email = '" + email + "'\n" +
                    "GROUP BY Account.Email, Account.Name, Movie.MovieName");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String movieName = rs.getString("MovieName");
                String genre = rs.getString("Genre");
                String language = rs.getString("Language");
                int length = rs.getInt("Length");
                int ageRating = rs.getInt("AgeRating");
                int programId = rs.getInt("ProgramId");
                movies.add(new Movie(movieName, genre, language, length, ageRating, programId));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error while getting movies.");
        }

        return movies;
    }
}
