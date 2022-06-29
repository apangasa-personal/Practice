package scaler.DSA;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KPlacesApart {
    public static int[] solve(int[] A, int B) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] result = new int[A.length];
        int size = B * 2 + 1;
        for(int i = 0; i < A.length; i++){
            priorityQueue.add(A[i]);
            if(priorityQueue.size() > size)
                result[i - size] = priorityQueue.poll();
        }
        while (priorityQueue.size() > 0){
            result[result.length - priorityQueue.size()] = priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 40, 2, 3};
        System.out.println(Arrays.toString(solve(A, 2)));
    }
}
