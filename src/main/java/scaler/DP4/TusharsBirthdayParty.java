package scaler.DP4;

import java.util.Arrays;

public class TusharsBirthdayParty {
    public static int solve(final int[] A, final int[] B, final int[] C) {
        if(A.length == 0)
            return 0;

        int ex = 0;
        for(int i = 0; i < A.length; i++){
            int[] cost = new int[A[i]+1];
            Arrays.fill(cost, 1, cost.length, Integer.MAX_VALUE);
            ex += solve(B, C, A[i], cost);
        }
        return ex;
    }

    public static int solve(int[] B, int[] C, int capacity, int[] dpMatrix){
        if(capacity <= 0)
            return 0;
        if(dpMatrix[capacity] != Integer.MAX_VALUE)
            return dpMatrix[capacity];
        for(int i = 0; i < B.length; i++){
            if(capacity >= B[i]){
                int v =  solve(B,C, capacity - B[i], dpMatrix);
                dpMatrix[capacity] = Math.min(dpMatrix[capacity], v + C[i]);
            }
        }
        return dpMatrix[capacity];
    }

    public static void main(String[] args) {
        int[]   A = {2, 4, 6},
                B = {2, 1, 3},
                C = {2, 5, 3};
        System.out.println(solve(A,B,C));
    }
}
