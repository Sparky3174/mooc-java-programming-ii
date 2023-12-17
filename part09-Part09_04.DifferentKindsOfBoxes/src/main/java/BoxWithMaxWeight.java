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
public class BoxWithMaxWeight extends Box {
    private int maxWeight;
    private ArrayList<Item> contents;
    
    public BoxWithMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
        this.contents = new ArrayList<>();
    }
    
    public boolean isInBox(Item item) {
        if (contents.contains(item)) {
            return true;
        }
        return false;
    }
    
    public void add(Item item) {
        if(item.getWeight() + this.getCurrentWeight() <= maxWeight) {
            contents.add(item);
        }
    }
    
    public int getCurrentWeight() {
        int currentWeight = 0;
        for(Item item : contents) {
            currentWeight += item.getWeight();
        }
        return currentWeight;
    }
    
}
