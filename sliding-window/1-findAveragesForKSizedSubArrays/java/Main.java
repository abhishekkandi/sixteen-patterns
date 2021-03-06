import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    double[] result = findAveragesForKSizedSubArrays(5, new int[] {
	      1,3,2,6,-1,4,1,8,2
        });

	    System.out.print("result: " + Arrays.toString(result));
	    //Output : [2.0, 2.0, 2.0, 3.0, 2.0]
    }

    public static double[] findAveragesForKSizedSubArrays(int K, int[] arr){
        double[] result = new double[arr.length - K + 1];
        int windowStart = 0;//This will be incremented when the window slides by 1
        int windowSum = 0;//This will be storing the current window sum, As the window slides it will deduct the
        //windowStart value and add new windowEnd value
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){//window will slide till end
            windowSum += arr[windowEnd];
            if(windowEnd >= K-1)//Once the windowEnd crosses the K, We will start storing the average of each window
            {
                result[windowStart] = windowSum / K;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return result;
    }
}
