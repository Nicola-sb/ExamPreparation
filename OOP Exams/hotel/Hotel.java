package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    //Next, write a Java class Hotel that has a roster (a collection that stores Person entities).
    // All entities inside the repository have the same fields. Also, the Hotel class should have those fields:
    //•	name: String
    //•	capacity: int
    private List<Person>roster ;
    private String name;
    private int capacity;
    //The class constructor should receive name and capacity,
    // also it should initialize the roster with a new instance of the collection. Implement the following features:

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster =new ArrayList<>();
    }
    //•	Method add(Person person) - adds an entity to the roster if there is room for it
    //•	Method remove(String name) - removes a person by given name, if such exists, and returns boolean
    //•	Method getPerson(String name, String hometown) – returns the people with the given name and hometown or null if there is no such person.
    //•	Getter getCount() – returns the number of people.
    //•	getStatistics() – returns a String in the following format:
    //o	"The people in the hotel {name} are:
    //{Person1}
    //{Person2}
    //(…)"
    public void add(Person person){
        if(roster .size()<capacity){
            roster .add(person);
        }
    }
    public boolean remove(String name){
        return roster .removeIf(element -> element.getName().equals(name));
    }
    //•	Method getPerson(String name, String hometown) – returns the people with the given name and hometown or null if there is no such person.
    public Person getPerson(String name,String hometown){
        for (Person currentPerson:roster ){
            if(currentPerson.getName().equals(name)&&currentPerson.getHometown().equals(hometown)){
                return currentPerson;
            }
        }
        return null;
    }
    public int getCount(){
        return roster .size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	"The people in the hotel {name} are:
    //{Person1}
    //{Person2}
    //(…)"
    public String getStatistics(){
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("The people in the hotel %s are:",name)).append(System.lineSeparator());
        for (Person currentPerson:roster ){
            builder.append(currentPerson).append(System.lineSeparator());
        }
        return builder.toString();
    }


}
