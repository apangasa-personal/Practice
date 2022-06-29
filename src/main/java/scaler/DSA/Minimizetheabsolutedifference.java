package scaler.DSA;

public class Minimizetheabsolutedifference {
    public static int solve(int[] A, int[] B, int[] C) {
        int ia = 0, ib = 0, ic = 0, result = Integer.MAX_VALUE;
        while (ia < A.length && ib < B.length && ic < C.length){
            int min = Math.min(Math.min(A[ia], B[ib]), C[ic]);
            int max = Math.max(Math.max(A[ia], B[ib]), C[ic]);
            result = Math.min(result, max - min);
            if(ia <A.length - 1 && A[ia] < B[ib] &&  A[ia] < C[ic])
                ia++;
            else if (ib < B.length - 1 && B[ib] < C[ic])
                ib++;
            else
                ic++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 1, 4, 5, 8, 10 };
        int[] B = { 6, 9, 15 };
        int[] C = { 2, 3, 6, 6 };
        System.out.println(solve(A,B,C));
    }
}
