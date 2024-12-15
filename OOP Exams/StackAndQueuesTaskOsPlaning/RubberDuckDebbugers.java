package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RubberDuckDebbugers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String [] stringArmorEnergy=scanner.nextLine().split(" ");
        ArrayDeque<Integer> timeProgramQueue=new ArrayDeque<>();

        String [] stringSoldierStrikingImpact=scanner.nextLine().split(" ");
        ArrayDeque<Integer>numberOfTasks=new ArrayDeque<>();

        for (String element:stringArmorEnergy){
            timeProgramQueue.offer(Integer.parseInt(element));
        }

        for (String element:stringSoldierStrikingImpact){
            numberOfTasks.push(Integer.parseInt(element));
        }

        int countDarthVaderDucky=0;
        int countThorDucky=0;
        int countBigBlueRubberDucky=0;
        int countSmallYellowDucku=0;

        while (!timeProgramQueue.isEmpty() && !numberOfTasks.isEmpty()){
            int timeProg=timeProgramQueue.peek();
            int numberStack=numberOfTasks.peek();

            int sum = timeProg * numberStack;
            //•	If the calculated time is between any of the time ranges below, you give the corresponding ducky and remove the programmer time's value and the tasks' value
            if(sum <=60){
              countDarthVaderDucky++;
              timeProgramQueue.poll();
              numberOfTasks.pop();
            }else if(sum <=120){
                countThorDucky++;
                timeProgramQueue.poll();
                numberOfTasks.pop();
            }else if(sum <=180){
                countBigBlueRubberDucky++;
                timeProgramQueue.poll();
                numberOfTasks.pop();
            }else if(sum <=240){
                countSmallYellowDucku++;
                timeProgramQueue.poll();
                numberOfTasks.pop();
            }else{
                //decrease the number of the task's value by 2. Then, move the programmer time's value to the end of its sequence, and continue with the next operation
                int currentTaskValue=numberOfTasks.peek();
                numberOfTasks.pop();
                numberOfTasks.push(currentTaskValue-2);
                timeProgramQueue.poll();
                timeProgramQueue.offer(timeProg);
                //Return the programmer time's value (22) at the end of the sequence and decrease the task's value (16) by 2 -> it becomes 14
            }
        }


        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");

        System.out.printf("Darth Vader Ducky: %d%n",countDarthVaderDucky);
        System.out.printf("Thor Ducky: %d%n",countThorDucky);
        System.out.printf("Big Blue Rubber Ducky: %d%n",countBigBlueRubberDucky);
        System.out.printf("Small Yellow Rubber Ducky: %d%n",countSmallYellowDucku);
    }
}
