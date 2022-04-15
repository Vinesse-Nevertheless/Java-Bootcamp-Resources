package src.main.model.account;

import src.main.Trade;

import java.util.Map;

public class TFSA extends Account {
    private static final double TRADE_FEE = 0.01;

    public TFSA(Map<String, Integer> portfolio, double funds) {
        super(portfolio, funds);
    }

    public TFSA(Account source) {
        super(source);
    }

    public boolean buy(Trade trade) {
        String stockName = String.valueOf(trade.getStockType());
        int shareCount = trade.getShareCount();
        double price = trade.getStockPrice();

        double feeForTrade = shareCount * price * TRADE_FEE;
        if (getFunds() < (shareCount * price) + feeForTrade){
            return false;
        }

        setFunds(getFunds() - (shareCount * price) - feeForTrade);
        if (portfolio.containsKey(stockName)) {
            setPortfolioShareCount(stockName, getPortfolioShareCount(stockName) + shareCount);
        } else {
            setPortfolioShareCount(stockName, shareCount);
        }
        return true;
    }

    public boolean sell(Trade trade) {
        String stockName = String.valueOf(trade.getStockType());
        int shareCount = trade.getShareCount();
        double price = trade.getStockPrice();

        if (portfolio.containsKey(stockName) && getPortfolioShareCount(stockName) >= shareCount) {
            double feeForTrade = shareCount * price * TRADE_FEE;
            setFunds(getFunds() + (shareCount * price) - feeForTrade);
            setPortfolioShareCount(stockName, getPortfolioShareCount(stockName) - shareCount);
            return true;
        }
        return false;
    }
}

