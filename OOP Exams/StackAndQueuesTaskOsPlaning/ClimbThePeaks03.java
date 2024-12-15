package StackAndQueuesTaskOsPlaning;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List conqueredPeaks = new ArrayList<String>();
//        ArrayDeque<Integer> foodPortions = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
//        ArrayDeque<Integer> staminaQuan = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> foodPortions=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(foodPortions::push);

        ArrayDeque<Integer>staminaQuan= Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        Map<String,Integer>peakAndLevel=new TreeMap<>();

        peakAndLevel.put("Vihren",80);
        peakAndLevel.put("Kutelo",90);
        peakAndLevel.put("Banski Suhodol",100);
        peakAndLevel.put("Polezhan",60);
        peakAndLevel.put("Kamenitza",70);

        ArrayDeque<String>peaks=new ArrayDeque<>();
        peaks.offer("Vihren");
        peaks.offer("Kutelo");
        peaks.offer("Banski Suhodol");
        peaks.offer("Polezhan");
        peaks.offer("Kamenitza");

        while (!foodPortions.isEmpty() && !staminaQuan.isEmpty()&& !peakAndLevel.isEmpty()){
            int firstPortion=foodPortions.peek();
            int firstStamina=staminaQuan.peek();
            int sum=firstPortion+firstStamina;
            String currentPeakname=peaks.getFirst();

            if(sum >=peakAndLevel.get(currentPeakname)){
                conqueredPeaks.add(currentPeakname);
                foodPortions.pop();
                staminaQuan.poll();
                peakAndLevel.remove(currentPeakname);
                peaks.remove(currentPeakname);
            }else{
                foodPortions.pop();
                staminaQuan.poll();
            }
        }
        if (peakAndLevel.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            System.out.println(conqueredPeaks.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        }


    }
}
