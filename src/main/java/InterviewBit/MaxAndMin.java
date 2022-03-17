package InterviewBit;

public class MaxAndMin {
    public static int perfectPeak(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = Integer.MIN_VALUE;
        right[A.length - 1] = Integer.MAX_VALUE;
        for(int i = 1 ; i < A.length; i++)
            left[i] = Math.max(A[i-1], left[i-1]);
        for(int i = A.length - 2; i >= 0; i--)
            right[i] = Math.min(A[i+1], right[i+1]);

        for(int i = 1; i< A.length-1; i++){
            if(A[i] > left[i] && A[i] < right[i])
                return 1;
        }
        if(A[A.length - 1] > left[A.length - 1])
            return 1;
        if(A[0] < right[0])
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {9488, 25784, 5652, 9861, 31311, 8611, 1671, 7129, 28183, 2743, 11059, 4473, 7927, 21287, 2259, 7214, 32529};
        perfectPeak(A);
    }
}
