package data;

public class Series extends Program {

    private int durationInMinutes;
    private int numberOfSeasons;
    private String youMayLike;

    public Series(String title, String genre, String language, int length, int ageRating, int durationInMinutes, int numberOfSeasons, String youMayLike) {
        super(title, genre, language, length, ageRating);
        this.durationInMinutes = durationInMinutes;
        this.numberOfSeasons = numberOfSeasons;
        this.youMayLike = youMayLike;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public String getYouMayLike() {
        return youMayLike;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
