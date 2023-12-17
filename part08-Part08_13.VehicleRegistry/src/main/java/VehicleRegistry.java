/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    
    private HashMap<LicensePlate, String> vehicleRegistry;
    
    public VehicleRegistry() {
        vehicleRegistry = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (!vehicleRegistry.containsKey(licensePlate)) {
            vehicleRegistry.put(licensePlate, owner);
            return true;
        }
        return false;
    }
    
    public String get(LicensePlate licensePlate) {
        return vehicleRegistry.getOrDefault(licensePlate, null);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (vehicleRegistry.containsKey(licensePlate)) {
            vehicleRegistry.remove(licensePlate);
            return true;
        }
        return false;
    }
    
    public void printLicensePlates() {
        for (LicensePlate licensePlate : vehicleRegistry.keySet()) {
            System.out.println(licensePlate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> ownersPrinted = new ArrayList<>();
        for (LicensePlate licensePlate : vehicleRegistry.keySet()) {
            String owner = vehicleRegistry.get(licensePlate);
            if (!ownersPrinted.contains(owner)) {
                System.out.println(owner);
                ownersPrinted.add(owner);
            }
        }
    }
}
