import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager;

    @BeforeEach
    public void setUp() {
        manager = new MovieManager();
    }

    @Test
    public void testAddMovie() {
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        assertArrayEquals(new String[]{"Movie 1", "Movie 2"}, manager.findAll());
    }

    @Test
    public void testFindLastWithDefaultLimit() {
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        assertArrayEquals(new String[]{"Movie 3", "Movie 2", "Movie 1"}, manager.findLast());
    }

    @Test
    public void testFindLastWithCustomLimit() {
        manager = new MovieManager(2);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        assertArrayEquals(new String[]{"Movie 3", "Movie 2"}, manager.findLast());
    }

    @Test
    public void testFindLastWhenNoMovies() {
        assertArrayEquals(new String[]{}, manager.findLast());
    }
}
