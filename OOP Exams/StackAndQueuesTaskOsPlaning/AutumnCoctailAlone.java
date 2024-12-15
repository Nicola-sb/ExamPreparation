package StackAndQueuesTaskOsPlaning;

import java.util.*;

public class AutumnCoctailAlone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String []inputIngretientsQueue=scanner.nextLine().split(" ");
        String[]inputFreshnessStac=scanner.nextLine().split(" ");

        ArrayDeque<Integer>ingreditients=new ArrayDeque<>();
        ArrayDeque<Integer>freshnessStack=new ArrayDeque<>();

        for (String element:inputIngretientsQueue){
            ingreditients.offer(Integer.parseInt(element));
        }

        for (String element:inputFreshnessStac){
            freshnessStack.push(Integer.parseInt(element));
        }
        Map<String,Integer>coctailsAndFreshnessMap=new TreeMap<>();
        coctailsAndFreshnessMap.put("Pear Sour",0);
        coctailsAndFreshnessMap.put("The Harvest",0);
        coctailsAndFreshnessMap.put("Apple Hinny",0);
        coctailsAndFreshnessMap.put("High Fashion",0);
        int leftIngreditiens=0;



        while (!ingreditients.isEmpty() && !freshnessStack.isEmpty()){
                     int firstElementIngretietns=ingreditients.peek();
                     int lastElementFreshness=freshnessStack.peek();
                     int sum=firstElementIngretietns*lastElementFreshness;
             //Pear Sour	150
            //The Harvest	250
            //Apple Hinny	300
            //High Fashion	400
                     if(firstElementIngretietns==0){
                         ingreditients.poll();
                         continue;
                     }

                     if(sum==150){
                         int currentValue=coctailsAndFreshnessMap.get("Pear Sour");
                         coctailsAndFreshnessMap.put("Pear Sour",currentValue+1);
                         ingreditients.poll();
                         freshnessStack.pop();
                     }else if(sum ==250){
                         int currentValue=coctailsAndFreshnessMap.get("The Harvest");
                         coctailsAndFreshnessMap.put("The Harvest",currentValue+1);
                         ingreditients.poll();
                         freshnessStack.pop();
                     }else if(sum ==300){
                         int currentValue=coctailsAndFreshnessMap.get("Apple Hinny");
                         coctailsAndFreshnessMap.put("Apple Hinny",currentValue+1);
                         ingreditients.poll();
                         freshnessStack.pop();
                     }else if(sum==400){
                         int currentValue=coctailsAndFreshnessMap.get("High Fashion");
                         coctailsAndFreshnessMap.put("High Fashion",currentValue+1);
                         ingreditients.poll();
                         freshnessStack.pop();
                     }else{
                         //Otherwise, you should remove the freshness level, increase the ingredient value by 5,
                         // then remove it from the first position and add it at the end.
                         // In case you have an ingredient with a value of 0 you have to remove it and continue mixing the cocktails.
                         freshnessStack.pop();
                         int currentIngrditent=ingreditients.peek()+5;
                         ingreditients.poll();
                         ingreditients.offer(currentIngrditent);
                     }
        }
        //# Apple Hinny --> 2
//        coctailsAndFreshnessMap.entrySet().stream().forEach(entry -> {
//            if(entry.getValue()>0){
//                System.out.println("It's party time! The cocktails are ready!");
//            }else{
//                System.out.println("What a pity! You didn't manage to prepare all cocktails.");
//            }
//        });
        if(coctailsAndFreshnessMap.get("Pear Sour")>0&&coctailsAndFreshnessMap.get("The Harvest")>0
        &&coctailsAndFreshnessMap.get("Apple Hinny")>0&&coctailsAndFreshnessMap.get("High Fashion")>0){
            System.out.println("It's party time! The cocktails are ready!");
        }else{
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if(!ingreditients.isEmpty()){
            for (int element:ingreditients){
                leftIngreditiens=leftIngreditiens+element;
            }
            System.out.println("Ingredients left: "+leftIngreditiens);
        }

        coctailsAndFreshnessMap.entrySet().forEach(entry-> {
            if(entry.getValue()>0){
                System.out.printf("# %s --> %d%n",entry.getKey(),entry.getValue());
            }

        });
    }
}
