package scaler.DSA;

public class MatrixSearch {
    public static int searchMatrix(int[][] A, int B) {
        for(int j = A[0].length-1, i=0; j>=0 && i< A.length;){
            if(A[i][j] == B)
                return 1;
            else if(A[i][j] < B)
                i++;
            else j--;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] A = {
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                    };
        int B = 7;
        System.out.println(searchMatrix(A,B));
    }
}
