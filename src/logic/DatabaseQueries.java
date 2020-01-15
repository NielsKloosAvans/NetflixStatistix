package logic;

public class DatabaseQueries {
    public  String createAccount(String account){
        return "INSERT INTO Account(Email, Name, passwe, Adres, Woonplaats) VALUES";
    }
    public String deleteAccount(String account){
        return "DELETE FROM Account WHERE AccountName = '" + account + "';";
    }
}
