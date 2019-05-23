// Write a function that accepts a string and returns the second highest numerical digit in the input as an integer.

// The following rules should apply:

// Inputs with no numerical digits should return -1
// Inputs with only one numerical digit should return -1
// Non-numeric characters should be ignored
// Each numerical input should be treated individually, meaning in the event of a joint highest digit then the second highest digit will also be the highest digit
// For example:

// "abc:1231234" returns 3
// "123123" returns 3

public class Solution {
    public static int secondHighestDigit(String input) {
        // Your code goes here
        int highest = 0;
        int secHighest = 0;
        for(char c : input.toCharArray()){
            try{
                if(Integer.parseInt(String.valueOf(c)) >= highest){
                    if (highest>=secHighest){
                        secHighest = highest;
                    }
                    highest = Integer.parseInt(String.valueOf(c));
                }
            }catch (NumberFormatException nfe){
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }
        return secHighest;
    }
}

import org.junit.*;
import static org.junit.Assert.*;

public class Tests
{
    
    @Test
    public void test1()
    {
        Solution solution = new Solution();

        assertEquals(3, solution.secondHighestDigit("abc:1231234"));
    }

    @Test
    public void test2()
    {
        Solution solution = new Solution();

        assertEquals(3, solution.secondHighestDigit("123123"));
    }
}