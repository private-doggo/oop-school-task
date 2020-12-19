package service;

import dao.PersonDaoImpl;
import entity.Person.Person;
import java.sql.SQLException;

public class PersonService {

    public Person getPersonByName(String name) {

        PersonDaoImpl pdi = new PersonDaoImpl();
        return pdi.getPersonByName(name);
    }

    public void register(String name, String role) {

        PersonDaoImpl pdi = new PersonDaoImpl();
        pdi.register(name, role);
    }

    public void delete(String name) {

        PersonDaoImpl pdi = new PersonDaoImpl();
        pdi.delete(name);
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {

        PersonDaoImpl pdi = new PersonDaoImpl();
        pdi.deleteAll();
    }

    public void setDiscountToPerson(int discount, String name) {

        PersonDaoImpl pdi = new PersonDaoImpl();
        pdi.setDiscountToPerson(discount, name);
    }
}
