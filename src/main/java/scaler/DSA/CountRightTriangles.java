package scaler.DSA;

import java.util.HashMap;

public class CountRightTriangles {
    public static int solve(int[] A, int[] B) {
        HashMap<Integer, Integer> xaxis = new HashMap();
        HashMap<Integer, Integer> yaxis = new HashMap();
        for(int i = 0; i< A.length; i++){
            xaxis.put(A[i], xaxis.getOrDefault(A[i], 0) + 1);
        }
        for(int i = 0; i< A.length; i++){
            yaxis.put(B[i], yaxis.getOrDefault(B[i], 0) + 1);
        }
        long result = 0;
        int mod = 1000000007;
        for(int i = 0; i< A.length; i++){
            result = (((xaxis.get(A[i])-1) * (yaxis.get(B[i])-1))%mod + result)%mod;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 3, 3}, B = {1, 2, 1, 2, 1};
        System.out.println(solve(A,B));
    }
}
