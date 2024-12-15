package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Workout {
    //•	type: String
    //•	exerciseCount: int
    private String type;
    private int exerciseCount;
    private List<Exercise>exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises=new ArrayList<>();
    }
    //•	Method addExercise(Exercise exercise) – adds an entity to the exercises If there is still space on the workout sheet (exerciseCount).
    //•	Method removeExercise(String name, String muscle) – removes the exercise by given name and muscle, if such exists, and returns boolean.
    //•	Method getExercise(String name, String muscle) – returns the exercise with the given name and muscle or null if there is no such exercise.
    //•	Method getMostBurnedCaloriesExercise() – returns the exercise which is burned the most calories or null if there are no exercises.
    //•	Getter getExerciseCount() – returns the number of exercises
    public void addExercise(Exercise exercise){
        if(exerciseCount>exercises.size()){
            exercises.add(exercise);
        }
    }
    public boolean removeExercise(String name, String muscle){
        for (Exercise currentExxercise:exercises){
            if(currentExxercise.getName().equals(name)&&currentExxercise.getMuscle().equals(muscle)){
                exercises.remove(currentExxercise);
                return true;
            }
        }
        return false;
    }
    public Exercise getExercise(String name, String muscle){
        for (Exercise currentExxercise:exercises){
            if(currentExxercise.getName().equals(name)&&currentExxercise.getMuscle().equals(muscle)){
                return currentExxercise;
            }
        }
        return null;
    }
    public Exercise getMostBurnedCaloriesExercise(){
        // return Collections.max(data,(e1,e2) -> Integer.compare(e1.getStrength(),e2.getStrength()));
        return Collections.max(exercises,(e1,e2)-> Integer.compare(e1.getBurnedCalories(),e2.getBurnedCalories()));
    }
    public int getExerciseCount(){
        return exercises.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	"Workout type: {workout type}
    //Exercise: {Exercise1}
    //Exercise: {Exercise2}
    //(…)"
    public String getStatistics(){
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("Workout type: %s",type)).append(System.lineSeparator());
        for (Exercise currentExercise:exercises){
            builder.append("Exercise:").append(currentExercise).append(System.lineSeparator());
        }
        return builder.toString();
    }

}
