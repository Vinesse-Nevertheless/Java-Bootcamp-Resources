package src.test;

import org.junit.jupiter.api.Test;
import src.main.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
In IntelliJ write the @Test.  Then write click.
Choose more options and then choose the JUnit version to add to the classpath.

As soon as you write the method under the annotation, the error will go away!
 */

public class checkoutTest{
    @Test
    public void subtotalIsValid(){
        //Make an assertion to assert that the expected value equals the one that's produced by another method.
        assertEquals(19.2, Main.getSubtotal());
    }

    @Test
    public void taxIsValid(){
        assertEquals(2.50, Main.getTax(19.2));
    }

    @Test
    public void totalIsValid(){
        assertEquals(21.70, Main.getTotal(19.20, 2.50));
    }
}
