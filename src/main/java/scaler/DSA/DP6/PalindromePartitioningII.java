package scaler.DSA.DP6;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        String a = "bbab";
        minCut(a);
    }

    public static int minCut(String A) {
        if(A.length() < 2)
            return 0;
        int[][] dpPalindrome = new int[A.length()][A.length()];
        for(int i = 0; i < A.length(); i++)
            dpPalindrome[i][i] = 1;

        for(int i = A.length() - 2; i >= 0; i--){
            for(int j = A.length() -1 ; j > i; j--){
                if(A.charAt(i) == A.charAt(j)) {
                    dpPalindrome[i][j] = dpPalindrome[i + 1][j - 1];
                    if(j-i <= 2)
                        dpPalindrome[i][j] = 1;
                }
            }
        }
        int[] result = new int[A.length()];
        for(int i = 0; i < A.length(); i++)
            result[i] = i;

        for(int i = 0; i < A.length(); i++){
            if(i > 0)
            result[i] = result[i-1] + 1;
            for(int j = 0; j < i; j++){
                if(dpPalindrome[j][i] == 1)
                    if(j == 0)
                        result[i] = 0;
                    else
                        result[i] = Math.min(result[i], result[j-1] + 1);
            }
        }
        return result[result.length - 1];
    }
}
