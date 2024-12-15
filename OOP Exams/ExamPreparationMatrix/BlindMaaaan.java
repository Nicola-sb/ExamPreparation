package ExamPreparationMatrix;

import java.util.Scanner;

public class BlindMaaaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]numbersInput=scanner.nextLine().split("\\s+");//100от100

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
            int oldRow=currentRow;
            int oldCol=currentCol;
            if(command.equals("left") && currentCol==0 || command.equals("right")&& currentCol>=columns-1|| command.equals("up")&& currentRow==0 ||
                    command.equals("down")&& currentRow>=rows-1){
                command=scanner.nextLine();
                continue;
            }

            if(command.equals("left") && matrix[currentRow][currentCol-1]=='O'){
                command=scanner.nextLine();
                continue;
            }else if(command.equals("right")&& matrix[currentRow][currentCol+1]=='O'){
                command=scanner.nextLine();
                continue;
            }else if(command.equals("up")&& (matrix[currentRow-1][currentCol]=='O')) {
                command=scanner.nextLine();
                continue;
            }else if(command.equals("down")&& matrix[currentRow+1][currentCol]=='O' ){
                command=scanner.nextLine();
                continue;
            }

            if(command.equals("left")){
                currentCol--;
            }else if(command.equals("right")){
                currentCol++;
            }else if(command.equals("up")){
                currentRow--;
            }else if(command.equals("down")){
                currentRow++;
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
                break;
            }
            command=scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d",touchedOpponents,movesMade);
    }
}
