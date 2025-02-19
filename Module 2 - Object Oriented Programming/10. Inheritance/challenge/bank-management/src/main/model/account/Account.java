package src.main.model.account;

import src.main.model.Bank;

import java.text.DecimalFormat;

public abstract class Account extends Bank {
    private String id;
    private String name;
    private double balance;

    public Account(String id, String name, double balance) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("id can't be blank or null");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can't be blank or null");
        }

        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("id can't be blank or null");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can't be blank or null");
        }
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = round(balance);
    }

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "    " +
                "\t" + id + "" +
                "\t" + name + "" +
                "\t$" + balance + "";
    }

    public abstract Account clone();
}
