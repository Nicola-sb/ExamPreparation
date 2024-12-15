package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer>tulipsStack=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tulipsStack::push);

        ArrayDeque<Integer> dafodils= Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int bouquets=0;
        int storedFlowers=0;
//        System.out.println(tulipsStack.peek());
//        System.out.println(dafodils.peek());
        while (!tulipsStack.isEmpty() && !dafodils.isEmpty()){
               int lastTulips=tulipsStack.peek();
               int firstDafodils=dafodils.peek();
               int sum=lastTulips+firstDafodils;
//If the sum of their values is equal to 15 – create one bouquet and remove them
               if(sum==15){
                   bouquets++;
                   tulipsStack.pop();
                   dafodils.poll();
               }else if(sum > 15){
  //While the sum is bigger than 15, keep decreasing the value of the tulips by 2
                 int currentValueTulips=tulipsStack.peek()-2;
                 tulipsStack.pop();
                 tulipsStack.push(currentValueTulips);
               }else{
     //If the sum is less than 15 you have to store them for later and remove them.
                   storedFlowers=storedFlowers+tulipsStack.peek();
                   storedFlowers=storedFlowers+dafodils.peek();
                   tulipsStack.pop();
                   dafodils.poll();
               }
        }

        int leftFlowers=storedFlowers/15;
        bouquets=bouquets+leftFlowers;

        if(bouquets>=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquets);
        }else{
            System.out.printf("You failed... You need more %d bouquets.",5-bouquets);
        }


    }
}
