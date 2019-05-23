import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getPotentialDomains' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY lines as parameter.
     */

    public static String getPotentialDomains(List<String> lines) {
    // Write your code here
        Set<String> potDomains = new TreeSet();
        String regex = "(?:http://|https://){1}(?:www\\.|ww2\\.|web\\.)?([a-z0-9-]+(\\.[a-z0-9-]+)*\\.(?:com|org|edu|in|me|net|tv))\\b";
        Pattern p = Pattern.compile(regex);
        for(String s : lines) {
            Matcher m = p.matcher(s);
            while (m.find())
                potDomains.add(m.group(1));
        }

        String addresses = potDomains.toString().replaceAll("(\\[|\\])", "").replace(", ", ";");

        return addresses;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int linesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> lines = IntStream.range(0, linesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String result = Result.getPotentialDomains(lines);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
