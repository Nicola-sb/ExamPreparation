package university;

public class Student {
    //•	firstName: String
    //•	lastName: String
    //•	bestSubject: String
    public String firstName;
    public String lastName;
    public String bestSubject;
    //The class constructor should receive (firstName, lastName and bestSubject).

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }
    //The class also should have the methods:
    //•	getFirstName()
    //•	getLastName()
    //•	getBestSubject()
    //•	Override the toString() method in the following format:
    //"Student: {firstName} {lastName}, {bestSubject}"

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, %s",firstName,lastName,bestSubject);
    }
}
