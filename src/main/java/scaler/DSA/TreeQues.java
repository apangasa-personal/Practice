package scaler.DSA;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeQues {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static ArrayList<TreeNode> queue = new ArrayList<>();
    public static int[] preorderTraversal(TreeNode A) {
        queue = new ArrayList<>();
        if (A == null)
            return new int[] {};
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (A != null || stack.size() != 0){
            if(A != null) {
                queue.add(A);
                if(A.right != null)
                    stack.add(A.right);
                A = A.left;
            }
            else{
                if (stack.peek() != null)
                    A= stack.pop();
            }
        }
        int[] array = new int[queue.size()];
        for (i = 0; i < array.length; i++)
            array[i] = queue.get(i).val;
        return array;
    }

    public static int[] inorderTraversal(TreeNode A) {
        queue = new ArrayList<>();
        if (A == null)
            return new int[] {};
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (A != null || stack.size() != 0){
            if(A != null) {
                stack.push(A);
                A = A.left;
            }
            else{
                while(stack.size() > 0){
                    TreeNode node = stack.pop();
                    queue.add(node);
                    if(node.right != null) {
                        A = node.right;
                        break;
                    }
                }
            }
        }
        int[] array = new int[queue.size()];
        for (i = 0; i < array.length; i++)
            array[i] = queue.get(i).val;
        return array;
    }

    public static int[] postorderTraversal(TreeNode A) {
        queue = new ArrayList<>();
        if (A == null)
            return new int[] {};
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (A != null || stack.size() != 0){
            if(A != null) {
                stack.push(A);
                A = A.left;
            }
            else{
                while(stack.size() > 0){
                    TreeNode node = stack.peek();
                    if(node.right != null) {
                        A = node.right;
                        node.right = null;
                        break;
                    }
                    else {
                        queue.add(node);
                        stack.pop();
                    }
                }
            }
        }
        int[] array = new int[queue.size()];
        for (i = 0; i < array.length; i++)
            array[i] = queue.get(i).val;
        return array;
    }

    public static int[][] levelOrder(TreeNode root){
        ArrayList<TreeNode> queue = new ArrayList<>();
        if(root == null)
            return new int[][]{{}};

        queue.add(root);
        queue.add(null);
        int i = 0, rowCount = 1, row = 0;
        while (!(i == queue.size() - 1 && queue.get(i) == null)){
            if(queue.get(i) == null) {
                queue.add(null);
                rowCount++;
            }
            else{
                if(queue.get(i).left != null)
                    queue.add(queue.get(i).left);
                if(queue.get(i).right != null)
                    queue.add(queue.get(i).right);
            }
            i++;
        }
        int[][] result = new int[rowCount][];

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(i = 0; i< queue.size(); i++){
            if(queue.get(i) == null){
                result[row] = arrayList.stream().mapToInt(Integer :: intValue).toArray();
                arrayList.clear();
                row++;
            }
            else{
                arrayList.add(queue.get(i).val);
            }
        }
        return result;
    }

    public static int[][] verticalOrderTraversal(TreeNode root) {
        ArrayList<Object[]> queue = new ArrayList<>();
        if(root == null)
            return new int[][]{{}};

        queue.add(new Object[]{root, 0});
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        int i = 0, rowCount = 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (i < queue.size()){
            TreeNode node = (TreeNode) queue.get(i)[0];
            int value = (int) queue.get(i)[1];
            max = Math.max(value, max);
            min = Math.min(value, min);
            if(hashMap.containsKey(value)){
                ArrayList<Integer> currentValues = hashMap.get(value);
                currentValues.add(node.val);
                hashMap.put(value, currentValues);
            }
            else{
                ArrayList<Integer> currentValues =  new ArrayList<>();
                currentValues.add(node.val);
                hashMap.put(value, currentValues);
            }
            if(node.left != null)
                queue.add(new Object[]{node.left, value - 1});
            if(node.right != null)
                queue.add(new Object[]{node.right, value + 1});
            i++;
        }
        int[][] result = new int[hashMap.size()][];

        for(int j = min, c = 0; j<= max; j++, c++){
            result[c] = hashMap.get(j).stream().mapToInt(Integer :: intValue).toArray();
        }
        return result;
    }

    public static int[] leftView(TreeNode root){
        if(root == null)
            return new int[]{};
        ArrayList<TreeNode> queue = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)
            return new int[]{};

        queue.add(root);
        queue.add(null);
        result.add(root.val);
        int i = 0;
        while (!(i == queue.size() - 1 && queue.get(i) == null)){
            if(queue.get(i) == null) {
                if (i + 1 < queue.size())
                    result.add(queue.get(i + 1).val);
                if (queue.get(i) == null) {
                    queue.add(null);
                }
            }
            else{
                if(queue.get(i).left != null)
                    queue.add(queue.get(i).left);
                if(queue.get(i).right != null)
                    queue.add(queue.get(i).right);
            }
            i++;
        }

        return result.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static int[] right(TreeNode A){
        if(A == null)
            return new int[]{};
        ArrayList<TreeNode> queue = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null)
            return new int[]{};

        queue.add(A);
        queue.add(null);
        result.add(A.val);
        int i = 0;
        while (!(i == queue.size() - 1 && queue.get(i) == null)){
            if(queue.get(i) == null) {
                if (i + 1 < queue.size())
                    result.add(queue.get(i + 1).val);
                if (queue.get(i) == null) {
                    queue.add(null);
                }
            }
            else{
                if(queue.get(i).right != null)
                    queue.add(queue.get(i).right);
                if(queue.get(i).left != null)
                    queue.add(queue.get(i).left);
            }
            i++;
        }

        return result.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static TreeNode buildTree(int[] A, int[] B, TreeNode current) {
        if(A.length == 1)
            return new TreeNode(A[0]);
        if(current == null){
            current = new TreeNode(A[0]);
        }
        int i = 0;
        for(i = 0; i < B.length; i++){
            if(B[i] == A[0])
                break;
        }
        current.left = buildTree(Arrays.copyOfRange(A, 1, i+1), Arrays.copyOfRange(B, 0, i));
        current.right = buildTree(Arrays.copyOfRange(A, i+1, A.length), Arrays.copyOfRange(B, i+1, B.length));
        return current;
    }


    public static TreeNode buildTree(int[] A, int[] B) {
       if(A.length == 0)
           return null;
       return buildTree(A, B, null);
    }

    public static TreeNode buildTreePost(int[] A, int[] B) {
        if(A.length == 0)
            return null;
        return buildTreePost(A, B, null);
    }

    public static TreeNode buildTreePost(int[] A, int[] B, TreeNode current) {
        if(A.length == 1)
            return new TreeNode(A[0]);
        if(current == null){
            current = new TreeNode(B[B.length - 1]);
        }
        int i;
        for(i = 0; i < B.length; i++){
            if(B[B.length - 1] == A[i])
                break;
        }
        current.right = buildTreePost(Arrays.copyOfRange(A, i+1, A.length), Arrays.copyOfRange(B, i, B.length - 1));
        current.left = buildTreePost(Arrays.copyOfRange(A, 0, i), Arrays.copyOfRange(B, 0, i));
        return current;
    }

    public void sumUncoveredNodesLeft(TreeNode A){
        if(A == null)
            return;
        sumUncovered = sumUncovered + A.val;
        sumUncoveredNodesLeft(A.left);
    }

    public void sumUncoveredNodesRight(TreeNode A){
        if(A == null)
            return;
        sumUncovered = sumUncovered + A.val;
        sumUncoveredNodesLeft(A.right);
    }

    long sumAll = 0;
    long sumUncovered = 0;
    public void sumAllNodes(TreeNode A){
        if(A == null)
            return;
        sumAll += A.val;
        sumAllNodes(A.right);
        sumAllNodes(A.left);
    }
    public long coveredNodes(TreeNode A) {
        sumUncovered = A.val;
        sumUncoveredNodesLeft(A.left);
        sumUncoveredNodesRight(A.right);
        long sumCovered = sumAll - sumUncovered;
        return Math.abs(sumCovered - sumUncovered);
    }

    public static TreeNode invertTree(TreeNode A) {
        if(A == null)
            return null;
        if(A.left != null){
            TreeNode left = A.left;
            A.left = A.right;
            A.right = left;
        }
        invertTree(A.left);
        invertTree(A.right);
        return A;
    }

    public static int[][] zigzagLevelOrder(TreeNode A) {
        if(A == null)
            return new int[][]{{}};
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(A);
        queue.add(null);
        int i = 0, rowCount = 0;
        while (!(queue.get(i) == null && i == queue.size() - 1)){
            if(queue.get(i) == null) {

                queue.add(null);
                rowCount++;
            }
            else{
                if(queue.get(i).left != null)
                    queue.add(queue.get(i).left);
                if(queue.get(i).right != null)
                    queue.add(queue.get(i).right);
            }
            i++;
        }
        int[][] result= new int[rowCount+1][];
        ArrayList<Integer> v = new ArrayList<>();
        for(rowCount = 0, i = 0; i< queue.size(); i++){
            if(queue.get(i) == null){
                if(rowCount%2 == 1){
                    Collections.reverse(v);
                }
                result[rowCount] = v.stream().mapToInt(Integer :: intValue).toArray();
                v = new ArrayList<>();
                rowCount++;
            }
            else{
                v.add(queue.get(i).val);
            }
        }
        return result;
    }

    public static int[] reverseLevelOrder(TreeNode A) {
        if(A == null)
            return new int[]{};
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(A);
        queue.add(null);
        int i = 0, rowCount = 0, length = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        while (!(queue.get(i) == null && i == queue.size() - 1)){
            ArrayList<Integer> v;
            if(queue.get(i) == null) {
                v = new ArrayList<>();
                queue.add(null);
                rowCount++;
            }
            else{
                if(map.containsKey(rowCount))
                    v = map.get(rowCount);
                else
                    v = new ArrayList<>();

                v.add(queue.get(i).val);
                map.put(rowCount, v);
                if(queue.get(i).left != null)
                    queue.add(queue.get(i).left);
                if(queue.get(i).right != null)
                    queue.add(queue.get(i).right);

                length++;
            }
            i++;
        }
        int[] result = new int[length];
        int j = 0;
        for(i = rowCount; i>=0; i--){
            for(int val : map.get(i)){
                result[j] = val;
                j++;
            }
        }
        return result;
    }

    public static int sumBinaryTree(TreeNode A) {
        if(A == null)
            return 0;
        if(A.left == null && A.right == null)
            return A.val;
        else {
            int sumLeft = solve(A.left);
            int sumRight = solve(A.right);
            if (A.val != sumLeft + sumRight)
                return 0;
            return sumLeft + sumRight + A.val;
        }
    }

    public static int solve(TreeNode A) {
        if(sumBinaryTree(A) == 0)
            return 0;
        return 1;
    }



    public static int symmetricBinaryTree(TreeNode A){
//        if(A == null)
//            return 1;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(A);
//        queue.add(null);
//        while (queue.size() != 1){
//            if(queue.peek() != null){
//                if(queue.peek() != null)
//            }
//        }
        return 1;
    }

    public static TreeNode reverse(TreeNode A){
        if(A == null)
            return null;
        TreeNode node = A.left;
        A.left = A.right;
        A.right = node;
        A.left = reverse(A.left);
        A.right = reverse(A.right);
        return A;
    }

    public static int isSymmetricCore(TreeNode A, TreeNode B){
        if(A == null && B == null)
            return 1;

        if(A.val != B.val)
            return 0;

        if((A == null && B != null ) || (A != null && B == null ))
            return 0;
        int v1 = isSymmetricCore(A.left, B.left);
        int v2 = isSymmetricCore(A.right, B.right);
        if(v1 != 1 || v2 != 1)
            return 0;
        return 1;
    }

    public static int isSymmetric(TreeNode A) {
        A.left = reverse(A.left);
        int v = isSymmetricCore(A.left, A.right);
        return v;
    }

    static int result = 1;
    public static int balancedBinaryTreeCore(TreeNode A){
        if(A == null)
            return 0;
        int depthLeft = balancedBinaryTreeCore(A.left) + 1;
        int depthRight = balancedBinaryTreeCore(A.right)+ 1;
        if(Math.abs(depthLeft - depthRight) > 1)
            result = 0;
        return Math.max(depthLeft, depthRight);
    }

    public static int balancedBinaryTree(TreeNode A){
        balancedBinaryTreeCore(A);
        return result;
    }


    public static TreeNode sortedArrayToBSTCore(final int[] A, int start, int end, boolean constructLeft) {
        if(A.length == 0)
            return null;
        if(A.length == 1)
            return new TreeNode(A[0]);
        int mid = (start + end + 1)/2;
        if(A.length % 2 == 0 && !constructLeft)
            mid--;
        TreeNode root = new TreeNode(A[mid]);
        root.left = sortedArrayToBSTCore(Arrays.copyOfRange(A, start, mid), start, mid-1, true);
        root.right = sortedArrayToBSTCore(Arrays.copyOfRange(A, mid+1, end+1), 0, end - mid-1, false);
        return root;
    }

    public static TreeNode sortedArrayToBST(final int[] A) {
        TreeNode root = sortedArrayToBSTCore(A, 0, A.length-1, true);
        return root;
    }

    static int validBST = 1;
    public static void isValidBSTCore(TreeNode A, int min, int max) {
        if(A == null)
            return;
        if(A.val < min || A.val > max)
            validBST = 0;
        if(A.left != null)
            isValidBSTCore(A.left, min, A.val);
        if(A.right != null)
            isValidBSTCore(A.right, A.val, max);
    }

    public static int isValidBST(TreeNode A) {
        isValidBSTCore(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return validBST;
    }

    public static int getFloor(TreeNode A, int v){
        if(A == null)
            return -1;
        int result = Integer.MIN_VALUE;
        while(A != null){
            if(v == A.val)
                return A.val;
            else if(A.val > v){
                A = A.left;
            }
            else{
                result = Math.max(result, A.val);
                A = A.right;
            }
        }
        if(result == Integer.MIN_VALUE)
            return -1;
        return result;
    }

    public static int getCeil(TreeNode A, int v){
        if(A == null)
            return -1;
        int result = Integer.MAX_VALUE;
        while(A != null){
            if(v == A.val)
                return A.val;
            else if(A.val > v){
                result = Math.min(result, A.val);
                A = A.left;
            }
            else{
                A = A.right;
            }
        }
        if(result == Integer.MIN_VALUE)
            return -1;
        return result;
    }
    public static int[][] solve(TreeNode A, int[] B) {
        int[][] result = new int[B.length][2];
        for(int i = 0; i < B.length; i++){
            result[i][0] = getFloor(A, B[i]);
            result[i][1] = getCeil(A, B[i]);
        }
        return result;
    }

    public static int solveAlterNateDiff(TreeNode A) {
        if(A == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        boolean subtract = false;
        int s = 0;
        while(queue.size() != 0){
            if(queue.peek() == null){
                queue.remove();
                if(queue.size() != 0){
                    queue.add(null);
                }
                subtract = !subtract;
            }
            else{
                if(subtract){
                    s = s - queue.peek().val;
                }
                else
                    s = s + queue.peek().val;
                if(queue.peek().left != null)
                    queue.add(queue.peek().left);
                if(queue.peek().right != null)
                    queue.add(queue.peek().right);
                queue.remove();
            }
        }
        return s;
    }

    public static TreeNode constructtree(List<Integer> A) {
        if(A.size() == 0)
            return null;
        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        for(int i = 1, j = 0; i < A.size(); i = i+2){
            if(A.get(i) != -1) {
                nodes.peek().left = new TreeNode(A.get(i));
                nodes.add(nodes.peek().left);
            }
            if(A.get(i+1) != -1) {
                nodes.peek().right = new TreeNode(A.get(i + 1));
                nodes.add(nodes.peek().right);
            }
            nodes.remove();
        }
        return root;
    }

    public static TreeNode constructBSTCore(int[] A, int start, int end) {
        if(end < start)
            return null;
        if(end - start == 0)
            return new TreeNode(A[start]);
        TreeNode root = new TreeNode(A[start]);

        int i = start+1;
        while(i < A.length && A[i] < A[start])
            i++;
        root.left = constructBSTCore(A, start+1, i-1);
        root.right = constructBSTCore(A, i, end);
        return root;
    }


    public static TreeNode constructBST(int[] A) {
        return constructBSTCore(A, 0, A.length-1);
    }

    public static ArrayList<Integer> getElements(TreeNode A, int B, ArrayList r){
        if(A == null)
            return r;
        if(A!= null && A.val == B) {
            r.add(A.val);
            return r;
        }
        r.add(A.val);
        if(A.left != null && B < A.val){
            r = getElements(A.left, B, r);
        }
        else
            r = getElements(A.right, B, r);
        return r;
    }


    public static int treeDifference(TreeNode A, int B, int C) {
        ArrayList<Integer> v1 = getElements(A,B, new ArrayList());
        ArrayList<Integer> v2 = getElements(A,C, new ArrayList());
        while(v1.size() > 0 && v2.size() > 0 && v1.get(0) == v2.get(0)){
            v1.remove(0);
            v2.remove(0);
        }
        return v1.size() + v2.size() ;
    }

    public static Boolean findPath(TreeNode A, int B){
        if(A == null)
            return false;
        if(A.val == B) {
            nodes.push(A);
            return true;
        }
        Boolean left = findPath(A.left, B);
        Boolean right = findPath(A.right, B);
        if(left || right) {
            nodes.push(A);
            return true;
        }
        return false;
    }

    static Stack<TreeNode> nodes = new Stack<>();
    public static int[] solve(TreeNode A, int B, int C) {
        nodes = new Stack<>();
        findPath(A,B);
        TreeNode down = nodes.pop();
        return new int[]{};
    }

    public static int maxPathSum(TreeNode A, int sum) {
        if(A == null)
            return sum;
        int left = maxPathSum(A.left, sum);
        int right = maxPathSum(A.right, sum);
        if(left < 0 && right < 0)
            return A.val;
        return Math.max(left, right) + A.val;
    }
    public static int maxPathSum(TreeNode A) {
        return maxPathSum(A, 0);

    }

    public static int[] boundary(TreeNode A) {
        if(A == null)
            return new int[]{};
        ArrayList<TreeNode> list = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int small = 1, large = 0, level = 0;
        list.add(A);
        list.add(null);
        while(list.size() > 0){
            if(list.get(0) == null && list.size() == 1)
                break;
            if(list.get(0) == null){
                list.add(null);
                level++;
            }
            else{
                ArrayList<Integer> l = new ArrayList<>();
                if(map.containsKey(level)){
                    l = map.get(level);
                }
                l.add(list.get(0).val);
                map.put(level, l);
                if(list.get(0).left != null)
                    list.add(list.get(0).left);
                if(list.get(0).right != null)
                    list.add(list.get(0).right);
            }
            list.remove(0);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < level; i++){
            result.add(map.get(i).get(0));
        }
        for(int i = 0; i < map.get(level).size(); i++)
            result.add(map.get(level).get(i));

        for(int i = level - 1; i > 0; i--){
            result.add(map.get(i).get(map.get(i).size() - 1));
        }
        return result.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static int solveCurrent(TreeNode A){
        if(A == null){
            return 0;
        }
        return 1 + Math.max(solveCurrent(A.left), solveCurrent(A.right));
    }
    public static int solveme(TreeNode A) {
        if(A == null)
            return result;
        int left = solveCurrent(A.left);
        int right = solveCurrent(A.right);
        result = Math.max(result, left + right);
        solve(A.left);
        solve(A.right);
        return result;
    }

    static HashSet<Long> sums = new HashSet<>();
    static long totalSum = 0;

    public static long solveCore(TreeNode A) {
        if(A == null)
            return 0;
        long sumLeft = solveCore(A.left);
        long sumRight = solveCore(A.right);
        totalSum += A.val;
        sums.add(sumLeft + sumRight + A.val);
        return sumLeft + sumRight + A.val;
    }

    public static int solveSum(TreeNode A) {
        totalSum = 0;
        sums = new HashSet<>();
        solveCore(A);
        if(totalSum %2 == 1)
            return 0;
        if(sums.contains(totalSum/2))
            return 1;
        return 0;
    }

    static int ans = Integer.MIN_VALUE;
    public static int maxPathSumCore(TreeNode A, int sum) {
        if(A == null)
            return 0;
        int left = maxPathSumCore(A.left, sum);
        int right = maxPathSumCore(A.right, sum);
        int max = Math.max(left, right);
        max = Math.max(max, 0);
        int newVal = max + A.val;
        ans = Math.max(newVal, ans);
        ans = Math.max(ans, left + right + A.val);

        return newVal;
    }

    public static int maxPathSum221(TreeNode A) {
        if(A == null)
            return 0;
        maxPathSumCore(A, 0);
        return ans;
    }

    public static int[] reverseLevelOrder123(TreeNode A) {
        Deque<TreeNode> list = new LinkedList<>();
        if(A == null)
            return new int[]{};
        list.add(A);
        list.add(null);
        Stack<Integer> stack = new Stack<>();
        while(list.size() > 0){
            if(list.peek() == null){
                if(list.size() > 1)
                    list.add(null);
            }
            else{
                if(list.peek().right != null)
                    list.add(list.peek().right);
                if(list.peek().left != null)
                    list.add(list.peek().left);
                stack.push(list.peek().val);
            }
            list.remove();
        }
        int[] a = new int[stack.size()];
        int count = 0;
        while(!stack.isEmpty()){
            a[count] = stack.pop();
            count++;
        }
        return a;
    }

    public static TreeNode solveCore(TreeNode root, TreeNode A, TreeNode B) {
        if(A == null && B == null)
            return null;

        root = new TreeNode(0);
        if(A == null)
            root = new TreeNode(B.val);
        else if(B == null)
            root = new TreeNode(A.val);
        else
            root = new TreeNode(A.val + B.val);

        if(A != null && A.left != null && B!= null && B.left != null){
            root.left = solveCore(root.left, A.left, B.left);
        }
        else if(A != null && A.left != null)
            root.left = solveCore(root.left, A.left, null);
        else if(B != null && B.left != null)
            root.left = solveCore(root.left,null, B.left);


        if(A != null && A.right != null && B!= null && B.right != null){
            root.right = solveCore(root.right, A.right, B.right);
        }
        else if(A != null && A.right != null)
            root.right = solveCore(root.right, A.right, null);
        else if(B != null && B.right != null)
            root.right = solveCore(root.right, null, B.right);

        return root;

    }

    public static TreeNode solveSumTree(TreeNode A, TreeNode B) {
        TreeNode root = new TreeNode(0);
        root  = solveCore(root, A,B);
        return root;
    }

    public static boolean findNode(TreeNode A, int B){
        if(A == null)
            return false;
        if(A.val == B) {
            parents.add(A);
            return true;
        }
        Boolean left = findNode(A.left, B);
        Boolean right = findNode(A.right, B);
        if(right  == true || left == true) {
            parents.add(A);
            return true;
        }
        return false;
    }

    static ArrayList<TreeNode> parents = new ArrayList<>();
    static ArrayList<Integer> nDistanceNodes = new ArrayList<>();
    public static void findChildren(TreeNode A, int B){
        if(A == null)
            return;
        if(B == 0){
            nDistanceNodes.add(A.val);
            return;
        }
        findChildren(A.left, B-1);
        findChildren(A.right, B-1);
    }

    public static int[] solveCthElementFromB(TreeNode A, int B, int C) {
        if(A == null)
            return new int[] {};
        parents = new ArrayList<>();
        findNode(A,B);
        nDistanceNodes = new ArrayList<>();
        if(parents.size() > 0){
            findChildren(parents.get(0), C);
            int i =0;
            while(i < parents.size()-1 && C >= 0){
                TreeNode node = parents.get(i+1);
                C--;
                if(C == 0)
                    nDistanceNodes.add(node.val);
                else {
                    if (node.left == parents.get(i))
                        findChildren(node.right, C - 1);
                    else
                        findChildren(node.left, C - 1);
                }
                i++;
            }
            return nDistanceNodes.stream().mapToInt(Integer :: intValue).toArray();
        }
        else
            return new int[] {};
    }

    public static void main(String[] args) {
//        68 81 11 55 49
        TreeNode root = new TreeNode(68);
        root.left = new TreeNode(81);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(55);
        root.left.right = new TreeNode(49);
//        root.right.left = new TreeNode(46);
//        root.right.right = new TreeNode(51);
//        root.left.left.left = new TreeNode(78);
//        root.left.left.right = new TreeNode(55);
//        root.left.right.left = new TreeNode(70);
//        root.left.right.left = new TreeNode(35);
//        root.left.right.right = new TreeNode(81);
//        root.left.right.left = new TreeNode(23);
//        root.left.right.right = new TreeNode(60);
        solveCthElementFromB(root, 11, 2);

        TreeNode root2 = new TreeNode(94);
        //root.left = new TreeNode(15);
        root2.left = new TreeNode(90);
        root2.right = new TreeNode(96);
//        root2.left.left = new TreeNode(64);
//        root2.left.right = new TreeNode(71);
//        root2.right.left = new TreeNode(92);
//        root2.right.right = new TreeNode(100);
        solveSumTree(root, root2);
//        root.left.left = new TreeNode(45);
//        root.left.right = new TreeNode(58);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(30);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(8);
//        root.right.left.left = new TreeNode(7);
//        boundary(root);
//        root.right = new TreeNode(46);
//        root.left.left = new TreeNode(17);
//        root.left.right = new TreeNode(47);
//        root.right.left = new TreeNode(40);
//        root.right.right = new TreeNode(49);
//        root.left.left.left = new TreeNode(9);
//        treeDifference(root, 16, 24);
////        int[] a = {3, 1, 2, 7, 6, 17, 15, 9, 10, 18};
//        treeDifference(root, 32, 32);
////        solveAlterNateDiff(root);
////        int arr[] = { 1, 2, 4, -1, 3, -1, 5, 7, -1, -1, 6, -1, 8, -1, -1, -1, -1 };
////        constructtree(IntStream.of(arr).boxed().collect(Collectors.toList()));
////        root.left.right = new TreeNode(27);
////        root.right.left = new TreeNode(40);
////        root.right.right = new TreeNode(49);
////        root.left.left.left = new TreeNode(9);
////        int[] A = {5 ,9 ,5 ,15 ,7 };
////        int[][] r = solve(root, A);
////        int[] A = {3, 2147483647};
////        root = sortedArrayToBST(A);
//        int result = isValidBST(root);
//        balancedBinaryTreeCore(root);
//        root.right.left.left = new TreeNode(7);
//        root.right.left.right = new TreeNode(8);
//        root = invertTree(root);
//        preorderTraversal(root);
//        inorderTraversal(root);
//        verticalOrderTraversal(root);
//        right(root);
//        int[] in = {4, 2, 1, 7, 5, 8, 3, 6};
//        int[] pre = {1, 2, 4, 3, 5, 7, 8, 6};
//        int[] post = postorderTraversal(root);
//        TreeNode r = buildTree(in, pre);
//        TreeNode r = buildTreePost(in, post);
//        int[][] value = zigzagLevelOrder(root);
//        int result = solve(root);
//        System.out.println("done");
    }
}
