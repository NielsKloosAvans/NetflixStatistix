package data;

public abstract class Program {
    private String title;
    private String genre;
    private String language;
    private int length;
    private int ageRating;


    public Program(String title, String genre, String language, int length, int ageRating) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.length = length;
        this.ageRating = ageRating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public int getLength() {
        return length;
    }

    public int getAgeRating() {
        return ageRating;
    }

    @Override
    public String toString() {
        return "Program title: " + this.title;
    }
}
