/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.logic;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andre
 */
//store words and translations in hashmap
//need to be able to get a random word
//get specific translation
//check if a word exists
public class Dictionary {

    private HashMap<String, String> dictionary;
    private ArrayList<String> values;

    public Dictionary() {
        this.dictionary = new HashMap();
        this.values = new ArrayList();
    }

    public void add(String word, String translation) {
        this.dictionary.put(word, translation);
        this.dictionary.put(translation, word);
    }

    public String getTranslation(String word) {
        return this.dictionary.get(word);
    }

    public String getRandomWord() {
        Random random = new Random();
        this.values.addAll(this.dictionary.values());
        if (dictionary.isEmpty()) {
            System.out.println("The dictionary is empty");
            return "The dictionary is Empty!";
        }
        return this.values.get(random.nextInt(this.values.size()));
    }

    public boolean checkTranslation(String translationToCheck, String attemptedWord) {
        if (translationToCheck.equals(this.dictionary.get(attemptedWord))) {
            return true;
        } else {
            return false;
        }
    }

}
