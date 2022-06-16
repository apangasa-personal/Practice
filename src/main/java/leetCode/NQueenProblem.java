package leetCode;

import java.util.ArrayList;

public class NQueenProblem {

    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here

        for(int i = 0; i < n; i++){
            int[] cols = new int[n];
            int[] leftDiagonal = new int[2 * n - 1];
            int[] rightDiagonal = new int[2 * n - 1];
            cols[i] = 1;
            leftDiagonal[i] = 1;
            rightDiagonal[n - 1 + i] = 1;
            ArrayList<Integer> resultCurrent = new ArrayList<>();
            resultCurrent.add(i+1);
            nQueen(n, rightDiagonal, leftDiagonal, cols, resultCurrent, 1);
        }
        return result;
    }

    static boolean nQueen(int n, int[] rightDiagonal, int[] leftDiagonal, int[] cols, ArrayList<Integer> resultCurrent, int nextRow) {
        if(nextRow == n) {
            result.add(new ArrayList<>(resultCurrent));
            return true;
        }
        for(int i = 0; i < n; i++){
            if(cols[i] != 1 && leftDiagonal[nextRow + i] != 1 && rightDiagonal[n - 1 + i - nextRow] != 1){
                cols[i] = 1;
                leftDiagonal[nextRow + i] = 1;
                rightDiagonal[n - 1 + i - nextRow] = 1;
                resultCurrent.add(i + 1);
                nQueen(n, rightDiagonal,leftDiagonal,cols,resultCurrent, nextRow + 1);
                cols[i] = 0;
                leftDiagonal[nextRow + i] = 0;
                rightDiagonal[n - 1 + i - nextRow] = 0;
                resultCurrent.remove(resultCurrent.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 8;
        ArrayList<ArrayList<Integer>> result = nQueen(n);
        System.out.println("done");
    }
}
