public class MovieManager {
    private String[] movies;
    private int limit;

    public MovieManager() {
        this.limit = 5; // По умолчанию лимит 5
        this.movies = new String[0]; // Изначально массив пустой
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new String[0]; // Изначально массив пустой
    }

    public void addMovie(String movie) {
        String[] newMovies = new String[movies.length + 1];
        System.arraycopy(movies, 0, newMovies, 0, movies.length);
        newMovies[newMovies.length - 1] = movie;
        movies = newMovies;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultLength = Math.min(movies.length, limit);
        String[] result = new String[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i]; // Заполнение в обратном порядке
        }

        return result;
    }
}
