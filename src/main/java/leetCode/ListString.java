package leetCode;

import java.util.ArrayList;
import java.util.List;

public class ListString {

    public static List<String> summaryRanges(int[] nums) {
        int s = 0;
        List<String> r = new ArrayList<String>();
        for(int i = 1; i< nums.length; i++){
            if(nums[i] == nums[i-1] + 1)
                continue;
            else{
                if(s == i-1){
                    r.add(nums[s] + "");
                }
                else{
                    r.add(nums[s] + "->" + nums[i-1]);
                }
                s = i;
            }
        }
        if(nums[s] == nums[nums.length-1]){
            r.add(nums[s] + "");
        }
                else{
            r.add(nums[s] + "->" + nums[nums.length-1]);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] A= {0,2,3,4,6,8,9};
        summaryRanges(A);
    }
}
