package src.main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static src.main.Trade.*;

import src.main.model.account.Account;
import src.main.utils.Color;

public class Main {

    static Account account;
    static final double INITIAL_DEPOSIT = 4000;
    static Map<String, Integer> portfolio = new HashMap<>() {{
        put("AAPL", 0);
        put("FB", 0);
        put("GOOG", 0);
        put("TSLA", 0);
    }};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        explainApp();
        accountSetup();
        performTrades();
        endTrading();
    }

    public static void explainApp() {
        System.out.print(Color.BLUE + "\n - PERSONAL: ");
        System.out.println(Color.YELLOW + "Every sale made in a personal account is charged a 5% fee.");
        System.out.print(Color.BLUE + "\n - TFSA: ");
        System.out.println(Color.YELLOW + "Every trade (buy/sell) made from a TFSA is charged a 1% fee.\n");
        System.out.println(Color.BLUE + " - Neither account has a limit on the amount of trades that can be made." + Color.RESET);
    }

    public static void accountSetup(){
        String choice = chooseAccount();
        account = createAccount(choice);
        account.setPortfolio(portfolio);
        setInitialBalance();
    }

    public static String chooseAccount() { //renamed from accountChoice which sounds like a variable
        System.out.print("\n  Respectively, type 'a' or 'b' to create a Personal account or TFSA: ");
        String choice = scanner.nextLine();
        while (!choice.equals("a") && !choice.equals("b")) {
            System.out.print("  Respectively, type 'a' or 'b' to create a Personal account or TFSA: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    public static Account createAccount(String choice) {
        String accountType = choice.equals("a") ? "Personal" : "TFSA";
        try {
            return ((Account) Class.forName("src.main.model.account." + accountType)
                    .getConstructor(Map.class, double.class)
                    .newInstance(portfolio, INITIAL_DEPOSIT));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void setInitialBalance() {  //renamed from initialBalance which sounds like a variable
        System.out.print("\n\n  You created a " + Color.YELLOW + account.getClass().getSimpleName() + Color.RESET + " account.");
        System.out.println(" Your account balance is " + Color.GREEN + "$" + account.getFunds() + Color.RESET);
        System.out.print("\n  Enter anything to start trading: ");
        scanner.nextLine();
    }

    public static void displayPrices(int day) {
        System.out.println("\n\n\t  DAY " + day + " PRICES\n");

        System.out.println("  " + Color.BLUE + Stock.AAPL + "\t\t" + Color.GREEN + getPrice(Stock.AAPL, day));
        System.out.println("  " + Color.BLUE + Stock.FB + "\t\t" + Color.GREEN + getPrice(Stock.FB, day));
        System.out.println("  " + Color.BLUE + Stock.GOOG + "\t\t" + Color.GREEN + getPrice(Stock.GOOG, day));
        System.out.println("  " + Color.BLUE + Stock.TSLA + "\t\t" + Color.GREEN + getPrice(Stock.TSLA, day) + Color.RESET);
    }

    public static Path getPath(String stock) {
        try {
            return Paths.get(Thread.currentThread().getContextClassLoader()
                    .getResource("src/main/data/" + stock + ".csv").toURI());
        } catch (URISyntaxException uri) {
            System.out.println(uri.getMessage());
        }
        return null;
    }

    public static String getPrice(Stock stock, int day) {
        try {
            return Files.lines(getPath(String.valueOf(stock)))
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(element -> Integer.parseInt(element[0]) == day)
                    .map(element -> element[1])
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String chooseTransaction() {//renamed from buyOrSell
        System.out.print("\n\n  Would you like to 'buy' or 'sell': ");
        String choice = scanner.nextLine();
        while (!choice.equals("buy") && !choice.equals("sell")) {
            System.out.print("  Would you like to 'buy' or 'sell': ");
            choice = scanner.nextLine();
        }
        return choice.equals("buy") ? "MARKET_BUY" : "MARKET_SELL";
    }

    public static String chooseStock() {
        System.out.print("  Choose a stock: ");
        String stock = scanner.nextLine();
        while (!stock.equals("AAPL") && !stock.equals("FB") && !stock.equals("GOOG") && !stock.equals("TSLA")) {
            System.out.print("  Choose a stock: ");
            stock = scanner.nextLine();
        }
        return stock;
    }

    public static int chooseNumberOfShares(String choice) { //renamed from numShares
        choice = choice.substring(7).toLowerCase();
        System.out.print("  Enter the number of shares you'd like to " + choice + ": ");
        testForInt(choice);
        return testForPositiveInt(choice);
    }

    public static void testForInt(String choice){
        while(!scanner.hasNextInt()){
            System.out.print("  Enter the number of shares you'd like to " + choice + ": ");
            scanner.nextLine();
        }
    }

    public static int testForPositiveInt(String choice){
        int shares = scanner.nextInt();
        scanner.nextLine();
        while (shares <= 0) {
            System.out.print("  Enter the number of shares you'd like to " + choice + ": ");
            testForInt(choice);
            shares = scanner.nextInt();
            scanner.nextLine();
        }
        return shares;
    }

    public static void performTrades(){
        for (int day = 1; day <= 2160; day++) {
            Trade trade = createTrade(day);
            boolean didTrade = executeTrade(trade);
            getTradeStatus(didTrade);
            System.out.print("\n  Continue trading? Enter 'stop' to stop. ");
            String answer = scanner.nextLine();
            if (answer.equals("stop")){
                break;
            }
        }
    }

    public static Trade createTrade(int day){
        displayPrices(day);
        String transactionType = chooseTransaction();
        String stockName = chooseStock();
        int numberOfShares = chooseNumberOfShares(transactionType);

        return new Trade(Stock.valueOf(stockName), numberOfShares,
                Double.parseDouble(getPrice(Stock.valueOf(stockName), day)),
                MarketType.valueOf(transactionType));
    }

    public static boolean executeTrade(Trade trade){
        boolean didTrade = false;
        MarketType tradeType = trade.getMarketType();
        switch (tradeType) {
            case MARKET_BUY:
                didTrade = account.buy(trade);
                break;
            case MARKET_SELL:
                didTrade = account.sell(trade);
                break;
        }
        return didTrade;
    }

    //Instructor originally had a String as parameter, but I changed it to boolean
    //to better suit my code.
    public static void getTradeStatus(boolean didTrade) {  //renamed from tradeStatus which sounds like a variable
        String result = didTrade ? "successful" : "unsuccessful";
        System.out.println("\n  The trade was " + (result.equals("successful") ? Color.GREEN : Color.RED) + result + Color.RESET + ". Here is your portfolio:");
        System.out.println(account);
    }

    //I added this method because I thought it was strange
    //that there was no way for the user to gracefully exit the program
    //or close the Scanner since not doing so could cause a memory leak.
    public static void endTrading(){
        System.out.println("\n  Thank you for trading!");
        System.out.println("  Here's your closing portfolio:");
        System.out.println(account);
        scanner.close();
        System.exit(0);
    }
}