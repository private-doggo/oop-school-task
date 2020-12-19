import entity.Person.Person;
import entity.Person.Role;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.MovieService;
import service.PersonService;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestPersonService {

    private static String name = "John";
    private static String role = Role.USER.name();

    @BeforeClass
    public static void beforeTest() {


    }

    @Test
    public void testRegister() {

        PersonService ps = new PersonService();
        ps.register(name, role);
        Person expected = ps.getPersonByName(name);
        assertEquals(expected.getName(), name);
    }

    @Test
    public void testDelete() {

        PersonService ps = new PersonService();
        ps.delete(name);
        Person expected = ps.getPersonByName(name);
        assertEquals(expected, null);
    }

    @Test
    public void testSetDiscount() throws SQLException, ClassNotFoundException {

        PersonService ps = new PersonService();
        ps.deleteAll();
        ps.register(name, role);
        ps.setDiscountToPerson(11, name);
    }
}
