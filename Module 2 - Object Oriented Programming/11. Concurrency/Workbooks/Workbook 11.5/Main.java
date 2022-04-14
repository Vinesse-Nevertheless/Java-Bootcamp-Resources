import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.stream.Stream;


public class Main{

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

            Callable < Double > callable1 = () -> average(path, "Furniture");
            Callable<Double> callable2 = () -> average(path, "Technology");
            Callable<Double> callable3 = () -> average(path, "Office Supplies");
            Callable<Double> callable4 = () -> totalAverage(path);

            ExecutorService service = Executors.newFixedThreadPool(4);

            Future<Double> future1 = service.submit(callable1);
            Future<Double> future2 = service.submit(callable2);
            Future<Double> future3 = service.submit(callable3);
            Future<Double> future4 = service.submit(callable4);

            furnitureSales = future1.get();
            techSales = future2.get();
            suppliesSales = future3.get();
            totalSales = future4.get();

        service.shutdown();
        } catch (URISyntaxException | InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }

       System.out.println("\nThank you " + name + ". The average sales for Global Superstore are:\n");
        System.out.println("Average Furniture Sales: " + furnitureSales);
        System.out.println("Average Technology Sales: " + techSales);
        System.out.println("Average Office Supplies Sales: " + suppliesSales);
        System.out.println("Total Average: " + totalSales);
        scan.close();

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
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
