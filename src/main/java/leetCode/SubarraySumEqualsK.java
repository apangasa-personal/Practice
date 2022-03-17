package leetCode;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        if(nums.length == 0)
            return 0;
        for(int i = 0; i< nums.length; i++){
            if(i != 0)
                nums[i] += nums[i-1];
            if(nums[i] == k)
                count++;

            if(sumMap.containsKey(nums[i] - k))
                count = count + sumMap.get(nums[i] - k);

            sumMap.put(nums[i], sumMap.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
