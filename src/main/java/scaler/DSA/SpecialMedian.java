package scaler.DSA;

import java.util.*;

public class SpecialMedian {

    public static int solve(int[] A) {
        if(solveCore(A) == 1)
            return 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = A.length -1 ; i >= 0; i--)
            list.add(A[i]);
        if(solveCore(list.stream().mapToInt(Integer::intValue).toArray()) == 1)
            return 1;
        return 0;
    }

    public static int solveCore(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < A.length; i++){
            if(maxHeap.size() == 0) {
                maxHeap.offer(A[i]);
                continue;
            }

            if(maxHeap.size() == minHeap.size()) {
                if ((double)A[i] == (double)(maxHeap.peek() + minHeap.peek())/2)
                    return 1;
            }
            else if(A[i] == maxHeap.peek())
                return 1;

            if(minHeap.size() == maxHeap.size()) {
                if(A[i] < maxHeap.peek())
                    maxHeap.offer(A[i]);
                else{
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(A[i]);
                }
            }
            else {
                if(A[i] < maxHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(A[i]);
                }
                else
                    minHeap.offer(A[i]);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] A = {2147483647, -2147483648, 0};
        solve(A);
    }
}
