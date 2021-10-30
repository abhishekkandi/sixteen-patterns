public class App {
    public static void main(String[] args) throws Exception {
        int[] input = new int[] { -10,-1,0,2,3 };
        int[] squares = makeSquares(input);

        for (int num : squares) 
            System.out.print(num + " ");
        
        System.out.println();
    }

    public static int[] makeSquares(int [] arr){
        int n = arr.length;
        int highestSquaredIndex = n-1;
        int[] squares = new int[n];
        int left = 0, right = highestSquaredIndex;

        while(left <= right){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if(leftSquare > rightSquare){
                squares[highestSquaredIndex--] = leftSquare;
                left++;
            } else {
                squares[highestSquaredIndex--] = rightSquare;
                right--;
            }
        }

        return squares;
    }
}
