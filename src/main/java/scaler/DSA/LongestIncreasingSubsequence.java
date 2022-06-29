package scaler.DSA;

public class LongestIncreasingSubsequence {
    public static void lis(final int[] A, int[] result, int n) {
        if(n == result.length)
            return;
        int current = 1;
        for(int i = 0; i <= n; i++){
            if(A[n] > A[i]){
                current = Math.max(current, result[i] + 1);
            }
        }
        result[n] = current;
        lis(A, result, n+1);
        return;
    }

    public static int lis(final int[] A) {
        int[] result = new int[A.length];
        result[0] = 1;
        lis(A, result, 1);
        int max = result[0];
        for(int i = 1; i < result.length; i++)
            max = Math.max(max, result[i]);
        return max;
    }

    public static void main(String[] args) {
        int[] A = {84, 80, 27};
        System.out.println(lis(A));
    }

}
