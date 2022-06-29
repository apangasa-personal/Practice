package scaler.DSA.Graph1;

public class NumberOfIslands {

    public static void findIsland(int[][] A, int i, int j){
        if( i < 0 || j < 0 || i > A.length - 1 || j > A[0].length - 1)
            return;
        if(A[i][j] == 0)
            return;
        A[i][j] = 0;
        findIsland(A, i-1, j - 1);
        findIsland(A, i-1, j);
        findIsland(A, i-1, j+1);
        findIsland(A, i, j-1);
        findIsland(A, i, j+1);
        findIsland(A, i+1, j-1);
        findIsland(A, i+1, j);
        findIsland(A, i+1, j+1);
    }

    public static int solve(int[][] A) {
        int islands = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 1){
                    islands++;
                    findIsland(A, i, j);
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(solve(A));
    }
}
