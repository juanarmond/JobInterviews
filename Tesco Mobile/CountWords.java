import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountWords {

    public static void main(String args[]){
        HashMap<String, Integer> words = new HashMap<>();
        String fileName = "data/mobydick.txt";

        try {
            Scanner s = new Scanner(new File(fileName));
            while (s.hasNextLine()) {
                //Get each line from the file and replace -- to " "
                Scanner line = new Scanner(s.nextLine().replaceAll("[--]"," ").toLowerCase());

                while(line.hasNext()){
                    //Get each word from the line and replace any non word character to ""
                    String word = line.next().replaceAll("\\W","");
                    words.put(word, words.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error accessing input file!");
        }

        //Sort by Decrease Value
        LinkedHashMap<String, Integer> wordsSortedByFrequency = new LinkedHashMap<>();
        words.entrySet().stream().sorted(HashMap.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> wordsSortedByFrequency.put(x.getKey(), x.getValue()));

        //Print the 20 most frequently used words
        int count = 0;
        for(String w : wordsSortedByFrequency.keySet()){
            if(count != 20){
                System.out.println(wordsSortedByFrequency.get(w)+ " " + w );
                count++;
            }else{
                break;
            }
        }

        //Total Size of unique words
        //System.out.println(words.size());
    }
}
