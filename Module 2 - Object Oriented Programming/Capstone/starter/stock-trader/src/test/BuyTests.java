package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.Trade;
import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class BuyTests {

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

        fb = new Trade(Trade.Stock.FB, 1, 2.0, Trade.MarketType.MARKET_BUY);

        goog = new Trade(Trade.Stock.GOOG, 5, 2.0, Trade.MarketType.MARKET_BUY);
    }

    @Test
    public void increasePersonalShares() {
        boolean buy = accounts[0].buy(fb); //left in return value as convenience to let anyone know that buy and sell return boolean
        assertEquals(11, accounts[0].getPortfolioShareCount(String.valueOf(fb.getStockType())));
    }

    @Test
    public void increaseTFSAShares() {
        boolean buy = accounts[1].buy(goog);
        assertEquals(40, accounts[1].getPortfolio().get(String.valueOf(goog.getStockType())));
    }

    @Test
    public void testInsufficientFunds() {
        Trade fb =
                new Trade(Trade.Stock.FB, 1000, 2.0, Trade.MarketType.MARKET_BUY);
        Trade goog = new Trade(Trade.Stock.GOOG, 500, 2.0, Trade.MarketType.MARKET_BUY);

        boolean buy = accounts[0].buy(fb);
        boolean sell = accounts[1].buy(goog);

        assertEquals(10, accounts[0].getPortfolio().get(String.valueOf(fb.getStockType())));
        assertEquals(35, accounts[1].getPortfolio().get(String.valueOf(goog.getStockType())));
    }

    @Test
    public void decreasePersonalFunds() {
        boolean buy = accounts[0].buy(fb);
        assertEquals(98, accounts[0].getFunds());
    }

    @Test
    public void decreaseTFSAFunds() {
        boolean buy = accounts[1].buy(goog);
        assertEquals(89.90, accounts[1].getFunds());
    }
}
