package scaler.DSA;

public class RatInAMaze {

    public static Boolean solveCore(int[][] A, int[][] visited, int i, int j) {
        if( i == A.length - 1 && j == A.length - 1) {
            result[i][j] = 1;
            return true;
        }
        if( i == A.length || i < 0)
            return false;
        if( j == A.length || j < 0)
            return false;

        if(A[i][j] == 0) {
            visited[i][j] = 1;
            return false;
        }

        if(visited[i][j] == 1) {
            return false;
        }

        visited[i][j] = 1;
        result[i][j] = 1;

        if( solveCore(A, visited, i+1, j) | solveCore(A, visited, i, j+1) | solveCore(A, visited, i-1, j) | solveCore(A, visited, i, j-1))
            return true;

        result[i][j] = 0;
        return false;
    }

    static int[][] result;
    public static int[][] solve(int[][] A) {
        result = new int[A.length][A.length];
        solveCore(A, new int[A.length][A.length], 0, 0);
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {    {1, 1, 1},
                {1, 0, 1},
                {0, 0, 1}
        };
        int[][] resultadf = solve(A);
    }
}
