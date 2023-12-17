/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.history = new ChangeHistory();
        history.add(initialBalance);
        super.addToWarehouse(initialBalance);
    }

    public String history() {
        return this.history.toString();
    }

    public void addToWarehouse(double amount) {
        history.add(super.getBalance() + amount );
        super.addToWarehouse(amount);
    }

    public double takeFromWarehouse(double amount) {
        history.add(super.getBalance() - amount );
        return super.takeFromWarehouse(amount);
    }
    
    public void printAnalysis() {
        StringBuilder s = new StringBuilder();
        s.append("Product: " + super.getName());
        s.append("\nHistory: " + history.toString());
        s.append("\nLargest amount of product: " + history.maxValue());
        s.append("\nSmallest amount of product: " + history.minValue());
        s.append("\nAverage: " + history.average());
        
        System.out.println(s.toString());
    }
}
