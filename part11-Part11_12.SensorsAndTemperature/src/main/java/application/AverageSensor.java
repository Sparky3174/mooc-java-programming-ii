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
import java.util.List;
import java.util.ArrayList;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (sensor.isOn() == false) {
                return false;
            }
        }
        return true;
    }

    public void setOn() {
        this.sensors.forEach(Sensor::setOn);
    }

    public void setOff() {
        this.sensors.forEach(Sensor::setOff);
    }

    public int read() {
        if (this.isOn()) {
            int result = this.sensors.stream().mapToInt(sensor -> sensor.read()).sum() / this.sensors.size();
            this.readings.add(result);
            return result;
        }
        throw new IllegalStateException("The average sensor is not on!");
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return this.readings;
    }
}
