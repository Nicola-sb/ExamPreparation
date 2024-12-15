package StackAndQueuesTaskOsPlaning;

import java.util.*;
import java.util.stream.Collectors;

public class BlackSmithTraining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String [] steelScanner= scanner.nextLine().split(" ");
        ArrayDeque<Integer>steelQueuee=new ArrayDeque<>();

        String[] carbonScanner=scanner.nextLine().split(" ");
        ArrayDeque<Integer>carbonStack=new ArrayDeque<>();
        for (String element:steelScanner){
            steelQueuee.offer(Integer.parseInt(element));
        }
        for (String element : carbonScanner) {
            carbonStack.push(Integer.parseInt(element));
        }
        int allSwords=0;

        Map<String,Integer>swordsMap=new TreeMap<>();
        swordsMap.put("Gladius",0);
        swordsMap.put("Shamshir",0);
        swordsMap.put("Katana",0);
        swordsMap.put("Sabre",0);

        int gladiusCount=0;
        int shamshirCount=0;
        int katanaCount=0;
        int sabreCount=0;
        while (!steelQueuee.isEmpty() && !carbonStack.isEmpty()){
            int steeelElement=steelQueuee.peek();
            int carbonElement=carbonStack.peek();
            int sum=steeelElement+carbonElement;

            if(sum == 70){
             int currentGladuis=swordsMap.get("Gladius");
             swordsMap.put("Gladius",currentGladuis+1);
             steelQueuee.poll();
             carbonStack.pop();
             allSwords++;
             gladiusCount++;
            }else if(sum ==80){
                int currentShamshir=swordsMap.get("Shamshir");
                swordsMap.put("Shamshir",currentShamshir+1);
                steelQueuee.poll();
                carbonStack.pop();
                shamshirCount++;
                allSwords++;
            }else if(sum ==90){
                int currentKatana=swordsMap.get("Katana");
                swordsMap.put("Katana",currentKatana+1);
                steelQueuee.poll();
                carbonStack.pop();
                katanaCount++;
                allSwords++;
            }else if(sum ==110){
                int currentSabre=swordsMap.get("Sabre");
                swordsMap.put("Sabre",currentSabre+1);
                steelQueuee.poll();
                carbonStack.pop();
                sabreCount++;
                allSwords++;
            }else{
                steelQueuee.poll();
                int currentValueCarbon=carbonStack.peek();
                carbonStack.pop();
                carbonStack.push(currentValueCarbon+5);
            }
        }

        if(gladiusCount > 0 || katanaCount>0 || shamshirCount>0 || sabreCount>0){
            System.out.printf("You have forged %d swords.%n",gladiusCount+katanaCount+sabreCount+shamshirCount);
        }else{
            System.out.println("You did not have enough resources to forge a sword.");
        }
//        if(swordsMap.get("Gladius")> 0 || swordsMap.get("Shamshir")>0 ||
//        swordsMap.get("Katana")> 0 || swordsMap.get("Sabre")>0){
//            System.out.printf("You have forged %d swords.%n",allSwords);
//        }else{
//            System.out.println("You did not have enough resources to forge a sword.");
//        }

        if(steelQueuee.isEmpty()){
            System.out.println("Steel left: none");
        }else{
            String leftSteel=steelQueuee.stream().map(String::valueOf).collect(Collectors.joining(", "));
//            System.out.println("Steel left: " + leftSteel);
            System.out.printf("Steel left: %s%n",leftSteel);
        }

        if(carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        }else{
            String leftCarbon=carbonStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
//            System.out.println("Carbon left: "+ leftCarbon);
            System.out.printf("Carbon left: %s%n",leftCarbon);
        }

//        swordsMap.entrySet().stream().filter( e -> {
//            if (e.getValue() > 0) {
//                System.out.printf("%s: %d", e.getKey(), e.getValue());
//            }
//        });

        swordsMap.entrySet().forEach(e -> {
            if(e.getValue() > 0){
                System.out.printf("%s: %d%n", e.getKey(), e.getValue());
            }
        });


    }
}
