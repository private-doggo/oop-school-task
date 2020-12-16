package service;

import collection.Collection;
import entity.Movie;

public class MovieService {

    public static Movie getMovieByName(String name) {

        for (Movie m : Collection.movieArrayList) {
            if (m.getName().equals(name)) {
                return m;
            }
        }

        return null;
    }

    public static void addMovie(String name, String description, int price) {

        Movie movie = new Movie(name, description, price);
        Collection.movieArrayList.add(movie);
    }
}
