package scaler.DSA;

import java.util.Arrays;

public class MinXorValue {
    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int result = Integer.MAX_VALUE;
        for(int i = 1; i<A.length; i++)
            result = Math.min(result, A[i] ^ A[i-1]);
        return result;
    }

    public static void  main(String[] args){

    }
}
