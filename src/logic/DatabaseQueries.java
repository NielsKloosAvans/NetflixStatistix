package logic;

public class DatabaseQueries {
    public String createAccount(String email, String name, String password, String address, String city) {
        return "INSERT INTO Account(Email, Name, Password, Address, City) VALUES('" + email + "', '" + name + "', '" + password + "', '" + address + "', '" + city + "');";
    }

    public String deleteAccount(String email) {
        return "DELETE FROM Account WHERE Email = '" + email + "';";
    }

    public String createProfile(String profileName, String email, int age) {
        return "INSERT INTO Profile(ProfileName, Email, Age) VALUES('" + profileName + "', '" + email + "', " + age + ");";
    }

    public String deleteProfile(String email, String profileName) {
        return "DELETE FROM Profile WHERE Email = '" + email + "' AND ProfileName = '" + profileName + "';";
    }

    public String createWatched(String profileName, int programId, int minutesWatched, String email) {
        return "INSERT INTO HasWatched(ProfileName, ProgramId, MinutesWatched, Email) VALUES('" + profileName + "', " + programId + ", " + minutesWatched + ", '" + email +  "');";
    }
    public String deleteWatched(String profileName, int programId, String email ){
        return "DELETE FROM HasWatched WHERE ProfileName = '" + profileName + "' AND ProgramId = " + programId + " AND Email = '" + email + "';";
    }

}
