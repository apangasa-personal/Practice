package scaler.Graph2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartitieGraph {
    public static int solve(int A, int[][] B) {
        HashMap<Integer, HashSet<Integer>> adjacencyMap = new HashMap<>();
        int[] assignment = new int[A];
        for(int i = 0; i < A; i++)
            adjacencyMap.put(i, new HashSet<>());

        for(int i = 0; i < B.length; i++) {
            adjacencyMap.get(B[i][0]).add(B[i][1]);
            adjacencyMap.get(B[i][1]).add(B[i][0]);
        }

        for(int i = 0; i < A; i++){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            if(assignment[i] == 0){
                assignment[i] = 1;
                if(assign(adjacencyMap, assignment, queue) == 0)
                    return 0;
            }
            else{
                if(assign(adjacencyMap, assignment, queue) == 0)
                    return 0;
            }
        }

        return 1;
    }

    public static int assign(HashMap<Integer, HashSet<Integer>> adjacencyMap, int[] assignment, Queue<Integer> queue){
        while (queue.size() > 0){
            int element = queue.poll();
            if(adjacencyMap.get(element) != null && adjacencyMap.get(element).size() > 0) {
                Integer[] keys = adjacencyMap.get(element).toArray(new Integer[0]);
                for (int key : keys) {
                    int value = assignment[element] == 1 ? 2 : 1;
                    if (assignment[key] == 0)
                        assignment[key] = value;
                    else if (assignment[key] != value)
                        return 0;

                    adjacencyMap.get(element).remove(key);
                    adjacencyMap.get(key).remove(element);
                    if (adjacencyMap.get(element).size() == 0)
                        adjacencyMap.remove(element);
                    if (adjacencyMap.get(key).size() == 0)
                        adjacencyMap.remove(key);
                    queue.add(key);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] B = {
                {7, 8},
                {1, 2},
                {0, 9},
                {1, 3},
                {6, 7},
                {0, 3},
                {2, 5},
                {3, 8},
                {4, 8}
        };
        int A = 10;
        System.out.println(solve(A,B));
    }
}
