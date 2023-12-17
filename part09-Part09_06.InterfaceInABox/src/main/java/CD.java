/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class CD implements Packable {

    private String artist;
    private String name;
    private int publicationYear;
    private double weight;

    public CD(String artist, String name, int publicationYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
        this.weight = 0.1;
    }

    public double weight() {
        return this.weight;
    }
    
    public String toString() {
        return artist + ": " + name + " (" + publicationYear + ")";
    }
}
