package scaler.DSA;

import java.util.Arrays;

public class RotateArray {
    public static int[] rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int count = 0;
        for(int i = result.length - k; i< result.length ; i++) {
            result[count] = nums[i];
            count++;
        }
        for(int i = 0; i< result.length - k ; i++) {
            result[count] = nums[i];
            count++;
        }
        return result;
    }

    public static void main(String[] argas){
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println(Arrays.toString(rotate(arr, k)));
    }
}
