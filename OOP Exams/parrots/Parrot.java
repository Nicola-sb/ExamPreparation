package parrots;

public class Parrot {
    //•	name: String
    //•	species: String
    //•	available: boolean - true by default
    private String name;
    private String species;
    private boolean available;
    //The class constructor should receive (name, species).
    //The class should also have the following methods:
    //•	getName()
    //•	getSpecies()
    //•	isAvailable()
    //•	setAvailable()
    //•	Override the toString() method in the format:
    //"Parrot ({species}): {name}"

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
        this.available=true;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }
    public boolean isAvailable(){
          return this.available;
    }
    public void setAvailable(boolean currentBool){
           this.available=currentBool;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s",species,name);
    }
}
