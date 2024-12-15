package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepairShop {

    private int capacity;
    private List<Vehicle>vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        vehicles=new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        if(capacity>vehicles.size()){
            vehicles.add(vehicle);
        }
    }
    public boolean removeVehicle(String vin){
        return  vehicles.removeIf(e -> e.getVIN().equals(vin));
    }
    public int getCount(){
        return vehicles.size();
    }
    //•	Method getLowestMileage() – returns the Vehicle with the lowest value of Mileage property.
    public Vehicle getLowestMileage(){
        return Collections.min(vehicles,(f1,s1) -> Integer.compare(f1.getMileage(),s1.getMileage()));
    }
    public String report(){
        StringBuilder builder=new StringBuilder();
        builder.append("Vehicles in the preparatory:").append(System.lineSeparator());
        for (Vehicle vehicle : vehicles) {
            builder.append(vehicle).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
