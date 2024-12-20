package StackAndQueuesTaskOsPlaning;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FoodFingerAlone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        ArrayDeque<Character> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> vowels.offer(e.charAt(0)));

        ArrayDeque<Character> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> consonants.offer(e.charAt(0)));

        while (!consonants.isEmpty()){
           char currentVowel=vowels.poll();//e
           char cureentConsonat=consonants.pop();//f

            for(int i=0 ;i<words.length ;i++){
                String word = words[i];
                int indexVowel = word.indexOf(currentVowel);
                int indexConsonant = word.indexOf(cureentConsonat);
                if(indexVowel>=0){
                    foundWords[i]=foundWords[i].substring(0,indexVowel)+ currentVowel + foundWords[i].substring(indexVowel + 1);
                }
                if(indexConsonant>=0){
                    foundWords[i]=foundWords[i].substring(0,indexConsonant) + cureentConsonat + foundWords[i].substring(indexConsonant + 1);
                }
            }
            vowels.offer(currentVowel);
        }

        List<String> output = Arrays.stream(foundWords).filter(w -> !w.contains("*")).collect(Collectors.toList());

        System.out.printf("Words found: %d%n", output.size());
        output.forEach(System.out::println);
    }
}
