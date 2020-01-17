package logic;

import data.Account;
import data.Profile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountOneProfile {
    DBconnection database = new DBconnection();

    public List<Account> getAll() {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<Profile> profiles = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT Account.Name as 'Account Name', COUNT(Profile.ProfileName) as 'No. of profiles'\n" +
                    "FROM Account\n" +
                    "INNER JOIN Profile ON Profile.Email = Account.Email\n" +
                    "GROUP BY Account.Name\n" +
                    "HAVING COUNT(Profile.ProfileName) = 1;");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String email = rs.getString("Email");
                String name = rs.getString("Name");
                String password = rs.getString("Password");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                String profileName = rs.getString("ProfileName");
                int age = rs.getInt("Age");
                profiles.add(new Profile(profileName, age, email));
                accounts.add(new Account(email, profiles, name, password, address, city));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error while getting accounts");
        }
        return accounts;
    }
}
