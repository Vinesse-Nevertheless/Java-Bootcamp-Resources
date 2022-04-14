package com.ibm.practice;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> portfolio = new HashMap<>(){{
            put("AAPL", 0);
            put("FB", 0);
            put("GOOG", 0);
            put("TSLA", 0);}};

        Map<String, Integer> copy = new HashMap<>(portfolio);

        copy.put("FB", 111);

        System.out.println(portfolio.get("FB"));

    }
}
