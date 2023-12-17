package FlightControl;

import java.util.HashMap;
import java.util.Scanner;
import FlightControl.logic.*;
import FlightControl.domain.*;

public class Main {

    public static void main(String[] args) {
        
        // Write the main program here. It is useful to create some classes of your own
        
        String testInput = "1\n" +
"AY-123\n" +
"108\n" +
"2\n" +
"AY-123\n" +
"HEL\n" +
"TXL\n" +
"2\n" +
"AY-123\n" +
"JFK\n" +
"HEL\n" +
"x\n" +
"2\n" +
"x";
        
        
        
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Plane> planes = new HashMap<>();
        HashMap<String, Flight> flights = new HashMap<>();
        AssetControl assetControl = new AssetControl(scanner, planes, flights);
        FlightControl flightControl = new FlightControl(scanner, planes, flights);
        UserInterface ui = new UserInterface(scanner, assetControl, flightControl);

        ui.start();
    }
}
