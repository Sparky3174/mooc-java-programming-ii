/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
import java.util.Scanner;
import java.util.ArrayList;
public class UserInterface {
    private Container containerOne;
    private Container containerTwo;
    private Scanner scanner;
    
    public UserInterface() {
        this.containerOne = new Container("First");
        this.containerTwo = new Container("Second");
        this.scanner = new Scanner(System.in);
    } 
    
    public void start() {
        doCommand();
    }
    
    
    public void doCommand() {
        //if amount exists, go into whatever
        //if amount is not negative, go into whatever
        
        
        boolean programIsRunning = true;
        while (programIsRunning) {
        System.out.println(containerOne);
        System.out.println(containerTwo);
        String userin = scanner.nextLine();
        String[] part = userin.split(" ");
                String command = part[0];
        if (part.length == 2) {
        int amount = Integer.valueOf(part[1]);
        if (amount > 0) {
            switch (command) {
                case "add":
                    this.add(amount);
                    break;
                case "remove":
                    this.remove(amount);
                    break;
                case "move":
                    this.move(amount);
                    break;
                case "quit":
                    programIsRunning = false;
                    break;
                default: 
                    System.out.println("Not a valid command!");
                    break;
        }
    } 
        } else {
            if (command.equals("quit")) {
                programIsRunning = false;
            }
        } 

        }
}
    
    public void move(int amount) {
// checking to make sure the user doesn't input a number larger than the first container contains.
        if (amount > containerOne.getAmount()) {
            containerTwo.add(containerOne.getAmount());
            containerOne.setAmount(0);
        } else {
            containerOne.remove(amount);
            containerTwo.add(amount);
        }
        
        
    }
    
    public void add(int amount) {
        containerOne.add(amount);
    }
    
    public void remove (int amount) {
        containerTwo.remove(amount);
    }
    
    public void quit () {
        
    }
            
}
