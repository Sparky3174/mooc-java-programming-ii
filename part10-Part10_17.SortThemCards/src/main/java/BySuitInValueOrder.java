/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

    public int compare(Card card1, Card card2) {
        if (card1.getSuit().ordinal() - card2.getSuit().ordinal() != 0) { //checking if the suits are the same
            return card1.getSuit().ordinal() - card2.getSuit().ordinal(); //if they arent the same, check whether the 2nd card's suit is a higher priority than the first card, then place them accordingly
        } else {
            return card1.getValue() - card2.getValue(); //if the cards suits are the same, order the 2 cards by value.
        }
    }
    
}
