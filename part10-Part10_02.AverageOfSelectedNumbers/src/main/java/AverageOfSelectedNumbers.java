
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        // toteuta ohjelmasi tänne
        while (true) {
            String userin = scanner.nextLine();
            if (!userin.equals("end")) {
                list.add(Integer.valueOf(userin));
                continue;
            }
            break;
        }

        //calc positive numbers
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String userin = scanner.nextLine();
        if (userin.equals("p")) {
            System.out.println("Average of the numbers: " + list.stream().mapToInt(s -> Integer.valueOf(s)).filter(s -> s > 0).average().getAsDouble());
        } else if (userin.equals("n")) {
            System.out.println("Average of the numbers: " + list.stream().mapToInt(s -> Integer.valueOf(s)).filter(s -> s < 0).average().getAsDouble());
        }

    }
}
