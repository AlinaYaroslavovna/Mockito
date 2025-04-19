import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<String> movies; // Список фильмов
    private int limit; // Лимит на количество последних фильмов

    // Конструктор по умолчанию, устанавливающий лимит в 5
    public MovieManager() {
        this.movies = new ArrayList<>();
        this.limit = 5;
    }

    // Конструктор с параметром для установки лимита
    public MovieManager(int limit) {
        this.movies = new ArrayList<>();
        this.limit = limit;
    }

    // Метод для добавления нового фильма
    public void addMovie(String movie) {
        movies.add(movie);
    }

    // Метод для получения всех фильмов
    public List<String> findAll() {
        return new ArrayList<>(movies);
    }

    // Метод для получения последних добавленных фильмов
    public List<String> findLast() {
        int resultLength = Math.min(limit, movies.size());
        List<String> result = new ArrayList<>(resultLength);

        for (int i = 0; i < resultLength; i++) {
            result.add(movies.get(movies.size() - 1 - i));
        }

        return result;
    }
}
