package scaler.DSA;

public class MaximumUnsortedSubarray {
    public static int[] subUnsort(int[] A) {
        int left = -1, right = A.length - 1;
        for(int i = 1; i<A.length; i++){
            if(A[i] < A[i-1]){
                left = i-1;
                break;
            }
        }
        if(left == -1)
            return new int[]{-1};
        for(int i = A.length-1; i>0; i--){
            if(A[i] < A[i-1]){
                right = i;
                break;
            }
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = left; i<= right; i++){
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        for(int i = 0; i<left; i++){
            if(A[i] > min){
                left = i;
                break;
            }
        }
        for(int i = A.length - 1; i>right; i--){
            if(A[i] < max){
                right = i;
                break;
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4, 5};
        System.out.println(subUnsort(A));
    }
}
