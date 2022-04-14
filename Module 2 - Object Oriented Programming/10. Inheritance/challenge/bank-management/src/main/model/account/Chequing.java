package src.main.model.account;

import src.main.model.account.impl.Taxable;

public class Chequing extends Account implements Taxable {
    public static final double WITHDRAWAL_FEE = 5.50;
    public static final double OVERDRAFT_LIMIT = 200.00;
    public static final double TAX_LIMIT = 3000.00;
    public static final double TAX_RATE = 0.15;

    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Account source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
       setBalance(getBalance() + amount);
    }

    @Override
    public boolean withdraw(double amount) {
        //The chequing account charges an overdraft fee of $5.50 if the amount being withdrawn exceeds the account balance.
        //The overdraft limit is $200.00 dollars.
        if(getBalance() - amount < -OVERDRAFT_LIMIT) {
            return false;
        }

        if(getBalance() - amount <= -1){
            setBalance(getBalance() - amount - WITHDRAWAL_FEE);
            return true;
        }

        setBalance(getBalance() - amount);
        return true;
    }

    @Override
    public void tax(double income) {
        //A chequing account is taxable.
        //Creator of programmed phrased the direction poorly.
        //He meant that if a deposit exceeds 3000, then the excess difference is taxable
        //and not just taking 15% of any amount 3000+.
        double tax = income > TAX_LIMIT ? (income - TAX_LIMIT) * TAX_RATE : 0;
        setBalance(getBalance() - tax);
    }

    @Override
    public Account clone() {
        return new Chequing(this);
    }
}
