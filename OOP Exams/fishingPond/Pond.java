package fishingPond;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pond {

    private int capacity;
    private List<Fish>fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        fishes=new ArrayList<>();
    }

    public void addFish(Fish fish){
        if(capacity>fishes.size()){
            fishes.add(fish);
        }
    }

    public boolean removeFish(String species){
        return fishes.removeIf(fish -> fish.getSpecies().equals(species));
    }

    public Fish getOldestFish(){
        return Collections.max(fishes,(f,s) -> Integer.compare(f.getAge(),s.getAge()));
    }

    public Fish getFish(String species){
        return fishes.stream().filter(fish -> fish.getSpecies().equals(species)).findFirst().orElse(null);
    }

    public int getCount(){
        return fishes.size();
    }
    public int getVacancies(){
        return capacity - fishes.size();
    }

    public String report(){
        StringBuilder builder=new StringBuilder();
        builder.append("Fishes in the pond:").append(System.lineSeparator());
        for (Fish currentFish : fishes) {
            builder.append(String.format("This %s is %d years old and reproduces through %s.",currentFish.getSpecies(),currentFish.getAge(),currentFish.getMatingSeason())).append(System.lineSeparator());
        }
        return builder.toString();
    }

}
