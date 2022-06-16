package scaler.Graph4;

import java.util.*;

public class ConstructionCost {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = {
                {1, 2, 14},
                {2, 3, 7},
                {3, 1, 2}
        };
        System.out.println(solve(A, B));
    }

    public static int solve(int A, int[][] B) {
        PriorityQueue<Graph> priorityQueue = new PriorityQueue<>(new CustomComparator());
        for(int i = 0; i < B.length; i++)
            priorityQueue.offer(new Graph(B[i][0], B[i][1], B[i][2]));

        int[] parents = new int[A+1];
        for(int i = 1; i < A+1; i++)
            parents[i] = i;

        int cost = 0;
        while (!priorityQueue.isEmpty()){
            Graph g = priorityQueue.poll();
            if(validateAkbarVascoKPapa(parents, g) == 0) {
                cost += g.cost;
            }
        }
        return cost;
    }

    public static int validateAkbarVascoKPapa(int[] parents, Graph g){
        int parent1 = getParent(g.to, parents), parent2 = getParent(g.from, parents);
        if(parents[g.from] == parents[g.to])
            return 1;

        parents[parent1] = parents[parent2];
        return 0;
    }

    public static int getParent(int node, int[] parents){
        if(node == parents[node])
            return node;
        parents[node] = getParent(parents[node], parents);
        return parents[node];
    }

    static class CustomComparator implements Comparator<Graph> {
        public int compare(Graph g1, Graph g2){
           return g1.cost - g2.cost;
        }
    }

    static class Graph{
        int from, to, cost;

        public Graph(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
