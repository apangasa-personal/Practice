package leetCode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = nums1.length - 1;
        while(i >=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
                k--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
        while(i >= 0){
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        System.out.println("done");
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int size = m + n - 1;
        int i = m-1;
        int j = n-1;
        while (size >= 0) {
            if (j >= 0 && i >= 0) {
                if (nums1[i] > nums2[j]) { // check largest value and add it last index of arr1
                    nums1[size--] = nums1[i--];
                } else {
                    nums1[size--] = nums2[j--];
                }
            } else if (i >= 0){ // arr2 is completed now fill values from arr1
                nums1[size--] = nums1[i--];
            } else { // arr1 is completed now fill values from arr2
                nums1[size--] = nums2[j--];
            }
        }
    }
    public static void main(String[] rags){
        int[] nums1= {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, nums2.length);
    }
}
