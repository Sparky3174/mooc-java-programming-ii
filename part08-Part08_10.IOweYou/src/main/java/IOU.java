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

public class IOU {
    private HashMap<String, Double> IOU;
    
    public IOU() {
        IOU = new HashMap<>();
    }
    
    //saves the amount owed and the person owed to to the IOU.
    public void setSum(String towhom, double amount) {
        IOU.put(towhom, amount);
    }
    
    // returns the amount owed to the person whose name is given as a parameter. If the person cannot be found, it returns 0.
    public double howMuchDoIOweTo(String toWhom) {
        return IOU.getOrDefault(toWhom, 0.0);
    }
    
}
