package entity.Person;

public class User extends Person {

    private int discount;

    @Override
    public String getRole() {
        return Role.USER.name();
    }

    public void buyMovie() {
        //
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public User(String name, String role) {
        super(name, role);
    }
}
