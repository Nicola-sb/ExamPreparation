package guild;

public class Player {
    //First, write a Java class Player with the following fields:
    //•	name: String
    //•	clazz: String
    //•	rank: String – "Trial" by default
    //•	description: String – "n/a" by default
    private String name;
    private String clazz;
    private String rank;
    private String description;
// The class constructor should receive name and clazz. You need to create the appropriate getters and setters.
// Override the toString() method in the following format:
//"Player {name}: {clazz}
//Rank: {rank}
//Description: {description}"


    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank="Trial";
        this.description="n/a";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        //// Override the toString() method in the following format:
        ////"Player {name}: {clazz}
        ////Rank: {rank}
        ////Description: {description}"
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("Player %s: %s",name,clazz)).append(System.lineSeparator());
        builder.append(String.format("Rank: %s",rank)).append(System.lineSeparator());
        builder.append(String.format("Description: %s",description));
        return builder.toString();
    }

}
