package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] stringArmorEnergy=scanner.nextLine().split(",");
        ArrayDeque<Integer>armorOfMonsters=new ArrayDeque<>();
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
             int currentArmorMonster=armorOfMonsters.peek();
             int currentStrikeStrenght=soldierStrikingImpact.peek();
//•	If the soldier's striking impact is greater than or equal to the monster's armor, the monster is killed, and its armor is removed from the sequence.
// The soldier's strike impact is then decreased by the value of the monster's armor.
// The remaining striking impact value is added to the next strike element in the sequence (if any)
// or is considered to be the last and only element. Zero values should not be pushed back to the sequence
              if(currentStrikeStrenght>=currentArmorMonster){
//                  armorOfMonsters.poll();
                  totalMonstarKill++;
                  int currentDiff=currentStrikeStrenght-currentArmorMonster;//5 трябва да го добавя към soldierStrike impact.Требва да поп sol trike
                  if(currentDiff == 0){
                      soldierStrikingImpact.pop();
                      armorOfMonsters.poll();
                  }else{
                      armorOfMonsters.poll();
                      if(soldierStrikingImpact.size()!=1){

                      }
                      soldierStrikingImpact.pop();
                      int soldierLastElement=soldierStrikingImpact.peek();
                      soldierStrikingImpact.pop();
                      if(currentDiff != 0){
                          soldierStrikingImpact.push(soldierLastElement+currentDiff);
                      }else{
                          soldierStrikingImpact.push(soldierLastElement);
                      }
                  }


              }else{
                  //•	If the soldier's striking impact is less than the monster's armor, the strike is performed, but the monster survives with reduced armor.
                  // The soldier's striking impact value is removed from the sequence, and the monster's armor value is decreased by the original strike value.
                  // The monster is then moved to the back of the sequence
                  int decreaseMonsterArmorValue=currentArmorMonster-currentStrikeStrenght;
                  soldierStrikingImpact.pop();
                  armorOfMonsters.poll();
                  armorOfMonsters.offer(decreaseMonsterArmorValue);
              }
         }


        if(armorOfMonsters.isEmpty()){
            System.out.println("All monsters have been killed!");
        }

        if(soldierStrikingImpact.isEmpty()){
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d%n",totalMonstarKill);
    }
}
