package dao;

import entity.Movie;

import java.sql.SQLException;

public interface MovieDao {

    public void save(String name, String description, int price) throws SQLException, ClassNotFoundException;
    public void delete(String name);
    public Movie getMovie(String name) throws SQLException, ClassNotFoundException;
    public void deleteAll() throws SQLException, ClassNotFoundException;
}
