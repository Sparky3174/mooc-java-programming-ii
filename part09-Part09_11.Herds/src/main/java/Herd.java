/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.util.ArrayList;
public class Herd implements Movable {
    private ArrayList<Movable> herdOrganisms;
    
    public Herd() {
        this.herdOrganisms = new ArrayList<>();
    }
    
    public void addToHerd(Movable organism) {
        this.herdOrganisms.add(organism);
    }
    
    public void move(int distanceX, int distanceY) {
        for (Movable organism : herdOrganisms) {
            organism.move(distanceX, distanceY);
        }
    }
    
    public String toString() {
        StringBuilder herd = new StringBuilder();
        for (Movable organism : herdOrganisms) {
            herd.append(organism);
            if (herdOrganisms.indexOf(organism) < herdOrganisms.size() - 1) {
                herd.append("\n");
            }
        }
        return herd.toString();
    }
}
