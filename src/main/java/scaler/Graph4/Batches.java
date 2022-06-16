package scaler.Graph4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Batches {

    public static void main(String[] args) {
        int A = 10, D = 1;
        int[] B = {4, 4, 4, 2, 7, 1, 5, 10, 6, 6};
        int[][] C = {
                {1, 5},
                {1, 8},
                {2, 5},
                {2, 7},
                {4, 9},
                {5, 9}
        };
        System.out.println(solve(A,B,C,D));
    }

    public static int solve(int A, int[] B, int[][] C, int D) {
        ArrayList<HashSet<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < A+1; i++){
            adjacencyList.add(new HashSet<>());
        }
        for(int i = 0; i < C.length; i++){
            adjacencyList.get(C[i][0]).add(C[i][1]);
            adjacencyList.get(C[i][1]).add(C[i][0]);
        }
        int[] visited = new int[A+1];
        int count = 0, result = 0;
        for(int i = 1; i < A+1; i++){
            if(visited[i] == 0){
                count++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                if(fillVisited(adjacencyList, visited, count, queue, B) >= D)
                    result++;
            }
        }
        return result;
    }

    public static int fillVisited(ArrayList<HashSet<Integer>> adjacencyList, int[] visited, int count, Queue<Integer> queue, int[] B) {
        if(queue.size() == 0)
            return 0;
        int strength = 0;
        while(!queue.isEmpty()){
            int element = queue.poll();
            if(visited[element] != 0)
                continue;
            visited[element] = count;
            strength = strength + B[element-1];
            for(int k : adjacencyList.get(element)){
                if(visited[k] == 0)
                    queue.add((k));
            }
        }
        return strength;
    }
}
