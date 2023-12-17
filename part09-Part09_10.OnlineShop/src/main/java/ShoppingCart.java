/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {

    private Map<String, Item> contents;

    public ShoppingCart() {
        this.contents = new HashMap<>();
    }

    public void add(String product, int price) {
        if (!contents.containsKey(product)) {
                    this.contents.put(product, new Item(product, 1, price));
                    return;
        }
        this.contents.get(product).increaseQuantity();
    }

    public int price() {
        int totalPrice = 0;
        for (Item item : this.contents.values()) {
            totalPrice += item.price();
        }
        return totalPrice;
    }
    
    public void print() {
        for (Item item : this.contents.values()) {
            System.out.println(item);
        }
    }

}
