package workout;

public class Exercise {
    //•	name: String
    //•	muscle: String
    //•	burnedCalories: int
    private String name;
    private String muscle;
    private int burnedCalories;

    public Exercise(String name, String muscle, int burnedCalories) {
        this.name = name;
        this.muscle = muscle;
        this.burnedCalories = burnedCalories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public int getBurnedCalories() {
        return burnedCalories;
    }

    public void setBurnedCalories(int burnedCalories) {
        this.burnedCalories = burnedCalories;
    }
    //Exercise: {name}, {muscle}, {burnedCalories}"

    @Override
    public String toString() {
        return String.format("Exercise: %s, %s, %d",name,muscle,burnedCalories);
    }
}
