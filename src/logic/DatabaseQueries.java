package logic;

public class DatabaseQueries {
    public String createAccount(String email, String name, String password, String address, String city){
        return "INSERT INTO Account(Email, Name, Password, Address, City) VALUES('" + email + "', '" + name +  "', '"  + password + "', '" + address + "', '" + city + "');";
    }
    public String deleteAccount(String email){
        return "DELETE FROM Account WHERE Email = '" + email + "';";
    }

}
