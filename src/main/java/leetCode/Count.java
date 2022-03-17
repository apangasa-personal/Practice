package leetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Count {

    public static int countPairs(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> values = new HashMap<>();
        int result = 0;
        for(int i = 0; i< nums.length; i++){
            if(values.containsKey(nums[i])){
                ArrayList<Integer> list = values.get(nums[i]);
                for(int j = 0; j <list.size(); j++ ){
                    if((i * list.get(j))%k == 0)
                        result++;
                }
                list.add(i);
                values.put(nums[i], list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                values.put(nums[i], list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {5,5,9,2,5,5,9,2,2,5,5,6,2,2,5,2,5,4,3};
        System.out.println(countPairs(A, 7));
    }
}
