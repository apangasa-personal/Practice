package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MakeEqual {
    public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int small = Integer.MAX_VALUE, large = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            small = Math.min(A[i], small);
            large = Math.max(A[i], large);
        }
        int mid = (large + small)/2;
        int i = 0;
        for( ; A[i] < mid; i++)
            A[i] += B;
        while (A[i] == mid)
            i++;
        for( ; i< A.length; i++)
            A[i] -= B;
        for (i = 1; i<A.length; i++)
            if(A[i] != A[i-1])
                return 0;
        return 1;
    }

    public static void main(String[] args) {
        int[] A={3, 1, 3, 3, 2, 3, 1, 2, 3, 3, 1, 2};
        System.out.println(solve(A,1));
    }
}
