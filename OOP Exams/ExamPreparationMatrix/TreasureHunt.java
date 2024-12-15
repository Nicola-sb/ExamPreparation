package ExamPreparationMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String []dimension=scanner.nextLine().split(" ");
        int rows=Integer.parseInt(dimension[0]);
        int columns=Integer.parseInt(dimension[1]);

        String[][]matrix=new String[rows][columns];
        for(int row=0 ;row<rows ;row++){
            String[]input=scanner.nextLine().split(" ");
            for(int col=0 ;col<columns ;col++){
                matrix[row][col]=input[col];
            }
        }
        int currentRow=0;
        int currentCol=0;
        for(int i=0 ;i<rows ;i++){
            for(int j=0 ;j< columns;j++){
                String currentElement=matrix[i][j];
                if(currentElement.equals("Y")){
                    currentRow=i;
                    currentCol=j;
                }
            }
        }
        List<String> commandsList=new ArrayList<>();
        String command=scanner.nextLine();
        while (!command.equals("Finish")){
            matrix[currentRow][currentCol]="-";
            int oldRow=currentRow;
            int oldCol=currentCol;
            switch (command){
                case "left":
                    if(currentCol==0){
                        command=scanner.nextLine();
                        continue;
                    }
                    currentCol--;
                    break;
                case "right":
                    if(currentCol>=columns-1){
                        command=scanner.nextLine();
                        continue;
                    }
                    currentCol++;
                    break;
                case "up":
                    if(currentRow==0){
                        command=scanner.nextLine();
                        continue;
                    }
                    currentRow--;
                    break;
                case "down":
                    if(currentRow>=rows-1){
                        command=scanner.nextLine();
                        continue;
                    }
                    currentRow++;
                    break;
            }
//If you step on a tree (position marked with 'T'), go one step back to the direction you came from (not make a move
            if(matrix[currentRow][currentCol].equals("T")){
                currentRow=oldRow;
                currentCol=oldCol;
                command=scanner.nextLine();
                continue;
            }

//            matrix[currentRow][currentCol]="Y";
            commandsList.add(command);
            command=scanner.nextLine();
        }
        //If the given command is "Finish" you need to check the position you are standing on.
        // If it is marked with 'X' this means you have found the treasure,
        // and you have to print the following message: "I've found the treasure!".
        // Then print the correct directions you went to in order to find the treasure.
        //Otherwise, print: "The map is fake!"
        if(matrix[currentRow][currentCol].equals("X")){
            System.out.println("I've found the treasure!");
//            System.out.printf("The right path is %s%n",String.join(", ",commandsList));
            System.out.println("The right path is "+String.join(", ",commandsList));

        }else{
            System.out.println("The map is fake!");
        }



//        for(int i=0 ;i<rows ;i++){
//            for(int j=0 ;j<columns ;j++){
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }


    }
}
