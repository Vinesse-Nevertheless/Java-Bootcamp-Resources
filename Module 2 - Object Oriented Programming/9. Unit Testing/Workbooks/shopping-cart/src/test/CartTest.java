package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.models.Cart;
import src.main.models.Item;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    Cart cart;

    @BeforeEach
    public void setup() {
        cart = new Cart();
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
    }

    @Test
    public void itemAddedTest() {
        assertTrue(cart.contains(new Item("Pepsi", 1.99)));
    }

    @Test
    public void skipsDuplicate() {
        assertFalse(cart.add(new Item("Crush", 1.99)));
    }

    @Test
    public void removedItemTest() {
        cart.remove("Pepsi");
        assertFalse(cart.contains(new Item("Pepsi", 1.99)));
    }

    @Test
    public void subtotalIsValid() {
        assertEquals(3.98, cart.getSubtotal());
    }

    @Test
    public void taxIsValid() {
        assertEquals(0.52, cart.getTax(3.98));
    }

    @Test
    public void totalIsValid() {
        assertEquals(4.5, cart.getTotal(3.98, 0.52));
    }

    @Test
    public void invalidRemoveState() {
        cart.clear();
        assertThrows(IllegalStateException.class, () -> cart.remove("Pepsi"));
    }

    @Test
    public void invalidCheckoutState(){
        cart.clear();
        assertThrows(IllegalStateException.class, () -> cart.checkout());
    }
}
