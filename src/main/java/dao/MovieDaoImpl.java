package dao;

import db.Const;
import db.DatabaseHandler;
import entity.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieDaoImpl implements MovieDao {

    public void save(String name, String description, int price) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.TABLE_NAME + "(" +
                Const.MOVIE_NAME + "," + Const.MOVIE_DESCRIPTION + "," +
                Const.MOVIE_PRICE + ")" + "VALUES(?,?,?)";

        DatabaseHandler dbh = new DatabaseHandler();

        try {
            PreparedStatement prSt = dbh.getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, description);
            prSt.setInt(3, price);

            prSt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Something went wrong");
        }

    }

    public void delete(String name) {
        /*String delete = "DELETE FROM " + Const.TABLE_NAME + " WHERE" + "(" +
                "name = " + name + ")";*/
        String delete = String.format("DELETE FROM " + Const.TABLE_NAME +
                " WHERE " + Const.MOVIE_NAME + " = '%s';", name);

        DatabaseHandler dbh = new DatabaseHandler();

        try {
            PreparedStatement prSt = dbh.getDbConnection().prepareStatement(delete);
            prSt.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("Movie was not found");
        }
    }

    public Movie getMovie(String name) throws SQLException, ClassNotFoundException {

        try {
            DatabaseHandler dbh = new DatabaseHandler();

            Statement st = dbh.getDbConnection().createStatement();
            String get = String.format("SELECT * FROM movies WHERE name = '%s';", name);
            ResultSet rs = st.executeQuery(get);

            Movie movie = new Movie();

            while (rs.next()) {

                movie.setName(name);
                movie.setPrice(rs.getInt("price"));
                return movie;
            }

            return null;
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("Error");
        }

        return null;
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {

        DatabaseHandler dbh = new DatabaseHandler();

        Statement st = dbh.getDbConnection().createStatement();
        String get = String.format("SELECT * FROM movies;");
        ResultSet rs = st.executeQuery(get);

        while (rs.next()) {

            delete(rs.getString("name"));
        }
    }
}
