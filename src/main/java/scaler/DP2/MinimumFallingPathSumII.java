package scaler.DP2;

import com.sun.tools.javac.Main;

public class MinimumFallingPathSumII {
    public static int solve(int[][] A) {
        int[][][] dp = new int[A.length][A.length][A.length];
        for(int i = 0; i < A.length; i++)
            for(int j = 0;j < A.length ; j++)
                for(int k = 0; k < A.length; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                    if(i == A.length - 1 && j == A.length - 1)
                        dp[i][j][k] = A[i][k];
                }
        solve(A, dp, 0,0,0);
        return 0;
    }

    public static int solve(int[][] A, int[][][] dp, int row, int col, int z){
        if(row == A.length || col == A.length)
            return 0;

        if(dp[row][col][z] != Integer.MAX_VALUE)
            return dp[row][col][z];

        for(int i = row+1; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(j == col)
                    continue;
                int v1 = solve(A, dp, row+1, j, j);
                dp[row][col][z] = Math.min(v1 + A[i][j], dp[row][col][z]);
            }
        }
        return dp[row][col][z];
    }
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(solve2(A));
    }

    public static int solve2(int[][] A) {
        int min = Integer.MAX_VALUE;
        if(A.length == 0)
            return 0;
        if(A.length == 1){
            for(int i = 0; i < A[0].length; i++)
                min = Math.min(A[0][i], min);
            return min;
        }
        int[][] dp = new int[A.length][A.length];
        for(int j = 0; j < A.length; j++)
            dp[A.length - 1][j] = A[A.length - 1][j];
        for(int i = 0; i < A.length-1; i++)
            for(int j = 0; j < A.length; j++)
                dp[i][j] = Integer.MAX_VALUE;
        for(int i = A.length - 2; i >= 0; i--){
            for(int j = 0; j < A.length; j++){
                for(int k = 0; k < A.length; k++){
                    if(k == j)
                        continue;
                    dp[i][j] = Math.min(dp[i+1][k], dp[i][j]);
                }
                dp[i][j] = dp[i][j] + A[i][j];
            }
        }
        for(int i = 0; i < A[0].length; i++)
            min = Math.min(dp[0][i], min);
        return min;
    }
}
