package scaler;

import java.util.HashMap;
import java.util.HashSet;

public class Subarraywith0sum {
    public static int solve(int[] A) {
        long[] prefix = new long[A.length];
        prefix[0] = A[0];
        int result = 0;
        if(A[0] == 0)
            return 1;
        for(int i = 1; i<A.length ; i++) {
            prefix[i] = (long)prefix[i - 1] + A[i];
            if(prefix[i] == 0)
                return 1;
        }

        HashSet<Long> sums = new HashSet();
        for(int i = 0; i< prefix.length; i++){
            if(sums.contains(prefix[i])){
                return 1;
            }
            else
                sums.add(prefix[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1,-1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }
}
