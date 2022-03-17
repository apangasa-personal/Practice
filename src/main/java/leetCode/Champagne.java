package leetCode;

public class Champagne {
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[101][101];
        glasses[0][0] = poured;
        for(int i = 1; i < query_row+1; i++){
            for(int j = 0; j < query_row + 1; j++){
                if(j == 0){
                    double available = Math.max(glasses[i-1][j] - 1.0, 0);
                    glasses[i][j] += available/2;
                }
                else {
                    double available = Math.max(glasses[i - 1][j] - 1.0, 0);
                    glasses[i][j] += available / 2;
                    available = Math.max(glasses[i - 1][j - 1] - 1.0, 0);
                    glasses[i][j] += available / 2;
                }
            }
        }
        return Math.min(1.0, glasses[query_row][query_glass]);
    }

    public static void main(String[] args) {
        int a = 2, b = 1 , c = 1;
        System.out.println(champagneTower(a,b,c));
    }
}
