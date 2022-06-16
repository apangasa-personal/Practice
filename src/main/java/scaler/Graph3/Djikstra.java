package scaler.Graph3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Djikstra {
    public static int[] solve(int A, int[][] B, int C) {
        ArrayList<ArrayList<Integer[]>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < A; i++)
            adjacencyList.add(new ArrayList<>());

        for(int i = 0; i < B.length; i++){
            adjacencyList.get(B[i][0]).add(new Integer[]{B[i][1],B[i][2]});
            adjacencyList.get(B[i][1]).add(new Integer[]{B[i][0],B[i][2]});
        }
        int[] result = new int[A];
        for(int i = 0; i < A; i++)
            result[i] = Integer.MAX_VALUE;
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new CustomComparator());
        solve(result, adjacencyList, C, queue);
        return result;
    }

    public static class CustomComparator implements Comparator<Integer[]>{
        public int compare(Integer[] a, Integer[] b){
            if(a[0] <= b[0])
                return -1;
            return 1;
        }
    }

    public static void solve(int[] result, ArrayList<ArrayList<Integer[]>> adjacencyList, int node, PriorityQueue<Integer[]> queue){
        queue.add(new Integer[]{0,node});
        result[node] = 0;
        while (queue.size() > 0){
            Integer[] element = queue.poll();
            if(result[element[1]] >= element[0]){
                for(Integer[] neighbours : adjacencyList.get(element[1])){
                    int newDistance = element[0] + neighbours[1];
                    if(newDistance < result[neighbours[0]]){
                        result[neighbours[0]] = newDistance;
                        queue.add(new Integer[]{newDistance, neighbours[0]});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int A = 6;
        int[][] B = {
                {0, 4, 9},
                {3, 4, 6},
                {1, 2, 1},
                {2, 5, 1},
                {2, 4, 5},
                {0, 3, 7},
                {0, 1, 1},
                {4, 5, 7},
                {0, 5, 1} };
        int C = 4;
        System.out.println(solve(A,B,C));
    }
}
