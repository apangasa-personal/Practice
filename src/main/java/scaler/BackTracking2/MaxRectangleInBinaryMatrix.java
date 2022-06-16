package scaler.BackTracking2;

public class MaxRectangleInBinaryMatrix {

    public static int maximalRectangle(int[][] A) {
//        for(int i = 0; i < A.length; i++){
//            for(int j = 1; j < A[i].length; j++){
//                if(A[i][j] == 0)
//                    continue;
//                A[i][j] = A[i][j-1] + 1;
//            }
//        }
//        for(int i = A[0].length - 1; i >= 0; i--){
//            for(int j = 0; j < A[i].length; j++){
//                if(A[i][j] != 0){
//                   continue;
//                }
//                else if(A[i][j - 1] != 0)
//                    A[i][j] = A[i][j]
//            }
//        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 1},
                {0, 1, 1},
                {1, 0, 0},
        };
        maximalRectangle(A);
    }
}
