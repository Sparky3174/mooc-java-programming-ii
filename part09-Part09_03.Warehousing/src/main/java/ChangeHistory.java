/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.util.ArrayList;
public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        this.history.clear();
    }
    
    public double maxValue() {
        double maxValue = history.get(0);
        for (Double amount : history) {
            if (amount > maxValue) {
                maxValue = amount;
            }
        }
        return maxValue;
    }
    
        public double minValue() {
        double minValue = history.get(0);
        for (Double amount : history) {
            if (amount < minValue) {
                minValue = amount;
            }
        }
        return minValue;
    }
        
        public double average() {
            double total = 0;
            for (Double amount : history) {
                total += amount;
            }
            return total / history.size();
        }
    
    public String toString() {
        return this.history.toString();
    }
}
