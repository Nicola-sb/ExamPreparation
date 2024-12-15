package shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shelter {
    //Next, write a Java class Shelter that has data (a List, which stores the Animals).
    // All entities inside the repository have the same fields. Also, the Shelter class should have those fields:
    //•	capacity: int
    private List<Animal>data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    //•	Field data – List that holds added animals
    //•	Method add(Animal animal) – adds an entity to the data if there is an empty cell for the animal.
    //•	Method remove(String name) – removes the animal by given name, if such exists, and returns boolean.
    //•	Method getAnimal(String name, String caretaker) – returns the animal with the given name and caretaker or null if no such animal exists.
    //•	Method getOldestAnimal() – returns the oldest Animal.
    //•	Getter getCount – returns the number of animals.
    public void add(Animal animal){
        if(data.size()<capacity){
            data.add(animal);
        }
    }
    public boolean remove(String name){
       return data.removeIf(e -> e.getName().equals(name));
    }
    //•	Method getAnimal(String name, String caretaker) – returns the animal with the given name and caretaker or null if no such animal exists.
    public Animal getAnimal(String name, String caretaker){
        for (Animal elementAnimal:data){
            if(elementAnimal.getName().equals(name)&& elementAnimal.getCaretaker().equals(caretaker)){
                return elementAnimal;
            }
        }
        return null;
    }
    ////•	Method getOldestAnimal() – returns the oldest Animal.
    public Animal getOldestAnimal(){
        //        return Collections.max(data,(e1,e2)->Integer.compare(e1.getYear(),e2.getYear()));
       return Collections.max(data,(e1,e2)-> Integer.compare(e1.getAge(), e2.getAge()));
    }
    public int getCount(){
        return data.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	"The shelter has the following animals:
    //{name} {caretaker}
    //{name} {caretaker}
    public String getStatistics(){
        StringBuilder builder=new StringBuilder();
        builder.append("The shelter has the following animals:").append(System.lineSeparator());
        for (Animal currentAnimal:data){
            builder.append(currentAnimal.getName()+" "+ currentAnimal.getCaretaker()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
