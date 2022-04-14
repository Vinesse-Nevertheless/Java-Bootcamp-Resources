package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.Trade;
import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SellTests {

    Account[] accounts;
    static Trade fb;
    static Trade goog;

    @BeforeEach
    public void setup() {
        accounts = new Account[]{
                new Personal(new HashMap<String, Integer>() {{
                    put("FB", 10);
                }}, 100),
                new TFSA(new HashMap<String, Integer>() {{
                    put("GOOG", 35);
                }}, 100)};

        accounts[0].setPortfolioShareCount("FB", 10);
        accounts[1].setPortfolioShareCount("GOOG", 35);

        fb = new Trade(Trade.Stock.FB, 2, 2.0, Trade.MarketType.MARKET_SELL);

        goog = new Trade(Trade.Stock.GOOG, 5, 2.0, Trade.MarketType.MARKET_SELL);
    }

    @Test
    public void decreasePersonalShares(){
        boolean sell = accounts[0].sell(fb);
        assertEquals(8, accounts[0].getPortfolioShareCount((String.valueOf(fb.getStockType()))));
    }

    @Test
    public void decreaseTFSAShares(){
        boolean sell = accounts[1].sell(goog);
        assertEquals(30, accounts[1].getPortfolioShareCount(String.valueOf(goog.getStockType())));
    }

    @Test
    public void testInsufficientShares() {
        Trade fb =
                new Trade(Trade.Stock.FB, 1000, 2.0, Trade.MarketType.MARKET_SELL);
        Trade goog = new Trade(Trade.Stock.GOOG, 500, 2.0, Trade.MarketType.MARKET_SELL);

        //no TSLA stocks in portfolio
        Trade tsla = new Trade(Trade.Stock.TSLA, 500, 2.0, Trade.MarketType.MARKET_SELL);

        boolean sell = accounts[0].sell(fb);
        boolean sell2 = accounts[1].sell(goog);
        boolean sell3 = accounts[0].sell(tsla);

        assertEquals(100, accounts[0].getFunds());
        assertEquals(100, accounts[1].getFunds());
    }

    @Test
    public void increasePersonalFunds() {
        boolean sell = accounts[0].sell(fb);
        assertEquals(103.80, accounts[0].getFunds());
    }

    @Test
    public void increaseTFSAFunds() {
        boolean sell = accounts[1].sell(goog);
        assertEquals(109.90, accounts[1].getFunds());
    }
}
