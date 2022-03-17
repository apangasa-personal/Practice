package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    public static int[] solve(int[] A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] result = new int[A.length];
        maxHeap.offer(A[0]);
        result[0] = A[0];
        for(int i = 1; i < A.length; i++){
           if(A[i] > maxHeap.peek())
               minHeap.offer(A[i]);
           else
               maxHeap.offer(A[i]);

           if(minHeap.size() > maxHeap.size())
               maxHeap.offer(minHeap.poll());
           if(maxHeap.size() - minHeap.size() > 1)
               minHeap.offer(maxHeap.poll());
            result[i] = maxHeap.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {59, 64, 10, 39};
        System.out.println(Arrays.toString(solve(A)));
    }

}
