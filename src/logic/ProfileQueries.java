package logic;

import data.Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfileQueries {
    private DBconnection database = new DBconnection();

    public boolean createProfile(String profileName, String email, int age) {
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("INSERT INTO Profile (ProfileName, email, age) VALUES(?);");
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
}
