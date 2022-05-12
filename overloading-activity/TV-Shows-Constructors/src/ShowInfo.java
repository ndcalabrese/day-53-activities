import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;


public class ShowInfo {
    public static void main(String[] args) {

        ArrayList<TvShow> listOfShows = new ArrayList<>();

        // Add objects using new, overloaded constructors
        // Remember, null is falsy
        TvShow theWire = new TvShow("The Wire", 60, "drama");
        TvShow theSimpsons = new TvShow("The Simpsons", 726);
        TvShow bigBangTheory = new TvShow("Big Bang Theory", "trash");
        TvShow familyGuy = new TvShow(386, "animated comedy");
        TvShow iLoveLucy = new TvShow("I Love Lucy");
        TvShow spongeBobSquarePants = new TvShow(248);
        TvShow noProps = new TvShow();

        noProps.setName("Whose Line Is It Anyway?");
        noProps.setNumEpisodes(379);
        noProps.setGenre("Comedy");

        Collections.addAll(listOfShows, theWire, theSimpsons, bigBangTheory,
                familyGuy, iLoveLucy, spongeBobSquarePants, noProps);

        listOfShows.addAll(addShows());

        displayShows(listOfShows);

    }

    public static ArrayList<TvShow> addShows() {
        ArrayList<TvShow> listOfShows = new ArrayList<>();
        TvShow newShow = new TvShow();
        int numEpisodes = 0;

        while (true) {

            System.out.print("\nEnter the name of the show: ");
            String name = getUserInput();
            if (checkIfDoneAdding(name)) {
                break;
            }

            newShow.setName(name);

            while (true) {
                System.out.print("\nHow many episodes of " + name + " are there?: ");
                String stringNumEpisodes = getUserInput();

                if (isNumeric(stringNumEpisodes)) {
                    numEpisodes = Integer.parseInt(stringNumEpisodes);
                    if (numEpisodes > 0) {
                        newShow.setNumEpisodes(numEpisodes);
                        break;
                    } else {
                        System.out.println("\nInvalid response.");
                    }
                } else {
                    System.out.println("\nInvalid response.");
                }
            }

            System.out.print("\nWhat is the genre?: ");
            newShow.setGenre(getUserInput());

            listOfShows.add(newShow);
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
