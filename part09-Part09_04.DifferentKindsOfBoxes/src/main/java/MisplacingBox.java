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
public class MisplacingBox extends Box {
    private ArrayList<Item> contents;
    
    public MisplacingBox() {
    this.contents = new ArrayList<>();    
    }
    
    public void add(Item item) {
        this.contents.add(item);
    }
    
    public boolean isInBox(Item item) {
        return false;
    }
    
}
