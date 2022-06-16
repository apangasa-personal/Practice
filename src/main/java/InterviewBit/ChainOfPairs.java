package InterviewBit;

import java.util.Arrays;
import java.util.Comparator;

public class ChainOfPairs {
    public static void main(String[] args) {
        int[][] A = {
                {98, 894},
                {397, 942},
                {70, 519},
                {258, 456},
                {286, 449},
                {516, 626},
                {370, 873},
                {214, 224},
                {74, 629},
                {265, 886},
                {708, 815},
                {394, 770},
                {56, 252}};
        System.out.println(solve(A));
    }

    public static int solve(int[][] A) {
        int[] dp = new int[A.length];
        int max = 0;
        for(int i = 0; i < A.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(A[i][0] > A[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
