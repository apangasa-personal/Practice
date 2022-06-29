package scaler.DSA;

public class SubmatrixSumQueries {
    public static int[] adjustArray(int[] A){
        for(int i =0; i<A.length;i++)
            A[i] = A[i] - 1;
        return A;
    }
    public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int[] result = new int[B.length];
        int mod = 1000000007;
        for(int i = 0; i< A.length; i++){
            for(int j = 1; j<A[i].length; j++){
                A[i][j] = (A[i][j]%mod + A[i][j-1]%mod)%mod;
            }
        }
        B = adjustArray(B);
        C = adjustArray(C);
        D = adjustArray(D);
        E = adjustArray(E);
        for(int j = 0; j< A[0].length; j++){
            for(int i = 1; i<A.length; i++){
                A[i][j] = (A[i][j]%mod + A[i-1][j]%mod)%mod;;
            }
        }
        for(int i = 0; i< B.length; i++){
            result[i] = A[D[i]][E[i]];
            if(B[i] > 0)
                result[i] = result[i] - A[B[i] - 1][E[i]];
            if(C[i] > 0)
                result[i] = result[i] - A[D[i]][C[i]-1];
            if(B[i] > 0 && C[i] > 0)
                result[i] = (result[i]%mod + A[B[i]-1][C[i]-1]%mod)%mod;
        }
        return result;
    }

    public static void main(String[] args){
        int [][] A = {  {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}   };
        int[]   B = {1, 2},
                C = {1, 2},
                D = {2, 3},
                E = {2, 3};
        solve(A,B,C,D,E);
        System.out.println("done");
    }
}
