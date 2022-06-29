package leetCode;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SerializeDeSerializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public static String serialize(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            String result = "";
            while (queue.size() > 0){
                TreeNode node = queue.poll();
                if(node == null){
                    result = result + ",null";
                    continue;
                }
                result = result + "," + node.val;
                if(node.left != null){
                    queue.add(null);
                }
                if(node.right != null){
                    queue.add(null);
                }
            }
            return result;
        }

        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String data) {
            if(data == "" || data == "null")
                return null;
            int i = 0, j = 0;
            for(; j < data.length(); j++){
                if(data.charAt(j) == ',')
                    break;
            }
            TreeNode root = new TreeNode(Integer.valueOf(data.substring(i,j)));
            TreeNode temp = root;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(j < data.length()){
                j++;
                i = j;
                TreeNode element = queue.poll();
                while (j < data.length() && data.charAt(j) != ',')
                    j++;

                if(data.substring(i, j).equals("null")){
                    element.left = null;
                }
                else{
                    element.left = new TreeNode(Integer.valueOf(data.substring(i, j)));
                }
                queue.add(element.left);
                j++;
                i = j;
                while (j < data.length() && data.charAt(j) != ',')
                    j++;
                if(data.substring(i, j).equals("null")){
                    element.right = null;
                }
                else{
                    element.right = new TreeNode(Integer.valueOf(data.substring(i, j)));
                }
                queue.add(element.right);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        String tree = "1,2,3,null,null,4,5";
        TreeNode root = Codec.deserialize(tree);
        System.out.println("done");
    }

}
