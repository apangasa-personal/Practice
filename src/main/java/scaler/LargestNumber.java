package scaler;

import java.util.Arrays;

public class LargestNumber {
    public static void merge(int[] nums, int start, int mid, int end){
        int[] result = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i<= mid && j <= end){
            String val1 = String.valueOf(nums[i]) + nums[j];
            String val2 = String.valueOf(nums[j]) + nums[i];
            if(Long.valueOf(val1) > Long.valueOf(val2)){
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

    public static String sortArray(int[] A) {
        int[] nums = new int[A.length];
        for(int i=0; i<A.length; i++)
            nums[i] = A[i];
        sortArray(nums, 0, nums.length - 1);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i< nums.length; i++)
            if(nums[i] != 0)
                result.append(nums[i]);
        if(result.length() == 0)
            return "0";
        return result.toString();
    }

    public static void main(String[] rag){
        int[] A = {3, 30, 34, 5, 9};
        System.out.println(sortArray(A));
    }
}
