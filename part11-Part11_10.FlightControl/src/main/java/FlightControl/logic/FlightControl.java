/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import java.util.HashMap;
import FlightControl.domain.*;
import java.util.Scanner;

/**
 *
 * @author Andre
 */
public class FlightControl {
    
    private Scanner scanner;
    private HashMap<String, Plane> planes;
    private HashMap<String, Flight> flights;
    
    public FlightControl(Scanner scanner, HashMap planes, HashMap flights) {
        this.scanner = scanner;
        this.planes = planes;
        this.flights = flights;
    }
    
    public void printPlanes() {
        for (Plane plane : planes.values()) {
            System.out.println(plane);
        }
    }
    
    public void printFlights() {
        for (Flight flight : flights.values()) {
            System.out.println(flight);
        }
    }
    
    public void printPlaneDetails() {
        System.out.println("Give the airplane id:");
        String planeID = scanner.nextLine();
        System.out.println(this.planes.get(planeID));
    }
}
