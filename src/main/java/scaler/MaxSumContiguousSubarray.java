package scaler;

public class MaxSumContiguousSubarray {
    public static int maxSubArray(final int[] A) {
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < A.length;i++){
            currentSum += A[i];
            maxSum = Math.max(currentSum, maxSum);
            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }
    public static void main(String[] args){
        int[] A = {-500 };
        System.out.println(maxSubArray(A));
    }
}
