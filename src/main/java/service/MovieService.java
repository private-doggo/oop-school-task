package service;

import dao.MovieDaoImpl;
import entity.Movie;
import java.sql.SQLException;

public class MovieService {

    public void addMovie(String name, String description, int price) throws SQLException, ClassNotFoundException {

        Movie movie = new Movie(name, description, price);
        MovieDaoImpl mdi = new MovieDaoImpl();
        mdi.save(name, description, price);
    }

    public void deleteMovie(String name) {

        MovieDaoImpl mdi = new MovieDaoImpl();
        mdi.delete(name);
    }

    public Movie getMovieByName(String name) throws SQLException, ClassNotFoundException {
        MovieDaoImpl mdi = new MovieDaoImpl();
        return mdi.getMovie(name);
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        MovieDaoImpl mdi = new MovieDaoImpl();
        mdi.deleteAll();
    }
}
