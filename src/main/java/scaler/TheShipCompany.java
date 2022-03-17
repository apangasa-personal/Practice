package scaler;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TheShipCompany {

    public static class MaxHeap implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            if(a > b)
                return -1;
            if(a == b)
                return 0;
            return 1;
        }
    }

    public static int[] solve(int A, int B, int[] C) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new MaxHeap());
        for(int i = 0; i < C.length; i++){
            minQueue.offer(C[i]);
            maxQueue.offer(C[i]);
        }
        int resultMin = 0, resultMax = 0;
        for(int i = 0; i < A; i++){
            int minElement = minQueue.poll();
            int maxElement = maxQueue.poll();
            resultMin = resultMin + minElement;
            resultMax = resultMax + maxElement;
            if(minElement - 1 > 0)
                minQueue.offer(minElement - 1);
            if(maxElement - 1 > 0)
                maxQueue.offer(maxElement - 1);
        }
        return new int[]{resultMax, resultMin};
    }

    public static void main(String[] args) {
        int A = 4,
        B = 3;
        int[] C = {2, 1, 1};
        solve(A, B, C);
    }
}
