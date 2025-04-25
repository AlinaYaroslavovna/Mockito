// Файл: Movie.java
public class Movie {
public MovieManager MovieManager = new MovieManager(

);

    private String title;


    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Movie movie = (Movie) obj;
        return title.equals(movie.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
