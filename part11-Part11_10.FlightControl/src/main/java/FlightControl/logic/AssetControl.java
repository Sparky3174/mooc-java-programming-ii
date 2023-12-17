/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import java.util.Scanner;
import java.util.HashMap;
import FlightControl.domain.*;

/**
 *
 * @author Andre
 */
public class AssetControl {

    private Scanner scanner;
    private HashMap<String, Plane> planes;
    private HashMap<String, Flight> flights;

    public AssetControl(Scanner scanner, HashMap planes, HashMap flights) {
        this.planes = planes;
        this.flights = flights;
        this.scanner = scanner;
    }

    public void addPlane() {
        System.out.println("Give the airplane id:");
        String planeID = scanner.nextLine();
        System.out.println("Give the airplane capacity:");
        int planeCapacity = Integer.valueOf(scanner.nextLine());

        this.planes.put(planeID, new Plane(planeID, planeCapacity));
    }

    public void addFlight() {
        System.out.println("Give the airplane id:");

        String planeID = scanner.nextLine();
        if (!this.planes.containsKey(planeID)) {
            System.out.println("No airplane with the id " + planeID + ".");
            return;
        }
        System.out.println("Give the departure airport id:");
        String departureID = scanner.nextLine();
        System.out.println("Give the target airport id: ");
        String destinationID = scanner.nextLine();
        
        Flight flight = new Flight(this.planes.get(planeID), departureID, destinationID);
        flights.put(flight.toString(), flight);
    }
}
