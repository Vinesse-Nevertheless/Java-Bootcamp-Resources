import java.util.Arrays;
import java.util.List;

public class Weather {
    public static void main(String[] args) {
        double noon = 77;          //temperature at noon in fahrenheit.
        double evening = 61;       //temperature during the evening in fahrenheit
        double midnight = 55;      //temperature at midnight in fahrenheit

        //Task 3 - Call the printTemperatures function.
        List<Double> fahrenheitTemps = Arrays.asList(noon, evening, midnight);
        for ( double fahrenheit : fahrenheitTemps) {
            printTemperatures(fahrenheit);
        }
    }


    //Task 1: Make a function here. See the doc comments below. 
    static double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit - 32) * 5 / 9;
    }
    /**
     * Function name: fahrenheitToCelsius - converts fahrenheit to celcius
     * @param fahrenheit (double)
     * @return celsius (double)
     * 
     * Inside the function:
     * 1. returns the temperature in celcius. C = (F - 32) * 5/9. 
     */

     
    //Task 2: Make a function here. See the doc comments below. 
     static void printTemperatures(double fahrenheit){
         double celsius = fahrenheitToCelsius(fahrenheit);
         System.out.println("F: <temp in " + fahrenheit);
         System.out.println("C: <temp in " + celsius);
     }
    /**
     * Function name: printTemperatures – prints both temperature values. 
     * @param fahrenheit (double)
     * 
     * Inside the function: 
     *  1. prints: F: <temperature in fahrenheit>.
     *  2. prints: C: <temperature in celsius> . 
     */
}