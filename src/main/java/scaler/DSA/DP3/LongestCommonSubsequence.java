package scaler.DSA.DP3;

public class LongestCommonSubsequence {
    public static int solve(String A, String B, int[][] matchingMatrix) {
        if(A.length() == 0 || B.length() == 0)
            return 0;

        if(A.charAt(A.length() - 1) == B.charAt(B.length() - 1))
            matchingMatrix[A.length() - 1][B.length() - 1] = 1 + solve(A.substring(0, A.length() - 1), B.substring(0, B.length() - 1), matchingMatrix);
        else
            matchingMatrix[A.length() - 1][B.length() - 1] = Math.max(solve(A.substring(0, A.length() - 1), B.substring(0, B.length()), matchingMatrix), solve(A.substring(0, A.length()), B.substring(0, B.length() - 1), matchingMatrix));

        return matchingMatrix[A.length() - 1][B.length() - 1];
    }

    public static int solve(String A, String B) {
        if(A.length() == 0 || B.length() == 0)
            return 0;

        int[][] matchingMatrix = new int[A.length()][B.length()];
        solve(A, B,matchingMatrix );
        return matchingMatrix[A.length() - 1][B.length() - 1];
    }

    public static void main(String[] args) {
        String A = "abbcdgf",
        B = "bbadcgf";
        solve(A,B);
    }
}
