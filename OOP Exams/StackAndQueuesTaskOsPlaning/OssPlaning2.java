package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OssPlaning2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]inputTasks=scanner.nextLine().split(",\\s+");
        ArrayDeque<Integer>tasksStack=new ArrayDeque<>();
        String[]inputThreads=scanner.nextLine().split("\\s+");
        ArrayDeque<Integer>threads=new ArrayDeque<>();
        int taskToKill=Integer.parseInt(scanner.nextLine());

        for (String element:inputTasks){
            tasksStack.push(Integer.parseInt(element));
        }
        for (String element:inputThreads){
            threads.offer(Integer.parseInt(element));
        }
        int firstTask=tasksStack.peek();
        int firstThreads=threads.peek();
        while (taskToKill !=firstTask){
//•	If the thread value is greater than or equal to the task value, the task and thread get removed.
            if(firstThreads>=firstTask){
                tasksStack.pop();
                threads.poll();
            }else{
                //•	If the thread value is less than the task value, the thread gets removed, but the task remains
                threads.poll();
            }
             firstTask=tasksStack.peek();
             firstThreads=threads.peek();

        }

        System.out.printf("Thread with value %s killed task %s",threads.peek(),taskToKill);
        //Then print the remaining threads (including the one that killed the task) starting from the first on a single line, separated by a single space.
        String leftThreads=threads.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(leftThreads);



    }
}
