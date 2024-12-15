package StackAndQueuesTaskOsPlaning;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MonsterExternation100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> monsters = new LinkedList<>();
        for (String s : scanner.nextLine().split(",")) {
            monsters.offer(Integer.parseInt(s));
        }

        Stack<Integer> strikes = new Stack<>();
        for (String s : scanner.nextLine().split(",")) {
            strikes.push(Integer.parseInt(s));
        }

        int killedMonsters = 0;

        while (!monsters.isEmpty() && !strikes.isEmpty()) {
            int armour = monsters.peek();
            int strike = strikes.peek();

            if (strike >= armour) {
                killedMonsters++;
                strike -= armour;

                if (strike == 0) {
                    strikes.pop();
                    monsters.poll();
                } else {
                    monsters.poll();
                    if (strikes.size() == 1) {
                        strikes.pop();
                        strikes.push(strike);
                    } else {
                        strikes.pop();
                        int tempStrike = strike;
                        int previousStrike = strikes.pop();
                        strikes.push(previousStrike + tempStrike);
                    }
                }
            } else {
                armour -= strike;
                strikes.pop();
                monsters.poll();
                monsters.offer(armour);
            }
        }

        if (monsters.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (strikes.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.println("Total monsters killed: " + killedMonsters);

        scanner.close();
    }
}
