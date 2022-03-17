package scaler;

import java.util.PriorityQueue;

public class ProductOf3PriorityQueue {

    public static int[] solve(int[] A){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< A.length; i++){
            pq.add(A[i]);
            if(i < 2)
                A[i] = -1;
            else{
                if(i > 2)
                    pq.poll();
                int a = pq.poll(), b = pq.poll(), c= pq.poll();
                A[i] = a * b * c;
                pq.add(a); pq.add(b); pq.add(c);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }
}
