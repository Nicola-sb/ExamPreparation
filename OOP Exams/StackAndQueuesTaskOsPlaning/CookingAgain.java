package StackAndQueuesTaskOsPlaning;

import java.util.*;
import java.util.stream.Collectors;

public class CookingAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer>ingreditients=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(ingreditients::push);
        Map<String,Integer>cookingMap=new TreeMap<>();
        //Bread	25
        //Cake	50
        //Pastry	75
        //Fruit Pie	100
        cookingMap.put("Bread",0);
        cookingMap.put("Cake",0);
        cookingMap.put("Pastry",0);
        cookingMap.put("Fruit Pie",0);


        while (!liquids.isEmpty()&&!ingreditients.isEmpty()){
//. If the sum of their values is equal to any of the items in the table below – cook the food corresponding to the value and remove both the liquid and the ingredient.
            int firstLiquid=liquids.peek();
            int firstIncreditiens=ingreditients.peek();
            int sum=firstLiquid+firstIncreditiens;
            if(sum==25){
                int currentValue=cookingMap.get("Bread");
                cookingMap.put("Bread",currentValue+1);
                liquids.poll();
                ingreditients.pop();
            }else if(sum==50){
                int currentValue=cookingMap.get("Cake");
                cookingMap.put("Cake",currentValue+1);
                liquids.poll();
                ingreditients.pop();
            }else if(sum==75){
                int currentValue=cookingMap.get("Pastry");
                cookingMap.put("Pastry",currentValue+1);
                liquids.poll();
                ingreditients.pop();
            }else if(sum==100){
                int currentValue=cookingMap.get("Fruit Pie");
                cookingMap.put("Fruit Pie",currentValue+1);
                liquids.poll();
                ingreditients.pop();
            }else{
                //Otherwise, remove only the liquid and increase the value of the ingredient by 3
                liquids.poll();
                ingreditients.pop();
                ingreditients.push(firstIncreditiens+3);
            }
        }

        if(cookingMap.get("Bread")>0&&cookingMap.get("Cake")>0 && cookingMap.get("Pastry")>0 &&cookingMap.get("Fruit Pie")>0){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        String leftLiquids=liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
        String leftIngreditiens=ingreditients.stream().map(String::valueOf).collect(Collectors.joining(", "));

        if(liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            System.out.println("Liquids left: "+leftLiquids);
        }
        if(ingreditients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            System.out.println("Ingredients left: "+leftIngreditiens);
        }

        cookingMap.entrySet().forEach(entry -> System.out.printf("%s: %d%n",entry.getKey(),entry.getValue()));


    }
}
