package ExamPreparationMatrix;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        String[]commandsInput=scanner.nextLine().split(",");
        String[][]matrix=new String[n][n];

        for(int row=0 ;row<n ;row++){
            String[]input=scanner.nextLine().split(" ");
            for(int col=0 ;col<n ;col++){
                matrix[row][col]=input[col];
            }
        }
        int currentRow=0;
        int currentCol=0;
        for(int i=0 ;i<n ;i++){
            for(int j=0;j<n ;j++){
                String currentElement=matrix[i][j];
                if(currentElement.equals("D")){
                    currentRow=i;
                    currentCol=j;
                }
            }
        }
        int totalStolenMoney=0;
        boolean isGetGought=false;
        for (String command:commandsInput){
            matrix[currentRow][currentCol]="+";
            switch (command){
                case "left":
                    if(currentCol==0){
                        System.out.println("You cannot leave the town, there is police outside!");
                        continue;
                    }
                    currentCol--;
                    break;
                case "right":
                    if(currentCol>=n-1){
                        System.out.println("You cannot leave the town, there is police outside!");
                        continue;
                    }
                    currentCol++;
                    break;
                case "up":
                    if(currentRow==0){
                        System.out.println("You cannot leave the town, there is police outside!");
                        continue;
                    }
                    currentRow--;
                    break;
                case "down":
                    if(currentRow>=n-1){
                        System.out.println("You cannot leave the town, there is police outside!");
                        continue;
                    }
                    currentRow++;
                    break;
            }
            //Each time when Dillinger finds a house, he robs it. When Dillinger robs a house replace "$" with "+",
            // calculate how much he has stolen by multiplying row and column indexes of the found symbol "$",
            // add the money to his pocket, and then print  "You successfully stole {calculated money}$.".

            if(matrix[currentRow][currentCol].equals("$")){
                matrix[currentRow][currentCol]="+";
                int currentMoney=currentRow*currentCol;
                totalStolenMoney=totalStolenMoney+currentMoney;
                System.out.printf("You successfully stole %d$.%n",currentMoney);
            }
            //When he steps on "P", he gets caught, print on the console "You got caught with {total stolen money}$,
            // and you are going to jail.", and then the program ends. You have to replace stepped "P" with "#", the matrix must not contain "D".
            if(matrix[currentRow][currentCol].equals("P")){
                System.out.printf("You got caught with %d$, and you are going to jail.%n",totalStolenMoney);
                matrix[currentRow][currentCol]="#";
                isGetGought=true;
                break;
            }
            matrix[currentRow][currentCol]="D";
        }

        if(!isGetGought){
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",totalStolenMoney);
        }

        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<n ;col++){
                System.out.print(matrix[row][col]+ " ");
            }
            System.out.println();
        }
    }
}
