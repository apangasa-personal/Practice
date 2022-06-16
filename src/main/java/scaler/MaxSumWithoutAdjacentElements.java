package scaler;

public class MaxSumWithoutAdjacentElements {

    public static int adjacent(int[][] A) {
        int[] max = new int[A[0].length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++)
                max[j] = Math.max(max[j], A[i][j]);
        }
        int[] result = new int[max.length];
        return adjacent(max, result, 0);
    }

    public static int adjacent(int[] max, int[] result, int m) {
        if (m >= result.length)
            return 0;

        if(result[m] != 0)
            return result[m];

        result[m] = Math.max(max[m] + adjacent(max, result, m + 2), adjacent(max, result, m+1));
        return result[m];
    }
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4},
                {2, 3, 4, 5}
        };
        System.out.println(adjacent(A));

    }
}
