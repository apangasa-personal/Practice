package leetCode;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int start = 0, end = nums.length -1;
        while (start <= end){
            int mid = (start + end)/2;
            if(nums[mid] > target)
                end = mid - 1;
            else if(nums[mid] < target)
                start = mid + 1;
            else{
                res[0] = mid;
                res[1] = mid;
                int newmid = 0;
                int newEnd = mid-1;
                int newStart = start;
                while (newStart <= newEnd) {
                    newmid = (newStart + newEnd)/2;
                    if(nums[newmid] < target)
                        newStart = newmid  + 1;
                    else
                        newEnd = newmid - 1;
                }
                res[0] = newEnd + 1;
                newStart = mid + 1;
                newEnd = end;
                while (newStart <= newEnd){
                    newmid = (newStart + newEnd)/2;
                    if(nums[newmid] > target)
                        newEnd = newmid - 1;
                    else
                        newStart = newmid + 1;
                }
                res[1] = newEnd;
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(A,target)));
    }
}
