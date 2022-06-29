package scaler.DSA.Graph1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public interface PathInDirectedGraph {
    public static int solve(int A, int[][] B) {
        ArrayList<Integer>[] links = new ArrayList[A+1];
        for(int i = 0; i < B.length; i++){
            if(links[B[i][0]] == null){
                links[B[i][0]] = new ArrayList<>();
            }
            links[B[i][0]].add(B[i][1]);
        }
        int[] visited = new int[A + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 1;
        while (!queue.isEmpty()){
            int element = queue.poll();
            if(links[element] != null) {
                for (int v : links[element]) {
                    if (visited[v] != 1) {
                        queue.add(v);
                        visited[v] = 1;
                    }
                }
            }
        }
        if(visited[A] != 1)
            return 0;
        return 1;
    }

    public static void main(String[] args) {
        int[][] B = {
                        {1, 2}
//                        {4, 1},
//                        {2, 4},
//                        {3, 4},
//                        {5, 2},
//                        {1, 3},
                    };
        System.out.println(solve(2, B));
    }
}
