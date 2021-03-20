//Problem Statement : Given a string, find the length of the longest substring which has no repeating characters.

import java.util.HashMap;
        import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int result1 = findMaxSubStringLengthWithNoRepeatingCharacter("aabccbb");
        System.out.println(Integer.toString(result1));

        int result2 = findMaxSubStringLengthWithNoRepeatingCharacter("abbbb");
        System.out.println(Integer.toString(result2));

        int result3 = findMaxSubStringLengthWithNoRepeatingCharacter("abccde");
        System.out.println(Integer.toString(result3));
    }

    public static int findMaxSubStringLengthWithNoRepeatingCharacter(String str){
        if(str == null || str.length() == 0)
            throw new IllegalArgumentException();

        int maxSubStringLength = 0, windowStart = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightMostCharacter = str.charAt(windowEnd);

            if(characterIntegerMap.containsKey(rightMostCharacter)){
                windowStart = Math.max(windowStart, characterIntegerMap.getOrDefault(rightMostCharacter, 0) + 1);//Previous index + 1
            }

            characterIntegerMap.put(rightMostCharacter, windowEnd);
            maxSubStringLength = Math.max(maxSubStringLength, (windowEnd - windowStart) + 1);
        }

        return maxSubStringLength;
    }

    //Initial Approach which was failing in 3rd testcase
    /* public static int findMaxSubStringLengthWithNoRepeatingCharacter(String str){
        if(str == null || str.length() == 0)
            throw new IllegalArgumentException();

        int maxSubStringLength = 0, windowStart = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<Character,Integer>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightMostCharacter = str.charAt(windowEnd);
            characterIntegerMap.put(rightMostCharacter, characterIntegerMap.getOrDefault(rightMostCharacter,0) + 1);

            if(characterIntegerMap.get(rightMostCharacter) > 1) {
                characterIntegerMap.put(rightMostCharacter, characterIntegerMap.getOrDefault(rightMostCharacter,0) - 1);
                windowStart++;
            }

            maxSubStringLength = Math.max(maxSubStringLength, (windowEnd - windowStart) + 1);
        }

        return maxSubStringLength;
    }*/
}