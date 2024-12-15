package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input=scanner.nextLine();
        ArrayDeque<Integer>liquidQueue=new ArrayDeque<>();
        ArrayDeque<Integer>ingreditientsStack=new ArrayDeque<>();

        Arrays.stream(input.split("\\s+")).map(Integer::parseInt).forEach(liquidQueue
                ::offer);
        input=scanner.nextLine();
        Arrays.stream(input.split("\\s+")).map(Integer::parseInt).forEach(ingreditientsStack::push);

//Bread	25
//Cake	50
//Pastry	75
//Fruit Pie	100
        int bread=0;
        int cake=0;
        int pastry=0;
        int fruitPie=0;
        //If the sum of their values is equal to any of the items in the table below
        // – cook the food corresponding to the value and remove both the liquid and the ingredient.
        // Otherwise, remove only the liquid and increase the value of the ingredient by 3.
        while (!liquidQueue.isEmpty()&& !ingreditientsStack.isEmpty()){
            int firstLiquid=liquidQueue.peek();
            int secondIngrediteint=ingreditientsStack.peek();

            int sum=firstLiquid+secondIngrediteint;

            if(sum==25){
                bread++;
                liquidQueue.poll();
                ingreditientsStack.pop();
            }else if(sum ==50){
                cake++;
                liquidQueue.poll();
                ingreditientsStack.pop();
            }else if(sum ==75){
                pastry++;
                liquidQueue.poll();
                ingreditientsStack.pop();
            }else if(sum==100){
                fruitPie++;
                liquidQueue.poll();
                ingreditientsStack.pop();
            }else{
                liquidQueue.poll();
                ingreditientsStack.pop();
                ingreditientsStack.push(secondIngrediteint+3);
            }
        }
        if(bread>=1 && cake >=1 && pastry>=1 && fruitPie>=1){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        //•	On the second line - print all liquids you have left:
        //o	If there are no liquids: "Liquids left: none"
        //o	If there are liquids: "Liquids left: {liquid1}, {liquid2}, {liquid3}, (…)"
        String remaingLiquids=liquidQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
        if(liquidQueue.isEmpty()){
            System.out.println("Liquids left: none");
        }else{

            System.out.println("Liquids left: "+remaingLiquids);
        }
        String remaingIngretients=ingreditientsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));

        if(ingreditientsStack.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            System.out.println("Ingredients left: "+remaingIngretients);
        }
        //o	"Bread: {amount}"
        //o	"Cake: {amount}"
        //o	"Fruit Pie: {amount}"
        //o	"Pastry: {amount}"
        System.out.printf("Bread: %d%n",bread);
        System.out.printf("Cake: %d%n",cake);
        System.out.printf("Fruit Pie: %d%n",fruitPie);
        System.out.printf("Pastry: %d%n",pastry);
    }
}
