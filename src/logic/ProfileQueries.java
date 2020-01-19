package logic;

import data.Account;
import data.Profile;
import javafx.scene.control.ComboBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileQueries {
    private DBconnection database = new DBconnection();

    public boolean createProfile(Profile profile) {
        boolean result = false;
        String profileName = profile.getProfileName();
        String email = profile.getEmail();
        int age = profile.getAge();

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("INSERT INTO Profile (ProfileName, email, age) VALUES(?,?,?);");
            statement.setString(1, profileName);
            statement.setString(2, email);
            statement.setInt(3, age);
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
            PreparedStatement statement = con.prepareStatement("UPDATE Profile SET Age = ? WHERE ProfileName = ? AND Email = ?;");
            statement.setInt(1, profile.getAge());
            statement.setString(2, profile.getProfileName());
            statement.setString(3, profile.getEmail());

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

    public List<Profile> getProfilesFromAccount(Account account){
        ArrayList<Profile> profiles = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Profile WHERE Email ='" + account.getEmail() + "'");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String profileName = rs.getString("ProfileName");
                String email = rs.getString("Email");
                int age = rs.getInt("Age");
                profiles.add(new Profile(profileName, age, email));
            }

            con.close();
        } catch (SQLException e){
            System.out.println("Error while getting all profiles.");
        }
        return profiles;
    }



}
