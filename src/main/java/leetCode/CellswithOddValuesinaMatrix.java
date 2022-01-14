package leetCode;

public class CellswithOddValuesinaMatrix {
    public static int oddCells(int m, int n, int[][] indices) {
        if( m < 1 && n < 1)
            return 0;
        int[][] elements = new int[m][n];
        int result = 0;
        for(int i = 0; i < indices.length; i++){
            int row = indices[i][0];
            int col = indices[i][1];
            for(int j = 0 ; j < elements[row].length ; j++)
                elements[row][j]++;
            for(int j = 0 ; j < elements.length ; j++)
                elements[j][col]++;
        }
        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                if(elements[i][j]%2 != 0)
                    result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        oddCells(48, 37, new int[][]{{40, 5}});
    }
}
