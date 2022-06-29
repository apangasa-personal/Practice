package scaler.DSA;

import java.util.ArrayList;

public class NQueens {

    public static void solveNQueensCore(int[][] currentArray, int[] cols, int[] leftdiagonals, int[] rightdiagonals, int nextRow, int A) {
        if(nextRow == A){
            ArrayList<String> currentList = new ArrayList<>();
            StringBuilder sb;
            for(int row = 0; row < currentArray.length; row++){
                sb = new StringBuilder();
                for(int col = 0; col < currentArray.length; col++){
                    if(currentArray[row][col] == 0)
                        sb.append('.');
                    else
                        sb.append('Q');
                }
                currentList.add(sb.toString());
            }
            result.add(new ArrayList<>(currentList));
            return;
        }
        for(int i = 0; i< A; i++){
            if(cols[i] == 1 || leftdiagonals[A - nextRow + i - 1] == 1 || rightdiagonals[nextRow + i] == 1)
                continue;
            cols[i] = 1;
            leftdiagonals[A - nextRow + i - 1] = 1;
            rightdiagonals[nextRow + i] = 1;
            currentArray[nextRow][i] = 1;
            solveNQueensCore(currentArray, cols, leftdiagonals, rightdiagonals, nextRow + 1, A);
            cols[i] = 0;
            leftdiagonals[A - nextRow + i - 1] = 0;
            rightdiagonals[nextRow + i] = 0;
            currentArray[nextRow][i] = 0;
        }

    }

    static ArrayList<ArrayList<String>> result;
    public static ArrayList<ArrayList<String>> solveNQueens(int A) {
        result = new ArrayList<>();
        solveNQueensCore(new int[A][A], new int[A], new int[A * 2], new int[A * 2], 0, A);
        return result;
    }

    public static void main(String[] args) {
        int A = 4;
        solveNQueens(A);
    }
}
