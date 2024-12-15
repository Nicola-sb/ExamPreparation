package StackAndQueuesTaskOsPlaning;

import java.util.*;
import java.util.stream.Collectors;

public class BlackSmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steel= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer>carbon=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(carbon::push);
//Sword	Resources needed
//Gladius	70
//Shamshir	80
//Katana	90
//Sabre	110
        Map<String,Integer>swordMap=new TreeMap<>();
        swordMap.put("Gladius",0);
        swordMap.put("Shamshir",0);
        swordMap.put("Katana",0);
        swordMap.put("Sabre",0);
        int forget=0;

        while (!steel.isEmpty()&& !carbon.isEmpty()){
            int firstSteel=steel.peek();
            int firstCarbon=carbon.peek();
            int sum=firstSteel+firstCarbon;
            //. If the sum of their values is equal to any of the swords in the table below
            // you should forge the sword corresponding to the value and remove both the steel and the carbon
            if(sum==70){
                int currentValueGladuis=swordMap.get("Gladius");
                swordMap.put("Gladius",currentValueGladuis+1);
                steel.poll();
                carbon.pop();
                forget++;
            }else if(sum==80){
                int currentValueShamshir=swordMap.get("Shamshir");
                swordMap.put("Shamshir",currentValueShamshir+1);
                steel.poll();
                carbon.pop();
                forget++;
            }else if(sum==90){
                int currentValueKatana=swordMap.get("Katana");
                swordMap.put("Katana",currentValueKatana+1);
                steel.poll();
                carbon.pop();
                forget++;
            }else if(sum==110){
                int currentValueSabre=swordMap.get("Sabre");
                swordMap.put("Sabre",currentValueSabre+1);
                steel.poll();
                carbon.pop();
                forget++;
            }else{
                //. Otherwise, remove only the steel, increase the value of the carbon by 5 and insert it back into the collection
                steel.poll();
                int currentValueCarbon=carbon.peek();
                carbon.pop();
                carbon.push(currentValueCarbon+5);
            }
        }

        if(swordMap.get("Gladius")>0 ||swordMap.get("Shamshir")>0 || swordMap.get("Katana")>0 || swordMap.get("Sabre")>0){
            System.out.printf("You have forged %d swords.%n",forget);
        }else{
            System.out.println("You did not have enough resources to forge a sword.");
        }
        //•	On the second line - print all steel you have left:
        //o	If there are no steel: "Steel left: none"
        //o	If there are steel: "Steel left: {steel1}, {steel2}, {steel3}, (…)"
        if(steel.isEmpty()){
            System.out.println("Steel left: none");
        }else{
            String steelJoining=steel.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Steel left:"+steelJoining);

        }
        if(carbon.isEmpty()){
            System.out.println("Carbon left: none");
        }else{
            String carbonLeft=carbon.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Carbon left: "+carbonLeft);
        }
        //•	Then, you need to print only the swords that you manage to forge and how many of them, ordered alphabetically:
        //o	"Sabre: {amount}"
        //o	"Katana: {amount}"
        //o	"Shamshir: {amount}"
        //o	"Gladius: {amount}"
        swordMap.entrySet().forEach(entry ->{
            if(entry.getValue()>0){
                System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
            }
        });




    }
}
