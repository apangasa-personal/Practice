package scaler.DSA;

public class MinimumSwaps2 {
    public static int solve(int[] A) {
        int result = 0;
        int i = 0;
        while (i < A.length){
            if(A[i] == i)
                i++;
            else {
                int val = A[i];
                A[i] = A[val];
                A[val] = val;
                result++;
                if(A[i] == i)
                    i++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] A = {2, 0, 1, 3};
        System.out.println(solve(A));
    }
}
