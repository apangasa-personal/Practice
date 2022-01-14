package scaler;

import java.util.Arrays;

public class DeleteOne {
    public static int gcd(int A, int B) {
        if(A > B){
            int temp = A;
            A = B;
            B = temp;
        }
        if(A == 0)
            return B;
        while( A > 0){
            int temp = A;
            A = (B-A)%A;
            B = temp;
        }
        return B;
    }


    public static int solve(int[] A) {
        if(A.length == 1){
            return A[0];
        }
        if(A.length == 2){
            return Math.max(A[0], A[1]);
        }
        int[] prefix = new int[A.length];
        int[] suffix = new int[A.length];
        prefix[0] = A[0];
        suffix[A.length - 1] = A[A.length - 1];
        for(int i = 1; i< A.length; i++){
            prefix[i] = gcd(A[i], prefix[i-1]);
        }
        suffix[A.length - 1] = A[A.length - 1];
        for(int i = A.length - 2; i>= 0; i--){
            suffix[i] = gcd(A[i], suffix[i+1]);
        }
        int result = 0;
        for(int i = 1; i<A.length - 1; i++){
            result = Math.max(result, gcd(prefix[i-1], suffix[i+1]));
        }
        return result;
    }

    public static void main(String[] rags){
        int[] A = {12, 15, 18, 24};
        System.out.println(solve(A));
    }
}
