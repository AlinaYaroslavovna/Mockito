import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {
    private MovieManager manager;

    @BeforeEach
    public void setUp() {
        manager = new MovieManager();
    }

    @Test
    public void testAddMovie() {
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");

        List<String> allMovies = manager.findAll();
        assertEquals(2, allMovies.size());
        assertEquals("Film 1", allMovies.get(0));
        assertEquals("Film 2", allMovies.get(1));
    }

    @Test
    public void testFindAll() {
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");

        List<String> allMovies = manager.findAll();
        assertEquals(List.of("Film 1", "Film 2"), allMovies);
    }

    @Test
    public void testFindLastWithDefaultLimit() {
        for (int i = 1; i <= 10; i++) {
            manager.addMovie("Film " + i);
        }

        List<String> lastMovies = manager.findLast();
        assertEquals(5, lastMovies.size());
        assertEquals(List.of("Film 10", "Film 9", "Film 8", "Film 7", "Film 6"), lastMovies);
    }

    @Test
    public void testFindLastWithCustomLimit() {
        MovieManager customManager = new MovieManager(3);
        for (int i = 1; i <= 5; i++) {
            customManager.addMovie("Film " + i);
        }

        List<String> lastMovies = customManager.findLast();
        assertEquals(3, lastMovies.size());
        assertEquals(List.of("Film 5", "Film 4", "Film 3"), lastMovies);
    }

    @Test
    public void testFindLastWhenLessThanLimit() {
        for (int i = 1; i <= 2; i++) {
            manager.addMovie("Film " + i);
        }

        List<String> lastMovies = manager.findLast();
        assertEquals(2, lastMovies.size());
        assertEquals(List.of("Film 2", "Film 1"), lastMovies);
    }

    @Test
    public void testFindLastWithEmptyManager() {
        List<String> lastMovies = manager.findLast();
        assertEquals(0, lastMovies.size());
    }
}
