package vetClinicCompileTimeError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    //Next, write a Java class Clinic that has data (a collection, which stores the Pets).
    // All entities inside the repository have the same fields. Also, the Clinic class should have those fields:
    //•	capacity: int
    private List<Pet>elements;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        elements=new ArrayList<>();
    }
    //Implement the following features:
    //•	Field data – List that holds added pets
    //•	Method add(Pet pet) – adds an entity to the data if there is an empty cell for the pet.
    //•	Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
    //•	Method getPet(String name, String owner) – returns the pet with the given name and owner or null if no such pet exists.
    //•	Method getOldestPet() – returns the oldest Pet.
    //•	Getter getCount – returns the number of pets.
    public void add(Pet pet){
        if(elements.size()<capacity){
            elements.add(pet);
        }
    }
    // //•	Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
    public boolean remove(String name){
          return  elements.removeIf(el -> el.getName().equals(name));
    }
    public Pet getPet(String name,String owner){
//         return elements.stream().filter(elem -> elem.getName().equals(name)&& elem.getOwner().equals(owner)).findFirst().orElse(null);
         for (Pet currentPet:elements){
             if(currentPet.getName().equals(name)&& currentPet.getOwner().equals(owner)){
                 return currentPet;
             }
         }

        return null;
    }
    //•	Method getOldestPet() – returns the oldest Pet.
    public Pet getOldestPet(){
       return Collections.max(elements, Comparator.comparingInt(Pet::getAge));
       //==return Collections.max(elements,(e1,e2)-> Integer.compare(e1.getAge(),e2.getAge()));
    }
    public int getCount(){
        return elements.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	"The clinic has the following patients:
    //{name} {owner}
    //{name} {owner}
    //   (…)"
    public String getStatistics(){
        StringBuilder builder=new StringBuilder();
        builder.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet petElement:elements){
            builder.append(petElement.getName()+ " "+petElement.getOwner()).append(System.lineSeparator());
        }
        return builder.toString();
    }

}
