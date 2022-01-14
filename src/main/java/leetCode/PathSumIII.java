package leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class PathSumIII {

     // Definition for a binary tree node.
     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) {
       this.val = val;
      }
     }
     public static int result = 0;

     static ArrayList<Integer> values = new ArrayList<>();

     public static int pathSum(TreeNode root, int targetSum) {
      if(root == null)
       return 0;
      values.add(root.val);
      int sum = 0;
      for(int i = values.size()-1; i>=0; i--){
        sum = sum + values.get(i);
        if(sum == targetSum)
         result++;
      }
      pathSum(root.left, targetSum);
      pathSum(root.right, targetSum);
      values.remove(values.size() - 1);
      return result;
     }

     public static void main(String[] args){
        //[5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        //root.left.right = new TreeNode(null);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        pathSum(root, 22);
        System.out.println(result);
     }
}
