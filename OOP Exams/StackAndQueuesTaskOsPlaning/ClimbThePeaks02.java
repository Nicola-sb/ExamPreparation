package StackAndQueuesTaskOsPlaning;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> quantutyDailiPortionsStack=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(quantutyDailiPortionsStack::push);

        ArrayDeque<Integer>dailyStamina= Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        //Vihren	80
        //Kutelo	90
        //Banski Suhodol	100
        //Polezhan	60
        //Kamenitza	70
        int vihrenCount=0;
        int kuteloCount=0;
        int baskiSuhodolCount=0;
        int polezahnCount=0;
        int kamenitzaCount=0;
        int daysLeft=7;
        Map<String,Integer>conqueredPeaks=new TreeMap<>();

        conqueredPeaks.put("Vihren",80);
        conqueredPeaks.put("Kutelo",90);
        conqueredPeaks.put("Banski Suhodol",100);
        conqueredPeaks.put("Polezhan",60);
        conqueredPeaks.put("Kamenitza",70);

        ArrayDeque<String>peaks=new ArrayDeque<>();
        peaks.offer("Vihren");
        peaks.offer("Kutelo");
        peaks.offer("Banski Suhodol");
        peaks.offer("Polezhan");
        peaks.offer("Kamenitza");

        boolean isAllPeaksClimbed=false;
        List<String>peaksClimbed=new ArrayList<>();
        StringBuilder builder=new StringBuilder();
        while (daysLeft!=0 && !quantutyDailiPortionsStack.isEmpty() && !dailyStamina.isEmpty()){
            daysLeft--;
            int firstPortion=quantutyDailiPortionsStack.peek();
            int firstStamina=dailyStamina.peek();
            int sum=firstPortion+firstStamina;
            //•	If the sum is equal or greater than the corresponding Mountain Peak’s Difficulty level from the table below, it means that the peak is conquered.
            // In this case, you should remove both quantities from the sequences and continue with the next ones towards the next peak

            if(sum>=conqueredPeaks.get("Vihren")){
                vihrenCount++;
                quantutyDailiPortionsStack.pop();
                dailyStamina.poll();
                builder.append("Vihren").append(System.lineSeparator());
                peaksClimbed.add("Vihren");
                if(sum>=conqueredPeaks.get("Kutelo")&&kuteloCount==0){
                    kuteloCount++;
                    quantutyDailiPortionsStack.pop();
                    dailyStamina.poll();
                    builder.append("Kutelo").append(System.lineSeparator());
                    peaksClimbed.add("Kutelo");
                }else if(sum>=conqueredPeaks.get("Banski Suhodol")&&baskiSuhodolCount==0){
                    baskiSuhodolCount++;
                    quantutyDailiPortionsStack.pop();
                    dailyStamina.poll();
                    builder.append("Banski Suhodol").append(System.lineSeparator());
                    peaksClimbed.add("Banski Suhodol");
                }else if(sum>=conqueredPeaks.get("Polezhan")&&polezahnCount==0&&conqueredPeaks.get("Vihren")==0){
                    polezahnCount++;
                    quantutyDailiPortionsStack.pop();
                    dailyStamina.poll();
                    builder.append("Polezhan").append(System.lineSeparator());
                    peaksClimbed.add("Polezhan");
                }else if(sum>=conqueredPeaks.get("Kamenitza")&&kamenitzaCount==0&&conqueredPeaks.get("Vihren")==0){
                    kamenitzaCount++;
                    polezahnCount++;
                    quantutyDailiPortionsStack.pop();
                    dailyStamina.poll();
                    builder.append("Kamenitza").append(System.lineSeparator());
                    peaksClimbed.add("Kamenitza");

                }
            }else{
                //•	If the sum is less than the corresponding Mountain Peak’s Difficulty level from the table below, the peak remains unconquered.
                // You should remove both quantities from the sequences.
                // Alex will have to sleep in his tent. On the next day he will try the same peak once again
                quantutyDailiPortionsStack.pop();
                dailyStamina.poll();
            }

            if(vihrenCount>0 && kuteloCount>0 && baskiSuhodolCount>0 && polezahnCount >0 && kamenitzaCount>0){
                isAllPeaksClimbed=true;
                break;
            }
        }

        if(isAllPeaksClimbed){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
//            System.out.println("Conquered peaks:");
//            if(!peaksClimbed.isEmpty()){
//                System.out.println(builder);
//            }
        }else{
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
//            if(!peaksClimbed.isEmpty()){
//                System.out.println("Conquered peaks:");
//                for (String element:peaksClimbed){
//                    System.out.println(element);
//                }
//            }
        }
        if(!peaksClimbed.isEmpty()){
                            System.out.println("Conquered peaks:");
            System.out.println(peaksClimbed.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        }


    }
}
