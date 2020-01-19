package logic;

import data.Account;
import data.Serie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SerieQueries {
    private DBconnection database = new DBconnection();

    /*(public List<Serie> getAll(){
        ArrayList<Serie> series = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Series");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String seriesid = rs.getString("SeriesId");
                String name = rs.getString("SeriesName");
                int agerating = rs.getInt("AgeRating");
                String language = rs.getString("Language");
                String genre = rs.getString("Genre");
                String youmaylike = rs.getString("YouMayLike");
                series.add(new Serie(seriesid,name,agerating,language,genre,youmaylike));
            }

            con.close();
        } catch (SQLException e){
            System.out.println("Error while getting all accounts.");
        }
        return series;
    }
    */


}
