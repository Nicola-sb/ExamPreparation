package bakery;

public class Employee {
    //First, write a Java class Employee with the following properties:
    //•	name: String
    //•	age: int
    //•	country: String
    private String name;
    private int age;
    private String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        //Employee: {name}, {age} ({country})"
        return String.format("Employee: %s, %d (%s)",name,age,country);
    }
}
