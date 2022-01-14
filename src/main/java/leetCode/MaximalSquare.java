package leetCode;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int answer = 0;
        for(int i = 1; i<matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[i][j] != '0') {
                    int val1 = Integer.valueOf(matrix[i][j]) - '0';
                    matrix[i][j] = (char) Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]),matrix[i-1][j-1]);
                    matrix[i][j] = (char)(matrix[i][j] - '0' + '1');
                    answer = Math.max(answer, matrix[i][j] - '0');
                }
            }
        }
        return answer;

    }
    public static void  main(String[] rags){
        char[][] vals = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(vals));
    }
}
