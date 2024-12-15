package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Scanner;

public class OsPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String task=scanner.nextLine();
        String threads=scanner.nextLine();
        String taskToKill=scanner.nextLine();

        String[]taskArr=task.split(",\\s+");
        ArrayDeque<Integer> stackTask=new ArrayDeque<>();
        for (String element:taskArr){
            stackTask.push(Integer.parseInt(element));
        }

        String[]threadsArr=threads.split("\\s+");
        ArrayDeque<Integer>threadsQueue=new ArrayDeque<>();
        for (String element:threadsArr){
            threadsQueue.offer(Integer.parseInt(element));
        }

        //Your job is to stop the work of the OS as soon as you get to this task, otherwise, your OS will crash.
        // The thread that gets first to this task, kills it.
        System.out.println();

        //•	It takes the first given thread value and the last given task value.
        //•	If the thread value is greater than or equal to the task value, the task and thread get removed.
        while (!stackTask.isEmpty() && !threadsQueue.isEmpty()){
                  int currentStackTask=stackTask.peek();
                  int currentThreadsQueue=threadsQueue.peek();

                  if(currentThreadsQueue>=currentStackTask){
                          threadsQueue.pop();
                          stackTask.poll();
                  }else{
                      //•	If the thread value is less than the task value, the thread gets removed, but the task remains.
                          threadsQueue.pop();
                  }
                  //After you finish the needed task, print on a single line:
            //"Thread with value {thread} killed task {taskToBeKilled}"
            //Then print the remaining threads (including the one that killed the task) starting from the first on a single line, separated by a single space.
        }

    }
}
