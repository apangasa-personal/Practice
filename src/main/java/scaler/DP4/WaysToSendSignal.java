package scaler.DP4;

public class WaysToSendSignal {
    public static int solve(int A) {
        int[][] dp1 = new int[2][A+1];
        dp1[1][1] = 1; dp1[0][1] = 1;
        solve(A, 0, dp1);
        solve(A, 1, dp1);
        return dp1[0][A] + dp1[1][A];
    }

    public static int solve(int A, int state, int[][] dp) {
        if(A == 0)
            return 0;

        if(dp[state][A] != 0)
            return dp[state][A];

        if(state == 1)
            dp[state][A] += solve(A-1, 0, dp);

        dp[state][A] += solve(A-1, 1, dp);
        return dp[state][A];
    }

    public static void main(String[] args) {
        int i = 2;
        System.out.println(solve(i));
    }
}
