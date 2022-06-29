package scaler.DSA;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AthLargestElement {
    public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < B.size(); i++){
            priorityQueue.offer(B.get(i));
            if(priorityQueue.size() > A){
                priorityQueue.poll();
            }
            if(priorityQueue.size() == A)
                result.add(priorityQueue.peek());
            else
                result.add(-1);
        }
        while(priorityQueue.size() > 0)
            result.add(priorityQueue.poll());
        return result;
    }

    public static void main(String[] args) {
         int[] A = {15, 20, 99, 1};
         ArrayList<Integer> list = new ArrayList<>();
         for(int i = 0; i < A.length; i++)
             list.add(A[i]);
         solve(2, list);
    }
}
