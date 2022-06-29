package scaler.DSA;

public class UniquePaths {
    public static int uniquePathsWithObstaclesIterative(int[][] A) {
        int[][] paths = new int[A.length][A[0].length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++)
                paths[i][j] = -1;
        }
        if(A[0][0] == 1)
            return 0;
        paths[0][0] = 1;
        for(int i = 1; i < A.length; i++)
            if(A[i][0] != 1)
                paths[i][0] = paths[i-1][0];
            else
                paths[i][0] = 0;

        for(int i = 1; i < A[0].length; i++)
            if(A[0][i] != 1)
                paths[0][i] = paths[0][i-1];
            else
                paths[0][i] = 0;

        for(int i = 1; i < A.length; i++){
            for(int j = 1; j < A[0].length; j++){
                if(A[i][j] != 1){
                    paths[i][j] = Math.max(paths[i-1][j],0) + Math.max(paths[i][j-1],0);
                }
            }
        }
        return paths[A.length-1][A[0].length-1];
    }

    public static int uniquePathsWithObstacles(int[][] A, int[][] result, int m, int n) {
        if(n < 0 || m < 0)
            return 0;
        if(A[m][n] == 1)
            return 0;
        if(result[m][n] != -1)
            return result[m][n];

        result[m][n] = uniquePathsWithObstacles(A, result, m-1,n) + uniquePathsWithObstacles(A, result, m,n-1);
        return result[m][n];
    }

    public static int uniquePathsWithObstacles(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        for(int i = 0 ; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++)
                result[i][j] = -1;
        }
        result[0][0] = 1;
        return uniquePathsWithObstacles(A, result, A.length - 1, A[0].length - 1);
    }

    public static void main(String[] args) {
        int[][] A = {
                {0, 0},
                {0, 0},
                {0, 0},
                {1, 0},
                {0, 0}
        };
        uniquePathsWithObstacles(A);
    }
}
