package scaler.Graph2;

import java.util.*;

public class ConstructRoads {
    public static void main(String[] args) {
        int A = 8;
        int[][] B = {
                {4, 1},
                {6, 3},
                {8, 1},
                {5, 2},
                {3, 2},
                {2, 1},
                {7, 6}
             };
        solve(A, B);
    }

    public static int solve(int A, int[][] B) {
        ArrayList<HashSet<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < A + 1; i++)
            adjacencyList.add(new HashSet<>());

        int[] bipartite = new int[A+1];
        for(int i = 0; i < B.length; i++){
            adjacencyList.get(B[i][0]).add(B[i][1]);
            adjacencyList.get(B[i][1]).add(B[i][0]);
        }
        for(int i = 0; i < bipartite.length; i++)
            bipartite[i] = -1;
        int value = 1;
        for(int i = 1; i < A+1; i++){
            if(bipartite[i] == -1){
                bipartite[i] = value;
                value = 2;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()){
                    int polledElement = queue.poll();
                    value = bipartite[polledElement] == 1 ? 2 : 1;
                    for(int element : adjacencyList.get(polledElement)){
                        if(bipartite[element] == -1) {
                            bipartite[element] = value;
                            queue.add(element);
                        }
                    }
                }
            }
        }
        int first = 0, second = 0;
        for(int i = 1; i < A+1; i++)
            if(bipartite[i] == 1)
                first++;
            else
                second++;
        long result = 0;
        int mod = 1000000007;
        result = (first * second)%mod;

        return (int)result - B.length ;
    }

    public static void buildBipartite(ArrayList<HashSet<Integer>> adjacencyList, int[] bipartite, int index, int[] visited){
        if(visited[index] == 1)
            return;
        visited[index] = 1;
        for(int v: adjacencyList.get(index)){
            bipartite[v] = (bipartite[index] == 2 || bipartite[index] == -1)? 1:2;
            buildBipartite(adjacencyList, bipartite, v, visited);
        }
    }
}
