package leetCode;

import java.util.HashMap;

public class Keys {
    public static int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        int count = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        for(int i = 0; i< nums.length; i++){
            map.put(nums[i], Math.max( map.get(nums[i]) - 1, 0));
            if(nums[i] == key && i < nums.length - 1){
                i++;
                if(result == Integer.MIN_VALUE) {
                    result = nums[i];
                    count = map.get(nums[i]);
                }
                else{
                    if(map.get(nums[i]) > count) {
                        result = nums[i];
                        count = map.get(nums[i]);
                    }
                }

                map.put(nums[i], Math.max( map.get(nums[i]) - 1, 0));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] v = {2,1,2,1,2,3}; int key = 2;
        System.out.println(mostFrequent(v, key));

    }
}
