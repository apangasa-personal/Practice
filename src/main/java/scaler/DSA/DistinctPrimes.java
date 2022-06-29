package scaler.DSA;

import java.util.ArrayList;
import java.util.HashSet;

public class DistinctPrimes {
    public static boolean isPrime(int A){
        if(A == 1)
            return false;
        for(int i = 2; i*i <=A; i++){
            if(A%i == 0)
                return false;
        }
        return true;
    }

    public static int solve(int[] A) {
        HashSet<Integer> values = new HashSet<>();
        for(int i = 0; i<A.length; i++) {
            if((A[i] > 1 && A[i] <= 3) || isPrime(A[i]))
                values.add(A[i]);
            else {
                for(int j = 2; j*j <=A[i]; j++){
                    if(A[i]%j == 0 ) {
                        if(isPrime(j))
                            values.add(j);
                        if(A[i]/j != j && isPrime(A[i]/j))
                            values.add(j=A[i]/j);
                    }

                }
            }
        }
        return values.size();
    }

    public static void main(String[] rags){
        int[] A = { 1, 76, 24, 64, 88, 65, 4, 37, 71, 89, 75};
        System.out.println(solve(A));
    }
}
