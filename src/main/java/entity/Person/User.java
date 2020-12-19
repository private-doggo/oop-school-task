package entity.Person;

public class User extends Person {

    @Override
    public String getRole() {
        return Role.USER.name();
    }

    public void buyMovie() {
        //
    }

    public User(String name, String role) {
        super(name, role);
    }
}
