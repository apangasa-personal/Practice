package scaler;

public class RainWaterTrapped {
    public static int trap(final int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = A[0];
        right[A.length - 1] = A[A.length - 1];
        for(int i = 1; i< A.length; i++) {
            left[i] = Math.max(A[i], left[i - 1]);
        }
        for(int i = A.length - 2; i>= 0; i--){
                right[i] = Math.max(A[i], right[i+1]);
        }
        int result = 0;
        for(int i = 0; i< A.length; i++){
            result += Math.min(left[i], right[i]) - A[i];
        }
        return result;
    }
    public static void main(String[] args){
        int[] A = {0, 1, 0, 2};
        System.out.println(trap(A));
    }
}
