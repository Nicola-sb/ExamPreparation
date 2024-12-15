package easterBasket;

import java.util.*;

public class Basket {
    //•	material: String
    //•	capacity: int
    private String material;
    private int capacity;
    private List<Egg>data;

    //The class constructor should receive material and capacity, also it should initialize the data with a new instance of the collection. Implement the following features:

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    //•	List<Egg> data - collection that holds added eggs

    //•	Method addEgg(Egg egg) – adds an entity to the data if there is room for it
    //•	Method removeEgg(string color) – removes an egg by given color, if such exists, and returns boolean (true if it is removed, otherwise – false)
    //•	Method getStrongestEgg()– returns the strongest egg
    //•	Method getEgg(string color) – returns the egg with the given color
    //•	Method getCount – returns the number of eggs
    public void addEgg(Egg egg){
        if(capacity>data.size()){
            data.add(egg);
        }
    }
    public boolean removeEgg(String color){
        return data.removeIf(e -> e.getColor().equals(color));
    }
    public Egg getStrongestEgg(){
        //return Collection.max(data,(e1,e2) -> Integer.compare(e1.getAge(),e2.getAge()));
        return Collections.max(data,(e1,e2) -> Integer.compare(e1.getStrength(),e2.getStrength()));
//        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);

    }
    public Egg getEgg(String color){
        //Method getEgg(string color) – returns the egg with the given color
        for (Egg currentEgg:data){
            if(currentEgg.getColor().equals(color)){
                return currentEgg;
            }
        }
        return null;
//        return data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    //•	Method report() – returns a string in the following format (print the eggs in order of appearance):
    //o	"{material} basket contains:
    //{Egg1}
    //{Egg2}
    //(…)"
    public String report(){
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("%s basket contains:",material)).append(System.lineSeparator());
        for (Egg currentEgg:data){
            builder.append(currentEgg).append(System.lineSeparator());
        }
        return builder.toString();
    }

}
