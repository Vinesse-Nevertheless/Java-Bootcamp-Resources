import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class OperationChain {

    static ArrayList<Double> prices = new ArrayList<Double>();


    public static void main(String[] args) {
        prices.add(1.99);
        prices.add(4.99);
        prices.add(10.99);
        prices.add(15.99);

        ArrayList<Double> updatePrices = new ArrayList<Double>();
       // filterLowPrices(updatePrices);
       // tax(updatePrices);

        DecimalFormat df = new DecimalFormat("#.##");
        updatePrices.addAll(prices.stream()
                .filter(price -> price < 5)
                .map(low -> df.format(low * 1.13))
                .map(Double::parseDouble)
                .collect(Collectors.toList()));

        System.out.println(updatePrices);

    }
    
    public static void filterLowPrices(ArrayList<Double> lowPrices) {
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) < 5) {
                lowPrices.add(prices.get(i));
            }
        }
    }

    public static void tax(ArrayList<Double> withTax) {
        for (int i = 0; i < withTax.size(); i++) {
                withTax.set(i, withTax.get(i) * 1.13);
        }
    }


}
