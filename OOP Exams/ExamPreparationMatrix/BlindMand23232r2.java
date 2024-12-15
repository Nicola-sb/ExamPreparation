package ExamPreparationMatrix;

import java.util.Scanner;

public class BlindMand23232r2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]numbersInput=scanner.nextLine().split("\\s+");

        int rows=Integer.parseInt(numbersInput[0]);
        int columns=Integer.parseInt(numbersInput[1]);

        char[][]matrix=new char[rows][columns];

        for(int row=0 ;row<rows ;row++){
            matrix[row]=scanner.nextLine().replaceAll(" ","").toCharArray();
        }

        int currentRow=0;
        int currentCol=0;
        int movesMade=0;
        int touchedOpponents=0;
        boolean isTouched=false;
        for(int i=0 ;i<rows ;i++){
            for(int j=0 ;j<columns ;j++){
                char currentElement=matrix[i][j];
                if(currentElement=='B'){
                    currentRow=i;
                    currentCol=j;
                }
            }

        }
        String command=scanner.nextLine();
        while (!command.equals("Finish")){
//            matrix[currentRow][currentCol]='-';
            int oldRow=currentRow;
            int oldCol=currentCol;
            switch (command){
                case "left":
                     if(matrix[currentRow][currentCol-1]=='O') {
                         command = scanner.nextLine();
                         continue;
                     }else if(currentCol==0){

                     }else{
                         currentCol--;
                     }

                    break;
                case "right":
                    if(matrix[currentRow][currentCol+1]=='O') {
                        command=scanner.nextLine();
                        continue;
                    }else if(currentCol==columns-1){

                    }else{
                        currentCol++;
                    }
                    break;
                case "up":
                     if(matrix[currentRow-1][currentCol]=='O') {
                        command=scanner.nextLine();
                        continue;
                    }else if(currentRow==0){

                     }else{
                         currentRow--;
                     }
                    break;
                case "down":
                     if(matrix[currentRow+1][currentCol]=='O') {
                        command=scanner.nextLine();
                        continue;
                    }else if(currentRow<=rows-1){

                     }else{
                         currentRow++;
                     }
                    break;
            }

            if(matrix[currentRow][currentCol]=='P'){
                touchedOpponents++;
                movesMade++;
                matrix[oldRow][oldCol]='-';
            }else if(matrix[currentRow][currentCol]=='-'){
                matrix[oldRow][oldCol]='-';
                movesMade++;
            }


            matrix[currentRow][currentCol]='B';
            if(touchedOpponents==3){
//                System.out.println("Game over!");
//                System.out.printf("Touched opponents: %d Moves made: %d",touchedOpponents,movesMade);
//                isTouched=true;
                break;
            }
            command=scanner.nextLine();
        }

//        if(touchedOpponents<3){
//            System.out.println("Game over!");
//            System.out.printf("Touched opponents: %d Moves made: %d",touchedOpponents,movesMade);
//        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d",touchedOpponents,movesMade);
    }
}


