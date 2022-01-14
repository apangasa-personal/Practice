package scaler;

public class EquilibriumIndex {
    public static int solve(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = A[0];
        for(int i = 1; i<A.length; i++){
            left[i] = left[i-1] + A[i];
        }
        right[A.length - 1] = A[A.length - 1];
        for(int i = A.length - 2; i>=0; i--){
            right[i] = right[i+1] + A[i];
        }
        for(int i = 0; i<A.length; i++){
            if(left[i] == right[i])
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] A= {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(solve(A));
    }
}
