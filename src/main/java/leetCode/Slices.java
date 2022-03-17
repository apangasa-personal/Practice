package leetCode;

import java.util.Arrays;

public class Slices {

    public static int numberOfArithmeticSlices(int[] nums) {
        Arrays.sort(nums);
        int dif = 0;
        if(nums.length < 3)
            return 0;
        int count = 0, result = 0;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
                count++;
            else
                count = 0;
            result = result + count;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a= {1,2,3,4};
        System.out.println(numberOfArithmeticSlices(a));
    }
}
