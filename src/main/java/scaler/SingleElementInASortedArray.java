package scaler;

public class SingleElementInASortedArray {
    public static int solve(int[] A) {
        int ans = Integer.MAX_VALUE;
        int start = 0, end = A.length - 1;
        if(A.length == 1 || A[0] != A[1])
            return A[0];
        if(A[A.length - 1] != A[A.length -2 ])
            return A[A.length-1];
        while(start <= end){
            int mid = (start + end)/2;
            if(A[mid] != A[mid + 1] && A[mid] != A[mid-1])
                return A[mid];
            if(A[mid] == A[mid-1])
                mid = mid -1 ;
            if(mid%2 == 0)
                start = mid+2;
            else
                end = mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]  A = {5, 11, 11, 100, 100};
        System.out.println(solve(A));
    }
}
