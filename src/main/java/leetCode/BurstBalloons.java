package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BurstBalloons {
    static long result = 0;
    public static long maxCoins(int[] nums) {
        if(nums.length == 0)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length; i++)
            list.add(nums[i]);
        int smallest = nums[0], smallestIndex = 0;
        if(nums.length > 2){
            smallest = nums[1];
            smallestIndex = 1;
        }
        for(int i = 1; i< nums.length-1; i++) {
            if(smallest > nums[i]) {
                smallest = Math.min(smallest, nums[i]);
                smallestIndex = i;
            }
        }
        int prev = 1, next = 1;
        if(smallestIndex != 0 ){
            prev = nums[smallestIndex - 1];
        }
        if(smallestIndex < nums.length-1)
            next = nums[smallestIndex + 1];
        result = result + (long)smallest * prev * next;
        list.remove(smallestIndex);
        maxCoins(list.stream().mapToInt(i-> (int) i).toArray());
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9,76,64,21,97,60};
        System.out.println(maxCoins(nums));
    }
}
