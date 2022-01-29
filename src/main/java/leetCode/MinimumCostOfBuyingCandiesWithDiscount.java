package leetCode;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public static int solve(int[] A ){
        int result = 0;
        Arrays.sort(A);
        for(int i = A.length - 1; i>=0 ;){
            result += A[i]; i--;
            if(i >= 0)
            result += A[i]; i--;
            if(i>=0)
                i--;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] cost = {6,5,7,9,2,2};
        System.out.println(solve(cost));
    }
}
