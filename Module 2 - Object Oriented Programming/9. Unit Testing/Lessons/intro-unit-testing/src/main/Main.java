package src.main;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Main {
    
    static double[] prices = new double[] {2.23, 1.32, 4.32, 11.33};

    public static void main(String[] args) {   


    }

    public static double getSubtotal(){
        return Arrays.stream(prices).reduce(0, Double::sum);
    }

    public static double getTax(double subtotal) {
        DecimalFormat df = new DecimalFormat("0.00");
        String tax = df.format(subtotal * 0.13);
        return Double.parseDouble(tax) ;
    }

    public static double getTotal(double subtotal, double tax) {
        return subtotal + tax;
    }
}
