
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        ArrayList<Integer> owo = new ArrayList<>();
        owo.add(-1);
        owo.add(2);
        System.out.println(positive(owo));

    }
    
    public static List<Integer> positive(List<Integer> numbers) {
        ArrayList<Integer> positives = numbers.stream().filter(number -> number > 0).collect(Collectors.toCollection((ArrayList::new)));
        return positives;
    }

}
