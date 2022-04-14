package src.main.model.account;

public class Loan extends Account{
    private static final double FIXED_INTEREST_RATE = 0.02;
    private static final double MAX_DEBT = 10_000;

    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan(Account source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() - amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if(getBalance() + amount >= MAX_DEBT) {
            return false;
        }
        //Every withdrawal is charged a fixed interest rate of 2%.
        setBalance(getBalance() + (amount * (1 + FIXED_INTEREST_RATE)));
        return true;
    }

    @Override
    public Account clone() {
        return new Loan(this);
    }
}
