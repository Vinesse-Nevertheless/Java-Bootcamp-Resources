import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.stream.Stream;


public class Main {

    static final String SALES = "data/sales.csv"; //Use backslash Windows users
    static Double furnitureSales;
    static Double techSales;
    static Double suppliesSales;
    static Double totalSales;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name to access the Global Superstore dataset: ");
        String name = scan.nextLine();

        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(SALES).toURI());
            //calculate average sales of "Furniture" here
            //calculate average sales of "Technology" here
            //calculate average sales of "Office Supplies" here
            //calculate total average of sales here


            Thread furniture = new Thread(() -> furnitureSales = average(path, "Furniture"));
            Thread technology = new Thread(() -> techSales = average(path, "Technology"));
            Thread supplies = new Thread(() -> suppliesSales = average(path, "Office Supplies"));
            Thread totalAverage = new Thread(() -> totalSales = totalAverage(path));


            furniture.start();
            technology.start();
            supplies.start();
            totalAverage.start();

            furniture.join();
            technology.join();
            supplies.join();
            totalAverage.join();

        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



       System.out.println("\nThank you " + name + ". The average sales for Global Superstore are:\n");
        System.out.println("Average Furniture Sales: " + furnitureSales);
        System.out.println("Average Technology Sales: " + techSales);
        System.out.println("Average Office Supplies Sales: " + suppliesSales);
        System.out.println("Total Average: " + totalSales);
        scan.close();
    }

    /**
     * Function name: average
     *
     * @param path     (Path)
     * @param category (String)
     * @return Double
     * <p>
     * Inside the function:
     * 1. Runs through every line from the CSV file as a stream.
     * 2. Maps every element in the stream to an array of three String values.
     * 3. Filters every value by the @param category
     * 4. Maps every element in the stream to a double (price * quantity).
     * 5. Applies the terminal operation average.
     * 6. Returns the average as double.
     */
    public static Double average(Path path, String category) {
        try {
            return Files.lines(path)
                    .parallel()
                    .skip(1)
                    .map(line -> String.valueOf(line).split(","))
                    .filter(elements -> {
                        for (String element : elements) {
                            if (element.equals(category)) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .mapToDouble(element -> Double.parseDouble(element[1]) * Double.parseDouble(element[2]))
                    .average()
                    .getAsDouble();
        }catch (IOException io){
            System.out.println(io.getMessage());
        }
        return 0.0;
    }


    /**
     * Function name: totalAverage
     * @param path (Path)
     * @return Double
     *
     * Inside the function:
     *   1. Runs through every line from the CSV file as a stream.
     *   2. Maps every element in the stream to an array of three values.
     *   3. Maps every element in the stream to a double: (price * quantity).
     *   4. Applies the terminal operation average.
     *   5. Returns the average as double.
     */

    public static Double totalAverage(Path path)  {
        try {
            return Files.lines(path)
                    .parallel()
                    .skip(1)
                    .map(line -> String.valueOf(line).split(","))
                    .mapToDouble(element -> Double.parseDouble(element[1]) * Double.parseDouble(element[2]))
                    .average()
                    .getAsDouble();
        }catch (IOException io){
            System.out.println(io.getMessage());
        }
        return 0.0;
    }


}
