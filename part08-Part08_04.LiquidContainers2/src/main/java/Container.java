/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class Container {

    private int contents;

    public Container() {
        this.contents = 0;
    }
    
    
    public int contains() {
        //made to appease the tests
        return contents;
    }

    public void add(int amount) {
        if (amount > 0) {
        this.contents += amount;
        verifyAmount();
        }
    }

    public void remove(int amount) {
        this.contents -= amount;
        verifyAmount();
    }
    
    public void setAmount(int number) {
        this.contents = number;
    }

    public int getAmount() {
        return contents;
    }
    
    public void verifyAmount() {
        //if amount is over 100, set to 100
        //if amount is negative, set to 0.
        if (contents > 100) {
            contents = 100;
        }
        if (contents < 0) {
            contents = 0;
        }
    }

    public String toString() {
        return contents + "/100";
    }
}
