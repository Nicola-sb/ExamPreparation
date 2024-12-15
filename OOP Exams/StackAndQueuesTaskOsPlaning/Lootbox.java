package StackAndQueuesTaskOsPlaning;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input=scanner.nextLine();

        ArrayDeque<Integer>firstBox=new ArrayDeque<>();
        ArrayDeque<Integer>secondBox=new ArrayDeque<>();
        List<Integer>lootboxSum=new ArrayList<>();

        Arrays.stream(input.split("\\s+")).map(Integer::parseInt).forEach(firstBox::offer);
        input=scanner.nextLine();
        Arrays.stream(input.split("\\s+")).map(Integer::parseInt).forEach(secondBox::push);


        while (!firstBox.isEmpty() && !secondBox.isEmpty()){
            int firstElement=firstBox.peek();
            int secondElement=secondBox.peek();

            int sum=firstElement+secondElement;
            //. If the sum of their values is an even number, add the summed item to your collection of claimed items and remove them both from the boxes.
            // Otherwise, remove the last item from the second box and add it to the last position in the first box.
            if(sum % 2 ==0){
                lootboxSum.add(sum);
                firstBox.pop();
                secondBox.poll();
            }else{
                secondBox.poll();
                firstBox.offer(secondElement);
            }
        }
        if (firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }else{
            System.out.println("Second lootbox is empty");
        }
        int allSum=0;
        for (int element:lootboxSum){
            allSum=allSum+element;
        }
        if(allSum>=100){
            System.out.printf("Your loot was epic! Value: %d",allSum);
        }else{
            System.out.printf("Your loot was poor... Value: %d",allSum);
        }
    }
}
