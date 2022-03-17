package InterviewBit;

import java.util.Arrays;

public class Segregate01 {
    public static int[] solve(int[] A) {
        int start = 0, end = A.length - 1;
        while(start<=end){
            while(A[start] == 0 && start < end)
                start++;
            while(A[end] == 1 && end > start)
                end--;

            if(start < end) {
                A[start] = 0;
                A[end] = 1;
            }
            start++; end--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = { 1, 1, 0, 0, 0, 1, 0, 1, 1, 1 };
        System.out.println(Arrays.toString(solve(A)));
    }
}
