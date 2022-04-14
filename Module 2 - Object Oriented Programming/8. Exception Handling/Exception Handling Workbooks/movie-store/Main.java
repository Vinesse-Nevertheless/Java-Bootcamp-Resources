import models.Movie;
import models.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Store store;

    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");

        store = new Store();

        try {
            loadMovies("./movies.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("MOVIES LOADED");
            System.out.println(store);
        }

        manageMovies();
    }

    /**
     * Name: manageMovies
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     * •        case a: ask for the name and sell.
     * •        case b: ask for the name and rent.
     * •        case c: ask for the name and return.
     * • 3. call close() from the Scanner object.
     */
    public static void manageMovies() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to: " +
                    "\n a) purchase" +
                    "\n b) rent " +
                    "\n c) return " +
                    "\n d) exit");
            String action = scanner.nextLine();
            if (!action.equalsIgnoreCase("a") &&
                    !action.equalsIgnoreCase("b") &&
                    !action.equalsIgnoreCase("c")) {
                break;
            }
            System.out.print("Enter the name of the movie: ");
            String name = scanner.nextLine();
            if (name == null || name.isBlank()){
                System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                continue;
            }
            switch (action) {
                case "a":
                    store.action(name, "sell");
                    break;
                case "b":
                    store.action(name, "rent");
                    break;
                case "c":
                    store.action(name, "return");
                    break;
            }
            System.out.println("\n\nUPDATED MOVIES\n\n");
            System.out.println(store);
        }
        scanner.close();
    }

    /**
     * Name: loadMovies
     *
     * @param fileName (String)
     * @throws FileNotFoundException Inside the function:
     *                               • 1. loads movies from <fileName>.txt.
     *                               • 2. adds all movies to the store object's movie field.
     *                               Hint: You will need to 'split' a String into three Strings.
     */

    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split("--");
            for (int i = 0; i + 2 < words.length; i += 2) {
                store.addMovie(new Movie(words[i], words[i + 1], Double.parseDouble(words[i + 2])));
            }
        }
    }
}
