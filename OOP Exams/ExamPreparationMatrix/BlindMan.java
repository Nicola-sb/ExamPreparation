package ExamPreparationMatrix;

import java.util.Scanner;

public class BlindMan {
    public static void main(String[] args) {
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
            // If the direction leads you out of the field, you need to stay in position inside the field(do NOT make the move).
            // If you have an obstacle, towards the direction, do NOT make the move and wait for the next command
            switch (command){
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "left":
                    currentCol--;
                    break;

            }
//            if(currentRow<0 || currentRow>=n || currentCol<0 || currentCol>=m){
//                matrix[currentRow][currentCol]='B';
//                continue;
//            }
            if(matrix[currentRow][currentCol]=='O'){
                command=scanner.nextLine();
                continue;
            }
            command=scanner.nextLine();
        }
    }
}
