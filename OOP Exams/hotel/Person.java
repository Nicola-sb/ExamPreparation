package hotel;

public class Person {
    //First, write a Java class Person with the following fields:
    //•	name: String
    //•	id: int
    //•	age: int
    //•	hometown: String – "n/a" by default
    private String name;
    private int id;
    private int age;
    private String hometown;
    //The class constructor should receive name, id, age, hometown.
    // You need to create the appropriate getters and setters.
    // Override the toString() method in the following format:
    //"Person {name}: {id}, Age: {age}, Hometown: {hometown}"

    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        // //"Person {name}: {id}, Age: {age}, Hometown: {hometown}"
        return String.format("Person %s: %d, Age: %d, Hometown: %s",name,id,age,hometown);
    }
}
