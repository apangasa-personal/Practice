package scaler.DSA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class MaximumFrequency {

    public static int[] solve(int[][] A) {
        int[] value = new int[A.length];
        HashMap<Integer, Integer> hashMapFreq = new HashMap<>();
        HashMap<Integer, Stack<Integer>> hashMapElements = new HashMap<>();
        for(int i = 0; i< A.length; i++){
            if(A[i][0] == 1){
                value[i] = -1;
                hashMapFreq.put(A[i][1], hashMapFreq.getOrDefault(A[i][1], 0) + 1);
                int freq = hashMapFreq.get(A[i][1]);
                Stack<Integer> stack = hashMapElements.getOrDefault(freq, new Stack<>());
                stack.push(A[i][1]);
                hashMapElements.put(freq, stack);
            }
            else{
                if(hashMapFreq.isEmpty()){
                    value[i] = -1;
                    continue;
                }
                int key = (int) hashMapElements.keySet().toArray()[hashMapElements.keySet().toArray().length - 1];
                value[i] = hashMapElements.get(key).peek();
                hashMapFreq.put(value[i], key - 1);
                Stack<Integer> stack = hashMapElements.get(key);
                stack.pop();
                if(stack.isEmpty())
                    hashMapElements.remove(key);
                else
                    hashMapElements.put(key, stack);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 5},
                {1, 7},
                {1, 5},
                {1, 7},
                {1, 4},
                {1, 5},
                {2, 0},
                {2, 0},
                {2, 0},
                {2, 0}};
        System.out.println(Arrays.toString(solve(A)));
    }
}
