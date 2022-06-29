package scaler.DSA.Graph1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstDepthFirstSearch {
    public static int solve(int[] A, final int B, final int C) {
        ArrayList<Integer>[] links = new ArrayList[A.length + 1];
        for(int i = 0; i < A.length; i++){
            if(A[i] + i == A[i])
                continue;
            if(links[A[i]] == null)
                links[A[i]] = new ArrayList<>();
            links[A[i]].add(i+1);
        }
        int[] visited = new int[A.length + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(C);
        while (!queue.isEmpty()){
            int element = queue.poll();
            if(links[element] != null){
                for(int v : links[element]){
                    if(v == B)
                        return 1;
                    queue.add(v);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        System.out.println(solve(A, 2, 1));
    }
}
