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

public class StorageFacility {
    private HashMap<String,ArrayList> storageUnits;
    
    public StorageFacility() {
        this.storageUnits = new HashMap<>();
    }
    //Storage units will be a hashmap containing storageUnits, each storageUnit will correspond to an arraylist that contains the items in the unit.
   
    //if the unit does not exist, make it.
    //then/or add item to unit.
    public void add(String unit, String item) {
        if (!storageUnits.containsKey(unit)) {
            storageUnits.put(unit, new ArrayList<>());
        }
        storageUnits.get(unit).add(item);
    }
    
    //find the unit specified, then return it's list of items, if the unit does not exist, return an empty list.
    public ArrayList<String> contents(String storageUnit) {
        return storageUnits.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item) {
        storageUnits.get(storageUnit).remove(item);
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> listOfStorageUnits = new ArrayList<>();
        for (String storageUnit : storageUnits.keySet()) {
            if (!storageUnits.get(storageUnit).isEmpty()) {
                listOfStorageUnits.add(storageUnit);
            }
        }
        return listOfStorageUnits;
    }
}
