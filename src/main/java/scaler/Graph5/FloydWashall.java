package scaler.Graph5;

public class FloydWashall {
    public static int[][] solve(int[][] A) {
        for(int k = 0; k < A.length; k++){
            for(int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (i == j)
                        continue;
                    if (A[i][k] != -1 && A[k][k] != -1) {
                        if (A[i][j] == -1)
                            A[i][j] = A[i][k] + A[k][j];
                        else
                            A[i][j] = Math.min(A[i][j], A[i][k] + A[k][j]);
                    }
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {
                {0 , 50 , 39},
                {-1 , 0 , 1},
                {-1 , 10 , 0}
        };
        int[][] result = solve(A);
        System.out.println("dine");
    }
}
