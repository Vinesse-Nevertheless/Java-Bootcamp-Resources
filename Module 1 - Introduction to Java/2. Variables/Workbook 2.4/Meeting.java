public class Meeting {
    public static void main(String[] args) {
        double sales = 24309.65; 
        double profit = 18562.18; 
        double refunds = 688.78; 
        double shipping = 1233.57;

        int intSales = (int) sales;
        int intProfit = (int) profit;
        int intRefunds = (int) refunds;
        int intShipping = (int) shipping;

        System.out.println("This month, we made $" + intSales + " in sales");
        System.out.println("Factoring in costs, we made $" + intProfit + " in profit");
        System.out.println("The refunds are at a low $" + intRefunds + ". This is a good sign!");
        System.out.println("Shipping costs were high. We paid $" + intShipping + " in shipping");


    }
}