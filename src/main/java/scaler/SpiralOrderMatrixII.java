package scaler;

public class SpiralOrderMatrixII {

    public static int[][] generateMatrix(int A) {
        int[][] r = new int[A][A];
        int i = 0, j = 0, lastCol = A - 1,lastRow = A - 1, elementVal = 1, firstCol = 0, firstRow = 0;
        while(firstRow <= lastRow && firstCol <= lastCol) {
            for(j = firstCol; j<= lastCol; j++)
                r[i][j] = elementVal++;
            firstRow++;j--;
            for(i = firstRow; i<= lastRow; i++)
                r[i][j] = elementVal++;
            lastCol--;i--;
            if(firstCol < j){
                for(j = lastCol; j>= firstCol; j--)
                    r[i][j] = elementVal++;
                lastRow--;j++;
            }
            if(firstRow < i){
                for(i = lastRow; i>=firstRow; i--)
                    r[i][j] = elementVal++;
                firstCol++;i++;
            }
        }
        return r;
    }

    public static void main(String[] args){
        int n = 3;
        int[][] result = generateMatrix(3);
    }
}
