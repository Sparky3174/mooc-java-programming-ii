
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {

    public static void main(String[] args) {
        getRatings().forEach(System.out::println);
    }

    public static ArrayList<LiteracyRating> getRatings() {
        ArrayList<LiteracyRating> list = new ArrayList<>();
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .map(p -> new LiteracyRating(p[3], p[2].replace(" (%)", ""), Integer.valueOf(p[4]), Double.valueOf(p[5]))).sorted().forEach(list::add);
            return list;
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
        return null;
    }
}
