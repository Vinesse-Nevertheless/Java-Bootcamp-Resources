package src.main;

import src.main.model.Bank;
import src.main.model.Transaction;
import src.main.model.account.Account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main {
    static Bank bank = new Bank();
    // Mac users:
    static String ACCOUNTS_FILE = "src/main/data/accounts.txt";
    static String TRANSACTIONS_FILE = "src/main/data/transactions.txt";

    // Windows users:
    //  static String ACCOUNTS_FILE = "src\main\data\accounts.txt";            
    //  static String TRANSACTIONS_FILE = "src\main\data\transactions.txt";

    public static void main(String[] args) {

        try {
            ArrayList<Account> accounts = returnAccounts();
            loadAccounts(accounts);

            ArrayList<Transaction> transactions = returnTransactions();
            runTransactions(transactions);
            bank.deductTaxes();
            for (Account account : accounts) {
                System.out.println("\n\t\t\t\t\t\t\t\t ACCOUNT\n\n\t"+account+"\n\n");
                transactionHistory(account.getId());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Account createObject(String[] values) {
        try {
            return ((Account) Class.forName("src.main.model.account." + values[0])
                    .getConstructor(String.class, String.class, double.class)
                    .newInstance(values[1], values[2], Double.parseDouble(values[3])));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Account> returnAccounts() throws FileNotFoundException{
        ArrayList<Account> accounts = new ArrayList<>();

            FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
            Scanner scanner = new Scanner(fis);

            while (scanner.hasNext()) {
                String[] split = scanner.nextLine().split(",");
                Account singleAccount = createObject(split);
                accounts.add(singleAccount);
            }
            scanner.close();

        return accounts;
    }

    public static void loadAccounts(ArrayList<Account> accounts) {
        accounts.forEach(account -> bank.addAccount(account));
    }

    public static ArrayList<Transaction> returnTransactions() throws FileNotFoundException{
        ArrayList<Transaction> transactions = new ArrayList<>();

            FileInputStream fis = new FileInputStream(TRANSACTIONS_FILE);
            Scanner scanner = new Scanner(fis);

            while (scanner.hasNext()) {
                String[] split = scanner.nextLine().split(",");
                Transaction singleTransaction = new Transaction(Transaction.Type.valueOf(split[1]), Long.parseLong(split[0]), split[2], Double.parseDouble(split[3]));
                transactions.add(singleTransaction);
            }
            scanner.close();
            Collections.sort(transactions);
        return transactions;
    }

    public static void runTransactions(ArrayList<Transaction> transactions){
        transactions.forEach(transaction -> bank.executeTransaction(transaction));
    }

    public static void transactionHistory(String id) throws FileNotFoundException{
        System.out.println("\t\t\t\t\t\t\t   TRANSACTION HISTORY\n\t");
        ArrayList<Transaction> transactions = returnTransactions();
        for (Transaction transaction: transactions) {
            if (transaction.getId().equals(id)){
                System.out.println( "\t"+transaction+"\n" );
                wait(300);
            }
        }
        System.out.print("\n\t\t\t\t\t\t\t\tAFTER TAX\n");
        System.out.print("\t");
        returnAccounts().stream().filter(account -> account.getId().equals(id)).forEach(System.out::println);
        System.out.print("\n\n\n\n");
    }

    /**
     * Function name: wait
     *
     * @param milliseconds Inside the function:
     *                     1. Makes the code sleep for X milliseconds.
     */

    public static void wait(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


}
