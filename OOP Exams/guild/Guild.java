package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {//88 ot 100
    //Next, write a Java class Guild that has a roster (a collection which stores Player entities).
    // All entities inside the repository have the same fields. Also, the Guild class should have those fields:
    //•	name: String
    //•	capacity: int
    private List<Player> roster;
    private String name;
    private int capacity;
    //The class constructor should receive name and capacity,
    // also it should initialize the roster with a new instance of the collection. Implement the following features:

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster=new ArrayList<>();
    }
    //•	Method addPlayer(Player player) - adds an entity to the roster if there is room for it
    //•	Method removePlayer(String name) - removes a player by given name, if such exists, and returns boolean
    //•	Method promotePlayer(String name) - promote (set his rank to "Member") the first player with the given name. If the player is already a "Member", do nothing.
    //•	Method demotePlayer(String name)- demote (set his rank to "Trial") the first player with the given name. If the player is already a "Trial",  do nothing.
    //•	Method kickPlayersByClass(String clazz) - removes all the players by the given class and returns all removed players from that class as an array
    //•	Method count() - returns the number of players
    public void addPlayer(Player player){
        if(roster.size()<capacity){
            roster.add(player);
        }
    }
    public boolean removePlayer(String name){
        //•	Method removePlayer(String name) - removes a player by given name, if such exists, and returns boolean
        return roster.removeIf(element-> element.getName().equals(name));
    }
    public void promotePlayer(String name){
        //•	Method promotePlayer(String name) - promote (set his rank to "Member") the first player with the given name. If the player is already a "Member", do nothing
        for (Player currentPlayer:roster){
            if(currentPlayer.getName().equals(name)){
                if(!currentPlayer.getRank().equals("Member"))
                currentPlayer.setRank("Member");
            }
        }

    }
   public void demotePlayer(String name){
       //•	Method demotePlayer(String name)- demote (set his rank to "Trial") the first player with the given name. If the player is already a "Trial",  do nothing.
       for (Player player:roster){
           if(player.getName().equals(name)){
               if(!player.getRank().equals("Trial")){
                   player.setRank("Trial");
               }
           }
       }
   }
   public int count(){
       //•	Method count() - returns the number of players
       return roster.size();
   }
   public String report(){
        //•	Method report() - returns a String in the following format:
       //o	"Players in the guild: {guildName}:
       //{Player1}
       //{Player2}
       //(…)"
       StringBuilder builder=new StringBuilder();
       builder.append(String.format("Players in the guild: %s:",name)).append(System.lineSeparator());
       for (Player currentPlayer:roster){
           builder.append(currentPlayer).append(System.lineSeparator());
       }
       return builder.toString();
   }
    //•	Method kickPlayersByClass(String clazz) - removes all the players by the given class and returns all removed players from that class as an array
    public Player[] kickPlayersByClass(String clazz){
        List<String>names=new ArrayList<>();
        for (Player currentPlayer:roster){
            if(currentPlayer.getClazz().equals(clazz)){
                names.add(currentPlayer.getClazz());
            }
        }
        Player[] removedPlayer=new Player[names.size()];

        for(int i=0 ;i<names.size() ;i++){
           Player player=this.roster.remove(i);
           removedPlayer[i]=player;
        }

        return removedPlayer;
    }
}
