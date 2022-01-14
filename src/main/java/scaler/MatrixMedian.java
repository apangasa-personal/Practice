package scaler;

public class MatrixMedian {
    public static int findMedian(int[][] A) {
        int start = A[0][0], end = A[A.length - 1][A[0].length - 1], result = 0;
        for(int i = 0; i<A.length; i++){
            for(int j = 0;j<A[0].length; j++){
                start = Math.min(A[i][j], start);
                end = Math.max(A[i][j], end);
            }
        }
        while (start <= end){
            int mid = (start+end)/2, count = 0;
            for(int i = 0; i<A.length; i++){
                for(int j = 0; j<A[0].length; j++){
                    if(A[i][j] >= mid)
                        count++;
                }
            }
            if(count >= (A.length * A[0].length)/2 + 1) {
                result = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {
                {5},
                {4},
                {3},
                {1},
                {3},
                {1},
                {4},
                {2},
                {5},
                {3},
                {3}
                    };
        System.out.println(findMedian(A));
    }
}
