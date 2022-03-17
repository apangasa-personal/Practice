package scaler;

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
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            Node newNode = new Node(A[i], i);
            heap.offer(newNode);
            max = Math.max(max, A[i]);
        }
        int i = 0;
        while(i< B && heap.size() > 0){
            Node newNode = heap.poll();
            newNode.val = newNode.val + A[newNode.index];
            i++;
            while(i < B && newNode.val < max) {
                newNode.val = newNode.val + A[newNode.index];
                i++;
            }
            max = Math.max(max, newNode.val);
            heap.offer(newNode);
        }
        while (heap.size() > 1)
            heap.poll();
        return heap.poll().val;
    }

    public static void main(String[] args) {
        int[] A = {5, 7, 8};
        int B = 9;
        System.out.println(solve(A,B));
    }
}
