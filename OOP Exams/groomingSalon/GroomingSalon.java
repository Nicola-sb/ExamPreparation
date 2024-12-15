package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon { // 90 ot 100
    //Next, write a Java class GroomingSalon that has data (a collection, which stores the Pets).
    // All entities inside the repository have the same fields. Also, the GroomingSalon class should have those fields:
    //•	capacity: int
    private List<Pet> data;
    private int capacity;
    //The class constructor should receive capacity, also it should initialize the data with a new instance of the collection.

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    //•	Method add(Pet pet) – adds an entity to the data if there is an empty place in the grooming salon for the pet.
    //•	Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
    //•	Method getPet(String name, String owner) – returns the pet with the given name and owner or null if no such pet exists.
    //•	Getter getCount – returns the number of pets.
    //•	getStatistics() – returns a String in the following format:
    //o	" The grooming salon has the following clients:
    //{name} {owner}
    //{name} {owner}
    //   (…)"
    public void add(Pet pet){
        if(data.size()<capacity){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        //•	Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
        return data.removeIf(element->element.getName().equals(name));
    }
    public Pet getPet(String name, String owner){
        //•	Method getPet(String name, String owner) – returns the pet with the given name and owner or null if no such pet exists.
        for (Pet currentPet:data){
            if(currentPet.getName().equals(name)&& currentPet.getOwner().equals(owner)){
                return currentPet;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	" The grooming salon has the following clients:
    //{name} {owner}
    //{name} {owner}
    //   (…)"
    public String getStatistics(){
        StringBuilder builder=new StringBuilder();
        builder.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet currentPet:data){
            builder.append(currentPet.getName()).append(" ").append(currentPet.getOwner()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
