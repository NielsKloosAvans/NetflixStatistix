package logic;

import data.Account;
import data.Profile;
import javafx.scene.control.PasswordField;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement statement = con.prepareStatement("UPDATE Account SET Name = ?, Password = ?, Address = ?, City = ? WHERE Email = ?;");
            statement.setString(1, account.getName());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getAddress());
            statement.setString(4, account.getCity());
            statement.setString(5, account.getEmail());
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


    public boolean loginAccount(String email, String password){
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT * FROM ACCOUNT WHERE Email = '" + email + "' AND Password ='" + password + "'");
            ResultSet rs = statement.executeQuery();
            if (!rs.next()){
                System.out.println("Logged in");
            } else {
                statement.execute();
                result = true;
            }
            con.close();
        } catch (SQLException e){
            System.out.println("Error while logging in.");
        }

        return result;
    }

    public List<Account> getAll(){
        ArrayList<Account> accounts = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT * FROM ACCOUNT");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String email = rs.getString("Email");
                String name = rs.getString("Name");
                String password = rs.getString("Password");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                accounts.add(new Account(email,name,password,address,city));
            }

            con.close();
        } catch (SQLException e){
            System.out.println("Error while getting all accounts.");
        }
        return accounts;
    }


    public List<Account> getEmail(){
        ArrayList<Account> accountEmail = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT Email FROM ACCOUNT");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String email = rs.getString("Email");
                accountEmail.add(new Account(email));
            }

            con.close();
        } catch (SQLException e){
            System.out.println("Error while getting all accounts.");
        }
        return accountEmail;
    }


}
