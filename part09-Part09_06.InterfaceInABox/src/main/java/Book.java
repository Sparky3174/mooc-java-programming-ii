/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class Book implements Packable {
    private String author;
    private String name;
    private double weight;
    
    public Book(String author, String name, double weight) {
        this.author = author;
        this.name = name;
        this.weight = weight;
    }
    
    public double weight() {
        return this.weight;
    }
    
    public String toString() {
        return author + ": " + name;
    }
    
}
