package scaler.DSA;

import java.util.*;

public class WierdFunction {

    public static int solve(int[]A, int N){
        int mod = 1000000007;
        long result = 0,  v1 = 0, v2 = 0, v3 = 0 ;
        HashMap<Integer, Integer> values = new HashMap<>();
        for(int i = 0; i< A.length; i++){
            v1 = (v1 + (A[i] * (N - i - 1))%mod)%mod;
            v2 = (v2 + (A[i] * (i))%mod)%mod;
            if(values.containsKey(A[i] + 1))
                v3 = (v3 + values.get(A[i] + 1))%mod;
            if(values.containsKey(A[i] - 1))
                v3 = (v3 - values.get(A[i] - 1))%mod;
            values.put(A[i], values.getOrDefault(A[i],0)+1);
        }
        result = (v3 + v2 - v1)%mod;
        int rFinal = (int)result%mod;
        return (rFinal)%mod;
    }

    public static void main(String[] args) {
        int[] A = {4,2,5,1};
        int N = A.length;
        System.out.println(solve(A,N));
    }
}
