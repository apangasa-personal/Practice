package scaler.DSA.DP5;

public class CuttingARod {
    public static void main(String[] args) {
        int[]  A = {1, 5, 2, 5, 6};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int[] maxPrice = new int[A.length];
        for(int i = 0; i < A.length; i++)
            maxPrice[i] = -1;
        return solve(A, maxPrice, 5);

    }

    public static int solve(int[] A, int[] maxPrice, int length) {
        if(length <= 0)
            return 0;
        if(maxPrice[length - 1] != -1)
            return maxPrice[length - 1];
        maxPrice[length-1] = A[length - 1];
        for(int i = 1; i < length; i++){
            int pendingLength = length - i;
            int v1 = solve(A, maxPrice, pendingLength);
            maxPrice[length-1] = Math.max(maxPrice[length-1], v1 + A[i-1]);
        }
        return maxPrice[length-1];
    }
}
