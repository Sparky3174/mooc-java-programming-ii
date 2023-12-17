
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your class here
        List<String> list = new List<>();
        list.add("test");
        list.add("yay");
        list.add("what.");
        list.add("when");
        list.add("where");
        list.add("how");
        System.out.println(list.contains("should be false"));
        System.out.println(list.indexOf("what."));
        list.remove("yay");
        list.remove("uh");
        System.out.println(list.toString());
        System.out.println(list.value(3));

    }

}
