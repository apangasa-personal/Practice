package InterviewBit;

import java.util.*;

public class Subsets {

    public static long getHash(int[] A){
        long val = 0, pow = 1;
        for(int i = 0; i< A.length; i++){
            val += A[i] * pow;
            pow = pow * 100;
        }
        return val;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Long> hashSet = new HashSet<>();
        int total = (int) (Math.pow(2, nums.length) - 1);
        for(int i = 0; i <= total; i++){
            List<Integer> values = new ArrayList<>();
            for(int j = 0; j< 32; j++){
                if(((1 << j) & i) != 0)
                    values.add(nums[j]);
            }
            long v = getHash(values.stream().mapToInt(Integer :: intValue).toArray());
            if(!hashSet.contains(v))
                result.add(values);
            if(values.size() != 0)
                hashSet.add(v);
        }
        return result;
    }

    public static List<Integer> toList(int[] a){
        List<Integer> v = new ArrayList<>();
        for(int i = 0; i< a.length; i++)
            v.add(a[i]);
        return v;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        subsets(nums);
    }
}
