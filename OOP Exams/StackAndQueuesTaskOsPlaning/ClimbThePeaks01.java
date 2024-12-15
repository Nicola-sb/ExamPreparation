package StackAndQueuesTaskOsPlaning;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> quantutyDailiPortionsStack=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(quantutyDailiPortionsStack::push);

        ArrayDeque<Integer>dailyStamina= Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        Map<String,Integer>conqueredPeaks=new TreeMap<>();

        conqueredPeaks.put("Vihren",0);
        conqueredPeaks.put("Kutelo",0);
        conqueredPeaks.put("Banski Suhodol",0);
        conqueredPeaks.put("Polezhan",0);
        conqueredPeaks.put("Kamenitza",0);
        StringBuilder builder=new StringBuilder();

        List<String>climbedPeaks=new ArrayList<>();

        int dailyFoodPortion=0;
        boolean isHeClimbAllThePeaks=false;
        while (dailyFoodPortion<8&& !quantutyDailiPortionsStack.isEmpty()&& !dailyStamina.isEmpty()){
            dailyFoodPortion++;
            int firstPortion=quantutyDailiPortionsStack.peek();
            int firstStamina=dailyStamina.peek();
            int sum=firstPortion+firstStamina;
            //He will start climbing from the first peak in the table below to the last one.

//•	If the sum is equal or greater than the corresponding Mountain Peak’s Difficulty level from the table below, it means that the peak is conquered.
// In this case, you should remove both quantities from the sequences and continue with the next ones towards the next peak.
            //Vihren	80
            //Kutelo	90
            //Banski Suhodol	100
            //Polezhan	60
            //Kamenitza	70
            if(sum==80 && conqueredPeaks.get("Vihren")==0){
                int currentValueVihren=conqueredPeaks.get("Vihren");
                conqueredPeaks.put("Vihren",currentValueVihren+1);
                quantutyDailiPortionsStack.pop();
                dailyStamina.poll();
                builder.append(conqueredPeaks.get("Vihren")).append(System.lineSeparator());
                climbedPeaks.add("Vihren");
                continue;
            }else if(sum==90&& conqueredPeaks.get("Kutelo")==0){
                int currentValueKutelo=conqueredPeaks.get("Kutelo");
                conqueredPeaks.put("Kutelo",currentValueKutelo+1);
                quantutyDailiPortionsStack.pop();
                dailyStamina.poll();
                climbedPeaks.add("Kutelo");
                continue;
            }else if(sum ==100){
                 int currentValuebanskiSuhodol=conqueredPeaks.get("Banski Suhodol");
                 conqueredPeaks.put("Banski Suhodol",currentValuebanskiSuhodol+1);
                quantutyDailiPortionsStack.pop();
                dailyStamina.poll();
                climbedPeaks.add("Banski Suhodol");
                continue;
            }else if(sum ==60&&conqueredPeaks.get("Polezhan")==0){
                int currentValuePolejan=conqueredPeaks.get("Polezhan");
                conqueredPeaks.put("Polezhan",currentValuePolejan+1);
                quantutyDailiPortionsStack.pop();
                dailyStamina.poll();
                climbedPeaks.add("Polezhan");
                continue;
            }else if(sum ==70&& conqueredPeaks.get("Kamenitza")==0){
                int currentValueKametiza=conqueredPeaks.get("Kamenitza");
                conqueredPeaks.put("Kamenitza",currentValueKametiza+1);
                quantutyDailiPortionsStack.pop();
                dailyStamina.poll();
                climbedPeaks.add("Kamenitza");
                continue;
            }else{
                quantutyDailiPortionsStack.pop();
                dailyStamina.poll();
            }
           //•	If the sum is less than the corresponding Mountain Peak’s Difficulty level from the table below, the peak remains unconquered.
            // You should remove both quantities from the sequences. Alex will have to sleep in his tent. On the next day he will try the same peak once again.
            if(conqueredPeaks.get("Vihren")>0 && conqueredPeaks.get("Kutelo")>0&&conqueredPeaks.get("Banski Suhodol")>0
            &&conqueredPeaks.get("Polezhan")>0 && conqueredPeaks.get("Kamenitza")>0){
                isHeClimbAllThePeaks=true;
//                System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
                break;
            }

        }
        if(isHeClimbAllThePeaks){
                            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
//            System.out.println("Conquered peaks: ");
            if(!climbedPeaks.isEmpty()){
                            System.out.println("Conquered peaks: ");
                            for (String element:climbedPeaks){
                                System.out.println(element);
                            }

            }
//                            for (String element:climbedPeaks){
//                                System.out.println(element);
//                            }

        }else{
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
            if(!climbedPeaks.isEmpty()){
                for (String element:climbedPeaks){
                    System.out.println(element);
                }
            }
        }

    }
}
