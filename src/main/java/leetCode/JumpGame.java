package leetCode;

import java.util.Arrays;

public class JumpGame {
    public static int canJump(int[] nums) {
        int largestReachable = 0;
        int[] jumps = new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        int maxSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j <= i + nums[i] && j < nums.length; j++)
                jumps[j] = Math.min(jumps[j], jumps[i] + 1);
        }
        return jumps[jumps.length - 1];
    }

    public static boolean canJump(int[] nums, int index) {
        int largestReachable = 0;

        for(int i = 0; i < nums.length-1; i++){
            if(largestReachable == i && nums[i] == 0)
                return false;
            if(largestReachable >= nums.length - 1)
                return true;
            largestReachable = Math.max(i, i + nums[i]);
        }
        if(largestReachable >= nums.length - 1)
            return true;
        return false;
    }

    public static void main(String[] args){
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(canJump(nums));
    }
}
