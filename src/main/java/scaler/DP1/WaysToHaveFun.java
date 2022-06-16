package scaler.DP1;

public class WaysToHaveFun {
    static int result = 0;
    public static int solve(int A) {
        int mod = 1000000007;

        long[][] dp = new long[3][A];
        for(int i = 0; i < 3; i++)
            dp[i][0] = 1;
        for(int i = 0; i < 3; i++)
            for(int j = 1; j < A; j++)
                dp[i][j] = -1;

        //last day sleep
        long r = solve(dp, 0, 0, A- 1) % mod;

        //last day pizza
        r = (r + solve(dp, 1, 0, A- 1) + mod) %mod;

        //last day tv
        r = (r + solve(dp, 2, 0, A- 1) + mod)%mod;
        return (int)r;
    }

    public static long solve(long [][] dp, int today, int yesterday, int daysLeft) {
        int mod = 1000000007;

        if(dp[today][daysLeft] != -1)
            return dp[today][daysLeft];

        //Sleep
        if(today == 0){
            dp[today][daysLeft] = solve(dp, 0, today, daysLeft-1) + solve(dp, 1, today, daysLeft-1);
            if(yesterday != 2)
                dp[today][daysLeft] += solve(dp, 2, today, daysLeft-1);
        }

        //Pizza
        else if (today == 1){
            dp[today][daysLeft] = solve(dp, 0, today, daysLeft - 1);
            if(yesterday != 2)
                dp[today][daysLeft] += solve(dp, 2, today, daysLeft-1);
        }

        //TV
        else{
            dp[today][daysLeft] =  solve(dp, 0, today, daysLeft - 1);
            if(today != 1)
                dp[today][daysLeft] += solve(dp, 1, today, daysLeft - 1);

            if(daysLeft >= 2)
                dp[today][daysLeft] -= 2* dp[today][daysLeft - 2];
        }

        return (int)((dp[today][daysLeft]+mod)%mod);
    }

    public static void main(String[] args) {
        int A = 3;
        System.out.println(solve(A));
    }
}
