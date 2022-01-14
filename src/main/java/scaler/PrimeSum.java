package scaler;

import java.util.Arrays;

public class PrimeSum {
    public static boolean isPrime(int A){
        for(int i = 2; i*i <= A; i++){
            if(A%i == 0)
                return false;
        }
        return true;
    }

    public static int[] primesum(int A) {
        for(int i = 2; i<=A/2; i++){
            if(isPrime(i) && isPrime(A-i))
                return new int[]{i, A-i};
        }
        return null;
    }

    public static void main(String[] rags){
        int A = 4;
        System.out.println(Arrays.toString(primesum(A)));
    }
}
