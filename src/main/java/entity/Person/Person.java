package entity.Person;

public class Person {

    private String name;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person getPersonByName(String name) {
        Person person = new Person();

        //

        return person;
    }

    public Person() {}

    public Person(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
