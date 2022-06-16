package scaler;

public class DungeonsAndPrincess {
    public static int calculateMinimumHPCore(int[][] A, int[][] visited, int m, int n){
        if(m >= A.length || n >= A[0].length)
            return Integer.MAX_VALUE;

        if(visited[m][n] != 0)
            return visited[m][n];


        int right = calculateMinimumHPCore(A, visited, m+1, n);
        int bottom = calculateMinimumHPCore(A, visited, m, n+1);
        if(A[m][n] > Math.min(right, bottom)) {
            visited[m][n] = 1;
        }
        else
            visited[m][n] = Math.min(right, bottom) - A[m][n];
        if(visited[m][n] == 0)
            visited[m][n] = 1;
        return visited[m][n];

    }
    public static int calculateMinimumHP(int[][] A) {
        int[][] energy = new int[A.length][A[0].length];
        energy[A.length - 1][A[0].length - 1] = 1 - Math.min(0, A[A.length - 1][A[0].length - 1]);
        return calculateMinimumHPCore(A, energy, 0, 0);
    }

    public static void main(String[] args) {
        int[][] A = {
                {0,0,0},
                {1,1,-1}
//                {10, 30, -5}
        };
        System.out.println(calculateMinimumHP(A));
    }
}
