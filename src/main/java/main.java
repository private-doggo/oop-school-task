import entity.Movie;
import service.MovieService;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.print("Who are you: 1 - admin, 2 - user \n");
            int role = in.nextInt();

            int choice;

            switch (role) {
                case 1: System.out.print("1 - add a movie \n" +
                        "2 - edit movie \n" +
                        "3 - manage users discounts \n" +
                        "6 - get movie ratings \n");
                    break;

                case 2: System.out.print("4 - buy a movie \n" +
                        "5 - rate a movie \n" +
                        "6 - get movie ratings \n");
                    break;
            }

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter movie name: \n");
                    String name = in.next();
                    System.out.print("Enter movie description: \n");
                    String description = in.next();
                    System.out.print("Enter movie price: \n");
                    int price = in.nextInt();

                    MovieService.addMovie(name, description, price);
                    break;

                case 2:
                    System.out.print("Enter movie name you want to edit: \n");
                    name = in.next();
                    Movie movie = MovieService.getMovieByName(name);

                    if (movie != null) {

                        System.out.print("Enter new name: \n");
                        name = in.next();
                        System.out.print("Enter new description: \n");
                        description = in.next();
                        System.out.print("Enter new price: \n");
                        price = in.nextInt();

                        movie.setName(name);
                        movie.setDescription(description);
                        movie.setPrice(price);
                    }
                    else {
                        System.out.print("Movie was not found \n");
                    }
                    break;

                case 3:
                    System.out.print("Enter movie name you want to set discount of: \n");
                    name = in.next();
                    movie = MovieService.getMovieByName(name);

                    if (movie != null) {
                        System.out.print("Enter discount");
                        int discount = in.nextInt();

                        if (discount > 0 && discount <= 100) {
                            movie.setDiscount(discount);
                        }
                        else {
                            System.out.print("Invalid number");
                        }
                    }
                    else {
                        System.out.print("Movie was not found \n");
                    }
                    break;

                case 4:
                    System.out.print("Enter movie name you want to buy: \n");
                    name = in.next();
                    movie = MovieService.getMovieByName(name);

                    if (movie != null) {
                        System.out.print("The price of the movie is " + movie.getPrice()*((100 - movie.getDiscount())/100) + " $. Thank you for the payment");
                    }
                    else {
                        System.out.print("Movie was not found \n");
                    }
                    break;

                case 5:
                    System.out.print("Enter movie name you want to rate: \n");
                    name = in.next();
                    movie = MovieService.getMovieByName(name);

                    if (movie != null) {
                        System.out.print("Your message: ");
                        String rating = in.next();
                        movie.getRatings().add(rating);
                    }
                    else {
                        System.out.print("Movie was not found \n");
                    }
                    break;

                case 6:
                    System.out.print("Enter movie name you want to get ratings of: \n");
                    name = in.next();
                    movie = MovieService.getMovieByName(name);

                    if (movie != null) {
                        for (String rating : movie.getRatings()) {
                            System.out.print(rating + "\n");
                        }
                    }
                    else {
                        System.out.print("Movie was not found \n");
                    }

                //default: System.out.print("Try once again \n");
            }

            //in.close();
        }
    }
}