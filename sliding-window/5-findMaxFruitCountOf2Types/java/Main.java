//Problem Statement :Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal
// is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
//
//You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot,
// i.e., you will stop when you have to pick from a third fruit type.
//
//Write a function to return the maximum number of fruits in both the baskets.

//Observation : Here we need to understand that they're referring subarray with max length consisting of K unique characters
//Here K = 2

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int result1 = findMaxFruitCountOf2Types(new char[]{ 'D', 'E', 'L','L' });
        System.out.println(Integer.toString(result1));

        int result2 = findMaxFruitCountOf2Types(new char[] { 'A','B', 'C','A','C', 'C'});
        System.out.println(Integer.toString(result2));
    }

    public static int findMaxFruitCountOf2Types(char[] chars){
        int maxLengthOfSubArray = 0, windowStart = 0;//windowStart - First picked fruit tree's index
        Map<Character, Integer> characterFrequencyMapper = new HashMap<Character, Integer>();//fruitTreeMapper

        for(int windowEnd = 0; windowEnd < chars.length; windowEnd++){

            //Pick first fruit
            char rightMostCharacter = chars[windowEnd];//Or currentFruitTreePicked
            characterFrequencyMapper.put(rightMostCharacter, characterFrequencyMapper.getOrDefault(rightMostCharacter,0) + 1);

            //Check if the Basket already has any 3rd fruit
            while(characterFrequencyMapper.size() > 2) {
                char leftMostCharacter = chars[windowStart];
                characterFrequencyMapper.put(leftMostCharacter, characterFrequencyMapper.getOrDefault(leftMostCharacter,0) - 1);
                if(characterFrequencyMapper.get(leftMostCharacter) == 0){
                    characterFrequencyMapper.remove(leftMostCharacter);
                }
                windowStart++;
            }

            maxLengthOfSubArray = Math.max(maxLengthOfSubArray, (windowEnd - windowStart) + 1);

        }

        return maxLengthOfSubArray;
    }
}

