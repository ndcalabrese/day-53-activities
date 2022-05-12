public class Animal {
    // Declare private variables.
    private String name;
    private boolean isDog;

    // Class constructors
    public Animal(String animalName, boolean isAnimalDog) {
        this.name = animalName;
        this.isDog = isAnimalDog;
    }

    public Animal(String animalName) {
        this.name = animalName;
    }

    public Animal(boolean isAnimalDog) {
        this.isDog = isAnimalDog;
    }

    public Animal() { }

    // Getters
    public String getName() {
        return this.name;
    }

    public boolean getIsDog() {
        return this.isDog;
    }

    // Setters

    public void setName(String animalName) {
        this.name = animalName;
    }

    public void setIsDog(boolean isAnimalDog) {
        this.isDog = isAnimalDog;
    }

    @Override
    public String toString() {
        return this.getName() + " is a dog = " + this.getIsDog();
    }

}
