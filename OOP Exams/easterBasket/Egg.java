package easterBasket;

public class Egg {
    //•	color: String
    //•	strength: int
    //•	shape: String
    private String color;
    private int strength;
    private String shape;
    //The class constructor should receive color, strength and shape.
    // You need to create the appropriate getters and setters. Override the toString() method in the following format:
    //"{color} egg, with {strength} strength and {shape} shape."

    public Egg(String color, int strength, String shape) {
        this.color = color;
        this.strength = strength;
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        //"{color} egg, with {strength} strength and {shape} shape."
        return String.format("%s egg, with %d strength and %s shape.",color,strength,shape);
    }
}
