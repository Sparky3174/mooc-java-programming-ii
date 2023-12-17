package dictionary;

/**
 *
 * @author Andre
 */
import java.util.HashMap;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.File;
import java.util.NoSuchElementException;

public class SaveableDictionary {

    private HashMap<String, String> dictionary;
    private PrintWriter writer;
    private File file;

    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.file = new File(file);
    }

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public boolean load() {
        try {
            Scanner scanner = new Scanner(Paths.get(file.getName()));
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(":");
                this.dictionary.put(line[0], line[1]);
            }
        } catch (Exception e) {
            System.out.println("Error! " + e);
            return false;
        }
        return true;
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(file.getName());
            for (HashMap.Entry<String,String> entry : dictionary.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error! " + e);
            return false;
        }
        return true;
    }

    public void add(String word, String translatedWord) {
        this.dictionary.putIfAbsent(word, translatedWord);
    }

    public String translate(String word) {
        for (String key : dictionary.keySet()) {
            String value = dictionary.get(key);
            if (value.equals(word)) {
                return key;
            } else if (key.equals(word)) {
                return value;
            }
        }
        return null;
    }

    public void delete(String word) {
        Iterator<HashMap.Entry<String, String>> iterator = dictionary.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<String, String> value = iterator.next();
            if (value.getValue().equals(word) || value.getKey().equals(word)) {
                iterator.remove();
            }
        }
    }
}
