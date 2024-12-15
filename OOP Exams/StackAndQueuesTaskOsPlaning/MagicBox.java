package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        ArrayDeque<Integer> firstBox=new ArrayDeque<>();
//        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(firstBox::push);
        ArrayDeque<Integer>firstBox= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer>secondBox=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(secondBox::push);//Stack
        int claimedItems=0;

       while (!firstBox.isEmpty()&&!secondBox.isEmpty()){
           int firstBoxElement=firstBox.peek();
           int secondBoxElement=secondBox.peek();
           int sum=firstBoxElement+secondBoxElement;
           //. If the sum of their values is an even number, add the summed item to your collection of claimed items and remove them both from the boxes
           if(sum%2==0){
               claimedItems+=sum;
               firstBox.poll();
               secondBox.pop();
           }else{
 //Otherwise, remove the last item from the second box and add it at the last position in the first box. You need to stop summing items when one of the boxes becomes empty.
               secondBox.pop();
               firstBox.offer(secondBoxElement);
           }
       }

       if(firstBox.isEmpty()){
           System.out.println("First magic box is empty.");
       }else{
           System.out.println("Second magic box is empty.");
       }
       if(claimedItems>=90){
           System.out.printf("Wow, your prey was epic! Value: %d",claimedItems);
       }else{
           System.out.printf("Poor prey... Value: %d",claimedItems);
       }
    }
}
