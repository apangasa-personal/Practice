package scaler.DP6;

public class IsInterleaved {

    public static int isInterleave(String A, String B, String C) {
        if(A.length() + B.length() != C.length())
            return 0;
        int[][] dp = new int[B.length()+1][A.length()+1];
        for(int i = 0; i < B.length()+1; i++){
            for(int j = 0; j < A.length()+1; j++)
                dp[i][j] = -1;
        }

        dp[0][0] = 0;
        for(int i = 1; i < A.length()+1;i++) {
            char ch = A.charAt(i - 1), ch2 = C.charAt(i - 1);
            if (A.charAt(i - 1) == C.charAt(i - 1))
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }

        for(int i = 1; i < B.length()+1;i++)
            if(B.charAt(i-1) == C.charAt(i-1) )
                dp[i][0] = 1;
            else
                dp[i][0] = 0;

        for(int i = 1; i < B.length()+1; i++){
            for(int j = 1; j < A.length()+1; j++){
                char chA = A.charAt(j-1), chB = B.charAt(i-1), chC = C.charAt(i+j-1);
                if(chC == chA && chC == chB){
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                }
                else if(chC == chB)
                    dp[i][j] = dp[i-1][j];
                else if(chA == chC)
                    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[B.length()][A.length()];
    }

    public static void main(String[] args) {
        String A = "LgR8D8k7t8KIprKDTQ7aoo7ed6mhKQwWlFxXpyjPkh",
        B = "Q7wQk8rqjaH971SqSQJAMgqYyETo4KmlF4ybf",
        C = "Q7wLgR8D8Qkk7t88KIrpqjarHKD971SqSQJTQ7aoAMgoq7eYd6yETmhoK4KmlQwWFlF4xybXfpyjPkh";

        System.out.println(isInterleave(A,B,C));
    }
}
