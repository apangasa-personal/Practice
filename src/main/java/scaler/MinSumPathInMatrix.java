package scaler;

public class MinSumPathInMatrix {
    public static int minPathSum(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        result[0][0] = A[0][0];
        for(int i = 1 ; i < A.length; i++)
            result[i][0] = A[i][0] + result[i-1][0];
        for(int j = 1 ; j < A[0].length; j++)
            result[0][j] = A[0][j] + result[0][j-1];

        for(int i = 1; i < A.length; i++){
            for(int j = 1; j < A[0].length; j++){
                result[i][j] = A[i][j] + Math.min(result[i-1][j],result[i][j-1]);
            }
        }
        return result[A.length - 1][A[0].length - 1];
    }

    public static int minPathSumr(int[][] A) {
        int m = A.length - 1;
        int n = A[0].length - 1;
        int[][] result = new int[m+1][n + 1];
        for(int i = 0; i < m+ 1; i++){
            for(int j = 0; j < n+1; j++){
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        result[0][0] = A[0][0];
        minPathSolveRecursive(A, result, m, n);
        return result[m][n];
    }

    public static int minPathSolveRecursive(int[][] A, int[][] result, int m, int n) {
        if(m < 0 || n < 0)
            return Integer.MAX_VALUE;

        if(result[m][n] != Integer.MAX_VALUE)
            return result[m][n];

        int left = minPathSolveRecursive(A,result, m-1, n);
        int top = minPathSolveRecursive(A,result, m,n-1);
        result[m][n] = A[m][n] + Math.min(left, top);
        return result[m][n];

    }



    public static void main(String[] args) {
        int[][] A = {
                {1,2,3},
                {1,2,3},
                {1,2,3}
            };
        System.out.println(minPathSumr(A));
    }
}
