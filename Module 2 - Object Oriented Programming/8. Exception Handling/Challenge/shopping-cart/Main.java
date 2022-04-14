import models.Cart;
import models.Item;
import models.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Store store;
    private static Cart cart;

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        try {
            loadItems("./products.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            manageItems();
        }
    }

    /**
     * Name: manageItems
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. Creates an infinite loop:
     * •        The user can choose to a) add or b) remove c) checkout.
     * •          case a: asks for the aisle and item number. Then, adds item to cart.
     * •          case b: asks for the name. Then, removes item from cart.
     * •          case c: prints the receipt and closes Scanner.
     * •        Prints the updated shopping cart.
     */
    public static void manageItems() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);
            System.out.println("Options: " +
                    "\n\t a) Add to cart " +
                    "\n\t b) Remove from cart " +
                    "\n\t c) Checkout ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "a":
                    System.out.println("Choose an aisle number between 1 - 7: ");
                    if (!scanner.hasNextInt()) {
                        scanner.nextLine();
                        continue;
                    }

                    int aisleNumber = scanner.nextInt();
                    if (aisleNumber > 7 || aisleNumber < 0){
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();
                    System.out.println("Choose an item number between 1 - 3: ");

                    if (!scanner.hasNextInt()) {
                        scanner.nextLine();
                        continue;
                    }
                    int itemNumber = scanner.nextInt();
                    if (itemNumber > 3 || itemNumber < 0){
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();

                    Item item = store.getItem(aisleNumber - 1, itemNumber - 1);
                    if (cart.add(item)) {
                        System.out.println(item.getName() + " was added to your shopping cart.");
                    } else {
                        System.out.println(item.getName() + " is already in your shopping cart.");
                    }
                    break;

                case "b":
                    System.out.print("Enter the item you'd like to remove: ");
                    if (cart.toString().isEmpty()){
                        scanner.nextLine();
                        continue;
                }
                    cart.remove(scanner.nextLine());
                    break;
                case "c":
                    String receipt = cart.checkout();
                    if (receipt.isEmpty()){
                        continue;
                    }
                    System.out.println(receipt);
                    break;
            }
            if (choice.equalsIgnoreCase("c")) {
                scanner.close();
                break;
            } else {
                System.out.println("\n\nSHOPPING CART\n\n" + cart);
                System.out.print("Enter anything to continue: \n");
                scanner.nextLine();
            }
        }
    }

    /**
     * Name: loadItems
     *
     * @param fileName (String)
     * @throws FileNotFoundException Inside the function:
     *                               1. loads items from <fileName>.txt.
     *                               • while loop runs through every line in <fileName>
     *                               • scan.nextLine() picks up the entire line.
     *                               • splits each String using the ";" separator.
     *                               • splits both fields in each String using the "=" separator.
     *                               • Parse each price into a Double.
     *                               2. adds all items to the store object's items field.
     */
    public static void loadItems(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fis);
        int row = 0;
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] split = line.split(";");

            for (int i = 0; i < split.length; i++) {
                String[] split2 = split[i].split("=");

                String item = split2[0];
                double price = Double.parseDouble(split2[1]);

                store.setItem(new Item(item, price), row, i);
            }
            row++;
        }
    }
}
