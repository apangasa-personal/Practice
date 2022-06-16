package scaler.Graph4;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class DamagedRoads {

    public static class Edge{
        int weight;
        int type;

        public Edge(int weight, int type) {
            this.weight = weight;
            this.type = type;
        }
    }

    public static class CustomComparator implements Comparator<Edge>{
        public int compare(Edge e1, Edge e2){
            if(e1.weight < e2.weight)
                return -1;
            return 1;
        }
    }
    public static int solve(int[] A, int[] B) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new CustomComparator());
        for(int i = 0; i < A.length; i++)
            queue.offer(new Edge(A[i], 0));
        for(int i = 0 ; i < B.length; i++)
            queue.offer(new Edge(B[i], 1));

        int m = A.length + 1, n = B.length+1, mod = 1000000007;
        long result = 0;
        while (!queue.isEmpty()){
            Edge e = queue.poll();
            if(e.type == 1){
                result = (result + e.weight * m)%mod;
                n--;
            }
            else{
                result = (result + e.weight * n)%mod;
                m--;
            }
        }
        return (int)result;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1},
            B = {1, 1, 2};
        System.out.println(solve(A,B));
    }
}
