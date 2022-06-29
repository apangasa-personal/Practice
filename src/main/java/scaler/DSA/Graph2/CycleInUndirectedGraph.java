package scaler.DSA.Graph2;

import java.util.*;

public class CycleInUndirectedGraph {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2},
                {2, 3},
                {3, 4}
        };
        int B = 4;
        System.out.println(solve(B,A));
    }

    public static int solve(int A, int[][] B) {
        ArrayList<HashSet<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < A+1; i++)
            adjacencyList.add(new HashSet<>());
        for (int i = 0; i < B.length; i++){
            adjacencyList.get(B[i][0]).add(B[i][1]);
            adjacencyList.get(B[i][1]).add(B[i][0]);
        }
        for (int i = 1; i < adjacencyList.size(); i++){
            for(int key: adjacencyList.get(i)){
                adjacencyList.get(key).remove(i);
                Queue<Integer> queue = new LinkedList<>();
                queue.add(key);
                if(findCycle(adjacencyList, i, queue) == 1)
                    return 1;
                adjacencyList.get(key).add(i);
            }
        }
        return 0;
    }

    public static int findCycle(ArrayList<HashSet<Integer>> adjacencyList, int index, Queue<Integer> queue ) {
        int[] visited = new int[adjacencyList.size()];
        while (!queue.isEmpty()){
            int current = queue.poll();
            visited[current] = 1;
            if(current == index)
                return 1;
            for(int key : adjacencyList.get(current))
                if(visited[key] == 0)
                    queue.add(key);
        }
        return 0;
    }
}
