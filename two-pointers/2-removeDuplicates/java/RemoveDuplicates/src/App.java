public class App {
    public static void main(String[] args) throws Exception {
        int length = remove(new int[]{ 2,3,3,3,6,9,9  });
        System.out.println("Length of new array with no duplicates: " + length);
    }

    public static int remove(int[] arr){
        int nextNonDuplicate = 1;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[nextNonDuplicate - 1]){
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }
}
