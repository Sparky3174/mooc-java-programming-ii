/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import java.util.Scanner;
import java.lang.StringBuilder;
import FlightControl.logic.*;

/**
 *
 * @author Andre
 */
public class UserInterface {

    private Scanner scanner;
    private AssetControl assetControl;
    private FlightControl flightControl;

    public UserInterface(Scanner scanner, AssetControl assetControl, FlightControl flightControl) {
        this.scanner = scanner;
        this.assetControl = assetControl;
        this.flightControl = flightControl;
    }

    public void start() {
        readAssetControlCommands();
        readFlightControlCommands();
    }

    public void readAssetControlCommands() {
        boolean programIsRunning = true;
        while (programIsRunning) {
            printAssetControlCommands();
            String userin = this.scanner.nextLine();

            //parsing user command
            switch (userin) {
                case "1":
                    assetControl.addPlane();
                    break;
                case "2":
                    assetControl.addFlight();
                    break;
                case "x":
                    programIsRunning = false;
                    break;
            }
        }
    }

    public void readFlightControlCommands() {
        boolean programIsRunning = true;
        while (programIsRunning) {
            printFlightControlCommands();
            String userin = this.scanner.nextLine();

            switch (userin) {
                case "1":
                    flightControl.printPlanes();
                    break;
                case "2":
                    flightControl.printFlights();
                    break;
                case "3":
                    flightControl.printPlaneDetails();
                    break;
                case "x":
                    programIsRunning = false;
                    break;
            }
        }
    }

    public void printAssetControlCommands() {
        StringBuilder s = new StringBuilder();
        s.append("Airport Asset Control\n");
        s.append("[1] Add an airplane\n");
        s.append("[2] Add a flight\n");
        s.append("[x] Exit Airport Asset Control\n");
        s.append(">");
        System.out.println(s.toString());
    }

    public void printFlightControlCommands() {
        StringBuilder s = new StringBuilder();
        s.append("Flight Control");
        s.append("[1] Print airplanes");
        s.append("[2] Print flights");
        s.append("[3] Print airplane details");
        s.append("[x] Quit");
        s.append(">");
        System.out.println(s.toString());
    }
}
