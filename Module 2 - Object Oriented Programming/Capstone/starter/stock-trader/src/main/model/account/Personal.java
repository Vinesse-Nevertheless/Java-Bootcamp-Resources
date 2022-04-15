package src.main.model.account;

import src.main.Trade;
import java.util.Map;

public class Personal extends Account{
public static final double SALE_FEE = 0.05;

    public Personal(Map<String, Integer> portfolio, double funds) {
        super(portfolio, funds);
    }

    public Personal(Account source) {
        super(source);
    }

    @Override
    public boolean buy(Trade trade) {
        String stockName = String.valueOf(trade.getStockType());
        int shareCount = trade.getShareCount();
        double price = trade.getStockPrice();

        if (getFunds() < shareCount * price) {
            return false;
        }

        setFunds(getFunds() - (shareCount * price));
        if(portfolio.containsKey(stockName)) {
            setPortfolioShareCount(stockName, getPortfolioShareCount(stockName) + shareCount);
        }else{
            setPortfolioShareCount(stockName, shareCount);
        }
        return true;
    }

        @Override
        public boolean sell(Trade trade) {
            String stockName = String.valueOf(trade.getStockType());
            int shareCount = trade.getShareCount();
            double price = trade.getStockPrice();

            if (portfolio.containsKey(stockName) && getPortfolioShareCount(stockName) >= shareCount ) {
                double currentFee = shareCount * price * SALE_FEE;
                setFunds(getFunds() + (shareCount * price) - currentFee);
                setPortfolioShareCount(stockName, getPortfolioShareCount(stockName) - shareCount);
            return true;
            }
            return false;
        }

    }

