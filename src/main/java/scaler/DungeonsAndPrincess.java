package scaler;

public class DungeonsAndPrincess {
    public static int calculateMinimumHP(int[][] A) {
        for(int i = 1; i < A.length; i++)
            A[i][0] = A[i][0] + A[i-1][0];

        for(int i = 1; i < A.length; i++)
            A[0][i] = A[0][i] + A[0][i-1];

        for(int i = 1; i < A.length; i++){
            for(int j = 1; j < A[0].length; j++){
                A[i][j] += Math.max(A[i-1][j], A[i][j-1]);
            }
        }
        return A[A.length][A[0].length] + 1;
    }

    public static void main(String[] args) {
        int[][] A = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        calculateMinimumHP(A);
    }
}
