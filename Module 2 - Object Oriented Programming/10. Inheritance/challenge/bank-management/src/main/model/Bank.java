package src.main.model;

import src.main.model.account.Account;
import src.main.model.account.Chequing;
import src.main.model.account.impl.Taxable;

import java.util.ArrayList;
import java.util.Arrays;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public Bank() {
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account.clone());
    }

    private void addTransaction(Transaction transaction) {
        transactions.add(new Transaction(transaction));
    }

    public Transaction[] getTransactions(String accountId) {
        return transactions.stream()
                .filter(transaction -> transaction.getId().equals(accountId))
                .toArray(Transaction[]::new);
    }

    public Account getAccount(String transactionId) {
        return accounts.stream()
                .filter(account -> account.getId().equals(transactionId))
                .findFirst()
                .orElse(null);
    }

    private void withdrawTransaction(Transaction transaction) {
        Account account = getAccount(transaction.getId());
        if (account.withdraw(transaction.getAmount())) {
            addTransaction(transaction);
        }
    }

    private void depositTransaction(Transaction transaction) {
        Account account = getAccount(transaction.getId());
        account.deposit(transaction.getAmount());
        addTransaction(transaction);
    }

    public void executeTransaction(Transaction transaction) {
        if (transaction.getType() == Transaction.Type.WITHDRAW) {
            withdrawTransaction(transaction);
        } else if (transaction.getType() == Transaction.Type.DEPOSIT){
            depositTransaction(transaction);
        }
    }

    private double getIncome(Taxable account) {
        if (!(account instanceof Chequing)) {
            return 0;
        }
        Chequing chequing = (Chequing) account;
        Transaction[] transactions = getTransactions(chequing.getId());

        return Arrays.stream(transactions)
                .map(transaction -> transaction.getType() == Transaction.Type.WITHDRAW ? -transaction.getAmount() : transaction.getAmount())
                .reduce(0.00, Double::sum);
    }

    public void deductTaxes() {
        for (Account account: accounts) {
               if(Taxable.class.isAssignableFrom(account.getClass())) {
                   Taxable account1 = (Taxable) account;
                   double income = getIncome(account1);
                   account1.tax(income);
               }
        }
    }
}
