package dealership;

public class Car {
    //First, write a Java class Car with the following public fields:
    //•	manufacturer: String
    //•	model: String
    //•	year: int
    public String manufacturer;
    public String model;
    public int year;
    //The class constructor should receive manufacturer, model and year.
    // You need to create the appropriate getters and setters. Override the toString() method in the following format:
    //"{manufacturer} {model} ({year})"

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        //"{manufacturer} {model} ({year})"
        return String.format("%s %s (%d)",manufacturer,model,year);
    }
}
