package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lilies=scanner.nextLine();
        String roses=scanner.nextLine();

        ArrayDeque<Integer>liliesStack=new ArrayDeque<>();
        ArrayDeque<Integer>rosesQueues=new ArrayDeque<>();

        Arrays.stream(lilies.split(",\\s+")).map(Integer::parseInt).forEach(e -> liliesStack.push(e));
        Arrays.stream(roses.split(",\\s+")).map(Integer::parseInt).forEach(e -> rosesQueues.offer(e));

        //. If the sum of their values is equal to 15 – create one wreath and remove them.
        // If the sum is bigger than 15, just decrease the value of the lilies by 2.
        // If the sum is less than 15 you have to store them for later and remove them.
        // You need to stop combining when you have no more roses or lilies.
        int boquetsCount=0;
        int laterCount=0;
        while (!roses.isEmpty() && !liliesStack.isEmpty()){
            int firstElement=rosesQueues.peek();
            int secondElement=liliesStack.peek();
            int sum=firstElement+secondElement;

            if(sum ==15){
                boquetsCount++;
                rosesQueues.poll();
                liliesStack.pop();
            }else if(sum > 15){
                //If the sum is bigger than 15, just decrease the value of the lilies by 2.
                int currentValuesLilies=liliesStack.peek() -2;
                liliesStack.pop();
                liliesStack.push(currentValuesLilies);
            }else{
                // If the sum is less than 15 you have to store them for later and remove them.
                laterCount=laterCount+sum;
                liliesStack.pop();
                rosesQueues.poll();
            }
        }
        int lastCountBouquets=laterCount / 15;
//        boquetsCount=boquetsCount+lastCountBouquets;
        int allBouquets=lastCountBouquets+boquetsCount;

        if(boquetsCount>=5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!",allBouquets);
        }else{
            System.out.printf("You didn't make it, you need %d wreaths more!",5-allBouquets);
        }
    }
}
