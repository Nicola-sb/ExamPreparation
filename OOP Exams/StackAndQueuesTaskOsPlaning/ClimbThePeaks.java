package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //First, you will be given a sequence of numbers, representing the quantities of the daily portions of food supplies in his backpack.
        //Afterward, you will be given another sequence of numbers, representing the quantities of the daily stamina he will have at his disposal for the next seven days.
        String[]quantiteDailyPortion=scanner.nextLine().split(",\\s+");
        String[]dailyStamina=scanner.nextLine().split(",\\s+");
        //You have to sum the quantity of the last daily food portion with the quantity of the first daily stamina.
        // He will start climbing from the first peak in the table below to the last one

        ArrayDeque<Integer>dailyPortionFood=new ArrayDeque<>();
        ArrayDeque<Integer>stamina=new ArrayDeque<>();
        Map<String,Integer>peaks=new LinkedHashMap<>();
        peaks.put("Vihren",80);
        peaks.put("Kutelo",90);
        peaks.put("Banski Suhodol",100);
        peaks.put("Polezhan",60);
        peaks.put("Kamenitza",70);

        for (String element:quantiteDailyPortion){
           dailyPortionFood.push(Integer.parseInt(element));
        }
        for (String element:dailyStamina){
            stamina.offer(Integer.parseInt(element));
        }
        while (!dailyPortionFood.isEmpty()&& stamina.isEmpty()&& !peaks.isEmpty()){
            //•	If the sum is equal or greater than the corresponding Mountain Peak’s Difficulty level from the table below, it means that the peak is conquered.
            // In this case, you should remove both quantities from the sequences and continue with the next ones towards the next peak.
            int lastDailyFood=dailyPortionFood.peek();
            int firstStamina=stamina.peek();
            int sum=lastDailyFood+firstStamina;
            if(sum>=60){
                dailyPortionFood.pop();
                stamina.poll();
            }else if(sum >=70){
                dailyPortionFood.pop();
                stamina.poll();
            }else if(sum >=80){
                dailyPortionFood.pop();
                stamina.poll();
            }else if(sum >=90){
                dailyPortionFood.pop();
                stamina.poll();
            }else if(sum >=100){
                dailyPortionFood.pop();
                stamina.poll();
            }


        }



    }
}
