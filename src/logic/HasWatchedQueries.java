package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HasWatchedQueries {
    DBconnection database = new DBconnection();

    public boolean createHasWatched(String profileName, String email, int minutesWatched, int programId) {
        boolean result = false;

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("INSERT INTO HasWatched(ProfileName,Email,MinutesWatched,ProgramId VALUES(?,?,?,?)");
            statement.setString(1, profileName);
            statement.setString(2, email);
            statement.setInt(3, minutesWatched);
            statement.setInt(4, programId);
            statement.execute();
            result = true;
            con.close();
        } catch (SQLException e) {
            System.out.println("Error while creating has watched.");
        }
        return result;
    }
    public boolean updateHasWatched(){
        return false;
    }
}

