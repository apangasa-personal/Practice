package scaler.DP4;

public class BuyingCandies {
    public static int solve(int[] A, int[] B, int[] C, int D) {
        if(D == 0)
            return 0;
        for(int i = 0; i < A.length; i++)
            A[i] *= B[i];

        int[] result = new int[D+1];
        return solve(A,C,D, result);
    }

    public static int solve(int[] A, int[] C, int D, int[] result) {
        if(D <= 0)
            return 0;
        if(result[D] != 0)
            return result[D];
        for(int i = 0; i < C.length; i++){
            if(D >= C[i])
                result[D] = Math.max(result[D], solve(A,C,D - C[i], result) + A[i]);
        }
        return result[D];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3},
                B = {2, 2, 10},
                C = {2, 3, 9};

        int D = 8;
        System.out.println(solve(A,B,C,D));
    }

}
