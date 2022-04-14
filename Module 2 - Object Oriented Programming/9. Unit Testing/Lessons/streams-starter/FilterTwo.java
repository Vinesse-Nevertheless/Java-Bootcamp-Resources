import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTwo {

    static ArrayList<Double> prices = new ArrayList<Double>();


    public static void main(String[] args) {
        prices.add(1.99);
        prices.add(4.99);
        prices.add(10.99);
        prices.add(15.99);

        ArrayList<Double> lowPrices = new ArrayList<Double>();
    
      //  filterLowPrices(lowPrices);
        System.out.println("Lambda with collect");
        lowPrices.addAll(prices.stream()
                .filter(price -> price < 5)
                .collect(Collectors.toList()));

        System.out.println(lowPrices);
    }

    public static void filterLowPrices(ArrayList<Double> lowPrices) {
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) < 5) {
                lowPrices.add(prices.get(i));
            }
        }
    }

}
