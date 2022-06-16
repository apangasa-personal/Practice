package GeeksForGeeks;

public class MatrixChainMultiplication {
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < N; i++)
            dp[i][i] = 0;
        matrixMultiplicationCore(1, N-1, dp, arr);
        return dp[1][N-1];
    }

    static int matrixMultiplicationCore(int i, int j, int[][] dp, int[] arr){
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }
        for(int k = i; k < j; k++){
            int val1 = matrixMultiplicationCore(i,k, dp, arr);
            int val2 = matrixMultiplicationCore(k+1,j, dp, arr);
            dp[i][j] = Math.min(dp[i][j], val1 + val2 + arr[i-1] * arr[k] * arr[j]);
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int N = 3;
        int[] arr = {40, 20, 30};
        System.out.println(matrixMultiplication(N, arr));
    }
}
