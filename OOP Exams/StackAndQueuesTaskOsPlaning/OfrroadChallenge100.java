package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OfrroadChallenge100 {
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

        List<String>attitudesNames=new ArrayList<>();
        attitudesNames.add("Altitude 1");
        attitudesNames.add("Altitude 2");
        attitudesNames.add("Altitude 3");
        attitudesNames.add("Altitude 4");

        if(!initialFuelStack.isEmpty() && additionConsuptionQueue.isEmpty()){




        }
    }
}
