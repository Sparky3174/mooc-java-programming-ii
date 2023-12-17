/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Warehouse {

    private Map<String, Integer> prices;
    private Map<String, Integer> stockValues;

    public Warehouse() {

        this.prices = new HashMap<>();
        this.stockValues = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stockValues.put(product, stock);
    }

    public int price(String product) {
        return this.prices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return this.stockValues.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (stockValues.getOrDefault(product, 0) > 0) {
            stockValues.put(product, stockValues.get(product) - 1);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        Set<String> products = new HashSet<>();
        products.addAll(prices.keySet());
        return products;
    }
}
