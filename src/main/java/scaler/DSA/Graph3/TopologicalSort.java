package scaler.DSA.Graph3;

import java.util.*;

public class TopologicalSort {
    public static int[] solve(int A, int[][] B) {
        HashMap<Integer,HashSet<Integer>> adjacencyList =new HashMap<>();
        for(int i = 1; i <= A; i++ ) {
            adjacencyList.put(i, new HashSet<>());
        }
        for(int i = 0; i < B.length; i++) {
            HashSet<Integer> current = adjacencyList.get(B[i][1]);
            current.add(B[i][0]);
            adjacencyList.put(B[i][1], current);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Integer[] keys = adjacencyList.keySet().toArray(new Integer[0]);
        for(int i: keys){
            if(adjacencyList.get(i).size() == 0){
                priorityQueue.offer(i);
                adjacencyList.remove(i);
            }
        }
        if(priorityQueue.isEmpty())
            return new int[]{};

        ArrayList<Integer> result = new ArrayList<>();

        topologicalSort(adjacencyList, priorityQueue , result, A);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void topologicalSort(HashMap<Integer,HashSet<Integer>> adjacencyList, PriorityQueue<Integer> priorityQueue, ArrayList<Integer> result, int count){
        if(result.size() == count)
            return;
        while (!priorityQueue.isEmpty()){
            int element = priorityQueue.poll();
            result.add(element);
            Integer[] keys = adjacencyList.keySet().toArray(new Integer[0]);
            for(Integer key: keys){
                if(adjacencyList.get(key).contains(element)){
                    adjacencyList.get(key).remove(element);
                    if(adjacencyList.get(key).size() == 0) {
                        priorityQueue.offer(key);
                        adjacencyList.remove(key);
                    }
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        int A = 8;
        int[][] B = {
                {1, 4},
                {1, 2},
                {4, 2},
                {4, 3},
                {3, 2},
                {5, 2},
                {3, 5},
                {8, 2},
                {8, 6}
        };
        System.out.println(Arrays.toString(solve(A,B)));
    }
}
