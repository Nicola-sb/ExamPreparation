package dealership;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealership {
    //Next, write a Java class Dealership that has data (Collection, which stores the entity Car).
    // All entities inside the repository have the same fields. Also, the Dealership class should have those public fields:
    //•	name: String
    //•	capacity: int
    private List<Car>data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    //•	Method add(Car car) – adds an entity to the data if there is an empty cell for the car.
    //•	Method buy(String manufacturer, String model) – removes the car by given manufacturer and model, if such exists, and returns boolean.
    //•	Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    //•	Method getCar(String manufacturer, String model) – returns the car with the given manufacturer and model or null if there is no such car.
    //•	Getter getCount() – returns the number of cars.
    //•	getStatistics() – returns a String in the following format:
    //o	" The cars are in a car dealership {name}:
    //{Car1}
    //{Car2}
    //(…)"
    public void add(Car car){
        if(data.size()<capacity){
            data.add(car);
        }
    }
    public boolean buy(String manufacturer, String model){
        //•	Method buy(String manufacturer, String model) – removes the car by given manufacturer and model, if such exists, and returns boolean.
        for (Car currentCar:data){
            if(currentCar.getManufacturer().equals(manufacturer)&& currentCar.getModel().equals(model)){
                data.remove(currentCar);
                return true;
            }
        }
        return false;
    }
    public Car getLatestCar(){
        //•	Method getLatestCar() – returns the latest car (by year) or null if have no cars.
        return Collections.max(data,(e1,e2)->Integer.compare(e1.getYear(),e2.getYear()));
    }
    public Car getCar(String manufacturer, String model){
        ////•	Method getCar(String manufacturer, String model) – returns the car with the given manufacturer and model or null if there is no such car.
        for (Car currentCar:data){
            if(currentCar.getManufacturer().equals(manufacturer)&& currentCar.getModel().equals(model)){
                return currentCar;
            }
        }
        return null;
    }
    public int getCount(){
        return data.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	" The cars are in a car dealership {name}:
    //{Car1}
    //{Car2}
    //(…)"
    public String getStatistics(){
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("The cars are in a car dealership %s:",name)).append(System.lineSeparator());
        for (Car currentCar:data){
            builder.append(currentCar).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
