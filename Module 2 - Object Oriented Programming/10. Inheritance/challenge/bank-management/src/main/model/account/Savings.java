package src.main.model.account;

public class Savings extends Account {
    private static final double WITHDRAWAL_FEE = 5.00;

    public Savings(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Account source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public boolean withdraw(double amount) {
        //the savings account charges a $5.00 fee for every withdrawal.
        setBalance(getBalance() - amount - WITHDRAWAL_FEE);
        return true;
    }

    @Override
    public Account clone() {
        return new Savings(this);
    }
}
