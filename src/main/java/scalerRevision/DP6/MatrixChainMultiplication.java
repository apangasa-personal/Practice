package scalerRevision.DP6;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] A = {
                40, 20, 30, 10, 30
        };

        System.out.println(solve(A));
    }


    public static int solve(int[] A){
        int[][] dp = new int[A.length][A.length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(i == j)
                    dp[i][j] = 0;
                else
                    dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return solveCore(A, dp, 1, A.length - 1);
    }

    public static int solveCore(int[] A, int[][] dp, int i, int j){
        if(dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        for(int k = i; k < j; k++){
            int v1 = solveCore(A, dp, i, k);
            int v2 = solveCore(A, dp, k+1, j);
            dp[i][j] = Math.min(dp[i][j],  v1 + v2 + A[i-1] * A[k] * A[j]);
        }
        return dp[i][j];
    }
}
