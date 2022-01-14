package scaler;

import java.util.Arrays;

public class Closestpairfromsortedarrays {

    public static int[] solveFinal(int[] A, int[] B, int C) {
        int start = 0, end = B.length - 1, result = Integer.MAX_VALUE;
        int[] values = new int[2];
        values[0] = Integer.MAX_VALUE;
        while (start < A.length && end >= 0){
            if(result >= Math.abs(C - A[start] - B[end])){
                if(!(result == Math.abs(C - A[start] - B[end]) && A[start] > values[0])) {
                    result = Math.abs(C - (A[start] + B[end]));
                    values[0] = A[start];
                    values[1] = B[end];
                }
            }
            if(C > (A[start] + B[end]) && start <A.length- 1)
                start++;
            else
                end --;
        }
        return values;
    }

    public static int[] solve(int[] A, int[] B, int C) {
        return solveFinal(A, B, C);
//        if(A[A.length - 1] > B[B.length - 1])
//            return solveFinal(B, A, C);
//        else
//            return solveFinal(A, B, C);
    }

    public static void main(String[] args) {
        int[] A = {5, 10, 20 };
        int[] B = {1, 2, 30};
        int C = 13;
        System.out.println(Arrays.toString(solve(A,B,C)));
    }
}
