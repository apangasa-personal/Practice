package leetCode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SubsequenceOfLengthKWithLargestSum {
    private static PriorityQueue<Integer> minHeap;

    public static int[] maxSubsequence(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
        {
            minHeap.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++)
        {
            if (minHeap.peek() > arr[i])
                continue;
            else
            {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        return minHeap.stream().mapToInt(Number::intValue).toArray();
    }

    public static void main(String[] rags){
        int[] A = {27,1,3,3};
        int[] result = maxSubsequence(A, 2);
        System.out.println(String.valueOf(result));
    }

}
