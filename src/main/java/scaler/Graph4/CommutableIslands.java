package scaler.Graph4;

import java.util.*;

public class CommutableIslands {
    static class Graph{
        int cost, from, to;

        public Graph(int from, int to, int cost) {
            this.cost = cost;
            this.from = from;
            this.to = to;
        }
    }

    static class CustomComparator implements Comparator<Graph>{

        @Override
        public int compare(Graph o1, Graph o2) {
            if(o1.cost <= o2.cost)
                return -1;
            return 1;
        }
    }

    public static int solve(int A, int[][] B) {
        PriorityQueue<Graph> priorityQueue = new PriorityQueue<>(new CustomComparator());
        int[] parent = new int[A+1];

        for(int i = 1; i < A+1; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < B.length; i++)
            priorityQueue.offer(new Graph(B[i][0], B[i][1], B[i][2]));

        int cost = 0;
        while (!priorityQueue.isEmpty()){
            Graph graph = priorityQueue.poll();

            if(kruskalAlgo(parent, graph) == 0){
                cost = cost + graph.cost;
            }
        }
        return cost;
    }

    public static int kruskalAlgo(int[] parent, Graph g) {
        if(parent[g.from] == parent[g.to])
            return 1;
        int parentTo = parent[g.to], parentFrom = parent[g.from];
        while (parentTo != parent[parentTo])
            parentTo = parent[parentTo];

        while (parentFrom != parent[parentFrom])
            parentFrom = parent[parentFrom];

        if(parentTo == parentFrom)
            return 1;
        else if(parentTo == g.to)
            parent[g.to] = parentFrom;
        else
            parent[parentFrom] = parentTo;

        return 0;
    }

    public static int isFormingCycle(ArrayList<HashSet<Integer>> adjacencyList, int[] visited, int parent, int index) {
        visited[parent] = 1;
        for(int key : adjacencyList.get(index)){
            if(visited[key] == 0){
                if(isFormingCycle(adjacencyList, visited, key, index) == 1)
                    return 1;
            }
            else if(parent != key)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int A = 3;
        int[][] B = {
                {1, 2, 10},
                {2, 3, 5},
                {1, 3, 9}

        };
        System.out.println(solve(A, B));
    }
}
