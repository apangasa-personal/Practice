package leetCode;

import com.sun.source.tree.Tree;

public class BinaryTreeUpsideDown {
    public static class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
    }

    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null)
            return root;
        // write your code here
        TreeNode flippedRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return flippedRoot;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode newRoot = upsideDownBinaryTree(root);
        System.out.println("done");
    }
}
