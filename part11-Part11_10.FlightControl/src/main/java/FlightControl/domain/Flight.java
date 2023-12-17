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
public class Flight {

    private Plane plane;
    private String departureID;
    private String destinationID;

    public Flight(Plane plane, String departureID, String destinationID) {
        this.plane = plane;
        this.departureID = departureID;
        this.destinationID = destinationID;
    }

    public String toString() {
        return plane + " (" + departureID + "-" + destinationID + ")";
    }

}
