package leetCode;
import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = 1;
        for(;i< nums.length - 1; i++){
            for(j=i+1;j< nums.length; j++){
                if(nums[i] + nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return null;
    }

    public static void  main(String[] rgs){
        int[] a = {3,2,4};
        System.out.println(Arrays.toString(twoSum(a,6)));
    }
}
