package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //On the first line, you will receive a sequence of numbers representing milligrams of caffeinе.
        // On the second line, you will receive another sequence of numbers representing energy drinks.
        // It is important to know that the maximum caffeine Stamat can have for the night is 300 milligrams, and his initial is always 0
        ArrayDeque<Integer>miligrams=new ArrayDeque<>();
        ArrayDeque<Integer>energyDrink=new ArrayDeque<>();

        String []miligramsCoffeine=scanner.nextLine().split(",\\s+");
        for (String element:miligramsCoffeine){
            miligrams.push(Integer.parseInt(element));
        }
        String[]energyDrinks=scanner.nextLine().split(",\\s+");
        for (String element:energyDrinks){
            energyDrink.offer(Integer.parseInt(element));
        }
        System.out.println(miligrams.peek());
        System.out.println(energyDrink.peek());
        //3
        //40
        int initialStamat=0;
        int maximumCaffeineStamat=300;
//        int limitPerDay=300;
        while (!miligrams.isEmpty()&&!energyDrink.isEmpty()){
             int firstElementMiligram=miligrams.peek();
             int firstElementCoffeine=energyDrink.peek();
             int result=firstElementMiligram*firstElementCoffeine;
            //To calculate the caffeine in the drink take the last milligrams of caffeinе and the first energy drink, and multiply them.
            // Then, compare the result with the caffeine Stamat drank
            //•	If the sum of the caffeine in the drink and the caffeine that Stamat drank doesn't exceed 300 milligrams,
            // remove both the milligrams of caffeinе and the drink from their sequences. Also, add the caffeine to Stamat's total caffeine
            int sum=firstElementCoffeine+initialStamat;
            if(result+initialStamat<=maximumCaffeineStamat){
                miligrams.pop();
                energyDrink.poll();
                initialStamat=initialStamat+result;
                maximumCaffeineStamat=maximumCaffeineStamat-result;
            }else{
                //•	If Stamat is about to exceed his maximum caffeine per night, do not add the caffeine to Stamat’s total caffeine.
                // Remove the milligrams of caffeinе and move the drink to the end of the sequence.
                // Also, reduce the current caffeine that Stamat has taken by 30 (Note: Stamat's caffeine cannot go below 0).
                miligrams.pop();
                energyDrink.poll();
                if(initialStamat>=30){
                    initialStamat=initialStamat-30;
                }
            }
            //o	If Stamat hasn't drunk all the energy drinks, print the remaining ones separated by a comma and a space ", ":
            //	"Drinks left: { remaining drinks separated by ", " }"
            //o	If Stamat has drunk all the energy drinks, print:
            //	"At least Stamat wasn't exceeding the maximum caffeine."


            if(!energyDrink.isEmpty()){
                System.out.printf("Drinks left: %d",String.join(", ",energyDrinks));
            }



        }

    }
}
