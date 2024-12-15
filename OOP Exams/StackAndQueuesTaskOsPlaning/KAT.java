package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlates = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carsNumber = new ArrayDeque<>();//Stack
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(carsNumber::push);

        int countRegistratedCars = 0;
        int countInstallacionDays = 0;

        while (!licensePlates.isEmpty() && !carsNumber.isEmpty()) {
            countInstallacionDays++;
            int currentNumberOfPlate = 0;
            for (int i = 0; i < 1; i++) {
                currentNumberOfPlate = licensePlates.poll();
            }
            int currentNumbersOfCars = 0;
            for (int i = 0; i < 1; i++) {
                currentNumbersOfCars = carsNumber.pop();
            }

            if (currentNumberOfPlate > (currentNumbersOfCars * 2)) {
                licensePlates.addLast(currentNumberOfPlate - (currentNumbersOfCars * 2));
                countRegistratedCars = countRegistratedCars + currentNumbersOfCars;
            } else if (currentNumberOfPlate < (currentNumbersOfCars * 2)) {
                int leftCars = currentNumbersOfCars - (currentNumberOfPlate / 2);
                carsNumber.addLast(leftCars);

//                countRegistratedCars=countRegistratedCars+(currentNumberOfPlate/2);
            } else {
                countRegistratedCars = countRegistratedCars + currentNumbersOfCars;
            }
        }

        System.out.printf("%d cars were registered for %d days!%n”",countRegistratedCars,countInstallacionDays);
        //•	If there are any remaining license plates:
        //o	“{count of plates} license plates remain

        if(!licensePlates.isEmpty()){
            System.out.printf("%d license plates remain!");
        }

    }
}
