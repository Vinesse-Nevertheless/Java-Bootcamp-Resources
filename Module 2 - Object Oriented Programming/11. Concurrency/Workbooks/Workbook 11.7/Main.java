import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
 
    static String[] files = new String[] { "data/sales1.csv", "data/sales2.csv", "data/sales3.csv"};
   
    static AtomicInteger sampleSize = new AtomicInteger(0);
    static AtomicInteger quantitySold = new AtomicInteger(0);


    public static void main(String[] args) throws Exception {
            // execute tasks here
        ExecutorService service = Executors.newFixedThreadPool(files.length);
        service.execute( () -> increment(files[0]));
        service.execute( () -> increment(files[1]));
        service.execute( () -> increment(files[2]));
            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore data: ");
            String name = scan.nextLine();
            System.out.println("\nThank you " + name + ".\n");
            scan.close();

        System.out.println("Sample size: " + sampleSize);
        System.out.println("Quantity sold: " + quantitySold);
service.shutdown();
    }

    //Used synchronized because I believe that's more favored
    //than re-entrant locks and countdown latches!
    public static synchronized void increment(String file){

        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(file).toURI());

            Files.lines(path)
                    .skip(1)
                    .map(line -> line.split(","))
                    .mapToInt(line -> Integer.parseInt(line[2]))
                    .forEach(quantity -> {sampleSize.addAndGet(1); quantitySold.addAndGet(quantity);});  //printing here causes the samplesize to be 1 less than expected
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
