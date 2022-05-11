public class Animal {
    // Declare private variables.
    private String name;
    private boolean isDog;

    // Class constructor
    public Animal(String animalName, boolean isAnimalDog) {
        this.name = animalName;
        this.isDog = isAnimalDog;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public boolean getIsDog() {
        return this.isDog;
    }

    @Override
    public String toString() {
        return this.getName() + " is a dog = " + this.getIsDog();
    }

}
