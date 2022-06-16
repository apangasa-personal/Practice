package scaler.DP1;

public class MinimumNumberOfSquares {
    public static void countMinSquares(int A, int[] ways) {
        if(A == 0)
            return;
        if(ways[A] != -1)
            return;

        int result = Integer.MAX_VALUE;
        for(int i = 1 ; i * i <= A; i++){
            int v = A - (i * i);
            countMinSquares(v, ways);
            result = Math.min(result, ways[v]);
        }
        ways[A] = 1 + result;
        return;
    }

    public static int countMinSquares(int A) {
        int[] ways = new int[A + 1];
        ways[0] = 0;
        ways[1] = 1;
        for(int i = 2; i <= A; i++){
            ways[i] = -1;
        }
        countMinSquares(A, ways);
        return ways[A];
    }

    public static void main(String[] args) {
        int A = 6;
        countMinSquares(A);
    }
}
