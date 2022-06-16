package scaler.Graph5;

import java.util.PriorityQueue;

public class CommutableIslands {

    public static class NodeBridge{
        int start, end, cost;

        public NodeBridge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static int solve(int A, int[][] B) {
        PriorityQueue<NodeBridge> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < B.length; i++)
            priorityQueue.offer(new NodeBridge(B[i][0], B[i][1], B[i][2]));

        int[] parent = new int[A+1];
        parent[0] = 0;
        for(int i = 0; i < A+1; i++)
            parent[i] = i;
        NodeBridge nodeBridge = priorityQueue.poll();
        parent[nodeBridge.end] = nodeBridge.start;
        int cost = nodeBridge.cost;
//        while (priorityQueue.size() > 0){
//            NodeBridge nodeBridge = priorityQueue.poll();
//            if(visited[nodeBridge.start] )
//        }
        return 0;
    }

    public static void main(String[] args) {
        int A = 4;
        int[][] B = {
                {1, 2, 1},
                {2, 3, 4},
                {1, 4, 3},
                {4, 3, 2},
                {1, 3, 10}
        };
        solve(A, B);
    }
}
