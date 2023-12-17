/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class CustomTacoBox implements TacoBox {

    private int tacos;

    public CustomTacoBox(int tacos) {
        this.tacos = tacos;
    }

    public void eat() {
        if (this.tacos != 0) {
            this.tacos--;
        }
    }

    public int tacosRemaining() {
        return this.tacos;
    }

}
