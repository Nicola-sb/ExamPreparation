package kindergarten;

import java.util.ArrayList;
import java.util.List;

public class Kindergarten {
    //Next, you are given a class Kindergarten.
    // The Kindergarten will have name and capacity (the maximum number of children that can be registered),
    // and adding new children will be limited by the capacity. Kindergarten also has a registry (a collection that stores Child entities).
    // All entities inside the collection have the same fields. The Kindergarten class should have the following properties:
    //•	name: String
    //•	capacity: int
    //•	registry: List<Child>
    private String name;
    private int capacity;
    private List<Child>registry ;
    //The class constructor should receive name and capacity, also it should initialize the registry with a new instance of the collection

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry =new ArrayList<>();
    }
    //•	Method	 addChild(Child child) - Adds a child to the registry if there is room for it and returns true. If there is no room for another child, returns false.
    //•	Method removeChild(String firstName) - removes a child by a given firstName. If removal is successful, returns true, otherwise, returns false.
    //•	Getter getChildrenCount - Returns the number of all children registered.
    //•	Method getChild(String firstName) - Returns the child with the given first name
    public void addChild(Child child){
        if(registry .size()<capacity){
            registry .add(child);
        }
    }
    public boolean removeChild(String firstName){
       return registry .removeIf(e -> e.getFirstName().equals(firstName));
    }
    public int getChildrenCount(){
        return registry .size();
    }
    public Child getChild(String firstName){
        for (Child name:registry ){
            if(name.getFirstName().equals(firstName)){
                return name;
            }
        }
        return null;
    }
    //•	Method registryReport() – Orders the children by age ascending, then by first name ascending, then by last name ascending, and returns a String in the following format:
    //o	"Registered children in {kindergartenName}:
    //--
    //{child1}
    //--
    //{child2}
    //--
    //(…)
    //--
    //{childn}"
    public String registryReport(){
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("Registered children in %s:",name)).append(System.lineSeparator());
        for (Child currentChild:registry ){

            builder.append(currentChild).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
