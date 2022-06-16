package scaler.DP5;

public class ZeroOneKnapsack2 {
    public static int solve(int[] A, int[] B, int C) {
        int []dp = new int[C + 1];
        for (int i = 1; i < A.length + 1; i++) {
            for (int w = C; w >= 0; w--) {
                if (B[i - 1] <= w) {
                    int val1 = dp[w];
                    int val2 = dp[w - B[i - 1]] + A[i - 1];
                    dp[w] = Math.max(val1,val2);
                }
            }
        }
        return dp[C];
    }

    static int solve(int W, int B[], int A[], int n, int [][]dp) {
        if (n == 0 || W == 0)
            return 0;
        if (dp[n][W] != -1)
            return dp[n][W];
        if (B[n - 1] > W)
            return dp[n][W] = solve(W, B, A, n - 1, dp);
        else
            return dp[n][W] = Math.max((A[n - 1] + solve(W - B[n - 1], B, A, n - 1, dp)),
                                        solve(W, B, A, n - 1, dp));
    }

    public static void main(String[] args) {
        int[] A = {6, 10, 12},
              B = {10, 20, 30};
        int C = 50;
        System.out.println(solve(A,B,C));
    }
}
