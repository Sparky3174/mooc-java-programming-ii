/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class Hideout<T> {

    private T object;

    public Hideout() {
    }

    public void putIntoHideout(T toHide) {
        this.object = toHide;
    }

    public T takeFromHideout() {
        if (this.object == null) {
            return null;
        } else {
            T placeholder = object;
            object = null;
            return placeholder;
        }
    }

    public boolean isInHideout() {
        if (this.object != null) {
            return true;
        } else {
            return false;
        }
    }

}
