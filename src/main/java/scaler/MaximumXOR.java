package scaler;

import com.sun.jdi.ClassLoaderReference;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumXOR {

    public static class Trie{
        Trie left;
        Trie right;
        int i;
    }

    public static void insertInTrie(int num,int index){
        Trie temp = root;
        for (int i=31; i>=0; i--) {
            int val = (num & (1<<i)) >= 1 ? 1 : 0;
            if(val == 0){
                if(temp.left == null)
                    temp.left = new Trie();
                temp = temp.left;
            }
            else{
                if(temp.right == null)
                    temp.right = new Trie();
                temp = temp.right;
            }
        }
        temp.i = index;
    }

    public static int query(int pre_xor) {
        Trie temp = root;
        int result = 0;
        for (int i=31; i>=0; i--) {
            int val = (pre_xor & (1<<i)) >= 1 ? 1 : 0;
            if(val == 0){
                if(temp.right != null){
                    result = (result << 1) + 1;
                    temp = temp.right;
                }
                else{
                    result = (result << 1) + 0;
                    temp = temp.left;
                }

            }
            else{
                if(temp.left != null){
                    result = (result << 1) + 0;
                    temp = temp.left;
                }
                else{
                    result = (result << 1) + 1;
                    temp = temp.right;
                }
            }
        }
        start = temp.i;
        return result;
    }

    static int start = 0;
    static Trie root = new Trie();

    public static int[] solve(int[] A) {
        int[] result = {1,1};
        int largest = A[0];
        for(int i = 1; i < A.length; i++)
            A[i] = A[i] ^ A[i-1];
        for(int i = 0; i< A.length; i++){
            if(i == 0) {
                insertInTrie(A[i], i+1);
                continue;
            }
            insertInTrie(A[i], i+1);
            int queryXor = query(A[i]);
            int newValue = queryXor ^ A[i];
            if(largest < Math.max(A[i], newValue)){
                largest = Math.max(A[i], newValue);
                if(newValue > A[i]){
                    result[0] = start+1;
                }
                else{
                    result[0] = 1;
                }
                result[1] = i+1;
            }
            else if(largest == newValue){
                if(result[1] - result[0] > i + 1 - start) {
                    result[0] = start+1;
                    result[1] = i+1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] A = {15, 25, 23} ;
        System.out.println(Arrays.toString(solve(A)));
//        System.out.println(Arrays.toString(solve(A)));

    }
}
