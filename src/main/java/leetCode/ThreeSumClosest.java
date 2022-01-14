package leetCode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for(int i = 0; i< nums.length - 1; i++){
            int p1 = i+1;
            int p2 = nums.length - 1;
            while(p1 < p2){
                int sum = nums[i] + nums[p1] + nums[p2];
                if(result == Integer.MAX_VALUE)
                    result = sum;
                if(Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if(sum > target)
                    p2--;
                else p1++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        int target = -1;
        System.out.println(threeSumClosest(nums, target));
    }
}
