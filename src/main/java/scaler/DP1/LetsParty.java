package scaler.DP1;

public class LetsParty {
    static int[] ways;

    public static int solveCore(int A, int[] ways) {
        if(ways[A] != -1)
            return ways[A];

        int single = solveCore(A-1, ways);
        int v = A-1;
        int w = solveCore(A-2, ways);
        int paired = v * w;

        ways[A] = single + paired;
        return ways[A];
    }

    public static int solve(int A) {
        if(A <= 1)
            return 1;
        ways = new int[A+1];
        ways[1] = 1; ways[0] = 1;
        for(int i = 2; i <= A; i++)
            ways[i] = -1;
        return solveCore(A, ways);
    }

    public static void main(String[] args) {
        int A = 6;
        System.out.println(solve(A));
    }

}
