
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // you may try out your class here
        Hideout<Scanner> h = new Hideout();
        
        h.putIntoHideout(scanner);
        System.out.println(h.isInHideout());
        System.out.println(h.takeFromHideout());
        System.out.println(h.isInHideout());
        

    }
}
