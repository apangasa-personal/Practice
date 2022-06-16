package scaler.Graph3;

import java.util.ArrayList;
import java.util.HashSet;

public class DetectACycle {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = {
                {1, 3},
                {2, 3},
                {3, 2}
        };
        System.out.println(solve(A, B));
    }

    public static int solve(int A, int[][] B) {
        ArrayList<HashSet<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < A+1; i++){
            adjacencyList.add(new HashSet<>());
        }
        for(int i = 0; i < B.length; i++)
            adjacencyList.get(B[i][0]).add(B[i][1]);

        for(int i = 1; i < A+1; i++){
            int[] visited = new int[A+1];
            if(detectCycle(adjacencyList, i, i, visited) == 1)
                return 1;
        }
        return 0;
    }

    public static int detectCycle( ArrayList<HashSet<Integer>> adjacencyList, int parent, int index, int[] visited) {
        visited[index] = 1;
        for(int key : adjacencyList.get(index)){
            if(visited[key] == 0) {
                if (key == parent)
                    return 1;
                if (detectCycle(adjacencyList, parent, key, visited) == 1)
                    return 1;
            }
            if(key == parent)
                return 1;
        }
        return 0;
    }
}
