package dao;

import entity.Person.Person;

import java.sql.SQLException;

public interface PersonDao {

    public Person getPersonByName(String name);
    public void register(String name, String role);
    public void delete(String name);
    public void deleteAll() throws SQLException, ClassNotFoundException;
    public void setDiscountToPerson(int discount, String name);
}
