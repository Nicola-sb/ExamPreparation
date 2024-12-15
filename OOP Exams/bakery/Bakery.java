package bakery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bakery {
    //Next, write a Java class Bakery that has employees (a collection, which stores the entity Employee).
    // All entities inside the repository have the same properties. Also, the Bakery class should have those properties:
    //•	name: String
    //•	capacity: int
    private List<Employee>data;
    private String name;
    private int capacity;
    //The class constructor should receive the name and capacity,
    // also it should initialize the employees with a new instance of the collection. Implement the following features:

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    //•	Method add(Employee employee) – adds an entity to the data if there is room for him/her.
    //•	Method remove(String name) – removes an employee by given name, if such exists, and returns a bool.
    //•	Method getOldestEmployee() – returns the oldest employee.
    //•	Method getEmployee(string name) – returns the employee with the given name.
    //•	Getter getCount() – returns the number of employees.
    //•	report() – returns a string in the following format:
    //o	"Employees working at Bakery {bakeryName}:
    //{Employee1}
    //{Employee2}
    //(…)"
    public void add(Employee employee){
        if(data.size()<capacity){
            data.add(employee);
        }
    }
    public boolean remove(String name){
        ////•	Method remove(String name) – removes an employee by given name, if such exists, and returns a bool.
        return data.removeIf(element -> element.getName().equals(name));
    }
    public Employee getOldestEmployee(){
        // //•	Method getOldestEmployee() – returns the oldest employee.
        return Collections.max(data,(f,s)->Integer.compare(f.getAge(),s.getAge()));
    }
    public Employee getEmployee(String name){
        // //•	Method getEmployee(string name) – returns the employee with the given name.
        for (Employee currentEmployee:data){
            if(currentEmployee.getName().equals(name)){
                return currentEmployee;
            }
        }
        return null;
    }
    public int getCount(){
        return data.size();
    }
    public String report(){
        //o	"Employees working at Bakery {bakeryName}:
        //{Employee1}
        //{Employee2}
        //(…)
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("Employees working at Bakery %s:",name)).append(System.lineSeparator());
        for (Employee currentEmployee:data){
            builder.append(currentEmployee).append(System.lineSeparator());
        }
        return builder.toString();
    }



}
