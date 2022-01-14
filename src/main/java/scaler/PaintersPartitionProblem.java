package scaler;

public class PaintersPartitionProblem {
    public static int paint(int A, int B, int[] C) {
        long start = Integer.MIN_VALUE, end = 0;
        for(int i = 0; i< C.length; i++){
            start = Math.max(start, C[i]);
            end += C[i];
        }
        long result = 0;
        while (start <= end){
            long mid = ((long) start + (long) end)/2;
            int workers = 1, timeTaken = 0;
            for(int i = 0; i< C.length; i++){
                timeTaken += C[i];
                if(timeTaken > mid){
                    workers++;
                    timeTaken = C[i];
                }
            }
            if(workers <= A){
                result = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;

        }
        int mod = 10000003;
        return (int)((result * (long)B)%mod);
    }

    public static void main(String[] args) {
        int A = 1 , B = 1000000;
        int[] C = {1000000, 1000000};
        System.out.println(paint(A,B,C));
    }
}
