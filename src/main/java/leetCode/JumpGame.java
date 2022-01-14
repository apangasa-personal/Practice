package leetCode;

public class JumpGame {
    public static boolean canJump(int[] nums) {
       int largestReachable = 0;
       for(int i = 0; i< nums.length; i++){
           if(largestReachable <= i && nums[i] == 0)
               return false;
           largestReachable = Math.max(i + nums[i], largestReachable);
           if(largestReachable >= nums.length - 1)
               return true;
       }
       return false;
    }

    public static void main(String[] args){
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
//        int[] nums = {0,2,3};
        System.out.println(canJump(nums));
    }
}
