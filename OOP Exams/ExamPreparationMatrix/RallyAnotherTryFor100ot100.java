package ExamPreparationMatrix;

import java.util.Scanner;

public class RallyAnotherTryFor100ot100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());
        char[][]matrix=new char[n][n];

        String numberCar=scanner.nextLine();

        int tunnelOneRow=0;
        int tunnelOneCol=0;

        int secondTubelRow=0;
        int secondTunelCol=0;

        boolean isCarGoToTheFinish=false;
        boolean isFirstTunelFound=false;

        int currentRow=0;
        int currentCol=0;
        int killometresPassed=0;

        for(int row=0 ;row<n ;row++){
            matrix[row]=scanner.nextLine().replaceAll(" ","").toCharArray();
        }

        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<n ;col++){
                char currentTunnel=matrix[row][col];
                if(currentTunnel=='T'&& !isFirstTunelFound){
                    tunnelOneRow=row;
                    tunnelOneCol=col;
                    isFirstTunelFound=true;
                }else if(currentTunnel=='T'&&isFirstTunelFound){
                    secondTubelRow=row;
                    secondTunelCol=col;
                }
            }
        }
        String command=scanner.nextLine();
        while (!command.equals("End")){
            matrix[currentRow][currentCol]='.';
            switch (command){
                case "left":
                    if(currentCol!=0){
                        currentCol--;
                    }
                    break;
                case "right":
                    if(currentCol!=n-1){
                        currentCol++;
                    }
                    break;
                case "down":
                    if(currentRow!=n-1){
                        currentRow++;
                    }
                    break;
                case "up":
                    if(currentRow!=0){
                        currentRow--;
                    }
                    break;
            }
//            if(currentRow<0 || currentCol<0 || currentRow>=n || currentCol>=n){
//                break;
//            }


            if(matrix[currentRow][currentCol]=='F'){
                killometresPassed=killometresPassed+10;
                System.out.printf("Racing car %s finished the stage!%n",numberCar);
                matrix[currentRow][currentCol]='C';
                isCarGoToTheFinish=true;
                break;
            }else if(currentRow==tunnelOneRow && currentCol==tunnelOneCol){
                matrix[currentRow][currentCol]='.';
                currentRow=secondTubelRow;
                currentCol=secondTunelCol;
                killometresPassed=killometresPassed+30;
                matrix[currentRow][currentCol]='.';
            }else if(currentRow==secondTubelRow && currentCol==secondTunelCol){
                matrix[currentRow][currentCol]='.';
                currentRow=tunnelOneRow;
                currentCol=tunnelOneCol;
                killometresPassed=killometresPassed+30;
                matrix[currentRow][currentCol]='.';
            }else if(matrix[currentRow][currentCol]=='.'){
                killometresPassed=killometresPassed+10;
                matrix[currentRow][currentCol]='C';
                command=scanner.nextLine();
                continue;
            }

//            if(matrix[currentRow][currentCol]=='T'){
//                killometresPassed=killometresPassed+30;
//                matrix[currentRow][currentCol]='.';
//                currentRow=secondTubelRow;
//                currentCol=secondTunelCol;
//                matrix[currentRow][currentCol]='.';
//            }

//            matrix[currentRow][currentCol]='C';
            command=scanner.nextLine();
        }

        if(!isCarGoToTheFinish){
            System.out.printf("Racing car %s DNF.%n",numberCar);
        }
        System.out.printf("Distance covered %d km.%n",killometresPassed);

        for(int row=0 ;row<n ;row++){
            for(int col=0 ;col<n ;col++){
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
