import entity.Movie;
import org.junit.BeforeClass;
import org.junit.Test;
import service.MovieService;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestMovieService {

    private static String name = "101 Долматинец";
    private static String description = "Детский фильм";
    private static int price = 4;

    @BeforeClass
    public static void beforeTest() throws SQLException, ClassNotFoundException {

        MovieService ms = new MovieService();
        ms.deleteAll();
        ms.addMovie(name, description, price);
    }

    @Test
    public void testGetMovieByName() throws SQLException, ClassNotFoundException {
        Movie expected = new Movie(name, description, price);
        MovieService ms = new MovieService();
        Movie actual = ms.getMovieByName(name);
        assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void testAddMovie() throws SQLException, ClassNotFoundException {
        Movie expected = new Movie("test", description, price);
        MovieService ms = new MovieService();
        ms.addMovie(expected.getName(), expected.getDescription(), expected.getPrice());
        Movie actual = ms.getMovieByName("test");
        assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void testDeleteMovie() throws SQLException, ClassNotFoundException {
        String test = "test5";
        MovieService ms = new MovieService();
        ms.addMovie(test, description, price);
        ms.deleteMovie(test);
        Movie expected = ms.getMovieByName(test);
        assertEquals(expected, null);
    }

}
