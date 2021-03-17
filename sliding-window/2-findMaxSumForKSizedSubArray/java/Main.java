//Problem Statement : Given an array of positive numbers and a positive number ‘k’,
// find the maximum sum of any contiguous subarray of size ‘k’.

public class Main {

    public static void main(String[] args) {
        int maxSubArraySum = findMaxSumSubArray(3, new int[]{2,1,5,1,3,2});
        System.out.print(maxSubArraySum);
    }

    public static int findMaxSumSubArray(int k, int[] arr){
        int maxSubArraySum = 0;
        int windowStart = 0;
        int windowSum = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            if(windowEnd > k - 1){
                if(windowSum > maxSubArraySum)
                    maxSubArraySum = windowSum;
                windowSum -= arr[windowStart];
                windowStart++;
            }
            windowSum += arr[windowEnd];
        }
        return maxSubArraySum;
    }
}