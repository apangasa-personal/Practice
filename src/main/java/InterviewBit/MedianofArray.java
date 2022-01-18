package InterviewBit;

import java.util.Arrays;
import java.util.List;

public class MedianofArray {
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int[] nums1 = a.stream().mapToInt(Integer :: intValue).toArray();
        int[] nums2 = b.stream().mapToInt(Integer :: intValue).toArray();

        if (nums1.length > nums2.length) {
           nums1 = b.stream().mapToInt(Integer :: intValue).toArray();;
           nums2 = a.stream().mapToInt(Integer :: intValue).toArray();
        }
        int m = nums1.length;
        int n = nums2.length;
        int start = 0;
        int end = m;
        while (start <= end) {
            int partitionNums1 = (start + end) / 2;
            int partitionNums2 = (m + n + 1) / 2 - partitionNums1;
            int maxLeftNums1 = partitionNums1 == 0 ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
            int minRightNums1 = partitionNums1 == m ? Integer.MAX_VALUE : nums1[partitionNums1];
            int maxLeftNums2 = partitionNums2 == 0 ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];
            int minRightNums2 = partitionNums2 == n ? Integer.MAX_VALUE : nums2[partitionNums2];
            if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2.0;
                } else {
                    return Math.max(maxLeftNums1, maxLeftNums2);
                }
            }
            else if (maxLeftNums1 > minRightNums2) {
                end = partitionNums1 - 1;
            }
            else {
                start = partitionNums1 + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Integer[] A = {1 ,4 ,5} , B = {2, 3};
        System.out.println(findMedianSortedArrays(Arrays.asList(A), Arrays.asList(B)));

    }
}
