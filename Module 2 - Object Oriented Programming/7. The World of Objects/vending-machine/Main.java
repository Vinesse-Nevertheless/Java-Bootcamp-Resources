import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************");


        Item[][] items = new Item[][]{
                {new Item("Pepsi", 1.99, 3), new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2)},
                {new Item("Fanta", 1.99, 2), new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3)},
                {new Item("Crush", 1.99, 2), new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1)}
        };

        Machine machine = new Machine(items);
        while (true) {
            try {
                System.out.print("Pick a row: ");
                int row = scan.nextInt();
                System.out.print("Pick a spot in the row: ");
                int spot = scan.nextInt();

                boolean didDispenseDrink = machine.dispense(row, spot);

                if (didDispenseDrink) {
                    System.out.println("Enjoy your drink! Press 1 to purchase another: ");
                } else {
                    System.out.println("Sorry, we're out of this item. Press 1 to purchase another: ");
                }
                if (scan.nextInt() != 1) {
                    break;
                }

                System.out.println("\n" + machine);
            }catch (InputMismatchException e){
                scan.nextLine();
                System.out.println("Please enter numbers only.");
            }catch (ArrayIndexOutOfBoundsException e){
                scan.nextLine();
                System.out.println("Selections are only from 0 through 2.");
            }
        }
        scan.close();
    }
}
