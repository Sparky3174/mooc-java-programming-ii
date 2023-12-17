
import java.util.Map;
import java.util.HashMap;
public class MainProgram {

    public static void main(String[] args) {
        // test your method here
        Map<String, String> map = new HashMap<>();

    }

    // Implement here a method returnSize, which takes a Map-object as a parameter 
    // and returns the size of the map object
    
    public static int returnSize(Map<String,String> map) {
        int sizeOfMap = 0;
        for (String string : map.keySet()) {
            sizeOfMap++;
        }
        return sizeOfMap;
    }
}
