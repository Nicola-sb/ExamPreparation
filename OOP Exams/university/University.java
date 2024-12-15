package university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    //Next, write a Java class University that has students (a collection which stores the entity Student).
    // All entities inside the repository have the same public fields. Also, the University class should have those fields:
    //•	capacity: int
    //•	students: List<Student> - holds all added students in the university

    public List<Student>students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students=new ArrayList<>();
    }
    //•	getCapacity()
    //•	getStudents()
    //•	getStudentCount() method– returns the number of students in the university
    public int getCapacity(){
        return capacity;
    }
    public List<Student> getStudents(){
        return students;
    }
    public int getStudentCount(){
        return students.size();
    }
//•	registerStudent(Student student) method – adds an entity to the students if there is room for it
//o	Returns "Added student {firstName} {lastName}" if the student is successfully added
//o	Returns "Student is already in the university" if the student is already in the university
//o	Returns "No seats in the university" if the university is full
    public String registerStudent(Student student){
        if(capacity<students.size()){
           return ("No seats in the university");
        }else if(students.contains(student)){
            return ("Student is already in the university");
        }else{
            students.add(student);
            return String.format("Added student %s %s",student.getFirstName(),student.getLastName());
        }
    }
    //•	dismissStudent(Student student) method – removes the student
    //o	Returns "Student not found" if the student is not in the university
    public String dismissStudent(Student student){
        if(students.contains(student)){
            students.remove(student);
            return String.format("Removed student %s %s",student.getFirstName(),student.getLastName());
        }else{
           return "Student not found";
        }
    }
    //•	getStudent(String firstName, String lastName) method - returns the student with the given names.
    public Student getStudent(String firstName,String lastName){
        for (Student currentStudent:students){
            if(currentStudent.getFirstName().equals(firstName)&& currentStudent.getLastName().equals(lastName)){
                return currentStudent;
            }
        }
        return null;
    }
    //•	getStatistics() – returns a String in the following format:
    //o	"==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
    // ==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
    //   (…)"
    public String getStatistics(){
        StringBuilder builder=new StringBuilder();
        for (Student currentStudent:students){
//            builder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",currentStudent.getFirstName(),currentStudent.getLastName()),currentStudent.getBestSubject());
//           builder.append(currentStudent).append(System.lineSeparator());
            builder.append("==Student: First Name = ").append(currentStudent.getFirstName()).append(", Last Name = ").append(currentStudent.getLastName())
                    .append(", Best Subject = ").append(currentStudent.getBestSubject()).append(System.lineSeparator());
        }
        return builder.toString();
    }
    public String getStatistics1(){
        return students.stream().map(element-> String.format("==Student: First Name = %s, Last Name = %s," +
                " Best Subject = %s",element.getFirstName(),element.getLastName(),element.getBestSubject())).collect(Collectors.joining(System.lineSeparator()));
    }

}
