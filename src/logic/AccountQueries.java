package logic;

import data.Account;
import data.Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountQueries {
    private DBconnection database = new DBconnection();

    public boolean createAccount(String name, String email, String password, String address,String city) {
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("INSERT INTO Account (Email, Name, Password, Address, City) VALUES(?,?,?,?,?);");
            statement.setString(1, email);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setString(4, address);
            statement.setString(5, city);
            statement.execute();
            result = true;
            con.close();
        } catch (SQLException e) {
            System.out.println("Error while creating account");
        }
        return result;
    }

    public boolean updateAccount(Account account) {
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("UPDATE Account SET Email = ?, Name = ?, Password = ?, Address = ?, City = ? WHERE Email = ?;");
            statement.setString(1, account.getEmail());
            statement.setString(2, account.getName());
            statement.setString(3, account.getPassword());
            statement.setString(4, account.getAddress());
            statement.setString(5, account.getCity());
            statement.execute();
            result = true;
            con.close();
        } catch (SQLException e){
            System.out.println("Error while updating account.");
        }

        return result;
    }
    public boolean deleteAccount(Account account){
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("DELETE FROM Account WHERE Email = ?;");
            statement.setString(1, account.getEmail());
            statement.execute();
            result = true;
            con.close();
        } catch (SQLException e){
            System.out.println("Error while deleting account.");
        }

        return result;
    }
}
