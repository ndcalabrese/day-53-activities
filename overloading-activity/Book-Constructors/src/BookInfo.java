import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;


public class BookInfo {
    public static void main(String[] args) {

        ArrayList<Book> listOfBooks = new ArrayList<>();

        // Add objects using new, overloaded constructors
        // Remember, null is falsy
        Book theCountOfMonteCristo = new Book("The Count of Monte Cristo", 640, 1844);
        Book toKillAMockingbird = new Book("To Kill a Mockingbird", 281);
        Book theHobbit = new Book("The Hobbit", 1937);
        Book choke = new Book("Choke");
        Book theRoad = new Book(287);
        Book noProps = new Book();

        noProps.setTitle("The Jungle");
        noProps.setNumPages(413);
        noProps.setPubYear(1906);

        Collections.addAll(listOfBooks, theCountOfMonteCristo, toKillAMockingbird,
                theHobbit, choke, theRoad, noProps);

        listOfBooks.addAll(addBooks());

        displayBooks(listOfBooks);

    }

    public static ArrayList<Book> addBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        int numPages;
        int pubYear;

        listOfBooks.add(new Book("Nineteen Eighty-Four", 328, 1949));
        listOfBooks.add(new Book("Harry Potter and the Sorcerer's Stone", 223, 1997));
        listOfBooks.add(new Book("Kitchen Confidential", 320, 2000));

        while (true) {

            System.out.print("\nEnter the title of the book: ");
            String title = getUserInput();
            if (checkIfDoneAdding(title)) {
                break;
            }

            while (true) {
                System.out.print("\nHow many pages does " + title + " have?: ");
                String stringNumPages = getUserInput();

                if (isNumeric(stringNumPages)) {
                    numPages = Integer.parseInt(stringNumPages);
                    if (numPages > 0) {
                        break;
                    } else {
                        System.out.println("\nInvalid response.");
                    }
                } else {
                    System.out.println("\nInvalid response.");
                }
            }

            while (true) {
                System.out.print("\nWhat year was " + title + " published?: ");
                String stringPubYear = getUserInput();

                if (isNumeric(stringPubYear)) {
                    pubYear = Integer.parseInt(stringPubYear);
                    if (pubYear > 0) {
                        break;
                    } else {
                        System.out.println("\nInvalid response.");
                    }
                } else {
                    System.out.println("\nInvalid response.");
                }
            }

            listOfBooks.add(new Book(title, numPages, pubYear));
        }

        return listOfBooks;
    }

    public static void displayBooks(ArrayList<Book> listOfBooks) {
        while (true) {
            System.out.print("\nWhat information will be printed?: ");
            String requestedData = getUserInput();

            if (requestedData.equalsIgnoreCase("everything")) {
                System.out.println("\n--Book Info--");
                for (Book book : listOfBooks) {
                    System.out.println(book.toString());
                }
                break;
            } else if (requestedData.equalsIgnoreCase("name")) {
                System.out.println("\n--Book Info--");
                for (Book book : listOfBooks) {
                    System.out.println(book.getTitle());
                }
                break;
            } else {
                System.out.println("\nInvalid response.");
            }
        }
        System.out.println("\n");
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static boolean checkIfDoneAdding(String userInput) {
        return userInput.equals("");
    }

    // Checks to see if an input string is a valid double
    // and returns a boolean
    public static boolean isNumeric(String amountInput) {
        try {
            Double.parseDouble(amountInput);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}
