package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WarmsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String []stringWarms=scanner.nextLine().split(" ");
        String[]stringHoles=scanner.nextLine().split(" ");

        ArrayDeque<Integer> warmsStack=new ArrayDeque<>();
        ArrayDeque<Integer>holesQueue=new ArrayDeque<>();

        for (String element:stringWarms){
            warmsStack.push(Integer.parseInt(element));
        }

        for (String element:stringHoles){
            holesQueue.offer(Integer.parseInt(element));
        }

        int countMatches=0;
        boolean allWormAndHolesFound=false;
//2 5 8 13
//13 8 5 6
        int sizeWarmStack=warmsStack.size();
        while (!warmsStack.isEmpty() && !holesQueue.isEmpty()){
            int currentWarm=warmsStack.peek();
            int currentHole=holesQueue.peek();

            if(currentWarm==currentHole){
                //•	If their values are equal, the worm fits the hole and can get into it.
                // After that, you should remove both of them from their sequences.
                // Otherwise, you should remove the hole and decrease the value of the worm by 3.
                warmsStack.pop();
                holesQueue.poll();

                countMatches++;
//                if(warmsStack.isEmpty() && holesQueue.isEmpty()){
//                    allWormAndHolesFound=true;
//                }
                if(sizeWarmStack == countMatches){
                    allWormAndHolesFound=true;
                }

            }else{
                holesQueue.poll();
                int cureentWarmToAdd=currentWarm-3;
                if(cureentWarmToAdd<=0){
                    warmsStack.pop();
                }else{
                    warmsStack.pop();
                    warmsStack.push(currentWarm-3);
                }

            }

//            if(warmsStack.isEmpty() && holesQueue.isEmpty()){
//                allWormAndHolesFound=true;
//            }
        }

        ArrayDeque<String>warmStackDeque=new ArrayDeque<>();
        for (Integer currentWarm : warmsStack) {
            warmStackDeque.push(String.valueOf(currentWarm));
        }


        if(countMatches>0){
            System.out.printf("Matches: %d%n",countMatches);
        }else{
            System.out.println("There are no matches.");
        }
//	If there are no worms left and all of them fit a hole:
//o	"Every worm found a suitable hole!"
//	If there are no worms left but only some of them fit a hole:
//o	"Worms left: none"
//	If there are worms left:
//o	"Worms left: {worm1}, {worm2}, (…),{wormn}"

        if(warmStackDeque.isEmpty() && allWormAndHolesFound){
            System.out.println("Every worm found a suitable hole!");
//            if(warmStackDeque.isEmpty()){
//                System.out.println("Every worm found a suitable hole!");
//            }else{
//                System.out.println("Worms left: none");
//            }
        }else if(warmStackDeque.isEmpty()){
            System.out.println("Worms left: none");
        }else{
            String leftWarms=warmStackDeque.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Worms left: " + leftWarms);
        }

//	If there are no holes left:
//o	"Holes left: none"
//	If there are holes left:
//o	"Holes left: {hole1}, {hole2}, (…),{holen}"
        if(holesQueue.isEmpty()){
            System.out.println("Holes left: none");
        }else{
            String leftHoles=holesQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Holes left: "+leftHoles);
        }
    }
}
