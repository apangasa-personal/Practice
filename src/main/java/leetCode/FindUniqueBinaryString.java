package leetCode;

import java.util.HashSet;

public class FindUniqueBinaryString {
    public static int convertToInt(String s){
        int num = 0;
        for(int i = 0; i<s.length(); i++) {
            num = num << 1;
            if(s.charAt(i) == '1')
                num++;
        }
        return num;
    }

    public static String convertToString(int s){
        StringBuilder num = new StringBuilder();
        if(s == 0)
            return "0";
        while (s > 0) {
            int r = (s & 1) == 1 ? 1:0;
            s = s/2;
            num.insert(0, r);
        }
        return num.toString();
    }
    public static String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> values = new HashSet<>();
        int max = 0;

        for(int i =0; i< nums.length; i++){
            int v = convertToInt(nums[i]);
            max = Math.max(max, v);
            values.add(v);
        }

        for(int i = 0; i<= max+1; i++){
            if(!values.contains(i)) {
                String newVal = convertToString(i);
                int diff = nums[0].length() - newVal.length();
                StringBuilder prefix = new StringBuilder();
                while (diff > 0) {
                    prefix.append('0');
                    diff--;
                }
                return prefix.toString() + newVal;
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        String[] nums = {"00","01"};
        System.out.println(findDifferentBinaryString(nums));
    }
}
