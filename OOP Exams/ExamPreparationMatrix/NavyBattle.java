package ExamPreparationMatrix;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        char[][]matrix=new char[n][n];
        for(int row=0 ;row<n ;row++){
            matrix[row]=scanner.nextLine().replaceAll(" ","").toCharArray();
        }
        int currentRow=0;
        int currentCol=0;

        int hitMines=0;
        int cruisesDestroyed=0;
        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<n ;col++){
                char currentElement=matrix[row][col];
                if(currentElement=='S'){
                    currentRow=row;
                    currentCol=col;
                }
            }
        }

        while (hitMines!=3 && cruisesDestroyed!=3){
            String command=scanner.nextLine();
            matrix[currentRow][currentCol]='-';
            switch (command){
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }
            if(matrix[currentRow][currentCol]=='-'){
                continue;
            }else if(matrix[currentRow][currentCol]=='*'){
                hitMines++;
                matrix[currentRow][currentCol]='-';
                if(hitMines==3){
//                    matrix[currentRow][currentCol]='S';
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",currentRow,currentCol);
                }
            }else if(matrix[currentRow][currentCol]=='C'){
                cruisesDestroyed++;
                matrix[currentRow][currentCol]='-';
                if(cruisesDestroyed==3){
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                }
            }
            matrix[currentRow][currentCol]='S';

        }


        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<n ;col++){
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }
}
