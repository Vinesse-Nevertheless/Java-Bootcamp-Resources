import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class AppleStore {
    public static void main(String[] args) {
        int numOfApples = 0;
        int numOfCustomers = 0;
        double profit = 0;


        System.out.println("You picked 500 apples from an apple orchard");
        //Update number of apples.
        numOfApples += 500;
        
        System.out.println("Time for business! You're selling each apple for 40 cents");
        //Make a price variable. Set it equal to 40 cents.
        final float price = 0.4f;

        System.out.println("One customer walked in. He bought 4 apples!");
        //Update number of apples.
        numOfApples -= 4;
        //Update number of customers;
        numOfCustomers += 1;
        //Update profit
        profit += 4 * price;

        System.out.println("Another customer walked in. He bought 20 apples!");
        //Update number of apples;
        numOfApples -= 20;
        //Update number of customers;
        numOfCustomers += 1;
        //Update profit
        profit += 20 * price;

        System.out.println("Another customer walked in. She bought 200 apples!");
        //Update number of apples;
        numOfApples -= 200;
        //Update number of customers;
        numOfCustomers += 1;
        //Update profit
        profit += 200 * price;

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String profitString = nf.format(profit);
        System.out.println("Wow! So far, you made: " + profitString + ".");
        System.out.println(numOfCustomers + " customers love your apples.");
        System.out.println("You have " + numOfApples + " apples left. We'll sell more tomorrow!");




    }

}