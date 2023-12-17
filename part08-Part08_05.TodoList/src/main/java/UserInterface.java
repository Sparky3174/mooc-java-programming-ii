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
public class UserInterface {
    private TodoList todoList;
    private Scanner scanner;
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.todoList = list;
        this.scanner = scanner;
    }
    
    public void start() {
        boolean programIsRunning = true;
        while (programIsRunning) {
            System.out.println("Command:");
            String userCommand = scanner.nextLine();
            switch (userCommand) {
                case "add":
                    System.out.println("To add:");
                    String task = scanner.nextLine();
                    todoList.add(task);
                    break;
                case "remove":
                    System.out.println("Which one is removed?");
                    int index = Integer.valueOf(scanner.nextLine());
                    todoList.remove(index);
                      break;
                case "list":
                    todoList.print();
                      break;
                case "stop":
                    programIsRunning = false;
                    break;
            }
        }
    }
    
}
