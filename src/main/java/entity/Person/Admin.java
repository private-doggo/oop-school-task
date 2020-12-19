package entity.Person;

public class Admin extends Person {

    @Override
    public String getRole() {
        return Role.ADMIN.name();
    }

    private void banUser(User user) {

    }

    private void setDiscountForUser(User user) {

    }

    public Admin(String name, String role) {
        super(name, role);
    }
}
