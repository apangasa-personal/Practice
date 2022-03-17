package scaler;

import java.util.PriorityQueue;

public class MaximumArrayAfterBNegations {

    public static int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < A.length; i++)
            pq.offer(A[i]);

        for(int i = 0; i < B; i++){
            pq.offer(pq.poll() * -1);
        }

        int result = 0;
        while (!pq.isEmpty())
            result += pq.poll();
        return result;
    }

    public static void main(String[] args) {
        int[] A = {57, 3, -14, -87, 42, 38, 31, -7, -28, -61};
        int B = 10;
        System.out.println(solve(A,B));
    }
}
