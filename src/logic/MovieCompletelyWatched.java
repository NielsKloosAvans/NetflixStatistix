package logic;

import java.sql.*;

public class MovieCompletelyWatched {
    private DBconnection database = new DBconnection();

    public int Movie(int programId) {
        int amount = 0;
        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT Movie.MovieName, COUNT(HasWatched.ProfileName) as 'TimesFullyWatched' FROM Movie\n" +
                    "INNER JOIN HasWatched ON HasWatched.ProgramId = Movie.ProgramId\n" +
                    "WHERE Movie.Length = HasWatched.MinutesWatched AND Movie.ProgramId = '" + programId + "'\n" +
                    "GROUP BY Movie.MovieName");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                amount = rs.getInt("TimesFullyWatched");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error while getting ");
        }
        return amount;
    }
}
