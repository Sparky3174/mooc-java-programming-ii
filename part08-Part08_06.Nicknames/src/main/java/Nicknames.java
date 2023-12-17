
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        HashMap map = new HashMap<String,String>();
                
        map.put("matthew", "matt");
        map.put("michael", "mike");
        map.put("arthur", "artie");
        System.out.println(map.get("matthew"));
    }

}
