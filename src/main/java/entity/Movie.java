package entity;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String name;
    private String description;
    private int price;
    private int discount;
    private List<String> ratings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public List<String> getRatings() {
        return ratings;
    }

    public void setRatings(List<String> ratings) {
        this.ratings = ratings;
    }

    public Movie(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
