package scaler.DSA;

public class BSTWithOneChild {

    public static String solve(int[] A) {
        int l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
        if(A.length < 2)
            return "YES";
        for(int i = 1; i< A.length; i++){
            if(A[i] < A[i-1])
                r = A[i-1];
            else
                l = A[i-1];
            if(A[i] < l || A[i] > r)
                return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        int[] A = { 12, 1, 9, 6, 2 };
        System.out.println(solve(A));
    }
}
