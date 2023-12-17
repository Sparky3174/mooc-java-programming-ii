
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class MainProgram {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        getBooks(books);

    }

    public static void getBooks(ArrayList books) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input the name of the book, empty stops:");
            String bookName = scanner.nextLine();
            if (bookName.isBlank()) {
                break;
            }
            System.out.println("Input the age recommendation:");
            int bookAge = Integer.valueOf(scanner.nextLine());
            Book book = new Book(bookName, bookAge);
            books.add(book);
        }

        System.out.println(books.size() + " books in total.");
        System.out.println("");
        System.out.println("Books:");

        Comparator<Book> comparator = Comparator
                .comparing(Book::getAgeRecommendation)
                .thenComparing(Book::getName);

        books.stream().sorted(comparator).forEach(System.out::println);
    }

    public static void sort(Book book) {

    }
}
