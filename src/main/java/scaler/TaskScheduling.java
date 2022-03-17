package scaler;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskScheduling {

    public static int solve(int[] A, int[] B) {
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i< A.length; i++)
            queue.add(A[i]);
        int cycles = 0;
        for(int i = 0; i< B.length; i++){
            while (queue.peek() != B[i]){
               queue.add(queue.remove());
               cycles++;
            }
            cycles++;
            queue.remove();
        }
        return cycles;
    }


    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5, 4}, B = {1, 3, 5, 4, 2};
        System.out.println(solve(A,B));
    }
}
