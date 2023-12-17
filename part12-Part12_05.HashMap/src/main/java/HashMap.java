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
import java.util.List;

public class HashMap<K, V> {

    private List<Pair<K, V>>[] hashMap;
    private int firstEmptyIndex;

    public HashMap() {
        this.hashMap = new List[32];
        this.firstEmptyIndex = 0;
    }

    public V getValue(K key) {
        int hashValue = calcHashValue(key);
        if (this.hashMap[hashValue] == null) {
            return null; //obviously, if the index described is empty, then this method will return nothing.
        }

        List<Pair<K, V>> valuesAtIndex = this.hashMap[hashValue]; //find the list located at the index descibed

        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (key == valuesAtIndex.get(i).getKey()) { //for every pair in the given list, check if the key(s) given are equal to the keys of the pairs
                return valuesAtIndex.get(i).getValue(); //if so, return the pair value
            }
        }
        return null;
    }

    public void add(K key, V value) {

        //The method first calculates the hash value for the key, and uses it to determine the suitable index in the internal array.
        //If there is no value in that index, we create a list into that index. 
        //After this the method goes through the list at the index, and looks for a key-value pair whose key matches the key of the key-value pair to be added.
        //If the matching key is found, the value related to it is updated to match the new value. 
        //Otherwise the method adds a new key-value pair in the list — in which case the number of stored values is also incremented by one.
        List<Pair<K, V>> specifiedList = getListFromKey(key);
        int index = getIndexFromKey(key, specifiedList);

        if (index != -1) { //if the pair was found (if not found, -1 is returned)
            specifiedList.get(index).setValue(value); //set the value of the pair to the value given
        } else {
            specifiedList.add(new Pair<>(key, value)); //Otherwise, make a new pair in the list with the given key + value
            this.firstEmptyIndex++;
        }
        firstEmptyIndex++; //obviously, the index that used to be empty is now full, so that needs to be specified.

        if (1.0 * this.firstEmptyIndex / this.hashMap.length > 0.75) { //if the hashmap is 75% full, grow.
            grow();
        }

    }

    public int getIndexFromKey(K key, List<Pair<K, V>> specifiedList) {
        for (int i = 0; i < specifiedList.size(); i++) { //for every pair inside the list specified
            if (specifiedList.get(i).getKey() == key) { //checks to see if there is a pair inside the list with the key
                return i; //if so, return the index that the pair was found at
            }
        }
        return -1; //else, return -1 (not found)
    }

    public List<Pair<K, V>> getListFromKey(K key) {
        int hashValue = calcHashValue(key); //calculate where the list must be based on the key

        if (hashMap[hashValue] == null) { //if the location (hashValue) checked is empty, make a blank list to fill it with
            hashMap[hashValue] = new ArrayList<>();
        }

        return hashMap[hashValue]; //return the list that does (or now does) exist at the determined index
    }

    public int calcHashValue(K key) {
        int hashValue = Math.abs(key.hashCode() % this.hashMap.length); //calculates where the given value should exist using the Modulo (%) function.
        return hashValue;
    }

    public void grow() {
        int oldArrayLength = hashMap.length;
        List[] newArray = new List[oldArrayLength * 2]; //make a new array that is double the size of the original

        for (int i = 0; i < this.hashMap.length; i++) { //copies each index
            copy(newArray, i);
        }

        this.hashMap = newArray; //sets the new array as the internal array
    }

    public void copy(List<Pair<K, V>>[] newArray, int listIndex) {

        for (int i = 0; i < this.hashMap[listIndex].size(); i++) { //for every list of key/value pairs in the hashMap
            Pair<K, V> copiedPair = this.hashMap[listIndex].get(i);
            int hashValue = Math.abs(copiedPair.getKey().hashCode() % newArray.length); //calculate the new hashValue (location) for each item, as we want the values to be at different locations

            if (newArray[hashValue] == null) { //checks if the index calculated is empty
                newArray[hashValue] = new ArrayList<>(); //if so, put an empty arraylist in it's place.
            }

            newArray[hashValue].add(copiedPair); //then add the pair that was copied from the old array to the specidied list inside the new array.
        }
    }

    public V remove(K key) {
        List<Pair<K, V>> listToRemoveFrom = getListFromKey(key); //gets the list that contains the key of the pair to be removed
        if (listToRemoveFrom == null) { //if the list is not found, stop and return null
            return null;
        }

        int index = getIndexFromKey(key, listToRemoveFrom);
        if (index == -1) { //if the index is not found, stop and return null
            return null;
        }

        Pair<K, V> pairToRemove = listToRemoveFrom.get(index); //save the pair to be removed as a variable
        listToRemoveFrom.remove(pairToRemove); //remove the pair
        return pairToRemove.getValue(); //return the value of the pair that was removed.
    }
}
