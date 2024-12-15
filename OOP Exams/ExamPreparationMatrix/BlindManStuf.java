package ExamPreparationMatrix;

import java.util.Scanner;

public class BlindManStuf {
    public static void main(String[] args) {//42 ot 100
        Scanner scanner = new Scanner(System.in);

        String []numbers=scanner.nextLine().split("\\s+");

        int n=Integer.parseInt(numbers[0]);
        int m=Integer.parseInt(numbers[1]);

        char[][]matrix=new char[n][m];

        for(int row=0 ;row<n ;row++){
            matrix[row]=scanner.nextLine().replaceAll(" ","").toCharArray();
        }

        int currentRow=0;
        int currentCol=0;
        int touchedOponenets=0;
        int movesMade=0;


        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<m ;col++){
                char currentElement=matrix[row][col];
                if(currentElement=='B'){
                    currentRow=row;
                    currentCol=col;
                }
            }
        }
        String command=scanner.nextLine();
        while (!command.equals("Finish")){
            int oldRow=currentRow;
            int oldCol=currentCol;
            switch (command){

                //". If the direction leads you out of the field, you need to stay in position inside the field(do NOT make the move).
                // If you have an obstacle, towards the direction, do NOT make the move and wait for the next command.
                //up", " down", "right", and "left
                case"up":
                    if(currentRow==0){
                        command=scanner.nextLine();
                        continue;
                    }
                    if(matrix[currentRow-1][currentCol]=='O'){
                        command=scanner.nextLine();
                        continue;
                    }
                    currentRow--;
                    break;
                case "down":
                    if(currentRow>=n-1){
                        command=scanner.nextLine();
                        continue;
                    }
                    if(matrix[currentRow+1][currentCol]=='O'){
                        command=scanner.nextLine();
                        continue;
                    }
                    currentRow++;;
                    break;
                case "right":
                    if(currentCol>=m-1){
                        command=scanner.nextLine();
                        continue;
                    }
                    if(matrix[currentRow][currentCol+1]=='O'){
                        command=scanner.nextLine();
                        continue;
                    }
                    currentCol++;
                    break;
                case "left":
                    if(currentCol==0){
                        command=scanner.nextLine();
                        continue;
                    }
                    if(matrix[currentRow][currentCol -1]=='O'){
                        command=scanner.nextLine();
                        continue;
                    }
                    currentCol--;
                    break;
            }

//If the direction leads you out of the field, you need to stay in position inside the field(do NOT make the move).

//            if(matrix[currentRow][currentCol]=='O'){
//                continue;
//            }
            //In case you step on a position marked with '-', increase the count of the moves made.
            //When you receive a command with direction, you check the position you need to step on for an obstacle or opponent.
            // If there is an opponent, you touch him and the position is marked with '-'
            // (increase the count of the touched opponents and moves made), and this is your new position.
            if(matrix[currentRow][currentCol]=='-'){
                movesMade++;
                matrix[oldRow][oldCol]='-';
            }
            else if(matrix[currentRow][currentCol]=='P'){
                matrix[oldRow][oldCol]='-';
                touchedOponenets++;
                movesMade++;
            }

            matrix[currentRow][currentCol]='B';
            if(touchedOponenets==3){
                System.out.println("Game over!");
                System.out.printf("Touched opponents: %d Moves made: %d",touchedOponenets,movesMade);
                break;
            }
            command=scanner.nextLine();
        }

        if(touchedOponenets<3){
            System.out.println("Game over!");
            System.out.printf("Touched opponents: %d Moves made: %d",touchedOponenets,movesMade);
        }
    }
}
