/*
Problem Statement : Given two strings s and t, return the minimum window in s which will contain all the characters in t.
        If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
(Leetcode)
*/

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(minWindowLengthWithTCharacters("ABAACBAB","ABC"));
        System.out.println(minWindowLengthWithTCharacters("ADOBECODEBANC","ABC"));
        System.out.println(minWindowLengthWithTCharacters("a","a"));
    }

    public static String minWindowLengthWithTCharacters(String s, String t) {
        if(s.length() == 0 || t.length() == 0)
            return "";

        int minWindowLength = Integer.MAX_VALUE, windowStart = 0;
        int[] answer = { -1, 0, 0 };//windowLength, startIndex, EndIndex

        Map<Character, Integer> desiredCharacterIntegerMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            desiredCharacterIntegerMap.put(t.charAt(i), desiredCharacterIntegerMap.getOrDefault(t.charAt(i),0) + 1);
        }

        int desiredCharacterCount = desiredCharacterIntegerMap.size();

        Map<Character, Integer> sCharacterMap = new HashMap<>();
        int formedCharacterCount = 0;//With Frequencies
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){

            char rightMostCharacter = s.charAt(windowEnd);
            sCharacterMap.put(rightMostCharacter, sCharacterMap.getOrDefault(rightMostCharacter,0) + 1);

            if(desiredCharacterIntegerMap.containsKey(rightMostCharacter) &&
                    desiredCharacterIntegerMap.get(rightMostCharacter).intValue() == sCharacterMap.get(rightMostCharacter).intValue())
            {
                formedCharacterCount++;
            }

            while (formedCharacterCount == desiredCharacterCount){

                int currentWindowLength = (windowEnd - windowStart) + 1;
                if(answer[0] == -1 || currentWindowLength < answer[0]){
                    answer[0] = currentWindowLength;
                    answer[1] = windowStart;
                    answer[2] = windowEnd;
                }

                char leftMostCharacter = s.charAt(windowStart);
                sCharacterMap.put(leftMostCharacter, sCharacterMap.getOrDefault(leftMostCharacter,0) - 1);

                if(desiredCharacterIntegerMap.containsKey(leftMostCharacter) && sCharacterMap.get(leftMostCharacter) <
                        desiredCharacterIntegerMap.get(leftMostCharacter)){
                    formedCharacterCount--;
                }

                windowStart++;
            }

        }

        return answer[0] != -1 ? s.substring(answer[1],answer[2] + 1) : "";
    }
}

