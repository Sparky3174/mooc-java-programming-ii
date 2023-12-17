/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Andre
 */
public class StandardSensor implements Sensor {
    private int num;
    
    public StandardSensor(int num) {
        this.num = num;
    }
    
    public void setOn() {
        
    }
    
    public void setOff() {
        
    }
    
    public int read() {
        return this.num;
    }
    
    public boolean isOn() {
        return true;
    }
    
}
