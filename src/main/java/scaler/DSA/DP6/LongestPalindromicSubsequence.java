package scaler.DSA.DP6;

public class LongestPalindromicSubsequence {

    public static int solve(String A) {
        int[][] dp = new int[A.length()][A.length()];
        for(int i = 0; i < A.length(); i++)
            dp[i][i] = 1;

        for(int i = A.length() - 2; i >= 0; i--){
            for(int j = i+1; j < A.length(); j++){
                if(A.charAt(i) == A.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][A.length() - 1];
    }

    public static void main(String[] args) {
        String A = "bebeeed";
        System.out.println(solve(A));
    }
}
