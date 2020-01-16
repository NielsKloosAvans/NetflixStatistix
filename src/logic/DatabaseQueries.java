package logic;

import data.Account;

public class DatabaseQueries {
    public String createAccount(String email, String name, String password, String address, String city) {
        return "INSERT INTO Account(Email, Name, Password, Address, City) VALUES('" + email + "', '" + name + "', '" + password + "', '" + address + "', '" + city + "');";
    }

    public String deleteAccount(String email) {
        return "DELETE FROM Account WHERE Email = '" + email + "';";
    }

    public String updateAccount(String email, String newEmail, String newName, String newPassword, String newAddress, String newCity) {
        String updateAccount = "UPDATE Account SET ";
        if (!newEmail.isEmpty()) {
            updateAccount += "Email = " + "'" + newEmail + "'";
            if (!newName.isEmpty() || !newPassword.isEmpty() || !newAddress.isEmpty() || !newCity.isEmpty()) {
                updateAccount += ",";
            }
        }
        if (!newName.isEmpty()) {
            updateAccount += "Name = " + "'" + newName + "'";
            if (!newPassword.isEmpty() || !newAddress.isEmpty() || !newCity.isEmpty()) {
                updateAccount += ",";
            }
        }
        if (!newPassword.isEmpty()) {
            updateAccount += "Password = " + "'" + newPassword + "'";
            if (!newAddress.isEmpty() || !newCity.isEmpty()) {
                updateAccount += ",";
            }
        }
        if (!newAddress.isEmpty()) {
            updateAccount += "Address = " + "'" + newAddress + "'";
            if (!newCity.isEmpty()) {
                updateAccount += ",";
            }
        }
        if (!newCity.isEmpty()) {
            updateAccount += "City = " + "'" + newCity + "'";
        }
        updateAccount += " WHERE Email = '" + email + "';";
        return updateAccount;
    }

    public String createProfile(String profileName, String email, int age) {
        return "INSERT INTO Profile(ProfileName, Email, Age) VALUES('" + profileName + "', '" + email + "', " + age + ");";
    }

    public String deleteProfile(String email, String profileName) {
        return "DELETE FROM Profile WHERE Email = '" + email + "' AND ProfileName = '" + profileName + "';";
    }

    public String updateProfile(String profileName, String newProfileName, String email, int newAge) {
        String updateProfile = "UPDATE Profile SET ";
        if (!newProfileName.isEmpty()) {
            updateProfile += "ProfileName = " + "'" + newProfileName + "'";
            if (newAge != 0) {
                updateProfile += ",";
            }
        }
        if (newAge != 0) {
            updateProfile += "Age = " + "'" + newAge + "'";
        }
        updateProfile += " WHERE Email = '" + email + "' AND ProfileName = '" + profileName + "';";
        return updateProfile;
    }

    public String createWatched(String profileName, int programId, int minutesWatched, String email) {
        return "INSERT INTO HasWatched(ProfileName, ProgramId, MinutesWatched, Email) VALUES('" + profileName + "', " + programId + ", " + minutesWatched + ", '" + email + "');";
    }

    public String deleteWatched(String profileName, int programId, String email) {
        return "DELETE FROM HasWatched WHERE ProfileName = '" + profileName + "' AND ProgramId = " + programId + " AND Email = '" + email + "';";
    }

    public String updateWatched(String profileName, String email, int newMinutesWatched, int programId) {
        return "UPDATE HasWatched SET MinutesWatched = " + newMinutesWatched + " WHERE ProfileName = '" + profileName + "' AND Email = '" + email + "' AND ProgramId = " + programId + ";";
    }

    public String percentageWatched() {
        return "SELECT Series.SeriesName, Episode.EpisodeName,  AVG(MinutesWatched) as 'Gemiddeld aantal minuten bekeken', Episode.ProgramId, Episode.Length, ROUND(((CAST(AVG(MinutesWatched) AS NUMERIC(6,2))/Episode.Length) * 100),2) as 'Percentage bekeken'\n" +
                "FROM HasWatched\n" +
                "RIGHT JOIN Episode ON Episode.ProgramId = HasWatched.ProgramId\n" +
                "INNER JOIN Series ON Episode.SeriesId = Series.SeriesId\n" +
                "WHERE Series.SeriesId = 1 \n" +
                "GROUP BY HasWatched.ProgramId, EpisodeName, SeriesName, Episode.Length, Episode.ProgramId\n" +
                "ORDER BY SeriesName\n";
    }

    public String movieLongestUnder16() {
        return "SELECT MAX(Movie.Length) as 'Longest movie'\n" +
                "FROM MOVIE\n" +
                "WHERE AgeRating < 16";
    }

    public String accountMovieWatched(String email) {
        return "SELECT '" + email + "', Movie.MovieName\n" +
                "FROM Account\n" +
                "INNER JOIN HasWatched on HasWatched.Email = Account.Email\n" +
                "INNER JOIN Movie on Movie.ProgramId = HasWatched.ProgramId\n" +
                "GROUP BY Account.Email, Account.Name, Movie.MovieName";
    }

    public String accountOneProfile() {
        return "SELECT Account.Name as 'Account Name', COUNT(Profile.ProfileName) as 'No. of profiles'\n" +
                "FROM Account\n" +
                "INNER JOIN Profile ON Profile.Email = Account.Email\n" +
                "GROUP BY Account.Name\n" +
                "HAVING COUNT(Profile.ProfileName) = 1";
    }

    public String movieCompletelyWatched(String movie) {
        return "SELECT '" + movie + "'," + "COUNT(HasWatched.ProfileName) as 'Times fully watched' FROM Movie\n" +
                "INNER JOIN HasWatched ON HasWatched.ProgramId = Movie.ProgramId\n" +
                "WHERE Movie.Length = HasWatched.MinutesWatched\n" +
                "GROUP BY Movie.MovieName";
    }

    public String averageWatchedEpisode(String email, int seriesId) {
        return "SELECT Series.SeriesName, Episode.EpisodeName, ROUND(((CAST(AVG(MinutesWatched) AS NUMERIC(6,2))/Episode.Length) * 100),2) as 'Percentage bekeken'\n" +
                "FROM Account\n" +
                "INNER JOIN HasWatched ON HasWatched.Email = Account.Email\n" +
                "RIGHT JOIN Episode ON Episode.ProgramId = HasWatched.ProgramId\n" +
                "INNER JOIN Series ON Episode.SeriesId = Series.SeriesId\n" +
                "WHERE Series.SeriesId = '" + seriesId + "' AND Account.Email = '" + email + "' \n" +
                "GROUP BY HasWatched.ProgramId, EpisodeName, SeriesName, Episode.Length, Episode.ProgramId\n" +
                "ORDER BY SeriesName";
    }

}
