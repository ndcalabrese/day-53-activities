import java.util.Scanner;
import java.util.ArrayList;


public class AnimalMenu {
    public static void main(String[] args) {

        System.out.println("--Animal Menu--");
        System.out.println("Entering nothing will stop the loop");

        ArrayList<Animal> listOfAnimals = addAnimals();
        displayAnimals(listOfAnimals);

    }

    public static ArrayList<Animal> addAnimals() {
        ArrayList<Animal> listOfAnimals = new ArrayList<>();

        while (true) {

            System.out.print("\nPlease enter a name: ");
            String name = getUserInput();

            if (name.equals("")) {
                System.out.println("\nHere is the list of animals: \n");
                break;
            }

            String inputIsDog;
            boolean isDog = false;
            while (true) {
                System.out.print("\nIs it a dog? Yes or no: ");
                inputIsDog = getUserInput();
                if (!inputIsDog.equalsIgnoreCase("yes")
                        && !inputIsDog.equalsIgnoreCase("y")
                        && !inputIsDog.equalsIgnoreCase("no")
                        && !inputIsDog.equalsIgnoreCase("n")) {
                    System.out.println("\nInvalid response");
                } else {
                    switch (inputIsDog.toLowerCase()) {
                        case "yes", "y" -> isDog = true;
                        case "no", "n" -> isDog = false;
                    }
                    break;
                }
            }
            listOfAnimals.add(new Animal(name, isDog));
        }

        return listOfAnimals;
    }

    public static void displayAnimals(ArrayList<Animal> listOfAnimals) {
        for (Animal animal : listOfAnimals) {
            System.out.println(animal.toString());
        }
        System.out.println("\n");
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}
