package data;

public class Episode {
    private String episodeTitle;
    private int episodeNumber;
    private int seasonNumber;
    private int durationInMinutes;
    private int percentageWatched;

    public Episode(String episodeTitle, int episodeNumber, int seasonNumber, int durationInMinutes, int percentageWatched){
        if (episodeNumber <= 0 || seasonNumber <= 0 || durationInMinutes <= 0 || percentageWatched <= 0){
            throw new IllegalArgumentException();
        }
        this.episodeTitle = episodeTitle;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
        this.durationInMinutes = durationInMinutes;
        this.percentageWatched = percentageWatched;
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
        return durationInMinutes;
    }

    public int getPercentageWatched() {
        return percentageWatched;
    }
}
