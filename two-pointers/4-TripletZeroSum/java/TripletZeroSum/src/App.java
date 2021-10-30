import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println(App.searchTriplets(new int[] { -5,2,-1,-2,3 }));     
        System.out.println(App.searchTriplets(new int[] { -3,0,1,2,-1,1,1,1,-2 }));  
    }

    public static List<List<Integer>> searchTriplets(int[] arr){
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++){
            if(i > 0 && arr[i] == arr[i-1])//skip same element to avoid duplicate element
                continue;
            searchPair(arr, -arr[i], i+1, triplets);
        }
        return triplets;
    }

    public static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets){
        int right = arr.length - 1;

        while(left < right){
            int currentSum = arr[left] + arr[right];

            if(currentSum == targetSum){
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--; 
                while(left < right && arr[left] == arr[left-1])
                    left++;
                while(left < right && arr[right] == arr[right+1])
                    right--;
            } else if (currentSum > targetSum){
                right--;
            } else {
                left ++;
            }
        }
    }
}
