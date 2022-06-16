package scaler.DP5;

public class FlipArray {
    public static int solve(final int[] A) {
        int sum = 0;
        for(int i = 0; i < A.length; i++)
            sum += A[i];

        int[] dp =  new int[(sum+1)/2 + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;
        solveCore(A, dp, 0, 0, 0);
        for(int i = 0; i < dp.length; i++)
            if(dp[i] != Integer.MAX_VALUE)
                return dp[i];
        return 0;
    }

    public static int solveCore(int[] A, int[] dp, int index, int negativeCount, int sum){
        if(index == A.length)
            return 0;
        if(dp[index] != Integer.MAX_VALUE)
            return dp[index];

        int csum = sum + A[index];
        solveCore(A, dp, index+1, negativeCount, csum);

//
//
//        //positive case
//        for(int i = index; i < A.length; i++)
//            currentSum += A[i];
//        if(currentSum < dp.length && currentSum > 0) {
//            dp[currentSum] = Math.min(dp[currentSum], negativeCount);
//        }
//        System.out.println(currentSum);
//        solveCore(A, dp, index+1, negativeCount, sum + A[index]);
//
//        //negative case
//        currentSum = sum - A[index];
//        for(int i = index+1; i < A.length; i++)
//            currentSum += A[i];
//
//        System.out.println(currentSum);
//        if(currentSum < dp.length  && currentSum > 0) {
//            dp[currentSum] = Math.min(dp[currentSum], negativeCount + 1);
//        }
        return solveCore(A, dp, index+1, negativeCount+1, sum - A[index]);
    }

    public static void main(String[] args) {
        int[] A = {5, 4, 6, 8, 7, 2, 3};
        System.out.println(solve(A));
    }
}
