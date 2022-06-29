package scaler.DSA;

import java.util.PriorityQueue;

public class Candies {
    public static int solve(int[] A, int B) {

        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < A.length; i++)
            pq.offer(A[i]);

        int a = pq.poll();
        while (!pq.isEmpty() && a <= B){
            result += a/2;
            int pending = a - a/2;
            int toOffer = pq.poll();
            toOffer += pending;
            pq.offer(toOffer);
            if(pq.isEmpty())
                return result;
            a = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {705};
        int B = 895;
        System.out.println(solve(A,B));
    }
}
