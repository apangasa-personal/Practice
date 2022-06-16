package scaler;

public class DiceThrow {
    public static int solve(int A) {
        int[] ways = new int[A+1];
        ways[1] = 1;
        ways[0] = 1;
        solve(A, ways);
        return result;
    }

    public static int solve(int A, int[] ways) {
        if(A < 0)
            return 0;
        if(ways[A] != 0)
            return ways[A];
        long result = 0;
        for(int i = 1; i <= Math.min(6, A); i++){
            result = result + solve(A - i, ways);
        }
        ways[A] = (int)(result%1000000007);
        return ways[A];
    }

//    public static int solve(int A) {
//        solveCore(A);
//        return result;
//    }
//
//    public static void solveCore(int A) {
//        if(A < 0) {
//            return;
//        }
//        if(A == 0) {
//            result++;
//            return;
//        }
//        for(int i = 1; i <= Math.min(6, A); i++){
//            solveCore(A - i);
//        }
//    }

    static int result = 0;
    public static void main(String[] args) {
        int A = 3;
        System.out.println(solve(A));
    }
}
