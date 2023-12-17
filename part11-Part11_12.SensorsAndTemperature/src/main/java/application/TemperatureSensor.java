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
import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean power;
    
    public TemperatureSensor() {
     this.power = false;
    }
    
    public boolean isOn() {
        return this.power;
    }
    
    public void setOff() {
        this.power = false;
    }
    
    public void setOn() {
        this.power = true;
    }
    
    public int read() {
        Random rand = new Random();
        if (this.power == true) {
            return rand.nextInt(61) - 30;
        } else {
            throw new IllegalStateException("Power is not on!");
        }
    }
}
