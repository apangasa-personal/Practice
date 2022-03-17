package leetCode;

import java.util.HashMap;

public class ContinuousArray {
    public static int findMaxLength(int[] nums) {
        for(int i = 0; i< nums.length ; i++){
            if(nums[i] == 0)
                nums[i] = -1;
        }
        HashMap<Integer, Integer> values = new HashMap<>();
        values.put(0, -1);
        int result = 0;
        for(int i = 1; i< nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int start = 0, end = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(values.containsKey(nums[i])){
                result = Math.max(result, i - values.get(nums[i]) );
            }
            if(!values.containsKey(nums[i]))
                values.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {0,1};
        System.out.println(findMaxLength(A));
    }
}
