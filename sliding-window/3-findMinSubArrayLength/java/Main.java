//Problem Statement #
//Given an array of positive numbers and a positive number ‘S’,
// find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
// Return 0, if no such subarray exists.

public class Main {

    public static void main(String[] args) {
        int minSubArrayLength = findMinSubArrayLength(new int[]{3, 4, 1, 1, 6}, 8);
        System.out.print(minSubArrayLength);
    }

    public static int findMinSubArrayLength(int[] arr, int size){
        int minSubArrayLength = Integer.MAX_VALUE;
        int windowSum = 0, windowStart = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];
            while(windowSum >= size){
                int currentWindowLength = (windowEnd - windowStart) + 1;
                minSubArrayLength = Math.min(currentWindowLength, minSubArrayLength);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minSubArrayLength;
    }

    //Initial Implmentation
    // public static int findMinSubArrayLength(int[] arr, int size){
    //     int minSubArrayLength = 0;
    //     int windowSum = 0, windowStart = 0;
    //     for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
    //         windowSum += arr[windowEnd];
    //         if(windowSum > size){
    //             int currentWindowLength = (windowEnd - windowStart) + 1;
    //             if(minSubArrayLength == 0)
    //                 minSubArrayLength = currentWindowLength;
    //             else if(currentWindowLength < minSubArrayLength)
    //                 minSubArrayLength = currentWindowLength;
                
    //             while(windowSum >= size){
    //                 windowSum -= arr[windowStart];
    //                 windowStart++;
    //                 int shrinkedWindowLength = (windowEnd - windowStart) + 1;
    //                 if(windowSum >= size && shrinkedWindowLength < minSubArrayLength)
    //                     minSubArrayLength = shrinkedWindowLength;
    //             }
    //         }
    //     }
    //     return minSubArrayLength;
    // }
}
