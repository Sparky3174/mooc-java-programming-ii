
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
//        String userin = scan.nextLine();
//        String[] usercommand = userin.split(" ");
        Container containerOne = new Container("First");
        UserInterface ui = new UserInterface();
        ui.start();
    }
    
    

}
