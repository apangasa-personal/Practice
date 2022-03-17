package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Mapping {

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        String[] values = new String[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< mapping.length; i++){
            map.put(mapping[i], i);
        }
        for(int i = 0; i< nums.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < String.valueOf(nums[i]).length(); j++){
                sb.append(mapping[(nums[i] + "").charAt(j) - '0']);
            }
            values[i] = sb.toString();
        }
        Arrays.sort(values, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
            }
        });
        for(int i = 0; i< values.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <values[i].length(); j++){
                char ch = values[i].charAt(j);
                sb.append(map.get(ch - '0'));
            }
            nums[i] = Integer.valueOf(sb.toString());
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] mapping = {8,9,4,0,2,1,3,5,7,6}, nums = {991,338,38};
        nums = sortJumbled(mapping, nums);
    }
}
