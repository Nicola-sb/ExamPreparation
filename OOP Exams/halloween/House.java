package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid>data;

    public House(int capacity) {
        this.capacity = capacity;
        data=new ArrayList<>();
    }

    public void addKid(Kid kid){
        if(capacity> data.size()){
            data.add(kid);
        }
    }
    public boolean removeKid(String name){
        return data.removeIf(kid -> kid.getName().equals(name));
    }
    //•	Method getKid(String street) – returns the kid of a given street or null if no such kid exists.
    public Kid getKid(String street){
        return data.stream().filter(kid -> kid.getStreet().equals(street)).findFirst().orElse(null);
    }

    public int getAllKids(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder builder=new StringBuilder();
        builder.append(" Children who visited a house for candy:").append(System.lineSeparator());
        for (Kid currentKid : data) {
            builder.append(String.format("%s from %s street",currentKid.getName(),currentKid.getStreet())).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
