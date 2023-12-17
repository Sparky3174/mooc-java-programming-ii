/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.util.Arrays;

public class List<T> {

    private T[] array;
    private int firstEmptyIndex;

    public List() {
        this.array = (T[]) new Object[10];
        this.firstEmptyIndex = 0;
    }

    public void add(T value) {
        //check if there is space inside the list
        //if not, make a new array that is 1.5x the size of the original one, then set the list to the new array
        //add the value to the new list
        //change the firstEmptyIndex to the index of the first null value in the array
        if (this.array[array.length - 1] != null) {
            grow(); //if there is no space in the array, grow()
        }
        this.array[this.firstEmptyIndex] = value;
        this.firstEmptyIndex++;
    }

    public void grow() {
        int oldArrayLength = this.array.length;
        T[] newArray = (T[]) new Object[oldArrayLength + oldArrayLength / 2];
        for (int i = 0; i < oldArrayLength; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
        this.firstEmptyIndex = oldArrayLength;
    }

    public boolean contains(T value) {
        if (indexOf(value) != -1) {
            return true;
        }
        return false;
    }

    public int indexOf(T value) {
        for (int i = 0; i < firstEmptyIndex; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void remove(T value) {
        if (contains(value)) {
            moveToTheLeft(indexOf(value) + 1);
            firstEmptyIndex--;
        }
    }

    public void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < firstEmptyIndex; i++) {
            array[i - 1] = array[i];
            array[i] = null;
        }
    }

    public T value(int index) {
        if (!(index >= 0 && index < firstEmptyIndex)) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstEmptyIndex + "]");
        }
        return array[index];
    }

    public int size() {
        return this.firstEmptyIndex;
    }

    public String toString() { //added this for debug purposes
        return Arrays.toString(array);
    }

}
