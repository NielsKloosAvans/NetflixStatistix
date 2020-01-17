package logic;

import data.Episode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EpisodeAverageWatchedSeries {
    DBconnection database = new DBconnection();

    public List<Episode> episodeGetPercentage(int seriesId) {
        ArrayList<Episode> episodes = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(database.getConnectionUrl());
            PreparedStatement statement = con.prepareStatement("SELECT Series.SeriesName, Episode.EpisodeName, ROUND(((CAST(AVG(MinutesWatched) AS NUMERIC(6,2))/Episode.Length) * 100),2) as 'Percentage bekeken'\n" +
                    "FROM HasWatched\n" +
                    "RIGHT JOIN Episode ON Episode.ProgramId = HasWatched.ProgramId\n" +
                    "INNER JOIN Series ON Episode.SeriesId = Series.SeriesId\n" +
                    "WHERE Series.SeriesId = '" + seriesId + "' \n" +
                    "GROUP BY HasWatched.ProgramId, EpisodeName, SeriesName, Episode.Length, Episode.ProgramId\n" +
                    "ORDER BY SeriesName");

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String episodeTitle = rs.getString("EpisodeTitle");
                int episodeNumber = rs.getInt("EpisodeNumber");
                int seasonNumber = rs.getInt("SeasonNumber");
                int durationInMinutes = rs.getInt("DurationInMinutes");
                int percentageWatched = rs.getInt("PercentageWatched");
                episodes.add(new Episode(episodeTitle, episodeNumber, seasonNumber, durationInMinutes, percentageWatched));

            }

            con.close();
        } catch (SQLException e){
            System.out.println("Error while getting percentage.");
        }

        return episodes;
    }
}
