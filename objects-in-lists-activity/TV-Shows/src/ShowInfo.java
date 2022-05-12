import java.util.Scanner;
import java.util.ArrayList;


public class ShowInfo {
    public static void main(String[] args) {
        ArrayList<TvShow> listOfShows = addShows();
        displayShows(listOfShows);

    }

    public static ArrayList<TvShow> addShows() {
        ArrayList<TvShow> listOfShows = new ArrayList<>();
        int numEpisodes = 0;

        while (true) {

            System.out.print("\nEnter the name of the show: ");
            String name = getUserInput();
            if (checkIfDoneAdding(name)) {
                break;
            }

            while (true) {
                System.out.print("\nHow many episodes of " + name + " are there?: ");
                String stringNumEpisodes = getUserInput();

                if (isNumeric(stringNumEpisodes)) {
                    numEpisodes = Integer.parseInt(stringNumEpisodes);
                    if (numEpisodes > 0) {
                        break;
                    } else {
                        System.out.println("\nInvalid response.");
                    }
                } else {
                    System.out.println("\nInvalid response.");
                }
            }

            System.out.print("\nWhat is the genre?: ");
            String genre = getUserInput();

            listOfShows.add(new TvShow(name, numEpisodes, genre));
        }

        return listOfShows;
    }

    public static void displayShows(ArrayList<TvShow> listOfShows) {
        System.out.println("\n--Show Info--");
        for (TvShow show : listOfShows) {
            System.out.println("\n" + show.toString());
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
