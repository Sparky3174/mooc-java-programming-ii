/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class Book {
    private String name;
    private int ageRecommendation;
    
    public Book(String name, int ageRecommendation) {
        this.name = name;
        this.ageRecommendation = ageRecommendation;
    }
    
    public int getAgeRecommendation() {
        return this.ageRecommendation;
    }
    
    public String getName() {
        return this.name;
    }
   
    
    @Override
    public String toString() {
        return this.name + " (recommended for " + this.ageRecommendation + " year-olds or older)";
    }
}
