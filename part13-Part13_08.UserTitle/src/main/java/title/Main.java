package title;

import javafx.application.Application;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give a title:");
        String userin = scanner.nextLine();
        System.out.println("OK! Starting application...");
        Application.launch(UserTitle.class, userin);
        
    }

}
