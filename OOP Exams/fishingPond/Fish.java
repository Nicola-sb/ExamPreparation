package fishingPond;

public class Fish {
    private String species;
    private int age;
    private String matingSeason;

    public Fish(String species, int age, String matingSeason) {
        this.species = species;
        this.age = age;
        this.matingSeason = matingSeason;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMatingSeason() {
        return matingSeason;
    }

    public void setMatingSeason(String matingSeason) {
        this.matingSeason = matingSeason;
    }

    @Override
    public String toString() {
      //This {species} is {age} years old and reproduces through {matingSeason}."
        return String.format("This %s is %d years old and reproduces through %s.",species,age,matingSeason);
    }
}
