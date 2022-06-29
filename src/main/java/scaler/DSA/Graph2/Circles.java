package scaler.DSA.Graph2;

public class Circles {

    public static String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[][] matrix = new int[A+1][B+1];
        for(int i = 0; i < C; i++){
            assignCirle(D, E[i], F[i], matrix);
        }
        return "test";
    }

    public static void assignCirle(int r, int x, int y, int[][] matrix){
        for(int i = 0; i <= r; i++){
            int left = x - i;
            if(left >= 0)
                matrix[left][y] = -1;
            int right = x+i;
            if (right < matrix.length)
                matrix[right][y] = -1;
            int up = y - i;
            if(up > 0)
                matrix[x][up] = -1;
            int down = y + i;
            int l = matrix[0].length;
            if(down < matrix[0].length);
                matrix[x][down] = -1;
        }
    }

    public static void main(String[] args) {
        int x = 2,
        y = 3,
        N = 1,
        R = 1;
        int[] A = {2},
        B = {3};
        System.out.println(solve(x,y,N,R, A, B));
    }
}
