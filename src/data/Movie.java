package data;

public class Movie extends Program {
    private int durationInMinutes;


    public Movie(String title, String genre, String language, int length, int ageRating, int durationInMinutes) {
        super(title, genre, language, length, ageRating);
        this.durationInMinutes = durationInMinutes;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
