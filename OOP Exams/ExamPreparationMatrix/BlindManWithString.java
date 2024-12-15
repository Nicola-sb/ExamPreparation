package ExamPreparationMatrix;

import java.util.Scanner;

public class BlindManWithString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]numbersInput=scanner.nextLine().split("\\s+");

        int rows=Integer.parseInt(numbersInput[0]);
        int columns=Integer.parseInt(numbersInput[1]);

        String[][]matrix=new String[rows][columns];

        for(int row=0 ;row<rows ;row++){
            String[]input=scanner.nextLine().split(" ");
            for(int col=0 ;col<columns ;col++){
                 matrix[row][col]=input[col];
            }
        }

        int currentRow=0;
        int currentCol=0;
        int movesMade=0;
        int touchedOpponents=0;
        boolean isTouched=false;
        for(int i=0 ;i<rows ;i++){
            for(int j=0 ;j<columns ;j++){
                String currentElement=matrix[i][j];
                if(currentElement.equals("B")){
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
                    if(currentCol!=0 && !matrix[currentRow][currentCol-1].equals("O")){
                        currentCol--;
                    }else if(matrix[currentRow][currentCol-1].equals("O")) {
                        command=scanner.nextLine();
                        continue;
                    }

                    break;
                case "right":
                    if(currentCol!=columns-1 && !matrix[currentRow][currentCol+1].equals("O")){
                        currentCol++;
                    }else if(matrix[currentRow][currentCol+1].equals("O")) {
                        command=scanner.nextLine();
                        continue;
                    }
                    break;
                case "up":
                    if(currentRow!=0 && !matrix[currentRow-1][currentCol].equals("O")){
                        currentRow--;
                    }else if(matrix[currentRow-1][currentCol].equals("O")) {
                        command=scanner.nextLine();
                        continue;
                    }
                    break;
                case "down":
                    if(currentRow!=rows-1 && !matrix[currentRow+1][currentCol].equals("O")){
                        currentRow++;
                    }else if(matrix[currentRow+1][currentCol].equals("O")) {
                        command=scanner.nextLine();
                        continue;
                    }
                    break;
            }

            if(matrix[currentRow][currentCol].equals("P")){
                touchedOpponents++;
                movesMade++;
                matrix[oldRow][oldCol]="-";
            }else if(matrix[currentRow][currentCol].equals("-")){
                matrix[oldRow][oldCol]="-";
                movesMade++;
            }


            matrix[currentRow][currentCol]="B";
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
