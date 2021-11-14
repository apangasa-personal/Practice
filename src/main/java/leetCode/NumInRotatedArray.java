package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class NumInRotatedArray {
    public static int search(int[] A, int target) {
        int start = 0, end = A.length-1 ;
        int mid;
        while(start <= end){
            mid = (start + end)/2;
            if (A[start] <= A[mid]) {
                if (target >= A[start] && target <= A[mid])
                    end = mid-1;
                else
                    start = mid +1;
            }

            if (target >= A[mid] && target <= A[end])
               start = mid + 1;
        }
        return -1;
    }

    static int search1(int[] arr, int l, int h, int key)
    {
        if (l > h)
            return -1;
        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
        if (arr[l] <= arr[mid]) {
            if (key >= arr[l] && key <= arr[mid])
                return search1(arr, l, mid - 1, key);
            return search1(arr, mid + 1, h, key);
        }
        if (key >= arr[mid] && key <= arr[h])
            return search1(arr, mid + 1, h, key);
        return search1(arr, l, mid - 1, key);
    }

    public static void main(String[] args){
        int[] nums = {3,1};
        System.out.println(search(nums, 1));
        System.out.println(search1(nums,0,nums.length - 1, 1));
    }
}
