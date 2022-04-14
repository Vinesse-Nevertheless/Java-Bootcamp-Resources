import java.lang.invoke.CallSite;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Main {

    static final double TARGET = 0.5;
    static final double PRECISION = 0.000000001;

    static double result;
    static double precision;

    public static void main(String[] args) {

        //call generateNumber here...
        //calculate precision level here...

        Thread thread1 = new Thread( () -> result = generateNumber() );
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        precision = difference(result);
        System.out.println("The computer returned a value of: " + result);
        System.out.println("The value was generated to a precision of : " + precision);
    }

    /**
     * Function name: generateNumber
     * @return double
     * 
     * Inside the function:
     *   1. Generates a number close to the TARGET to a precision of PRECISION.
     * 
     */

    public static double generateNumber(){
        double number = Math.random() * TARGET;
        double difference = difference(number);
        while(difference > PRECISION){
            number = Math.random();
            difference = difference(number);
        }
        return number;
    }

    public static double difference(double number){
        return Math.abs(TARGET - number);
    }
}
