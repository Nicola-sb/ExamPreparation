package ExamPreparationMatrix;

import java.util.Scanner;

public class BombAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        String[]commandsPart=scanner.nextLine().split(",");
        String[][]matrix=new String[n][n];


        for(int row=0 ;row<n ;row++){
            matrix[row]=scanner.nextLine().split("\\s+");
        }

        int currentRow=0;
        int currentCol=0;
        //Ще си обходя матрицата за да си намеря стартовата точка(ред и колона),която се намира на символа "s";
        int countBombs=0;//Tука ще си държа броя на бомбите
        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<n ;col++){
                if(matrix[row][col].equals("s")){
                    currentRow=row;
                    currentCol=col;
                }else if(matrix[row][col].equals("B")){
                    countBombs++;
                }
            }
        }
        //commandParts-->up,right,right,up,right
        //left/right/up/down
        int bombsFound=0;
        boolean eIsFounde=false;

        for(int i=0 ;i<commandsPart.length ;i++){
           String currentCommand=commandsPart[i];

            switch (currentCommand){
                case "left":
                    if(currentCol!=0){
                        currentCol--;
                    }
                    break;
                case "right":
                    if(currentCol != n-1){
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
            if(matrix[currentRow][currentCol].equals("B")){
                System.out.println("You found a bomb!");
                bombsFound++;
                matrix[currentRow][currentCol]="+";
            }

            if(matrix[currentRow][currentCol].equals("e")){
                System.out.printf("END! %d bombs left on the field",countBombs-bombsFound);
                eIsFounde=true;
                break;
            }
            if(countBombs==bombsFound){
                System.out.println("Congratulations! You found all bombs!");
                break;
            }

        }


        if(countBombs!=bombsFound && !eIsFounde){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",countBombs-bombsFound,currentRow,currentCol);
        }


    }
}
