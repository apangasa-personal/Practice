package InterviewBit;

import java.util.HashMap;

public class MaxProduct {

    public static int maxProduct(final int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int max_ending = A[0], min_ending = A[0];
        int max_so_far = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max_ending;
            max_ending = Integer.max(A[i], Integer.max(A[i] * max_ending, A[i] * min_ending));
            min_ending = Integer.min(A[i], Integer.min(A[i] * temp, A[i] * min_ending));
            max_so_far = Integer.max(max_so_far, max_ending);
        }
        return max_so_far;
    }


    public static void main(String[] args) {
        int[] A = {-6, 4, -5, 8, -10, 0, 8};
        maxProduct(A);
    }
}
