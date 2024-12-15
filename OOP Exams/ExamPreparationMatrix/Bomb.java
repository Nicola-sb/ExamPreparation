package ExamPreparationMatrix;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        String[]inputCommands=scanner.nextLine().split(",");
        String[][]matrix=new String[n][n];
        for(int row=0 ;row<n ;row++){
            String[]input=scanner.nextLine().split("\\s+");
            for(int col=0 ;col<n ;col++){
                matrix[row][col]=input[col];
            }
        }
        int currentRow=0;
        int currentCol=0;
        int bombCounter=0;
        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<n ;col++){
                String currentElement=matrix[row][col];
                if(currentElement.equals("s")){
                    currentRow=row;
                    currentCol=col;
                }else if(currentElement.equals("B")){
                    bombCounter++;
                }
            }
        }
        int foundBombs=0;
        boolean isEndFound=false;

        for (String command:inputCommands){
            switch (command){
                case "left":
              if(currentCol!=0){
                  currentCol--;
              }
                    break;
                case "right":
                    if(currentCol!=n-1){
                        currentCol++;
                    }
                    break;
                case "up":
                    if(currentRow!=0){
                        currentRow--;
                    }
                    break;
                case "down":
                    if(currentRow!=n-1){
                        currentRow++;
                    }
                    break;
            }
            //Each time when sapper finds a bomb, he deactivates it, and replace "B" with "+".
            // Keep track of the count of the bombs. Each time you find a bomb, you have to print the following message: "You found a bomb!".
            if(matrix[currentRow][currentCol].equals("B")){
                System.out.println("You found a bomb!");
                foundBombs++;
                matrix[currentRow][currentCol]="+";
            }
            //!". If sapper steps at the end of the route game is over (the program stops) and you have to print the output as shown in the output section
            if(matrix[currentRow][currentCol].equals("e")){
                System.out.printf("END! %d bombs left on the field",bombCounter-foundBombs);
                isEndFound=true;
                break;
            }
            //. After executing all of the commands there are only 2 possible outcomes (there are not going to be more cases):
            //•	if you found all bombs – you win and the game ends
            //•	if you reach the end point ("e"), you have to stop
            if(foundBombs==bombCounter){
                System.out.println("Congratulations! You found all bombs!");
                break;
            }

        }


        if(!isEndFound && foundBombs!=bombCounter){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombCounter-foundBombs,currentRow,currentCol);
        }


    }
}
