/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.util.List;
import java.util.ArrayList;

public class Pipe<T> {
    private List<T> pipeItems;
    
    public Pipe() {
        this.pipeItems = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        this.pipeItems.add(value);
    }
    
    public T takeFromPipe() {
        T placeholder = this.pipeItems.get(0);
        this.pipeItems.remove(0);
        return placeholder;
    }
    
    public boolean isInPipe() {
        if (!this.pipeItems.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
