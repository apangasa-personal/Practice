package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortbyColor {
    public static void sortColors(ArrayList<Integer> a) {
        int[] nums = a.stream().mapToInt(Integer :: intValue).toArray();
        int mid = 0, start = 0, end = a.size() - 1;
        //0 ,1 ,2 ,0 ,1 ,2
        while (mid <= end){
            if(nums[mid] == 0){
                int p = nums[mid];
                nums[mid] = nums[start];
                nums[start] = p;
                mid++;
                start++;
            }
            else if(nums[mid] == 2){
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            }
            else
                mid++;
        }
        a.clear();
        for(int i = 0; i< nums.length; i++)
            a.add(nums[i]);
        System.out.println("done");
    }

    public static void main(String[] args) {
        Integer[] values = {2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2, 1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2, 0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2};
        ArrayList<Integer> listOfInts = new ArrayList<>(values.length);
        for(int i: values){
            listOfInts.add(i);
        }
        sortColors((ArrayList<Integer>) listOfInts);
    }
}
