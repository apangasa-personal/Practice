package scaler.DSA;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumLargestElement {

    public static class Node{
        int index;
        int val;

        public Node(int val, int index) {
            this.index = index;
            this.val = val;
        }
    }

    public static class NodeValueComparator implements Comparator<Node>{
        public int compare(Node a, Node b){
            if(a.val < b.val)
                return -1;
            else
                return 1;
        }
    }
    public static int solve(int[] A, int B) {
        PriorityQueue<Node> heap = new PriorityQueue(new NodeValueComparator());
        int[] newValues = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            heap.offer(new Node(A[i] * 2, i));
            newValues[i] = A[i] * 2;
        }

        while (B > 1){
            Node current = heap.poll();
            current.val += A[current.index];
            newValues[current.index] = current.val;
            heap.offer(current);
            B--;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < newValues.length; i++)
            max = Math.max(max, newValues[i]);
        return max;
    }

    public static void main(String[] args) {
        int[] A = {5, 7, 8};
        int B = 9;
        System.out.println(solve(A,B));
    }
}
