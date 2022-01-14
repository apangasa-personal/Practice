package scaler;

public class MaximumSumSquareSubMatrix {
    public static int solve(int[][] A, int B) {
        int ans = 0;
        for(int i = 0; i< A.length; i++){
            for(int j = 1; j<A[i].length; j++){
                A[i][j] = (A[i][j] + A[i][j-1]);
            }
        }
        for(int j = 0; j< A[0].length; j++){
            for(int i = 1; i<A.length; i++){
                A[i][j] = (A[i][j] + A[i-1][j]);;
            }
        }
        ans = A[B-1][B-1];
        int temp = 0;
        for(int i = B-1; i < A.length; i++){
            for(int j = B-1; j < A.length; j++){
                temp = 0;
                temp = A[i][j];
                if(i>= B)
                    temp -= A[i-B][j];
                if(j >= B)
                    temp -= A[i][j-B];
                if(i>= B && j >= B)
                    temp += A[i-B][j-B];
                ans = Math.max(ans,temp);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[][] A = {{1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}};
        int B = 3;
        System.out.println(solve(A,B));
    }
}
