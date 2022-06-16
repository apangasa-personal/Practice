package scaler.Graph3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ReversingGraphs {

    public static class Node{
        int distance, edge;

        public Node(int distance, int edge) {
            this.distance = distance;
            this.edge = edge;
        }
    }

    public static class CustomComparator implements Comparator<Node>{
        public int compare(Node a, Node b){
            if(a.distance < b.distance)
                return -1;
            return 1;
        }
    }

    public static int reverseEdges(int A, int[][] B) {
        ArrayList<ArrayList<Node>> nodes = new ArrayList<>();

        for(int i = 0; i < A + 1; i++){
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i < B.length; i++){
            nodes.get(B[i][0]).add(new Node(0, B[i][1]));
            nodes.get(B[i][1]).add(new Node(1, B[i][0]));
        }

        int[] result = new int[A+1];
        for(int i = 0; i < result.length; i++)
            result[i] = Integer.MAX_VALUE;
        PriorityQueue<Node> queue = new PriorityQueue<>(new CustomComparator());
        queue.add(new Node(0, 1));
        result[1] = 0;
        while (queue.size() > 0){
            Node current = queue.poll();
            if(result[current.edge] >= current.distance){
                for(Node node : nodes.get(current.edge)){
                    int newDistance = current.distance + node.distance;
                    if(newDistance < result[node.edge]){
                        result[node.edge] = newDistance;
                        queue.add(new Node(newDistance, node.edge));
                    }
                }
            }
        }
        return result[A];
    }


    public static void main(String[] args) {
        int A = 5;
        int[][] B = {
                {1, 2},
                {2, 3},
                {4, 3},
                {4, 5}
        };
        System.out.println(reverseEdges(A,B));
    }
}
