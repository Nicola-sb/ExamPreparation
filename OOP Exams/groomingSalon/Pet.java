package groomingSalon;

public class Pet {
    //•	name: String
    //•	age: int
    //•	owner: String
    private String name;
    private int age;
    private String owner;
    //The class constructor should receive all fields.
    // You need to create the appropriate getters and setters. The class should override the toString() method in the following format:
    //"{name} {age} - ({owner})"

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        //"{name} {age} - ({owner})"
        return String.format("%s %d (%s)",name,age,owner);
    }
}
