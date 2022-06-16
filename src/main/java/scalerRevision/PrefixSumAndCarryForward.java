package scalerRevision;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PrefixSumAndCarryForward {
    public static int[] solve(int A, int[][] B) {
        int[] result = new int[A+2];
        for(int i = 0; i < B.length; i++){
            result[B[i][0]] += B[i][2];
            result[B[i][1] + 1] -= B[i][2];
        }
        for(int i = 1; i < result.length; i++)
            result[i] += result[i-1];

        return Arrays.copyOfRange(result, 1, result.length - 1);
    }


    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
