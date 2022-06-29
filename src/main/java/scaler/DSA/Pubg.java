package scaler.DSA;

import java.util.Arrays;

public class Pubg {
    public static int gcd(int A, int B){
        if(A > B){
            A = A^B;
            B = A^B;
            A = A^B;
        }
        while(A>0){
            int temp= A;
            A = B%A;
            B = temp;
        }
        return B;
    }

    public static int solve(int[] A) {
        int result = A[0];
        for(int i = 1; i<A.length; i++){
            result = gcd(result, A[i]);
        }
        return result;
    }

    public static void main(String[] args){
        int[] A = {6, 4, 1};
        System.out.println(solve(A));
    }
}
