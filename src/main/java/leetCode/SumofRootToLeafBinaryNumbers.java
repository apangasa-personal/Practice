package leetCode;

public class SumofRootToLeafBinaryNumbers {
    static int sum = 0;
    public static void sumRootToLeaf(TreeNode root, int num) {
        if(root == null)
            return;
        if(root.left == null & root.right == null){
            sum = sum + (num<<1) + root.val;
            return;
        }
        num = (num<<1) + root.val;
        sumRootToLeaf(root.left, num);
        sumRootToLeaf(root.right, num);

    }
    public static int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root, 0);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(1);
        System.out.println(sumRootToLeaf(head));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val; this.left = left; this.right = right;
        }
    }
}
