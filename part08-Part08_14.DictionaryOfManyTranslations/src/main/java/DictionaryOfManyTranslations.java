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
import java.util.HashMap;
public class DictionaryOfManyTranslations {
    private HashMap<String,ArrayList> dictionary;
    private ArrayList<String> translations;
    
    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
        this.translations = new ArrayList<>();
    }
    
    public void add(String word, String translation) {
        if (!dictionary.keySet().contains(word)) {
            dictionary.put(word, new ArrayList<>());
            dictionary.get(word).add(translation);
            return;
        }
        this.dictionary.get(word).add(translation);
    }
    
    public ArrayList<String> translate(String word) {
        return dictionary.getOrDefault(word, new ArrayList<>());
    }
    
    public void remove(String word) {
        dictionary.remove(word);
    }
}
