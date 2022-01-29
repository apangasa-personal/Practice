package leetCode;

import java.util.HashSet;

public class MaximumXORofTwoNumbersinanArray {
    public static int findMaximumXOR(int[] nums) {
        int maxx = 0, mask = 0;
        HashSet<Integer> se = new HashSet<Integer>();
        for (int i = 5; i >= 0; i--){
            mask |= (1 << i);
            for (int j = 0; j < nums.length; ++j){
                se.add(nums[j] & mask);
            }
            int newMaxx = maxx | (1 << i);
            for (int prefix : se){
                if (se.contains(newMaxx ^ prefix)){
                    maxx = newMaxx;
                    break;
                }
            }
            se.clear();
        }
        return maxx;
    }

    public static void main(String[] args) {
        int[] A = {3,10,5,25,2,8};
        System.out.println(findMaximumXOR(A));
    }
}
