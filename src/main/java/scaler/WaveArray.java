package scaler;

public class WaveArray {
    public static void merge(int[] nums, int start, int mid, int end){
        int[] result = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i<= mid && j <= end){
            if(nums[i] < nums[j]){
                result[k] = nums[i];
                i++;
            }
            else{
                result[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i<= mid){
            result[k] = nums[i];
            i++;
            k++;
        }
        while (j <= end){
            result[k] = nums[j];
            j++;
            k++;
        }
        for(i = 0; i< result.length; i++, start++){
            nums[start] = result[i];
        }
    }

    public static void sortArray(int[] nums, int start, int end) {
        if(start == end)
            return ;
        sortArray(nums, start, (start + end)/2);
        sortArray(nums, (start + end)/2 +1 , end);
        merge(nums, start, (start + end)/2,end);
    }

    public static int[] waveUsingSort(int[] A) {
        sortArray(A, 0, A.length-1);
        for(int i = 1; i<A.length; i = i+2){
            A[i] = A[i] ^ A[i-1];
            A[i-1] = A[i] ^ A[i-1];
            A[i] = A[i] ^ A[i-1];
        }
        return A;
    }

    public static void main(String[] rags){
        int[] A = {5, 1, 3, 2, 4};
        int[] result = waveUsingSort(A);
        System.out.println("done");
    }
}
