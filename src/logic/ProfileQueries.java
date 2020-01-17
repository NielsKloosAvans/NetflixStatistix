package logic;

import data.Account;
import data.Profile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileQueries {
    private DBconnection database = new DBconnection();

    public boolean createProfile(String profileName, int age) {
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("INSERT INTO Profile (ProfileName, age) VALUES(?,?);");
            statement.setString(1, profileName);
=            statement.setInt(2, age);
            statement.execute();
            result = true;
            con.close();
        } catch (SQLException e) {
            System.out.println("Error while creating profile. ");
        }
        return result;
    }

    public boolean updateProfile(Profile profile) {
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("UPDATE Account SET ProfileName = ?, Email = ?, Age = ? WHERE ProfileName = ? AND Email = ?;");
            statement.setString(1, profile.getProfileName());
            statement.setString(2, profile.getEmail());
            statement.setInt(3, profile.getAge());
            statement.execute();
            result = true;
            con.close();
        } catch (SQLException e) {
            System.out.println("Error while updating profile.");
        }
        return result;
    }

    public boolean removeProfile(Profile profile) {
        boolean result = false;
        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("DELETE FROM Profile WHERE ProfileName = ? AND Email = ?;");
            statement.setString(1, profile.getProfileName());
            statement.setString(2, profile.getEmail());
            statement.execute();
            result = true;
            con.close();
        } catch (SQLException e){
            System.out.println("Error while removing profile.");
        }
        return result;
    }

    public List<Profile> getAll(){
        ArrayList<Profile> profiles = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Profile");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                int age = rs.getInt("Age");
                profiles.add(new Profile(name, age, email));
            }

            con.close();
        } catch (SQLException e){
            System.out.println("Error while getting all accounts.");
        }
        return profiles;
    }

}
