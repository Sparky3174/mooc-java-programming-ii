
import java.util.Scanner;
import java.util.ArrayList;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            int userin = Integer.valueOf(scanner.nextLine());
            if (userin > 0) {
                numbers.add(userin);
            }
            if (userin == 0) {
                double sum = 0;
                for (int number : numbers) {
                    sum += number;
                }
                if (numbers.size() != 0) {
                    System.out.println(sum / numbers.size());
                    break;
                }
                System.out.println("Cannot calculate the average");
                break;
            }
        }
    }
}
