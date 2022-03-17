package leetCode;

import java.util.Arrays;

public class MinimumDeviation {
    public static int minimumDeviation(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1], min = nums[0];
        for(int i = nums.length - 1; i>= 0; i--){
            while (nums[i] > min && nums[i]%2 == 0){
                nums[i] /= 2;
                max = Math.min(max, nums[i-1]);
            }
            while (nums[i] < max && nums[i] %2 == 1){
                nums[i] *= 2;
                min = Math.min(min, nums[i]);
            }
        }
        Arrays.sort(nums);
        return nums[nums.length - 1] - nums[0];
    }

    public static void main(String[] args) {
        int[] nums= {1,2,3,4};
        System.out.println(minimumDeviation(nums));

    }
}
