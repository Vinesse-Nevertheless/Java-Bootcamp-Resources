package src.main.model.account;

import src.main.Trade;
import src.main.utils.Color;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Account {
    Map<String, Integer> portfolio;
    double funds;

    public Account(Map<String, Integer> portfolio, double funds) {
        this.portfolio = new HashMap<>(portfolio);
        this.funds = funds;
    }

    public Account(Account source) {
        this.portfolio = new HashMap<>(source.portfolio);
        this.funds = source.funds;
    }

    public Map<String, Integer> getPortfolio() {
        return new HashMap<>(portfolio);
    }

    public void setPortfolio(Map<String, Integer> portfolio) {
        this.portfolio = new HashMap<>(portfolio);
    }

    public Integer getPortfolioShareCount(String stockName){
         return portfolio.get(stockName);
    }

    public void setPortfolioShareCount(String stockName, Integer numberOfShares){
        portfolio.put(stockName, numberOfShares);
    }
    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public abstract boolean buy (Trade trade);
    public abstract boolean sell (Trade trade);

    @Override
    public String toString() {
        return "\n  Stock\t\t"  + Color.RESET + "Shares" +
                "\n\n" + displayPortfolio() + Color.RESET +
                "\n  Funds Left\t" + Color.GREEN + "$" + round(this.getFunds()) + Color.RESET;
    }

    private String displayPortfolio() {
        return Arrays.stream(portfolio.entrySet().toArray())
                .map(pair -> String.valueOf(pair).split("="))
                .map(array -> "  " + Color.BLUE + array[0] + "\t\t" + Color.GREEN + array[1] + "\n")
                .collect(Collectors.joining());
    }

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }
}
