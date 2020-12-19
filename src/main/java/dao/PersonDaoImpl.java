package dao;

import db.Const;
import db.DatabaseHandler;
import entity.Movie;
import entity.Person.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDaoImpl implements PersonDao {

    public Person getPersonByName(String name) {

        try {
            DatabaseHandler dbh = new DatabaseHandler();

            Statement st = dbh.getDbConnection().createStatement();
            String get = String.format("SELECT * FROM " + Const.PERSONS_TABLE_NAME + " WHERE " +
                    Const.PERSON_NAME + " = '%s';", name);
            ResultSet rs = st.executeQuery(get);

            Person person = new Person();

            while (rs.next()) {

                person.setName(name);
                person.setRole(rs.getString("role"));
                return person;
            }

            return null;
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("Error");
        }

        return null;
    }

    public void register(String name, String role) {

        String insert = "INSERT INTO " + Const.PERSONS_TABLE_NAME + "(" +
                Const.PERSON_NAME + "," + Const.PERSON_ROLE + ")" + "VALUES(?,?)";

        DatabaseHandler dbh = new DatabaseHandler();

        try {
            PreparedStatement prSt = dbh.getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, role);

            prSt.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("Something went wrong");
        }
    }

    public void delete(String name) {

        String delete = String.format("DELETE FROM " + Const.PERSONS_TABLE_NAME +
                " WHERE " + Const.PERSON_NAME + " = '%s';", name);

        DatabaseHandler dbh = new DatabaseHandler();

        try {
            PreparedStatement prSt = dbh.getDbConnection().prepareStatement(delete);
            prSt.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("Person was not found");
        }
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {

        DatabaseHandler dbh = new DatabaseHandler();

        Statement st = dbh.getDbConnection().createStatement();
        String get = String.format("SELECT * FROM " + Const.PERSONS_TABLE_NAME + ";");
        ResultSet rs = st.executeQuery(get);

        while (rs.next()) {

            delete(rs.getString("name"));
        }
    }

    public void setDiscountToPerson(int discount, String name) {

        /*String insert = "INSERT INTO " + Const.PERSONS_TABLE_NAME + "(" +
                Const.PERSON_DISCOUNT + ")" + "VALUES(?)" +
                " WHERE " + Const.PERSON_NAME + " = " + name;*/
        String update = String.format("UPDATE " + Const.PERSONS_TABLE_NAME + " SET " + Const.PERSON_DISCOUNT
                + " = '%s' WHERE name = '%s';", discount, name);

        DatabaseHandler dbh = new DatabaseHandler();

        try {
            PreparedStatement prSt = dbh.getDbConnection().prepareStatement(update);
            //prSt.setInt(1, discount);

            prSt.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("Something went wrong");
        }
    }
}
