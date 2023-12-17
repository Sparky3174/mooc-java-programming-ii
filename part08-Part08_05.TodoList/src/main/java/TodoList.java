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
import java.util.Scanner;

public class TodoList {

    private ArrayList<String> todoList;

    public TodoList() {
        this.todoList = new ArrayList<>();
    }

    public void add(String task) {
        this.todoList.add(task);
    }

    public void remove(int index) {
        this.todoList.remove(index - 1);
    }

    public void print() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ": " + todoList.get(i));
        }
    }

}
