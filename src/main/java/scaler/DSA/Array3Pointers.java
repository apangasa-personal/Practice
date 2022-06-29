package scaler.DSA;

public class Array3Pointers {
    public static int minimize(final int[] A, final int[] B, final int[] C) {
        int result = Integer.MAX_VALUE, iA = 0, iB = 0, iC = 0;
        while(iA < A.length && iB < B.length && iC <C.length){
            int maxNow = Math.max(Math.abs(A[iA] - B[iB]), Math.abs(C[iC] - B[iB]));
            maxNow = Math.max(maxNow,Math.abs(A[iA] - C[iC]));
            result = Math.min(maxNow, result);
            if(iA != A.length - 1 && A[iA] < B[iB] && A[iA] < C[iC])
                iA++;
            else if(iB != B.length - 1 && B[iB] < C[iC])
                iB++;
            else
                iC++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 6};
        int[] B = {2};
        int[] C = {3, 5, 6};
        System.out.println(minimize(A,B,C));
    }
}
