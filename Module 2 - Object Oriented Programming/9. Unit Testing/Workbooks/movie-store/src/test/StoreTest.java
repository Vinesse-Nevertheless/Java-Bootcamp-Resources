package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import src.main.models.Movie;
import src.main.models.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {

    Store store;

    @BeforeEach
    public void setup() {
        store = new Store();
        store.addMovie(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2));
        store.addMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
    }

    @Test
    public void movieAdded() {
        assertTrue(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void sellMovieTest() {
        store.sellMovie("The Godfather");
        assertFalse(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void rentMovieTest() {
        store.rentMovie("The Godfather");
        assertFalse(store.getMovie(1).isAvailable());
    }

    @Test
    public void returnMovieTest() {
        store.returnMovie("The Godfather");
        assertTrue(store.getMovie(1).isAvailable());
    }

    @Test
    //THIS TEST WILL ONLY PASS IF ILLEGALSTATEEXCEPTION IS THROWN BY
    //THESE CONDITIONS.  SELLMOVIE METHOD SHOULD THROW EXCEPTION.
    public void movieNotInStock() {
        Assertions.assertThrows(IllegalStateException.class, () ->
        {
            store.rentMovie("The Godfather");
            store.sellMovie("The Godfather");
        });
    }
}
