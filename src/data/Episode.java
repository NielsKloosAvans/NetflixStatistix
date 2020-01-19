package data;

public class Episode {
    private String episodeTitle;
    private int episodeNumber;
    private int seasonNumber;
    private int length;
    private int programId;
    private int percentageWatched;
    private String seriesName;


    public Episode(String episodeTitle, int episodeNumber, int seasonNumber, int durationInMinutes, int programId) {
        if (episodeNumber <= 0 || seasonNumber <= 0 || durationInMinutes <= 0) {
            throw new IllegalArgumentException();
        }
        this.episodeTitle = episodeTitle;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
        this.length = durationInMinutes;
        this.programId = programId;
    }

    public Episode(String episodeTitle, int percentageWatched, int length) {
        this.episodeTitle = episodeTitle;
        this.percentageWatched = percentageWatched;
        this.length = length;
    }

    public Episode(String seriesName, String episodeName, int percentageWatched) {
        this.seriesName = seriesName;
        this.episodeTitle = episodeName;
        this.percentageWatched = percentageWatched;
    }

    public int getPercentageWatched() {
        return percentageWatched;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getDurationInMinutes() {
        return length;
    }


    public int getProgramId() {
        return programId;
    }

    @Override
    public String toString() {
        return "Episode Name: " + episodeTitle + "\n" +
                "Duration: " + length + " minutes\n";
    }
}


