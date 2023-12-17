
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         ArrayList<Integer> userInputs = new ArrayList<>();

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            
            if (input < 0) {
                break;
            }
            userInputs.add(input);
        }
        userInputs.stream().filter(num -> num >= 0 && num <= 5).forEach(System.out::println);
    }
}
