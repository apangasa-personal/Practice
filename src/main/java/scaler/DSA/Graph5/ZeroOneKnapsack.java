package scaler.DSA.Graph5;

public class ZeroOneKnapsack {
    public static int solve(int[] A, int[] B, int C) {
        int[] dp = new int[C+1];
        for(int i = 0; i < A.length; i++){
            for(int j = C; j >= B[i]; j--) {
                int v1 = dp[j], v2 = A[i] + dp[j - B[i]];
                dp[j] = Math.max(v1,v2);
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        int[] A = {6, 10, 12},
        B = {10, 20, 30};
        int C = 50;
        System.out.println(solve(A,B,C));
    }
}
