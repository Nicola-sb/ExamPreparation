package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] stringTools=scanner.nextLine().split(" ");
        ArrayDeque<Integer> toolsQueue=new ArrayDeque<>();

        String [] stringSubstances=scanner.nextLine().split(" ");
        ArrayDeque<Integer>substancesStack=new ArrayDeque<>();

        for (String element:stringTools){
            toolsQueue.offer(Integer.parseInt(element));
        }

        for (String element:stringSubstances){
            substancesStack.push(Integer.parseInt(element));
        }
        String [] stringChallenges=scanner.nextLine().split(" ");
//        ArrayDeque<Integer>challengesInteger=new ArrayDeque<>();
//        for (String element:stringChallenges){
//            challengesInteger.offer(Integer.parseInt(element));
//        }
        List<Integer>challenges=new ArrayList<>();
        for (String stringChallenge : stringChallenges) {
            challenges.add(Integer.parseInt(stringChallenge));
        }

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty()){
            int currentTool = toolsQueue.peek();
            int currentSubstance = substancesStack.peek();
            for(int i=0 ;i<challenges.size() ;i++) {
                int currnetNumber = challenges.get(i);

                int sum = currentTool * currentSubstance;
                if (sum == currnetNumber) {
                    toolsQueue.poll();
                    substancesStack.pop();
                    challenges.remove(i);
                }
//                //Increase the value of the tool element by 1 and move the element to the back of the tools’ sequence.
//                //Decrease the value of the substance element by 1 and return the element to the substance’s sequence.
//                // If the value of the substance element reaches 0, remove it from the sequence.
//                toolsQueue.poll();
//                toolsQueue.offer(currentTool+1);
//                int currentSubstances=currentSubstance - 1;
//                if(currentSubstances==0){
//                    substancesStack.pop();
//                }
//                substancesStack.pop();
//                substancesStack.push(currentSubstance-1);
//            }
            }

        }
        int currentValue=toolsQueue.peek();
        toolsQueue.poll();
        toolsQueue.offer(currentValue+1);
        int currentSubstancesTACK=substancesStack.peek();
        substancesStack.pop();
        substancesStack.push(currentSubstancesTACK-1);


        System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");

        List<Integer>listSubstances=new ArrayList<>();
        for (Integer integer : substancesStack) {
            listSubstances.add(integer);
        }

        String leftSubstansece=listSubstances.stream().map(String::valueOf).collect(Collectors.joining(", "));
        if(!listSubstances.isEmpty()){
            System.out.printf("Substances: "+leftSubstansece);
        }

        List<Integer>toolsList=new ArrayList<>();
        for (Integer integer : toolsQueue) {
            toolsList.add(integer);
        }
        String leftTools=toolsList.stream().map(String::valueOf).collect(Collectors.joining(", "));
        if(!toolsList.isEmpty()){
            System.out.printf("Tools: "+leftTools);
        }

    }
}
