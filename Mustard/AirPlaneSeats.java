//Free 3 seats together

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N, String S) {
        // write your code in Java SE 8
        
        // All seats are free
        if(S.equals("")){
            return N*3;
        }
        
        //Array of seats split by space
        String seats[] = S.split(" ");
        List<String> reserved = new ArrayList<>();
        int maxSeats = N*3;
        reserved = Arrays.asList(seats);
        
        //Deduct one seat if ther are reserved
        for(int i = 1; i<= N ; i++) {
                if(reserved.contains(i+"A") && !reserved.contains(i+"B") && reserved.contains(i+"C")) {
                    maxSeats--;
                }
                if((reserved.contains(i+"E") || reserved.contains(i+"F"))) {
                    maxSeats--;
                }
                if(reserved.contains(i+"H") && !reserved.contains(i+"J") && reserved.contains(i+"K")) {
                    maxSeats--;
                }
        }
        return maxSeats;
    }
}