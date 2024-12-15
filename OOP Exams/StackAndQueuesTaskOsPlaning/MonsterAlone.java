package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MonsterAlone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] stringArmorEnergy=scanner.nextLine().split(",");
        ArrayDeque<Integer> armorOfMonsters=new ArrayDeque<>();
        String [] stringSoldierStrikingImpact=scanner.nextLine().split(",");
        ArrayDeque<Integer>soldierStrikingImpact=new ArrayDeque<>();

        for (String element:stringArmorEnergy){
            armorOfMonsters.offer(Integer.parseInt(element));
        }

        for (String element:stringSoldierStrikingImpact){
            soldierStrikingImpact.push(Integer.parseInt(element));
        }

        int totalMonstarKill=0;

        while (!armorOfMonsters.isEmpty() && !soldierStrikingImpact.isEmpty()){
            int currentArmor=armorOfMonsters.peek();
            int currentStrikeImpact=soldierStrikingImpact.peek();

            if(currentStrikeImpact >= currentArmor){
                totalMonstarKill++;
                currentStrikeImpact=currentStrikeImpact-currentArmor;

                if(currentStrikeImpact==0){
                    soldierStrikingImpact.pop();
                    armorOfMonsters.poll();
                }else{
                    armorOfMonsters.poll();
                    if(soldierStrikingImpact.size() == 1){
                        soldierStrikingImpact.pop();
                        soldierStrikingImpact.push(currentStrikeImpact);
                    }else{
                        soldierStrikingImpact.pop();
                        int tempStrike = currentStrikeImpact;
                        int previousStrike=soldierStrikingImpact.pop();
                        soldierStrikingImpact.push(previousStrike + tempStrike);
                    }
                }
            }else{
                currentArmor=currentArmor-currentStrikeImpact;
                soldierStrikingImpact.pop();
                armorOfMonsters.poll();
                armorOfMonsters.offer(currentArmor);
            }
        }

        if (armorOfMonsters.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (soldierStrikingImpact.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.println("Total monsters killed: " + totalMonstarKill);
    }
}
