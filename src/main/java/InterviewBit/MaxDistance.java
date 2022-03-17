package InterviewBit;

public class MaxDistance {
    public static int maximumGap(final int[] A) {
        int r = 0;
        int[] minLeft = new int[A.length];
        if(A.length <2)
            return 0;
        minLeft[0] = A[0];
        for(int i = 1; i< A.length; i++)
            minLeft[i] = Math.min(minLeft[i-1], A[i]);
        int i = A.length - 1, j = A.length - 1;
        while(i >= 0 && j>=0){
            if(A[i] > minLeft[j]){
                r = Math.max(r, i-j);
                j--;
            }
            else
                i--;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] A = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maximumGap(A));
    }

}
