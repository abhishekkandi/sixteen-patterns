public class App {
    public static void main(String[] args) throws Exception {
        int[] output = sortArray(new int[] { 0,2,1,0,1,2 });
        for(int num : output){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static int[] sortArray(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        //mid will iterate through entire array
        //low pointer will be incremented only when mid is encounter with 0 
        //high pointer will be decremented whenever mid encounters a two

        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, mid, low);
                mid++;
                low++;
            } else if(arr[mid] == 1){
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }

        return arr;

    }

    private static int[] swap(int[] arr, int index1, int index2){
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
        return arr;
    }
    
}
