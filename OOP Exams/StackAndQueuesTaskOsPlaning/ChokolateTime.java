package StackAndQueuesTaskOsPlaning;

import java.util.*;
import java.util.stream.Collectors;

public class ChokolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milk= Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double>cacao=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).forEach(cacao::push);
        Map<String,Integer>cholateMap=new TreeMap<>();
        cholateMap.put("Milk Chocolate",0);
        cholateMap.put("Dark Chocolate",0);
        cholateMap.put("Baking Chocolate",0);
        //Chocolate types	Cacao percentage
        //Milk Chocolate	30
        //Dark Chocolate	50
        //Baking Chocolate	100
        int milkCholateCount=0;
        int darKCholatateCount=0;
        int bakingChocolateCount=0;

        while (!milk.isEmpty() && !cacao.isEmpty()){
            double milkValue=milk.peek();
            double cacaoValue=cacao.peek();
            double sumValue=milkValue+cacaoValue;
//The cacao percentage is calculated by dividing the cacao powder value by the sum of the milk and cacao powder values.
// If the result of this operation equals one of the point levels described in the table, you make the chocolate and remove both milk and cacao powder values
            double cacaoPercentage=cacaoValue / (milkValue+cacaoValue) * 100;
            if(cacaoPercentage==30){
                int currentValueMilk=cholateMap.get("Milk Chocolate");
                cholateMap.put("Milk Chocolate",currentValueMilk+1);
                milkCholateCount++;
                milk.poll();
                cacao.pop();
            }else if(cacaoPercentage==50){
                int currentValueDark=cholateMap.get("Dark Chocolate");
                cholateMap.put("Dark Chocolate",currentValueDark+1);
                darKCholatateCount++;
                milk.poll();
                cacao.pop();
            }else if(cacaoPercentage==100){
                int currentValueBaiking=cholateMap.get("Baking Chocolate");
                cholateMap.put("Baking Chocolate",currentValueBaiking+1);
                bakingChocolateCount++;
                milk.poll();
                cacao.pop();
            }else{
                //Otherwise, you should remove the cacao powder value, increase the milk value by 10, then remove it from the first position and add it at the end
                cacao.pop();
                double currentMilk=milk.peek();
                milk.poll();
                milk.offer(currentMilk+10);
            }
        }


        if(milkCholateCount>0 && darKCholatateCount>0 && bakingChocolateCount>0){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else{
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        //•	In the next few lines, you have to print the chocolates you have made at least once, ordered alphabetically in the format:
        //" # {chocolate type} --> {amount}".
        cholateMap.entrySet().stream().forEach(entry-> {
            if(entry.getValue()>0){
                System.out.println(" # "+entry.getKey()+ " --> "+entry.getValue());
            }
        });
    }
}
