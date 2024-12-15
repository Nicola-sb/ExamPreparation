package ExamPreparationMatrix;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        String[][]matrix=new String[n][n];

        for(int row=0 ;row<n ;row++){
            String[]input=scanner.nextLine().split("");
            for(int col=0 ;col<n ;col++){
                matrix[row][col]=input[col];
            }
        }
        int currentRow=0;
        int currentCol=0;

       for(int row=0 ;row<n ;row++){
           for(int col=0 ;col<n ;col++){
             String currentElement=matrix[row][col];
               if(currentElement.equals("S")){
                   currentRow=row;
                   currentCol=col;
               }
           }
       }
         //On random positions there will be clients, marked with a single digit.
        // There may also be pillars. Their count will be either 0 or 2 and they are marked with the letter - 'P'. All of the empty positions will be marked with '-'.
        int firstPillarRow=0;
        int firstPillarCol=0;

        int secondPillarRow=0;
        int secondPillarCol=0;
        boolean isFirstPillarFound=false;
         for(int row=0 ;row<n ;row++){
             for(int col=0 ;col<n ;col++){
                 String currentElement=matrix[row][col];
                 if(currentElement.equals("P")&& !isFirstPillarFound){
                     firstPillarRow=row;
                     firstPillarCol=col;
                     isFirstPillarFound=true;
                 }
                 if(currentElement.equals("P")&& isFirstPillarFound){
                     secondPillarRow=row;
                     secondPillarCol=col;
                 }
             }
         }
//        for(int row=0 ;row<n ;row++){
//            for(int col=0 ;col<n ;col++){
//                System.out.print(matrix[row][col]);
//            }
//            System.out.println();
//        }
         int money=0;
         while (money<50){
             String command=scanner.nextLine();
             matrix[currentRow][currentCol]="-";

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

             if(currentRow<0 || currentCol<0 || currentRow>=n || currentCol>=n){
                 break;
             }

             if(currentRow ==firstPillarRow && currentCol==firstPillarCol){
                 matrix[currentRow][currentCol]="-";
                 currentRow=secondPillarRow;
                 currentCol=secondPillarCol;
             }else if(currentRow==secondPillarRow && currentCol==secondPillarCol){
                 matrix[currentRow][currentCol]="-";
                 currentRow=firstPillarRow;
                 currentCol=firstPillarCol;
             }else if(matrix[currentRow][currentCol].equals("-")){

             }else{
                 money=money+Integer.parseInt(matrix[currentRow][currentCol]);
             }


              matrix[currentRow][currentCol]="S";
//             command=scanner.nextLine();
         }

         //•	On the first line:
        //o	If the player goes to the void, print: "Bad news! You are out of the pastry shop."
        //o	If the player collects enough star power, print: "Good news! You succeeded in collecting enough money!"
        //•	On the second line print all star power collected: "Money: {money}"
        //•	In the end print the matrix.
        if(money>=50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }else{
            System.out.println("Bad news! You are out of the pastry shop.");
        }

        System.out.println("Money: "+money);


         for(int row=0 ;row<n ;row++){
             for(int col=0 ;col<n ;col++){
                 System.out.print(matrix[row][col]);
             }
             System.out.println();
         }


    }
}
