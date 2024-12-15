package ExamPreparationMatrix;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        String []commands=scanner.nextLine().split(",\\s+");
        char[][]matrix=new char[n][n];
        for(int row=0 ;row<n ;row++){
            matrix[row]=scanner.nextLine().replaceAll(" ","").toCharArray();

        }
        int pythonRow=0;
        int pythonCol=0;
        int countFood=0;
        int pythonLenght=1;
        boolean isDead=false;


        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<n ;col++){
                char currentElement=matrix[row][col];
                if(currentElement=='s'){
                    pythonRow=row;
                    pythonCol=col;
                }else if(currentElement=='f'){
                    countFood++;
                }
            }
        }


        for (String command:commands){
            matrix[pythonRow][pythonCol]='*';
            switch (command){
           //left/right/up/down
                case "left":
                    pythonCol--;
                    break;
                case "right":
                    pythonCol++;
                    break;
                case "up":
                    pythonRow--;
                    break;
                case "down":
                    pythonRow++;
                    break;
            }
        //If the python reaches the side edge of the screen (left or right), it goes to the opposite side of the same row.
            if(pythonCol<0 || pythonCol >=n){
                if(pythonCol<0){
                    pythonCol=n-1;
                }
                if(pythonCol>=n){
                    pythonCol=0;
                }
            }
            //. If the python reaches the top/bottom edge of the screen it goes on the opposite side of the same column
            if(pythonRow<0 || pythonRow>=n){
                if(pythonRow<0){
                    pythonRow=n-1;
                }
                if(pythonRow>=n){
                    pythonRow=0;
                }
            }
            if(countFood==0){
                break;
            }

            if(matrix[pythonRow][pythonCol]=='f'){
                pythonLenght++;
                countFood--;
            }
            if(matrix[pythonRow][pythonCol]=='e'){
//                System.out.println("You lose! Killed by an enemy!");
                isDead=true;
                break;
            }
            matrix[pythonRow][pythonCol]='s';
        }

        //•	There are three types of output:
        //o	If all of the food is eaten print the following output: "You win! Final python length is {length}"
        //o	If there are no left commands and there is still some food to be eaten: "You lose! There is still {left food} food to be eaten."
        //o	If you step on the enemy the game is over and you print "You lose! Killed by an enemy!"
        if(isDead){
            System.out.println("You lose! Killed by an enemy!");
        }else if(countFood==0){
                System.out.printf("You win! Final python length is %d",pythonLenght);
            }else {
            System.out.printf("You lose! There is still %d food to be eaten.", countFood);
        }








    }
}
