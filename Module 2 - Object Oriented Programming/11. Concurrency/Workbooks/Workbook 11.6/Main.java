import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
 
    static String[] files = new String[] { "data/sales1.csv", "data/sales2.csv", "data/sales3.csv"};
   
    static int sampleSize = 0;
    static int quantitySold = 0;


    public static void main(String[] args) throws Exception {
     
            // execute tasks here
        ExecutorService service = Executors.newFixedThreadPool(files.length);
        service.execute( () -> increment(files[0]));
        service.execute( () -> increment(files[1]));
        service.execute( () -> increment(files[2]));
           /* Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore data: ");
            String name = scan.nextLine();
            System.out.println("\nThank you " + name + ".\n");
            scan.close();*/
service.shutdown();
    }

    public static void increment(String file){
        try {
        Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(file).toURI());

            Files.lines(path)
                    .parallel()
                    .skip(1)
                    .map(line -> line.split(","))
                    .mapToInt(array -> Integer.parseInt(array[2]))
                    .forEachOrdered(quantity -> System.out.println(sampleSize++ + " " +  (quantitySold += quantity)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
