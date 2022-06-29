package scaler.DSA;

public class ChocolateDistribution {

    public static void merge(int[] nums, int start, int mid, int end){
        int[] result = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i<=mid && j<=end){
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
        while (i<=mid){
            result[k] = nums[i];
            i++;
            k++;
        }
        while (j<=end){
            result[k] = nums[j];
            j++;
            k++;
        }
        for(i = 0; i<result.length; i++, start++)
            nums[start] = result[i];
    }

    public static void mergeSort(int[] nums, int start, int end){
        if(start == end)
            return;
        mergeSort(nums, start, (start + end)/2);
        mergeSort(nums, (start + end)/2 + 1, end);
        merge(nums, start, (start + end)/2, end);
    }

    public static int solve(int[] A, int B) {
        mergeSort(A, 0, A.length - 1);
        int result = Integer.MAX_VALUE;
        for(int i = B-1; i<A.length; i++)
            result = Math.min(result, A[i] - A[i-B+1]);
        return result;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(solve(A, 5));
    }
}
