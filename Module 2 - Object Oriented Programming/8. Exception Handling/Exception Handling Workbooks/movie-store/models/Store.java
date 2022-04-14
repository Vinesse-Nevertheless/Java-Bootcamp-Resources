package models;

import java.util.ArrayList;

public class Store {
    private ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<>();
    }

    public Movie getMovie(int index) {
        return new Movie(movies.get(index));
    }

    public int getMovie(String name) {
        for (int i = 0; i < movies.size(); i++) {
            if (name.equalsIgnoreCase(movies.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public void setMovie(Movie movie, int index) {
        new Movie(movies.set(index, movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void action(String name, String action) {
        if (movies.isEmpty()) {
            throw new IllegalStateException("No movies in store");
        }
        if (name == null || name.isBlank()) {
            System.out.println("\n\nThe input you provided is not valid. Please try again.\n");
        }
        if (!action.equalsIgnoreCase("sell") && !action.equalsIgnoreCase("rent")
                && !action.equalsIgnoreCase("return")) {
            throw new IllegalArgumentException("No such action exists.");
        }

        int index = getMovie(name);
        if (index == -1 && !name.isBlank()) {
            System.out.println("Movie not found in store.");
        }
        if (index != -1) {
            switch (action) {
                case "sell":
                    if (!movies.get(index).isAvailable()) {
                        System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again.\n");
                    }else {
                        movies.remove(movies.get(index));
                    }
                    break;
                case "rent":
                    if (!movies.get(index).isAvailable()) {
                        System.out.println("\n\n\n\nThe movie is not available for rent. Please try again.\n");
                    }
                    movies.get(index).setIsAvailable(false);
                    break;
                case "return":
                    movies.get(index).setIsAvailable(true);
                    break;
            }
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for (Movie movie : movies) {
            temp += movie.toString();
            temp += "\n\n";
        }
        return temp;
    }
}