//Problem Statement : Given a string, find the length of the longest substring in it with no more than K distinct characters.

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int result1 = findLengthOfLongestSubstringWithKDistinctCharacters("abhishek", 3);//Expected output: 4(hish)
        System.out.println(Integer.toString(result1));
        int result2 = findLengthOfLongestSubstringWithKDistinctCharacters("araaci", 2);//Expected output: 4(araa)
        System.out.println(Integer.toString(result2));
    }

    public static int findLengthOfLongestSubstringWithKDistinctCharacters(String str, int k){
        if(str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();

        int longestSubstring = 0, windowStart = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<Character, Integer>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightMostCharacter = str.charAt(windowEnd);//right most character in window
            charFrequencyMap.put(rightMostCharacter, charFrequencyMap.getOrDefault(rightMostCharacter, 0) + 1);
            while (charFrequencyMap.size() > k){
                char leftMostCharacter = str.charAt(windowStart);
                charFrequencyMap.put(leftMostCharacter, charFrequencyMap.getOrDefault(leftMostCharacter,0) - 1);
                if(charFrequencyMap.get(leftMostCharacter) == 0){
                    charFrequencyMap.remove(leftMostCharacter);
                }
                windowStart++;//shrinking the window
            }
            longestSubstring = Math.max(longestSubstring, ((windowEnd - windowStart) + 1));
        }

        return longestSubstring;
    }
}

//Input: String="araaci", K=2
//Output: 4
//Explanation: The longest substring with no more than '2' distinct characters is "araa".

//Input: String="araaci", K=1
//        Output: 2
//        Explanation: The longest substring with no more than '1' distinct characters is "aa".