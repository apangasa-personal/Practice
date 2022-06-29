package scaler.DSA.DP2;

import java.util.ArrayList;

public class MinSumPathinTriangle {
    public static int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int dp[][] = new int[a.size()][a.size()];
        dp[0][0] = a.get(0).get(0);
        for(int i = 1; i < a.size(); i++){
            for(int j = 0; j < a.get(i).size(); j++) {
                if (j == 0)
                    dp[i][0] = a.get(i).get(0) + dp[i - 1][0];
                else if (j == a.get(i).size() - 1)
                    dp[i][j] = a.get(i).get(j) + dp[i - 1][j - 1];
                else {
                    dp[i][j] = a.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }
        int min = dp[dp.length - 1][0];
        for(int i = 1; i < dp.length; i++)
            min = Math.min(min, dp[dp.length - 1][i]);
        return min;
    }

    public static void main(String[] args) {
        int[][] A = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            ArrayList<Integer> value = new ArrayList<>();
            for(int j = 0; j < A[i].length; j++){
                value.add(A[i][j]);
            }
            list.add(new ArrayList<>(value));
        }
        System.out.println(minimumTotal(list));
    }
}
