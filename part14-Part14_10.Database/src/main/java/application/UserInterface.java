package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            switch (command) {
                case "1":
                    System.out.println("Listing the database contents");
                    database.list().forEach(item -> System.out.println(item.toString()));
                    break;
                case "2":
                    System.out.println("Adding a new todo");
                    System.out.println("Enter name");
                    String itemName = scanner.nextLine();
                    System.out.println("Enter description");
                    String itemDescription = scanner.nextLine();
                    database.add(new Todo(database.list().size() + 1, itemName, itemDescription, false));
                    break;
                case "3":
                    System.out.println("Which todo should be marked as done (give the id)?");
                    int todoToMark = Integer.valueOf(scanner.nextLine());
                    database.markAsDone(todoToMark);
                    break;
                case "4":
                    System.out.println("Which todo should be removed (give the id)?");
                    int todoToRemove = Integer.valueOf(scanner.nextLine());
                    database.remove(todoToRemove);
                    break;
                case "x":
                    System.out.println("Thank you!");
                    running = false;
                    break;
            }

            // implement the functionality here
        }

    }

}
