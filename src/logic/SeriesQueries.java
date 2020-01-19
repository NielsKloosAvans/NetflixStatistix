package logic;

import data.Account;
import data.Series;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeriesQueries {
    private DBconnection database = new DBconnection();

    public List<Series> getAll(){
        ArrayList<Series> series = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Series");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                int seriesId = rs.getInt("SeriesId");
                String seriesName = rs.getString("SeriesName");
                int ageRating = rs.getInt("AgeRating");
                String language = rs.getString("Language");
                String genre = rs.getString("Genre");
                series.add(new Series(seriesName, genre, language, ageRating, seriesId));
            }

            con.close();
        } catch (SQLException e){
            System.out.println("Error while getting all accounts.");
        }
        return series;
    }



}
