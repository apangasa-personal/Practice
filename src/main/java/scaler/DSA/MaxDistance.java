package scaler.DSA;

import java.util.Arrays;

public class MaxDistance {
    public static int maximumGap(final int[] A) {
        int[] minprefix = new int[A.length];
        int[] maxSuffix = new int[A.length];
        maxSuffix[A.length - 1] = A[A.length - 1];
        for(int i = A.length - 2; i >=0; i--){
            maxSuffix[i] = Math.max(maxSuffix[i+1], A[i]);
        }
        minprefix[0] = A[0];
        for(int i = 1; i<=A.length - 1; i++){
            minprefix[i] = Math.min(minprefix[i-1], A[i]);
        }
        int maxIndex = 1, result = 0, minIndex = 0;
        while(maxIndex < A.length){
            if(maxSuffix[maxIndex] >= minprefix[minIndex]){
                result = Math.max(maxIndex - minIndex, result);
                maxIndex++;
            }
            else
                minIndex++;
        }
        return result;
    }
    public static void main(String[] args){
        int []v = {34, 8, 10, 3, 2, 80, 30, 35, 1};
        System.out.println( maximumGap(v));
    }
}
