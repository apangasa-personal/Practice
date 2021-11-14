package scaler;

import java.util.Arrays;

public class SumTheDifference {
    public static int solve(int[] A) {
        long element1 = 0;
        long element2 = 0;
        long mathPow = 1;
        long val1 = 0;
        long val2 = 0;
        int modulo = 1000000007;
        Arrays.sort(A);
        for(int i=0; i< A.length; i++) {
            val1 = (long) (A[i] * mathPow)%modulo;
            mathPow = (mathPow * 2) %1000000007;
            element1 = (element1%1000000007 +  val1%1000000007)%1000000007;
        }
        mathPow = 1;
        for(int i=A.length-1; i>=0; i--) {
            val2 = (long) (A[i] * (mathPow)%1000000007);
            mathPow = (mathPow * 2) %1000000007;
            element2 = (element2%1000000007 +  val2%1000000007)%1000000007;
        }

        return (int) ((element2 - element1)%(1000000007));
    }

    public static void main(String[ ] args){

        int[] A = {5,4,2};
        System.out.println(solve(A));
    }
}
