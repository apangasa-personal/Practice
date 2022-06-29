package scaler.DSA;

public class AnotherCountRectangles {
    public static int solve(int[] A, int B) {
        int mod = 1000000007;
        int start = 0, end = A.length - 1, result  = 0;
        while (start <= end){
            long area = (long)A[start] * A[end];
            if(area%mod < B) {
                long val = (long)2*(end - start);
                result = (result + (int)(val%mod + 1))%mod;
                start++;
            }
            else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;
        System.out.println(solve(A,B));
    }
}
