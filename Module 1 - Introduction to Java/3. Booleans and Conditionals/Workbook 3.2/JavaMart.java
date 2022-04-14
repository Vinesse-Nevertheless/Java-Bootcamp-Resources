public class JavaMart {
    public static void main(String[] args) {
        double wallet = 100;
        double toyCar = 5.99;
        System.out.println("Can I get this car?");
        wallet = makePayment(wallet, toyCar);

        //if you have enough money
            //       print: Sure!
            //       pay for the toy car 

        //else:  Sorry, I only have <wallet> left.
        
        double nike = 95.99;       //run test case with 89.99
        System.out.println("Can I get these nike shoes?");
        //if you have enough money
            //       print: Sure!
            //       pay for the nike shoes 

        //else: Sorry, I only have <wallet> left.
        wallet = makePayment(wallet, nike);
    }
    //Decided to be DRY and use a method instead of repeating myself.
    static double makePayment(double wallet, double purchase){
        if ( wallet >= purchase){
            System.out.println("Sure!");
        }else{
            System.out.println("Sorry, I only have $" + wallet + " left.");
        }
        return wallet - purchase;
    }
}