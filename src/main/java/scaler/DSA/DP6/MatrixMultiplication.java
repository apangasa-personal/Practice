package scaler.DSA.DP6;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[] A = {
                40, 20, 30, 10, 30
        };

        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int[][] dp = new int[A.length][A.length];
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A.length; j++)
                dp[i][j] = -1;
        return solve(A, 1, A.length -1, dp);

    }

    public static int solve(int[] A, int start, int end, int[][] dp) {
        if(start == end)
            return 0;
        if(dp[start][end] != -1)
            return dp[start][end];
        dp[start][end] = Integer.MAX_VALUE;
        for(int i = start; i < end; i++){
            dp[start][end] = Math.min(dp[start][end], solve(A, start, i, dp) + solve(A, i+1, end, dp) + A[start-1] * A[i] * A[end]);
        }
        return dp[start][end];
    }

}
