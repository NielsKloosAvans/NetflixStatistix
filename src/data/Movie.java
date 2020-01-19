package data;

public class Movie extends Program {
    private int programId;

    public Movie(String title, String genre, String language, int length, int ageRating, int programId) {
        super(title, genre, language, ageRating);
        this.programId = programId;
    }



    public int getProgramId() {
        return programId;
    }

    @Override
    public String toString() {
        return "Movie: " + getTitle() + "\n";
    }
}
