package src.main;

public class Trade {
    public enum MarketType { MARKET_BUY , MARKET_SELL}

    public enum Stock {AAPL, FB, GOOG, TSLA}
    int shareCount;
    double stockPrice;
    MarketType marketType;
    Stock stockType;

    public Trade(Stock stockType, int shareCount, double stockPrice, MarketType marketType) {
        this.shareCount = shareCount;
        this.stockPrice = stockPrice;
        this.marketType = marketType;
        this.stockType = stockType;
    }

    public Trade(Trade source) {
        this.shareCount = source.shareCount;
        this.stockPrice = source.stockPrice;
        this.marketType = source.marketType;
        this.stockType = source.stockType;
    }

    public int getShareCount() {
        return shareCount;
    }

    private void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    private void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public MarketType getMarketType() {
        return marketType;
    }

    private void setMarketType(MarketType marketType) {
        this.marketType = marketType;
    }

    public Stock getStockType() {
        return stockType;
    }

    private void setStockType(Stock stockType) {
        this.stockType = stockType;
    }
}
