package scaler.DSA;

import java.util.Arrays;

public class FoodPacketsDistribution {
    public static int solve(int[] A, int B) {
        long start = Integer.MAX_VALUE, total = 0, result = 0, min = 0;
        for(int i = 0; i< A.length; i++) {
            total += A[i];
            start = Math.min(start, A[i]);
        }
        if( B > total)
            return 0;

       total = start; start = 1;
        while (start <= total){
            long mid = (start + total)/2;
            long current = 0;
            for(int i = 0; i<A.length; i++){
                current += A[i]/mid;
            }
            if(current >= B) {
                result = mid;
                start = mid + 1;
            }
            else {
                total = mid - 1;
            }
        }
        return (int)result;
    }

    public static void main(String[] args) {
        int[] A = {2, 9, 5, 4};
        int B = 13;
        System.out.println(solve(A,B));
    }
}
