
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        ArrayList<Integer> list = new ArrayList<>();
        
        //reading user input
        while (true) {
            String userin = scanner.nextLine();
            if (!userin.equals("end")) {
                list.add(Integer.valueOf(userin));
                continue;
            }
            break;
        }
        
        // calculating the average using a stream
        System.out.println("Average of the numbers: " + list.stream().mapToInt(s -> Integer.valueOf(s)).average().getAsDouble());


    }
}
