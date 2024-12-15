package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TempDownAlone {
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
        List<Integer> challenges=new ArrayList<>();
        for (String stringChallenge : stringChallenges) {
            challenges.add(Integer.parseInt(stringChallenge));
        }

            while (!toolsQueue.isEmpty() && !substancesStack.isEmpty() && !challenges.isEmpty()){

                    int currentTool = toolsQueue.peek();
                    int currentSubstance = substancesStack.peek();

                    int sum=currentTool*currentSubstance;
//                    for(int i=0 ;i<challenges.size() ;i++){
//
//                           int currnetNumber = challenges.get(i);
//                           if (sum == currnetNumber) {
//                               toolsQueue.poll();
//                               substancesStack.pop();
//                               challenges.remove(i);
//                           }
//                       }
                if(challenges.contains(currentTool*currentSubstance)){
                    toolsQueue.poll();
                    substancesStack.pop();
                    challenges.remove(Integer.valueOf(currentTool*currentSubstance));
                }else{
                    int currentValue=toolsQueue.peek();
                    toolsQueue.poll();
                    toolsQueue.offer(currentValue+1);
                    int currentSubstancesTACK=substancesStack.peek();
                    if(currentSubstancesTACK -1 ==0){
                        substancesStack.pop();
                    }else{
                        substancesStack.pop();
                        substancesStack.push(currentSubstancesTACK-1);
                    }
                }

                if(challenges.isEmpty()){
                    System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                }

            }

            if(toolsQueue.isEmpty() ||substancesStack.isEmpty()){
                if(!challenges.isEmpty()){
                    System.out.println("Harry is lost in the temple. Oblivion awaits him.");
                }
            }

        List<Integer>listSubstances=new ArrayList<>();
        for (Integer integer : substancesStack) {
            listSubstances.add(integer);
        }

        String leftSubstansece=listSubstances.stream().map(String::valueOf).collect(Collectors.joining(", "));
        if(!listSubstances.isEmpty()){
            System.out.printf("Substances: "+leftSubstansece);
            System.out.println();
        }

        List<Integer>toolsList=new ArrayList<>();
        for (Integer integer : toolsQueue) {
            toolsList.add(integer);
        }
        String leftTools=toolsList.stream().map(String::valueOf).collect(Collectors.joining(", "));
        if(!toolsList.isEmpty()){
            System.out.printf("Tools: "+leftTools);
            System.out.println();
        }

        String challengesRes=challenges.stream().map(String::valueOf).collect(Collectors.joining(", "));
        if(!challenges.isEmpty()){
            System.out.printf("Challenges: "+challengesRes);
        }
    }
}
