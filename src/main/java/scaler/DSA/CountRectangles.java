package scaler.DSA;

import java.util.HashMap;
import java.util.HashSet;

public class CountRectangles {
    public static int solve(int[] A, int[] B) {
        HashMap<Integer, HashSet> xValues = new HashMap<>();
        HashMap<Integer, HashSet> yValues = new HashMap<>();

        //building hashmap for x axis
        for(int i = 0; i < A.length; i++) {
            if(xValues.containsKey(A[i])){
                HashSet<Integer> n = xValues.get(A[i]);
                n.add(B[i]);
                xValues.put(A[i], n);
            }
            else {
                HashSet<Integer> n = new HashSet<>();
                n.add(B[i]);
                xValues.put(A[i], n);
            }
        }
        //building hashmap for y axis
        for(int i = 0; i < A.length; i++) {
            if(yValues.containsKey(B[i])){
                HashSet<Integer> n = yValues.get(B[i]);
                n.add(A[i]);
                yValues.put(B[i], n);
            }
            else {
                HashSet<Integer> n = new HashSet<>();
                n.add(A[i]);
                yValues.put(B[i], n);
            }
        }
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = i+1; j< A.length; j++){
                if(A[i] == A[j] || B[i] == B[j])
                    continue;
                if(xValues.get(A[i]).contains(B[j]) && yValues.get(B[i]).contains(A[j]))
                    result++;
            }
        }
        return result/2;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 3, 3}, B = {1, 2, 1, 2, 1, 2};
        System.out.println(solve(A,B));
    }
}
