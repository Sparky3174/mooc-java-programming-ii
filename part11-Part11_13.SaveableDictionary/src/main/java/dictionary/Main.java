package dictionary;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here
        
SaveableDictionary s = new SaveableDictionary();
s.add("apina", "monkey");
s.add("tietokone", "computer");
        System.out.println(s.translate("monkey"));
    }
}
