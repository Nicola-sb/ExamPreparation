package StackAndQueuesTaskOsPlaning;

import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        ArrayDeque<Character> ingreditients= Arrays.stream(scanner.nextLine().split(" ")).map(char::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<String>vowels=new ArrayDeque<>();
        String[]intputVowels=scanner.nextLine().split(" ");
        for (String element:intputVowels){
            vowels.offer(element);
        }

        ArrayDeque<String>consonats=new ArrayDeque<>();
        String[]inputConsonants=scanner.nextLine().split(" ");
        for (String element:inputConsonants){
            consonats.push(element);
        }
//        String wordOne="pear";
//        String wordTwo="flour";
//        String wordThree="pork";
//        String wordFour="olive";
        List<String> words=new ArrayList<>();
//        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        words.add("pear");
        words.add("flour");
        words.add("pork");
        words.add("olive");

        String firstVowels=vowels.peek();
        String lastConsonats=consonats.peek();
        while (!consonats.isEmpty()){
            String currentVowell=vowels.poll();
          String currentConsonats=consonats.pop();
           for(int i=0 ;i<words.size() ;i++){
               String word=words.get(i);
               if(word.contains(currentVowell)){
                   word.replace(currentVowell,"*");
               }

           }
           vowels.offer(currentVowell);
        }




    }
}
