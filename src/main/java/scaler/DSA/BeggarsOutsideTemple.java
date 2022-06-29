package scaler.DSA;

public class BeggarsOutsideTemple {
    public static int[] solve(int A, int[][] B) {
        int[] res = new int[A];
        for(int i = 0; i < B.length; i++){
            res[B[i][0] - 1] = res[B[i][0] - 1] + B[i][2];
            if(B[i][1] < res.length)
                res[B[i][1]] = res[B[i][1]] - B[i][2];
        }
        for(int i = 1; i < res.length; i++)
            res[i] = res[i] + res[i-1];
        return res;
    }

    public static void main(String[] args){
        int[][] D = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int N = 5;
        solve(N, D);

    }
}
