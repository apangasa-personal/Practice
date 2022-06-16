package leetCode;

class Node
{
     int data;
     Node left, right;

     public Node(int d)
     {
         data = d;
         left = right = null;
     }
}

public class LargestBST {
    static int result = 0;
    static int largestBst(Node root)
    {
        result = 0;
        // Write your code here
        if(root == null){
            return 0;
        }
        largestBstUtil(root);
        return result;

    }

    static int[] largestBstUtil(Node root)
    {
        // Write your code here
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1};
        }
        if(root.left == null && root.right == null){
            result = Math.max(result, 1);
            return new int[]{root.data, root.data, 1, 1};
        }
        int[] left = largestBstUtil(root.left);
        int[] right = largestBstUtil(root.right);

        if(root.data >= left[1] && root.data <= right[0] && left[3] == 1 && right[3] == 1){
            int[] current= new int[3];
            if(left[0] == Integer.MIN_VALUE)
                left[0] = root.data;

            if(right[1] == Integer.MAX_VALUE)
                right[1] = root.data;
            current[0] = Math.min(left[0], root.data);
            current[1] = Math.max(right[1], root.data);
            current[2] = left[2] + right[2] + 1;
            result = Math.max(current[2], result);
            return current;
        }
        return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(6);
        //root.left.left = new Node(6);
        root.left.right = new Node(9);
        System.out.println(largestBst(root));
    }
}
