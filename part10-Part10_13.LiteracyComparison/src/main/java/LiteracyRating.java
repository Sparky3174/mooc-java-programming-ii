/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class LiteracyRating implements Comparable<LiteracyRating> {
    private String country;
    private String gender;
    private int year;
    private double literacyRate;
    
    public LiteracyRating(String country, String gender, int year, double literacyRate) {
        this.country = country;
        this.year = year;
        this.literacyRate = literacyRate;
        this.gender = gender;
    }
    
    
    public double getLiteracyRate() {
        return this.literacyRate;
    }
    
    public String toString() {
        return this.country + " (" + this.year +")," + this.gender + ", " + this.literacyRate;
    }
    
    @Override
    public int compareTo(LiteracyRating rating) {
        return Double.compare(literacyRate, rating.getLiteracyRate());
    }
    
}
