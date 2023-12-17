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

public class Box implements Packable {

    private double maximumCapacity;
    private ArrayList<Packable> contents;

    public Box(double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.contents = new ArrayList<>();
    }

    public double weight() {
        double currentWeight = 0;
        for (Packable item : contents) {
            currentWeight += item.weight();
        }
        return currentWeight;
    }

    public void add(Packable item) {
        if (item.weight() + this.weight() <= this.maximumCapacity) {
            contents.add(item);
        }
    }
    
    public String toString() {
        return "Box: " + contents.size() + " items, total weight " + this.weight() + " kg";
    }

}
