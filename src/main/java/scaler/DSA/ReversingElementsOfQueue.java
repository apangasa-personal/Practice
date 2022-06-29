package scaler.DSA;

import java.util.*;

public class ReversingElementsOfQueue {
    public static int[] solve(int[] A, int B) {
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< B; i++){
            stack.add(A[i]);
        }
        while (!stack.isEmpty())
            queue.add(stack.pop());

        for(int i = B; i < A.length; i++)
            queue.add(A[i]);

        return queue.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 3;
        System.out.println(Arrays.toString(solve(A,B)));
    }
}
