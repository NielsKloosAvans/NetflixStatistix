package data;

public class Series extends Program {
    private int numberOfSeasons;
    private String youMayLike;
    private int seriesId;

    public Series(int seriesId, String title, String genre, String language, int ageRating, int numberOfSeasons, String youMayLike) {
        super(title, genre, language, ageRating);
        this.numberOfSeasons = numberOfSeasons;
        this.youMayLike = youMayLike;
        this.seriesId = seriesId;
    }

    public Series(String title, String genre, String language, int ageRating, int seriesId) {
        super(title, genre, language, ageRating);
        this.seriesId = seriesId;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public String getYouMayLike() {
        return youMayLike;
    }

    public int getSeriesId() {
        return seriesId;
    }

    @Override
    public String toString() {
        return "Series title: " + super.getTitle();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }


}
