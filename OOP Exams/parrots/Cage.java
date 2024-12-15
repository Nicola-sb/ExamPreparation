package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    //Next, write a Java class Cage that has data (a collection which stores the entity Parrot).
    // All entities inside the repository have the same fields. Also, the Cage class should have those fields:
    //•	name: String
    //•	capacity: int
    //•	data: List<Parrot> that holds added parrots
    private String name;
    private int capacity;
    private List<Parrot> data;
    //The class constructor should receive (name, capacity), also it should initialize the data with a new instance of the collection.

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    //•	getName()
    //•	getCapacity()
    //•	add(Parrot parrot) method - adds an entity to the data if there is room for it
    //•	remove(String name) method - removes a parrot by given name, if such exists, and returns boolean
    //•	sellParrot(String name) method - sell (set its available property to false without removing it from the collection) the first parrot with the given name, also return the parrot
    //•	sellParrotBySpecies(String species) method - sells and returns all parrots from that species as a List
    //•	count() - returns the number of parrots
    private String getName(){
        return name;
    }
    private int getCapacity(){
        return capacity;
    }
    public void add(Parrot parrot){
        if(capacity>data.size()){
            data.add(parrot);
        }
    }
    public boolean remove(String name){
       return data.removeIf(e -> e.getName().equals(name));
    }
    public Parrot sellParrot(String name){
        // public Parrot sellParrot(String name) {
        //        Parrot toReturn = null;
        //        for (Parrot r: this.data){
        //            if(r.getName().equals(name)){
        //                r.setAvailable(false);
        //                toReturn = r;
        //            }
        //        }
        //        return toReturn;
        //    }
        // sell (set its available property to false without removing it from the collection) the first parrot with the given name, also return the parrot
        Parrot parrotToReturn=null;
        for (Parrot parrot:data){
            if(parrot.getName().equals(name)){
                parrot.setAvailable(false);
                parrotToReturn=parrot;
            }
        }
        return parrotToReturn;
    }
    public List<Parrot> sellParrotBySpecies(String species){
//        sells and returns all parrots from that species as a List
//        public List<Parrot> sellParrotBySpecies(String species) {
//                List<Parrot> toReturn = new ArrayList<>();
//                this.data.forEach(i -> {
//                    if (i.getSpecies().equals(species)) {
//                        i.setAvailable(false);
//                        toReturn.add(i);
//                    }
//                });
//                return toReturn;
//            }
        List<Parrot>parrotToReturn=new ArrayList<>();
        for (Parrot currentParrot:data){
            if(currentParrot.getSpecies().equals(species)){
                currentParrot.setAvailable(false);
                parrotToReturn.add(currentParrot);
            }
        }
        return parrotToReturn;
    }
    public int count(){
        return data.size();
    }
    //•	report() - returns a String in the following format, including only not sold parrots:
    //o	"Parrots available at {cageName}:
    //{Parrot 1}
    //{Parrot 2}
    //(…)"
    public String report(){
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("Parrots available at %s:",name)).append(System.lineSeparator());
        for (Parrot currentParrot:data){
            builder.append(currentParrot).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
