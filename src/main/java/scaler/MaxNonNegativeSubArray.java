package scaler;

import java.util.Arrays;

public class MaxNonNegativeSubArray {
    public static int[] maxset(int[] A) {
        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        int maxStart = 0, maxEnd = 0, i = 0;
        for(int count = 0; count < A.length; count++){
            if(A[count] < 0){
                if(maxSum < currentSum){
                    maxSum = currentSum;
                    maxStart = i;maxEnd = count;
                }
                i = count + 1;
                currentSum = 0;
            }
            else
                currentSum += (long)A[count];
        }
        if(maxSum < currentSum){
            maxSum = currentSum;
            maxStart = i;maxEnd = A.length;
        }
        return Arrays.copyOfRange(A, maxStart, maxEnd);
    }

    public static void main(String[] args){
        int[] A = {1967513926, 1540383426, -1303455736, -521595368};
        int[] result = maxset(A);
        System.out.println("done");
    }
}
