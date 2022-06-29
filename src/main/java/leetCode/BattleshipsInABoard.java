package leetCode;

public class BattleshipsInABoard {
    static int maxRow, maxColumn;
    public static void main(String[] args) {
        char[][] s = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(countBattleships(s));
    }

    public static int countBattleships(char[][] board) {
        int result = 0;
        maxRow = board.length;
        maxColumn = board[0].length;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'X' && battleShipNeighbours(board, i, j, false, false) == true){
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean battleShipNeighbours(char[][] board, int row, int col, boolean horizontal, boolean vertical) {
        int[] x = {0,1,0,-1};
        int[] y = {-1,0,1,0};
        board[row][col] = '.';
        for(int i = 0; i < x.length; i++){
            if(isValid(row + x[i], col + y[i]) && board[row + x[i]][col + y[i]] == 'X') {
                if (i % 2 == 0) {
                    horizontal = true;
                } else {
                    vertical = true;
                }
            }
        }
        if(horizontal == true && vertical == true)
            return false;

        if(horizontal == true){
            for(int i = 0; i < x.length; i++){
                if(i % 2 == 0 && isValid(row + x[i], col + y[i]) && board[row + x[i]][col + y[i]] == 'X') {
                    if(battleShipNeighbours(board, row + x[i], col + y[i], true, false) == false)
                        return false;
                }
            }
        }

        if(vertical == true){
            for(int i = 0; i < x.length; i++){
                if(i % 2 == 1 && isValid(row + x[i], col + y[i]) && board[row + x[i]][col + y[i]] == 'X') {
                    if(battleShipNeighbours(board, row + x[i], col + y[i], false, true) == false)
                        return false;
                }
            }
        }

        return true;
    }

    public static boolean isValid(int row, int column){
        if(row >= 0 && row < maxRow && column >= 0 && column < maxColumn)
            return true;
        return false;
    }
}
