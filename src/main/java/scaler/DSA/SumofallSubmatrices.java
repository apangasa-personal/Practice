package scaler.DSA;

public class SumofallSubmatrices {
    public static int solve(int[][] A) {
        int ans = 0;
        for(int i= 0; i< A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                ans += (i + 1) * (j + 1) * (A.length - i) * (A[i].length - j) * A[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 1, 1, 1},
        {2, 2, 2, 2, 2},
        {3, 8, 6, 7, 3},
        {4, 4, 4, 4, 4},
        {5, 5, 5, 5, 5}};
        System.out.println(solve(A));
    }
}
