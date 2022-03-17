package scaler;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class NmaxPair {

    public static class ComparatorCustom implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            if(a < b)
                return 1;
            return 1;
        }
    }

    public int[] solve(int[] A, int[] B) {
        PriorityQueue<Integer> aQueue = new PriorityQueue<>(new ComparatorCustom());
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < B.length; j++)
                aQueue.offer(A[i] + B[j]);

        int[] result = new int[A.length];
        for(int i = 0; i < result.length; i++)
            result[i] = aQueue.poll();
        return result;
    }


}
