package scaler.DP2;

public class MaxRectangleinBinaryMatrix {
    public static int maximalRectangle(int[][] A) {
        for(int i = 0; i < A.length; i++){
            for(int j = 1; j < A[i].length; j++){
                if(A[i][j] == 0)
                    continue;
                A[i][j] += A[i][j-1];
            }
        }
        int[][] dp = new int[A.length][A[0].length];

        for(int j = 0; j < A[0].length; j++){
            dp[0][j] = A[0][j];
        }

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 0)
                    continue;
                int height = 1, width = A[i][j];
                dp[i][j] = height * width;
                for(int k = i+1; k < A.length; k++){
                    if(A[k][j] == 0)
                        break;
                    height++;
                    width = Math.min(width, A[k][j]);
                    dp[i][j] = Math.max(dp[i][j], height * width);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][]  A = {
                        {1}
                    };
        System.out.println(maximalRectangle(A));
    }
}
