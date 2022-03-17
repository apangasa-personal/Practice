package leetCode;

import java.util.HashMap;

public class FourSum {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> sum1 = new HashMap<>();
        for(int i = 0; i< nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int s = nums1[i] + nums2[j];
                sum1.put(s, sum1.getOrDefault(s, 0) + 1);
            }
        }
        HashMap<Integer, Integer> sum2 = new HashMap<>();
        for(int i = 0; i< nums3.length; i++){
            for(int j = 0; j < nums4.length; j++){
                int s = nums3[i] + nums4[j];
                sum2.put(s, sum2.getOrDefault(s, 0) + 1);
            }
        }
        int result = 0;
        for(Integer key: sum1.keySet()){
            if(sum2.containsKey( key * (-1))){
                result += sum1.get(key) * sum2.get(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
