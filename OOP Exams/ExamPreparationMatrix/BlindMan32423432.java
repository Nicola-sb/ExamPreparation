package ExamPreparationMatrix;

import java.util.Scanner;

public class BlindMan32423432 {
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
                    if(currentCol==0){

                    }else if(matrix[currentRow][currentCol-1].equals("O")) {
                        command=scanner.nextLine();
                        continue;
                    }else{
                        currentCol--;
                    }

                    break;
                case "right":
                    if(currentCol==columns-1){

                    }else if(matrix[currentRow][currentCol+1].equals("O")) {
                        command=scanner.nextLine();
                        continue;
                    }else{
                        currentCol++;
                    }
                    break;
                case "up":
                    if(currentRow==0){

                    }else if(matrix[currentRow-1][currentCol].equals("O")) {
                        command=scanner.nextLine();
                        continue;
                    }else{
                        currentRow--;
                    }
                    break;
                case "down":
                    if(currentRow==rows-1){

                    }else if(matrix[currentRow+1][currentCol].equals("O")) {
                        command=scanner.nextLine();
                        continue;
                    }else{
                        currentRow++;
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

