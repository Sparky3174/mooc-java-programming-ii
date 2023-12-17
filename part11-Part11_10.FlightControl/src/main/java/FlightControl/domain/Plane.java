/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author Andre
 */
public class Plane {

    private String id;
    private int capacity;

    public Plane(String planeID, int planeCapacity) {
        this.id = planeID;
        this.capacity = planeCapacity;
    }

    public String toString() {
        return this.id + " (" + this.capacity + " capacity)";
    }

}
