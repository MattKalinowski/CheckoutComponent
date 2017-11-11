package com.matthew.checkout.checkoutcomponent.domain;

import java.util.HashMap;
import java.util.Map;

public class ItemUtils {
    
    private static final Map<String, Double> PRICES;
    private static final Map<String, Double> DISCOUNTS;
    static
    {
        PRICES = new HashMap<>();
        PRICES.put("A", 25.0);
        PRICES.put("B", 30.0);
        PRICES.put("C", 40.0);
        PRICES.put("D", 50.0);
        
        DISCOUNTS = new HashMap<>();
        DISCOUNTS.put("A", 2.0);
        DISCOUNTS.put("B", 3.0);
        DISCOUNTS.put("C", 4.0);
        DISCOUNTS.put("D", 4.5);
    }
    
    public static double returnItemPrice(String name) {
        double price = 0;
        for (String key : PRICES.keySet()) {
            if (key.equals(name)) {
                price = PRICES.get(key);
            }
        }
        return price;
    }
    
    public static double returnItemDiscount(String name) {
        double discount = 0;
        for (String key : DISCOUNTS.keySet()) {
            if (key.equals(name)) {
                discount = DISCOUNTS.get(key);
            }
        }
        return discount;
    }
    
}
