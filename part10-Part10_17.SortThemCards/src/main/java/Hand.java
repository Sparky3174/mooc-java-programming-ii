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
import java.util.Collections;
public class Hand implements Comparable<Hand> {
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        this.cards.forEach(System.out::println);
    }
    
    public void sort() {
        this.cards.stream().sorted().forEach(System.out::println);
    }

    public int compareTo(Hand hand) {
        int thisValue = this.cards.stream().mapToInt(card -> card.getValue()).sum();
        int comparedValue = hand.cards.stream().mapToInt(card -> card.getValue()).sum();
        return thisValue - comparedValue;
    }
    
    public void sortBySuit() {
        this.cards.sort(new BySuitInValueOrder());
    }
    
}
