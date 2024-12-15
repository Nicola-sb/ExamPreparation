package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] stringTools = scanner.nextLine().split(" ");
        ArrayDeque<Integer> initialFuelStack = new ArrayDeque<>();

        String[] stringSubstances = scanner.nextLine().split(" ");
        ArrayDeque<Integer> additionConsuptionQueue = new ArrayDeque<>();

        for (String element : stringTools) {
            initialFuelStack.push(Integer.parseInt(element));
        }

        for (String element : stringSubstances) {
            additionConsuptionQueue.offer(Integer.parseInt(element));
        }

        String[] stringAmountFuelNeeded = scanner.nextLine().split(" ");
        List<Integer> amountFuelNeeeded = new ArrayList<>();
        for (String s : stringAmountFuelNeeded) {
            amountFuelNeeeded.add(Integer.parseInt(s));
        }

        List<Integer>attidues=new ArrayList<>();
        StringBuilder builder=new StringBuilder();
        List<String>attitudesNames=new ArrayList<>();
        attitudesNames.add("Altitude 1");
        attitudesNames.add("Altitude 2");
        attitudesNames.add("Altitude 3");
        attitudesNames.add("Altitude 4");
        int countAttiduteReached=0;
        while (!additionConsuptionQueue.isEmpty() && !initialFuelStack.isEmpty()){
            String currentLevel = attitudesNames.get(0);
            int currentAdditionConsuption = additionConsuptionQueue.peek();
            int currentInitialFuelStack = initialFuelStack.peek();

            int sum = currentInitialFuelStack - currentAdditionConsuption;
            int firstIndexAmoutFuelNeeded = amountFuelNeeeded.get(0);


            if((sum >= firstIndexAmoutFuelNeeded)){
                additionConsuptionQueue.poll();
                initialFuelStack.pop();
                amountFuelNeeeded.remove(0);
                countAttiduteReached++;
                attidues.add(countAttiduteReached);
                builder.append(String.format("Altitude %d",countAttiduteReached));
//                System.out.printf("John has reached: Altitude %d%n",countAttiduteReached);
                System.out.println("John has reached: " + currentLevel);
            }else{
//                System.out.printf("John did not reach: Altitude %d%n",countAttiduteReached+1);
//                break;
                initialFuelStack.pop();
                additionConsuptionQueue.poll();
                attitudesNames.remove(currentLevel);
                System.out.println("John did not reach: " + currentLevel);
                break;
            }
        }

        if(!initialFuelStack.isEmpty()){
            System.out.printf("John failed to reach the top.%n");
            String leftAttidute=attitudesNames.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Reached altitudes: " + leftAttidute);
        }




        if(amountFuelNeeeded.isEmpty()){
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }



    }
}
