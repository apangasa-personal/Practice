package leetCode;

public class BinaryTreeFromBracket {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public static TreeNode treeFromBracket(String str)
    {
        // Write your code here.
        i = 0;
        TreeNode root = treeFromBracketUtil(str);
        return root;
    }

    static int i;

    public static TreeNode treeFromBracketUtil(String str)
    {
        // Write your code here.
        if(i == str.length())
            return null;
        int j = i;
        TreeNode root = null;
        if(str.charAt(i) == '-' || (str.charAt(j) >= '0' && str.charAt(j) <= '9')) {
            if(str.charAt(i) == '-' )
                j++;
            while (str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                j++;
            }
            int value = Integer.valueOf(str.substring(i, j));
            root = new TreeNode(value);
            i = j;
        }
        if(str.charAt(i) == '('){
            ++i;
            root.left = treeFromBracketUtil(str);
            ++i;
        }
        if(i < str.length() && str.charAt(i) == '('){
            ++i;
            root.right = treeFromBracketUtil(str);
            ++i;
        }

        return root;
    }

    public static void main(String[] args) {
        String str= "1(2(3(4(5(6(7(8)))))))";
        treeFromBracket(str);
    }
}
