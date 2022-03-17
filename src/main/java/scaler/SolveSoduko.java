package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SolveSoduko {

    public static void solveSudokuCore(char[][] A, int index) {
        if(index == 81) {
            for(int i = 0; i < A.length; i++)
                for(int j = 0; j < A.length; j++)
                    result[i][j] = A[i][j];
            return;
        }

        int row = index/A.length, col = index % A.length;
        if(A[row][col] != '.') {
            solveSudokuCore(A, index + 1);
            return;
        }

        for(int i = 0; i < 9; i++){
            char ch = (char) (i + '1');
            if(checkCube(A, row, col, ch) && checkRow(A, row, ch) && checkCol(A, col, ch)) {
                A[row][col] = ch;
                solveSudokuCore(A, index + 1);
                A[row][col] = '.';
            }
        }
    }

    public static boolean checkRow(char[][] A, int row, char ch){
        for(int i = 0; i < A.length; i++)
            if(A[row][i] == ch)
                return false;
        return true;
    }

    public static boolean checkCol(char[][] A, int col, char ch){
        for(int i = 0; i < A.length; i++)
            if(A[i][col] == ch)
                return false;
        return true;
    }

    public static boolean checkCube(char[][] A, int row, int col, char ch){
        int cubes = (int)Math.sqrt(A.length);
        int startRow = row - row % cubes, startCol = col - col % cubes;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (A[i + startRow][j + startCol] == ch)
                    return false;

        return true;
    }

    static char[][] result;
    public static void solveSudoku(char[][] A) {
        result = new char[A.length][A.length];
        solveSudokuCore(A, 0);
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A.length; j++)
                A[i][j] = result[i][j];
    }

    public static void main(String[] args) {
        String[] array = new String[]{"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        char[][] a = new char[array.length][array.length];
        for(int i = 0; i < array.length; i++) {
            char[] chars = array[i].toCharArray();
            for(int j = 0; j < chars.length; j++)
                a[i][j] = chars[j];
        }
        solveSudoku(a);
    }
}
