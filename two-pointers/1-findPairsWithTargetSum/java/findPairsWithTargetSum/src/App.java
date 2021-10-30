public class App {
    public static void main(String[] args) throws Exception {
        
        int[] output1 = searchPair(new int[] { 1,2,3,4,6 }, 10);
        printPair(output1);

        int[] output2 = searchPair(new int[] { 1,2,3,4,6 }, 11);
        printPair(output2);
    }

    private static void printPair(int[] pair){
        System.out.println("Pair: { " + pair[0] + ", " + pair[1] + " }");
    }

    private static int[] searchPair(int[] arr, int targetSum){
        int left = 0, right = arr.length - 1;

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum == targetSum)
                return new int[] { left, right };
            else if(sum > targetSum)
                right--;
            else
                left++;
            
        }

        return new int[] { -1, -1 };
    }
}
