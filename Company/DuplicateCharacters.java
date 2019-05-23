// Write a function that accepts a string and returns an integer value representing the number of distinct duplicated characters within the string, i.e. the number of characters that appear twice or more.

// Your solution should be able to deal with all alphanumeric and special characters. Your solution should also also treat upper and lower case characters as distinct characters.

// For example:

// Given "Aasdefsgh!!!" the expected result would be '2' ('s' and '!' are duplicated)

import java.util.HashMap;
public class Solution {
    public static int duplicateCharacters(String input) {
        // Your code goes here
        HashMap<Character, Integer> characters = new HashMap<>();
        int count = 0;
        for(char c : input.toCharArray()){
            characters.put(c, characters.getOrDefault(c, 0)+1);
            if(characters.get(c) > count){
                count = characters.get(c);
            }
        }
        return count;
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

        assertEquals(2, solution.duplicateCharacters("Aasdefsgh!!"));
    }
}