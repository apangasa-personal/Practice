package scaler.Graph3;

import java.util.ArrayList;
import java.util.HashSet;

public class PossibilityOfFinishing {
    public static int solve(int A, int[] B, int[] C) {
        ArrayList<HashSet<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < A + 1; i++)
            adjacencyList.add(new HashSet<>());

        for (int i = 0; i < B.length; i++)
            adjacencyList.get(B[i]).add(C[i]);

        for(int i = 1; i < A + 1; i++){
            int[] visited = new int[A+1];
            if(findCycle(adjacencyList, visited, i, i) == 1)
                return 0;
        }
        return 1;
    }

    public static int findCycle(ArrayList<HashSet<Integer>> adjacencyList, int[] visited, int parent, int index){
        visited[index] = 1;
        for(int key : adjacencyList.get(index)){
            if(visited[key] == 0){
                if(findCycle(adjacencyList, visited, index, key) == 1)
                    return 1;
            }
            else if(key != parent)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int A = 3;
        int[] B = {1, 2, 3}, C = {2, 3, 1};
        System.out.println(solve(A, B, C));
    }
}
