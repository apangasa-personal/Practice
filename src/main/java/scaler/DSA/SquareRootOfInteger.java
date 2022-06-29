package scaler.DSA;

public class SquareRootOfInteger {
    public static int sqrt(int A) {
        if(A <= 1)
            return A;
        int ans = 1;
        int start  = 1, end = A/2;
        while(start <= end){
            long mid = (long)(start + end)/2;
            if(mid * mid <= A) {
                ans = (int) mid;
                start = (int) (mid+1);
            }
            else
                end = (int) (mid - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(1));
    }
}
