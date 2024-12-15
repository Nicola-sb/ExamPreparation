package ExamPreparationMatrix;

import java.util.Scanner;

public class TheGambler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        char[][]matrix=new char[n][n];

        for(int row=0 ;row<n ;row++){
            matrix[row]=scanner.nextLine().replaceAll(" ","").toCharArray();
        }

        int currentRow=0;
        int currentCol=0;
        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<n ;col++){
                char currentElement=matrix[row][col];
                if(currentElement=='G'){
                    currentRow=row;
                    currentCol=col;
                }
            }
        }

        int totalAmount=100;

        boolean isNotReacheTheEnd=false;
        String command=scanner.nextLine();
        while (!command.equals("end")){
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

            if(currentRow < 0 || currentCol < 0 || currentRow>=n || currentCol>=n){
                totalAmount=0;
                System.out.println("Game over! You lost everything!");
                matrix[currentRow][currentCol]='G';
                return;
            }

            if(matrix[currentRow][currentCol]=='-'){
                matrix[currentRow][currentCol]='G';
                command=scanner.nextLine();
                continue;
            }else if(matrix[currentRow][currentCol]=='W'){
                totalAmount=totalAmount+100;
            }else if(matrix[currentRow][currentCol]=='P'){
                totalAmount=totalAmount-200;
            }else if(matrix[currentRow][currentCol]=='J'){
                totalAmount=totalAmount+100000;
                System.out.println("You win the Jackpot!");
                System.out.printf("End of the game. Total amount: %d$%n",totalAmount);
                isNotReacheTheEnd=true;
                matrix[currentRow][currentCol]='G';
                break;
            }

            if(totalAmount<=0){
                System.out.println("Game over! You lost everything!");
                matrix[currentRow][currentCol]='G';
                return;
            }

            matrix[currentRow][currentCol]='G';
            command=scanner.nextLine();
        }

        if(!isNotReacheTheEnd){
            System.out.printf("End of the game. Total amount: %d$%n",totalAmount);
        }

        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<n ;col++){
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
